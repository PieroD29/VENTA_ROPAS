package Controlador;

import Config.GenerarSerie;
import Modelo.Boleta;
import Modelo.Clasificacion;
import Modelo.Categoria;
import Modelo.Usuarios;
import Modelo.Especificaciones;
import Modelo.SubCategoria; 
import Modelo.Productos;
import Modelo.Venta;
import ModeloDAO.BoletaDAO;
import ModeloDAO.ClasificacionDAO;
import ModeloDAO.CategoriaDAO;
import ModeloDAO.UsuariosDAO;
import ModeloDAO.EspecificacionesDAO;
import ModeloDAO.SubCategoriaDAO;
import ModeloDAO.ProductosDAO;
import ModeloDAO.VentaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Controlador_tabla", urlPatterns = {"/Controlador_tabla"})
public class Controlador_tabla extends HttpServlet {

    //RequestDispatcher dispatcher = null;
    Usuarios usua = new Usuarios();
    UsuariosDAO usuarioDAO = new UsuariosDAO();
    int ide;
    
//--------------------------------------------------
    
    Especificaciones espe = new Especificaciones();
    EspecificacionesDAO especificacionDAO = new EspecificacionesDAO();

//--------------------------------------------------
    
    Productos prod = new Productos();
    ProductosDAO productoDAO = new ProductosDAO();
 

//--------------------------------------------------
    Clasificacion clasi = new Clasificacion();
    ClasificacionDAO clasificacionDAO = new ClasificacionDAO();
    
//--------------------------------------------------
    Categoria cate = new Categoria();
    CategoriaDAO categoriaDAO = new CategoriaDAO();

 
//--------------------------------------------------
    SubCategoria sbcate = new SubCategoria();
    SubCategoriaDAO subCateDAO = new SubCategoriaDAO();
    

 
//--------------------------------------------------
    Boleta bole = new Boleta();
    List<Boleta> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cantidad;
    double subtotal;
    double monto_total;

    String numero_serie;
    BoletaDAO boletaDAO = new BoletaDAO();

