package Controlador;

import Config.GenerarSerie;
import Modelo.Boleta;
import Modelo.Clasificacion;
import Modelo.Categoria;
import Modelo.Empleado;
import Modelo.Especificaciones;
import Modelo.SubCategoria; 
import Modelo.Marca;
import Modelo.Productos;
import Modelo.Venta;
import ModeloDAO.BoletaDAO;
import ModeloDAO.ClasificacionDAO;
import ModeloDAO.CategoriaDAO;
import ModeloDAO.EmpleadoDAO;
import ModeloDAO.EspecificacionesDAO;
import ModeloDAO.MarcaDAO;
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
import java.io.File;
import jakarta.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

 
 

@WebServlet(name = "Controlador_tabla", urlPatterns = {"/Controlador_tabla"})
public class Controlador_tabla extends HttpServlet {

    //RequestDispatcher dispatcher = null;
    Empleado vende = new Empleado();
    EmpleadoDAO vendedorDAO = new EmpleadoDAO();
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
    Productos pro = new Productos();
    ProductosDAO productosDAO = new ProductosDAO();

//--------------------------------------------------
    Marca mar = new Marca();
    MarcaDAO marcaDAO = new MarcaDAO();

 
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

        if (menu.equals("Vendedores")) {
            switch (accion) {
                case "BuscarEmpleado":
                    String perfil = request.getParameter("codigoempleado");
                    if (perfil != null && !perfil.isEmpty()) {
                        List<Empleado> lista = new ArrayList<>();
                        Empleado vende = vendedorDAO.buscar(perfil);
                        if (vende != null) {
                            lista.add(vende);
                        }
                        request.setAttribute("vendedores", lista);
                    } else {
                        // Si el campo de búsqueda está vacío, muestra todos los proveedores.
                        List<Empleado> lista = vendedorDAO.listar();
                        request.setAttribute("vendedores", lista);
                    }
                    break;
                case "Read":
                    List<Empleado> lista = vendedorDAO.listar();
                    request.setAttribute("vendedores", lista);
                    break;
                case "Agregar":
                    String usuario = request.getParameter("txtusuario");
                    String contra = request.getParameter("txtcontra");
                    String perfiles = request.getParameter("txtperfil");
                    String nivel = request.getParameter("txtnivel");
                    String otros = request.getParameter("txtotros");
                    vende.setusuario(usuario);
                    vende.setcontra(contra);
                    vende.setperfil(perfiles);
                    vende.setnivel(nivel);
                    vende.setotros(otros);
                    vendedorDAO.agregar(vende);
                    request.getRequestDispatcher("Controlador_tabla?menu=Vendedores&accion=Read").forward(request, response);
                    break;
                case "Update":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado v = vendedorDAO.listarId(ide);
                    request.setAttribute("vendedor", v);
                    request.getRequestDispatcher("Controlador_tabla?menu=Vendedores&accion=Read").forward(request, response);
                    break;
                case "Actualizar":
                    String usuario1 = request.getParameter("txtusuario");
                    String contra1 = request.getParameter("txtcontra");
                    String perfiles1 = request.getParameter("txtperfil");
                    String nivel1 = request.getParameter("txtnivel");
                    String otros1 = request.getParameter("txtotros");
                    vende.setusuario(usuario1);
                    vende.setcontra(contra1);
                    vende.setperfil(perfiles1);
                    vende.setnivel(nivel1);
                    vende.setotros(otros1);
                    vende.setid_user(ide);
                    vendedorDAO.actualizar(vende);
                    request.getRequestDispatcher("Controlador_tabla?menu=Vendedores&accion=Read").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    vendedorDAO.eliminar(ide);
                    request.getRequestDispatcher("Controlador_tabla?menu=Vendedores&accion=Read").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Vendedores.jsp").forward(request, response);
        }
        if (menu.equals("ReportesUsuarios")) {
            switch (accion) {
                case "reporteusuario":
                    List<Empleado> lista = vendedorDAO.listar();
                    request.setAttribute("vendedores", lista);
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
                case "Guardar":
                    ArrayList<String> listaimg = new ArrayList<>();
                    try {
                        for (Part part : request.getParts()) {
                            if (!part.getName().equals("file")) { // Ignora los campos de formulario normales
                                continue;
                            }
                            String fileName = extractFileName(part); // Obtener nombre del archivo
                            String uploadPath = "C:\\xampp\\htdocs\\img\\"; // Directorio donde se guardarán los archivos
                            File file = new File(uploadPath + File.separator + fileName);
                            part.write(file.getAbsolutePath()); // Guarda el archivo en el directorio de carga
                            clasi.setImg_dir("http://localhost/img/" + fileName); // Agrega la URL del archivo al objeto clasi
                        }
                        clasi.setDescripcion(request.getParameter("txtdescripcion")); // Obtener otros datos del formulario
                        clasificacionDAO.agregar(clasi);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    request.getRequestDispatcher("Controlador_tabla?accion=Read").forward(request, response);
                    break;
                case "Read":
                    List<Clasificacion> lista= clasificacionDAO.listar();
                    request.setAttribute("clasificaciones", lista);
                    break;
                case "Agregar":
                    String descripcion = request.getParameter("txtdescripcion");
                    String img_dir = request.getParameter("txtdir_imagen");

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
<<<<<<< HEAD
                    String img_dir1 = request.getParameter("txtestado");
=======
                    String img_dir1 = request.getParameter("txtdir_imagen");
                    
>>>>>>> db62c05fc46c0df6a713a38ca7f13085a9e10b54
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
                    String descripcion = request.getParameter("txtdescripcion");
                    String img_dir = request.getParameter("txtdir_imagen");

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
                    String img_dir1 = request.getParameter("txtdir_imagen");
                    
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
 
        if (menu.equals("ReportesSubCategorias")) {
            switch (accion) {
                case "reportesubcategoria":
                    List<SubCategoria> lista = subCateDAO.listar();
                    request.setAttribute("subCategorias", lista);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("reporteSubCategorias.jsp").forward(request, response);
        }
        //---------------------------
        
        if (menu.equals("Producto")) {
            switch (accion) {
                case "BuscarProducto":
                    String prod = request.getParameter("COD_PRODUCTO");
                    if (prod != null && !prod.isEmpty()) {
                        List<Productos> listaP = new ArrayList<>();
                       Productos productos = productoDAO.buscar((cod));
                        if (productos != null) {
                            listaP.add(productos);
                        }
                        request.setAttribute("listaprod", listaP);
                    } else {
                        // Si el campo de búsqueda está vacío, muestra todos los proveedores.
                        List<Productos> listaP = productoDAO.listar();
                        request.setAttribute("listaprod", listaP);
                    }
                    break;
                case "Read":
                    List<Productos> listaP = productoDAO.listar();
                    request.setAttribute("listaprod", listaP);
                    break;
                case "Agregar":
                    int id = Integer.parseInt(request.getParameter("txtidprod"));
                    String nombre = request.getParameter("txtnomprod");
                    String descripcion = request.getParameter("txtdescprod");
                    double precio = Double.parseDouble(request.getParameter("txtpreprod"));
                    String modelo = request.getParameter("txtmodprod");
                    int stock = Integer.parseInt(request.getParameter("txtstockprod"));
                    boolean estado = Boolean.parseBoolean(request.getParameter("txtestprod"));
                    int clasif =  Integer.parseInt(request.getParameter("txtclasiprod"));
                    int categoria = Integer.parseInt(request.getParameter("txtcatprod"));
                    int subcateg = Integer.parseInt(request.getParameter("txtsubcprod"));
                    int marca = Integer.parseInt(request.getParameter("txtmarcaprod"));


                    pro.setID_PROD(id);
                    pro.setNOMBRE_PROD(nombre);
                    pro.setDESC_PROD(descripcion);
                    pro.setPREC_PROD(precio);
                    pro.setMODE_PROD(modelo);
                    pro.setSTOCK_PROD(stock);
                    pro.setESTADO_PROD(estado);
                    pro.setID_CLASIFICACION(clasif);
                    pro.setID_CATEGORIA(categoria);
                    pro.setID_SUBCAT(subcateg);
                    pro.setID_MARCA(marca);
                    request.getRequestDispatcher("Controlador_tabla?menu=Producto&accion=Read").forward(request, response);
                    break;
                case "Update":
                    int cod1 = Integer.parseInt(request.getParameter("COD_PRODUCTO"));
                    Productos p = productoDAO.buscar(cod1);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador_tabla?menu=Producto&accion=Read").forward(request, response);
                    break;
                case "Actualizar":
                    String nombre1 = request.getParameter("txtnomprod");
                    String descripcion1 = request.getParameter("txtdescprod");
                    double precio1 = Double.parseDouble(request.getParameter("txtpreprod"));
                    String modelo1 = request.getParameter("txtmodprod");
                    int stock1 = Integer.parseInt(request.getParameter("txtstockprod"));
                    boolean estado1 = Boolean.parseBoolean(request.getParameter("txtestprod"));
                    int clasif1 =  Integer.parseInt(request.getParameter("txtclasiprod"));
                    int categoria1 = Integer.parseInt(request.getParameter("txtcatprod"));
                    int subcateg1 = Integer.parseInt(request.getParameter("txtsubcprod"));
                    int marca1 = Integer.parseInt(request.getParameter("txtmarcaprod"));

                    int id1 = Integer.parseInt(request.getParameter("COD_PRODUCTO"));
                    pro.setID_PROD(id1);
                    pro.setNOMBRE_PROD(nombre1);
                    pro.setDESC_PROD(descripcion1);
                    pro.setPREC_PROD(precio1);
                    pro.setMODE_PROD(modelo1);
                    pro.setSTOCK_PROD(stock1);
                    pro.setESTADO_PROD(estado1);
                    pro.setID_CLASIFICACION(clasif1);
                    pro.setID_CATEGORIA(categoria1);
                    pro.setID_SUBCAT(subcateg1);
                    pro.setID_MARCA(marca1);
                    productoDAO.actualizar(pro);
                    request.getRequestDispatcher("Controlador_tabla?menu=Producto&accion=Read").forward(request, response);
                    break;
                case "Delete":
                    int cod3 = Integer.parseInt(request.getParameter("COD_PRODUCTO"));
                    productoDAO.eliminar(cod3);
                    request.getRequestDispatcher("Controlador_tabla?menu=Producto&accion=Read").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }

if (menu.equals("Marca")) {
         switch (accion) {
             case "BuscarMarca":
                 String cod = request.getParameter("COD_MARCA");
                 if (cod != null && !cod.isEmpty()) {
                     List<Marca> listaM = new ArrayList<>();
                    Marca marca = marcaDAO.buscar(Integer.parseInt(cod));
                     if (marca != null) {
                         listaM.add(marca);
                     }
                     request.setAttribute("listamarca", listaM);
                 } else {
                     // Si el campo de búsqueda está vacío, muestra todos los proveedores.
                     List<Marca> listaM = marcaDAO.listar();
                     request.setAttribute("listamarca", listaM);
                 }
                 break;
             case "Read":
                 List<Marca> listaM = marcaDAO.listar();
                 request.setAttribute("listamarca", listaM);
                 break;
             case "Agregar":
                 int id = Integer.parseInt(request.getParameter("txtidmarca"));
                 String nombre = request.getParameter("txtnommarca");
                 boolean estado = Boolean.parseBoolean(request.getParameter("txtestmarca"));


                 mar.setID_MARCA(id);
                 mar.setNOMBRE_MARCA(nombre);
                 mar.setESTADO_MARCA(estado);
                 request.getRequestDispatcher("Controlador_tabla?menu=Marca&accion=Read").forward(request, response);
                 break;
             case "Update":
                 int cod1 = Integer.parseInt(request.getParameter("COD_MARCA"));
                 Marca m = marcaDAO.buscar(cod1);
                 request.setAttribute("marca", m);
                 request.getRequestDispatcher("Controlador_tabla?menu=Marca&accion=Read").forward(request, response);
                 break;
             case "Actualizar":
                 String nombre1 = request.getParameter("txtnommarca");
                 boolean estado1 = Boolean.parseBoolean(request.getParameter("txtestmarca"));

                 int id1 = Integer.parseInt(request.getParameter("COD_PRODUCTO"));
                 mar.setNOMBRE_MARCA(nombre1);
                 mar.setESTADO_MARCA(estado1);
                 marcaDAO.actualizarnombre(id1, nombre1, estado1);
                 request.getRequestDispatcher("Controlador_tabla?menu=Marca&accion=Read").forward(request, response);
                 break;
             case "Delete":
                 int id3 = Integer.parseInt(request.getParameter("COD_PRODUCTO"));
                 marcaDAO.eliminar(id3);
                 request.getRequestDispatcher("Controlador_tabla?menu=Marca&accion=Read").forward(request, response);
                 break;
             default:
                 throw new AssertionError();
         }

         request.getRequestDispatcher("Marca.jsp").forward(request, response);
     } 
      
    }
     
    private String extractFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                return item.substring(item.indexOf("=") + 2, item.length() - 1);
            }
        }
        return "";
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