    //--------------------------------------------------
    Venta ve = new Venta();
    VentaDAO ventaDAO = new VentaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }

        if (menu.equals("Usuarios")) {
            switch (accion) {
                case "BuscarUsuario":
                    String perfil = request.getParameter("perfil");
                    if (perfil != null && !perfil.isEmpty()) {
                        List<Usuarios> lista = new ArrayList<>();
                       Usuarios usua = usuarioDAO.buscar(perfil);
                        if (usua != null) {
                            lista.add(usua);
                        }
                        request.setAttribute("usuarios", lista);
                    } else {
                        // Si el campo de búsqueda está vacío, muestra todos los proveedores.
                        List<Usuarios> lista = usuarioDAO.listar();
                        request.setAttribute("usuarios", lista);
                    }
                    break;
                case "Read":
                    List<Usuarios> lista = usuarioDAO.listar();
                    request.setAttribute("usuarios", lista);
                    break;
                case "Agregar":
                    String usuario = request.getParameter("txtusuario");
                    String contra = request.getParameter("txtcontra");
                    String perfiles = request.getParameter("txtperfil");
                    String nivel = request.getParameter("txtnivel");
                    String otros = request.getParameter("txtotros");
                    usua.setusuario(usuario);
                    usua.setcontra(contra);
                    usua.setperfil(perfiles);
                    usua.setnivel(nivel);
                    usua.setotros(otros);
                    usuarioDAO.agregar(usua);
                    request.getRequestDispatcher("Controlador_tabla?menu=Usuarios&accion=Read").forward(request, response);
                    break;
                case "Update":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Usuarios u = usuarioDAO.listarId(ide);
                    request.setAttribute("usuario", u);
                    request.getRequestDispatcher("Controlador_tabla?menu=Usuarios&accion=Read").forward(request, response);
                    break;
                case "Actualizar":
                    String usuario1 = request.getParameter("txtusuario");
                    String contra1 = request.getParameter("txtcontra");
                    String perfiles1 = request.getParameter("txtperfil");
                    String nivel1 = request.getParameter("txtnivel");
                    String otros1 = request.getParameter("txtotros");
                    usua.setusuario(usuario1);
                    usua.setcontra(contra1);
                    usua.setperfil(perfiles1);
                    usua.setnivel(nivel1);
                    usua.setotros(otros1);
                    usua.setid_user(ide);
                    usuarioDAO.actualizar(usua);
                    request.getRequestDispatcher("Controlador_tabla?menu=Usuarios&accion=Read").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    usuarioDAO.eliminar(ide);
                    request.getRequestDispatcher("Controlador_tabla?menu=Usuarios&accion=Read").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
        }
        if (menu.equals("ReportesUsuarios")) {
            switch (accion) {
                case "reporteusuario":
                    List<Usuarios> lista = usuarioDAO.listar();
                    request.setAttribute("usuarios", lista);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("reporteUsuarios.jsp").forward(request, response);
        }
        if (menu.equals("Especificaciones")) {
            switch (accion) {
                /*case "BuscarUsuario":
                    String perfil = request.getParameter("perfil");
                    if (perfil != null && !perfil.isEmpty()) {
                        List<Usuarios> lista = new ArrayList<>();
                       Usuarios usua = usuarioDAO.buscar(perfil);
                        if (usua != null) {
                            lista.add(usua);
                        }
                        request.setAttribute("usuarios", lista);
                    } else {
                        // Si el campo de búsqueda está vacío, muestra todos los proveedores.
                        List<Usuarios> lista = usuarioDAO.listar();
                        request.setAttribute("usuarios", lista);
                    }
                    break;*/
                case "Read":
                    List<Especificaciones> lista = especificacionDAO.listar();
                    List<Productos> productos = productoDAO.obtenerTodosLosProductos();
                    request.setAttribute("productos", productos);
                    request.setAttribute("especificaciones", lista);
                    break;
                case "Agregar":
                    String titulo = request.getParameter("txttitulo");
                    String descripcion = request.getParameter("txtdescripcion");
                    String producto = request.getParameter("txtproducto");
                    int productoInt = 0;
                    try {
                        productoInt = Integer.parseInt(producto);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    espe.settitulo(titulo);
                    espe.setdescripcion(descripcion);
                    espe.setid_prod(productoInt);
                    especificacionDAO.agregar(espe);
                    request.getRequestDispatcher("Controlador_tabla?menu=Especificaciones&accion=Read").forward(request, response);
                    break;
                case "Update":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Especificaciones es = especificacionDAO.listarId(ide);
                    request.setAttribute("especificacion", es);
                    request.getRequestDispatcher("Controlador_tabla?menu=Especificaciones&accion=Read").forward(request, response);
                    break;
                case "Actualizar":
                    String titulo1 = request.getParameter("txttitulo");
                    String descripcion1 = request.getParameter("txtdescripcion");
                    String producto1 = request.getParameter("txtproducto");
                    int productoInt1 = 0;
                    try {
                        productoInt1 = Integer.parseInt(producto1);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    espe.settitulo(titulo1);
                    espe.setdescripcion(descripcion1);
                    espe.setid_prod(productoInt1);
                    espe.setid_esp(ide);
                    especificacionDAO.actualizar(espe);
                    request.getRequestDispatcher("Controlador_tabla?menu=Especificaciones&accion=Read").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    especificacionDAO.eliminar(ide);
                    request.getRequestDispatcher("Controlador_tabla?menu=Especificaciones&accion=Read").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Especificaciones.jsp").forward(request, response);
        }
 
 
        if (menu.equals("ReportesEspecificaciones")) {
            switch (accion) {
                case "reporteespecificacion":
                    List<Especificaciones> lista = especificacionDAO.listar();
                    List<Productos> listaProductos = productoDAO.listar(); // Obtener lista de productos          
                    request.setAttribute("productos", listaProductos);
                    request.setAttribute("especificaciones", lista);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("reporteEspecificaciones.jsp").forward(request, response);
        }
 
        //----------------------------------------CLASIFICACION
        if (menu.equals("Clasificacion")) {
            switch (accion) {
                case "Read":
                    List<Clasificacion> lista = clasificacionDAO.listar();
                    request.setAttribute("clasificacion", lista);
                    break;
                case "Agregar":
                    String id_clas = request.getParameter("txtnombre");
                    String descripcion = request.getParameter("txtdescripcion");
                    String img_dir = request.getParameter("txtestado");

                    clasi.setId_clas(Integer.parseInt(id_clas));
                    clasi.setDescripcion(descripcion);
                    clasi.setImg_dir(img_dir);
                    clasificacionDAO.agregar(clasi);
                    request.getRequestDispatcher("Controlador_tabla?menu=Clasificaciones&accion=Read").forward(request, response);
                    break;

                case "Update":
                    ide = Integer.parseInt(request.getParameter("id_clas"));
                    Clasificacion clas = clasificacionDAO.listarId(ide);
                    request.setAttribute("clasificacion", clas);
                    request.getRequestDispatcher("Controlador_tabla?menu=Clasificaciones&accion=Read").forward(request, response);
                    break;
                case "Actualizar":
                    String descripcion1 = request.getParameter("txtdescripcion");
                    String img_dir1 = request.getParameter("txtestado");
                    
                    clasi.setDescripcion(descripcion1);
                    clasi.setImg_dir(img_dir1);
                    clasi.setId_clas(ide);
                    clasificacionDAO.actualizar(clasi);
                    request.getRequestDispatcher("Controlador_tabla?menu=Clasificaciones&accion=Read").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id_clas"));
                    clasificacionDAO.eliminar(ide);
                    request.getRequestDispatcher("Controlador_tabla?menu=Clasificaciones&accion=Read").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clasificaciones.jsp").forward(request, response);

        }
 
        
 
 
        if (menu.equals("ReportesClasificaciones")) {
            switch (accion) {
                case "reporteclasificacion":
                    List<Clasificacion> lista = clasificacionDAO.listar();
                    request.setAttribute("clasificacion", lista);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("reporteClasificaciones.jsp").forward(request, response);
        }
        //-----------------------
        
        //----------------------------------------CATEGORIA

        if (menu.equals("Categorias")) {
            switch (accion) {
                case "Read":
                    List<Categoria> lista = categoriaDAO.listar();
                    request.setAttribute("categorias", lista);
                    break;
                case "Agregar":
                    String descripcion = request.getParameter("txtdescripcion");
                    String img_dir = request.getParameter("txtdir_imagen");

                    cate.setDescripcion(descripcion);
                    cate.setImg_dir(img_dir);
                    categoriaDAO.agregar(cate);
                    request.getRequestDispatcher("Controlador_tabla?menu=Categorias&accion=Read").forward(request, response);
                    break;

                case "Update":
                    ide = Integer.parseInt(request.getParameter("id_cat"));
                    Categoria ca = categoriaDAO.listarId(ide);
                    request.setAttribute("categoria", ca);
                    request.getRequestDispatcher("Controlador_tabla?menu=Categorias&accion=Read").forward(request, response);
                    break;
                case "Actualizar":
                    String descripcion1 = request.getParameter("txtdescripcion");
                    String img_dir1 = request.getParameter("txtdir_imagen");
                    
                    cate.setDescripcion(descripcion1);
                    cate.setImg_dir(img_dir1);
                    cate.setId_cat(ide);
                    categoriaDAO.actualizar(cate);
                    request.getRequestDispatcher("Controlador_tabla?menu=Categorias&accion=Read").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id_cat"));
                    categoriaDAO.eliminar(ide);
                    request.getRequestDispatcher("Controlador_tabla?menu=Categorias&accion=Read").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Categorias.jsp").forward(request, response);
            
        }
        if (menu.equals("ReportesCategorias")) {
            switch (accion) {
                case "reportecategoria":
                    List<Categoria> lista = categoriaDAO.listar();
                    request.setAttribute("categorias", lista);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("reporteCategorias.jsp").forward(request, response);
        }
 
        //----------------------------------------SUBCATEGORIA
        if (menu.equals("subCategorias")) {
            switch (accion) {
                case "Read":
                    List<SubCategoria> lista = subCateDAO.listar();
                    request.setAttribute("subcategoria", lista);
                    break;
                case "Agregar":
                    String id_sbcat = request.getParameter("txtnombre");
                    String descripcion = request.getParameter("txtdescripcion");
                    String img_dir = request.getParameter("txtestado");

                    sbcate.setId_sbcat(Integer.parseInt(id_sbcat));
                    sbcate.setDescripcion(descripcion);
                    sbcate.setImg_dir(img_dir);
                    subCateDAO.agregar(sbcate);
                    request.getRequestDispatcher("Controlador_tabla?menu=subCategorias&accion=Read").forward(request, response);
                    break;

                case "Update":
                    ide = Integer.parseInt(request.getParameter("id_sbcat"));
                    SubCategoria sbcat = subCateDAO.listarId(ide);
                    request.setAttribute("subcategorias", sbcat);
                    request.getRequestDispatcher("Controlador_tabla?menu=subCategorias&accion=Read").forward(request, response);
                    break;
                case "Actualizar":
                    String descripcion1 = request.getParameter("txtdescripcion");
                    String img_dir1 = request.getParameter("txtestado");
                    
                    sbcate.setDescripcion(descripcion1);
                    sbcate.setImg_dir(img_dir1);
                    sbcate.setId_sbcat(ide);
                    subCateDAO.actualizar(sbcate);
                    request.getRequestDispatcher("Controlador_tabla?menu=subCategorias&accion=Read").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id_sbcat"));
                    subCateDAO.eliminar(ide);
                    request.getRequestDispatcher("Controlador_tabla?menu=subCategorias&accion=Read").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("subCategorias.jsp").forward(request, response);

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
