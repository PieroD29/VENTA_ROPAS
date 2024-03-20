package Controlador;

import Config.GenerarSerie;
import Modelo.Boleta;
import Modelo.Clasificacion;
import Modelo.Categoria;
import Modelo.Usuarios;
import Modelo.Especificaciones;
import Modelo.SubCategoria;
import Modelo.Cliente;
import Modelo.Cliente_direccion;
import Modelo.Direccion;
import Modelo.Empleado;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Telefono;
import Modelo.Venta;
import ModeloDAO.BoletaDAO;
import ModeloDAO.ClasificacionDAO;
import ModeloDAO.CategoriaDAO;
import ModeloDAO.UsuariosDAO;
import ModeloDAO.EspecificacionesDAO;
import ModeloDAO.SubCategoriaDAO;
import ModeloDAO.ClienteDAO;
import ModeloDAO.Cliente_direccionDAO;
import ModeloDAO.DireccionDAO;
import ModeloDAO.EmpleadoDAO;
import ModeloDAO.ProductoDAO;
import ModeloDAO.ProveedorDAO;
import ModeloDAO.TelefonoDAO;
import ModeloDAO.VentaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    Cliente cli = new Cliente();
    ClienteDAO clienteDAO = new ClienteDAO();

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
    Producto pro = new Producto();
    ProductoDAO productoDAO = new ProductoDAO();

//--------------------------------------------------
    Telefono tel = new Telefono();
    TelefonoDAO telefonoDAO = new TelefonoDAO();

//--------------------------------------------------
    Direccion dir = new Direccion();
    DireccionDAO direccionDAO = new DireccionDAO();

//--------------------------------------------------
    Cliente_direccion cli_dir = new Cliente_direccion();
    Cliente_direccionDAO cliente_direccionDAO = new Cliente_direccionDAO();

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
>>>>>>> 2b44fc1ce7a6f101663b287dc91809e5188a4ceb
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
<<<<<<< HEAD
=======
        //-----------------------
        //----------------------------------------SUBCATEGORIA
        if (menu.equals("subCategorias")) {
            switch (accion) {
                case "Read":
                    List<Categoria> lista = subCateDAO.listar();
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
        //-----------------------
>>>>>>> 2b44fc1ce7a6f101663b287dc91809e5188a4ceb
        
        if (menu.equals("Productos")) {
            switch (accion) {
                case "Read":
                    List<Producto> lista = productoDAO.listar();
                    List<Categoria> categorias = categoriaDAO.obtenerTodasLasCategorias();
                    List<Proveedor> proveedores = proveedorDAO.obtenerTodosLosProveedores();
                    request.setAttribute("categorias", categorias);
                    request.setAttribute("proveedores", proveedores);
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar":

                    String nombre = request.getParameter("txtnombre");
                    String descripcion = request.getParameter("txtdescripcion");
                    String precio = request.getParameter("txtprecio");
                    double precioDouble = 0.0;
                    try {
                        precioDouble = Double.parseDouble(precio);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    String stock = request.getParameter("txtstock");
                    int stockInt = 0;
                    try {
                        stockInt = Integer.parseInt(stock);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    String estado = request.getParameter("txtestado");
                    boolean estadoIn;

                    if (estado != null && !estado.isEmpty()) {
                        estadoIn = Boolean.parseBoolean(estado);
                    } else {
                        // En este caso, el valor de "estado" está vacío o nulo, puedes tomar una acción específica o asignar un valor predeterminado.
                        estadoIn = false; // O cualquier otro valor predeterminado que desees.
                    }
                    String proveedor = request.getParameter("txtproveedor");
                    int proveedorInt = 0;
                    try {
                        proveedorInt = Integer.parseInt(proveedor);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    String categoria = request.getParameter("txtcategoria");
                    int categoriaInt = 0;
                    try {
                        categoriaInt = Integer.parseInt(categoria);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    pro.setNOMBRE_PRODUCTO(nombre);
                    pro.setDESCRIPCION(descripcion);
                    pro.setPRECIO_UNITARIO(precioDouble);
                    pro.setSTOCK(stockInt);
                    pro.setESTADO(estadoIn);
                    pro.setID_PROVEEDOR(proveedorInt);
                    pro.setID_CATEGORIA(categoriaInt);
                    productoDAO.agregar(pro);
                    request.getRequestDispatcher("Controlador_tabla?menu=Productos&accion=Read").forward(request, response);
                    break;
                case "Update":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Producto prod = productoDAO.listarId(ide);
                    request.setAttribute("producto", prod);

                    request.getRequestDispatcher("Controlador_tabla?menu=Productos&accion=Read").forward(request, response);
                    break;
                case "Actualizar":
                    String nombre1 = request.getParameter("txtnombre");
                    String descripcion1 = request.getParameter("txtdescripcion");
                    String precio1 = request.getParameter("txtprecio");
                    double precioDouble1 = 0.0;
                    try {
                        precioDouble1 = Double.parseDouble(precio1);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    String stock1 = request.getParameter("txtstock");
                    int stockInt1 = 0;
                    try {
                        stockInt1 = Integer.parseInt(stock1);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    String estado1 = request.getParameter("txtestado");
                    boolean estadoIn1;

                    if (estado1 != null && !estado1.isEmpty()) {
                        estadoIn1 = Boolean.parseBoolean(estado1);
                    } else {
                        // En este caso, el valor de "estado" está vacío o nulo, puedes tomar una acción específica o asignar un valor predeterminado.
                        estadoIn1 = false; // O cualquier otro valor predeterminado que desees.
                    }
                    String proveedor1 = request.getParameter("txtproveedor");
                    int proveedorInt1 = 0;
                    try {
                        proveedorInt1 = Integer.parseInt(proveedor1);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    String categoria1 = request.getParameter("txtcategoria");
                    int categoriaInt1 = 0;
                    try {
                        categoriaInt1 = Integer.parseInt(categoria1);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    pro.setNOMBRE_PRODUCTO(nombre1);
                    pro.setDESCRIPCION(descripcion1);
                    pro.setPRECIO_UNITARIO(precioDouble1);
                    pro.setSTOCK(stockInt1);
                    pro.setESTADO(estadoIn1);
                    pro.setID_PROVEEDOR(proveedorInt1);
                    pro.setID_CATEGORIA(categoriaInt1);
                    pro.setCOD_PRODUCTO(ide);
                    productoDAO.actualizar(pro);
                    request.getRequestDispatcher("Controlador_tabla?menu=Productos&accion=Read").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    productoDAO.eliminar(ide);
                    request.getRequestDispatcher("Controlador_tabla?menu=Productos&accion=Read").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Productos.jsp").forward(request, response);

        }
        if (menu.equals("ReportesProductos")) {
            switch (accion) {
                case "reporteproducto":
                    List<Producto> listaProductos = productoDAO.listar();
                    List<Categoria> listaCategorias = categoriaDAO.listar(); // Obtener lista de categorías
                    List<Proveedor> listaProveedores = proveedorDAO.listar(); // Obtener lista de proveedores

                    request.setAttribute("productos", listaProductos);
                    request.setAttribute("categorias", listaCategorias);
                    request.setAttribute("proveedores", listaProveedores);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("reporteProductos.jsp").forward(request, response);
        }
         
        if (menu.equals("Ventas")) {
            switch (accion) {
                case "Read":
                    List<Venta> lista = ventaDAO.listar();
                    request.setAttribute("ventas", lista);
                    List<Cliente> clientes = clienteDAO.obtenerTodosLosClientes();
                    request.setAttribute("clientes", clientes);
                    List<Empleado> vendedores = vendedorDAO.obtenerTodosLosEmpleados();
                    request.setAttribute("vendedores", vendedores);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtdni");
                    String nombre = request.getParameter("txtnombre");
                    String record = request.getParameter("txtrecord");
                    int recordInt = 0;
                    try {
                        recordInt = Integer.parseInt(record);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    String fecha = request.getParameter("txtfecha");
                    String estado = request.getParameter("txtestado");
                    cli.setDNI(dni);
                    cli.setNOMBRE_CLIENTE(nombre);
                    cli.setRECORD_COMPRA(recordInt);
                    cli.setFECHA_NACIMIENTO(fecha);
                    cli.setESTADO_CLIENTE(estado);
                    clienteDAO.agregar(cli);
                    request.getRequestDispatcher("Controlador_tabla?menu=Ventas&accion=Read").forward(request, response);
                    break;
                case "Update":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Cliente c = clienteDAO.listarId(ide);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador_tabla?menu=Ventas&accion=Read").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtdni");
                    String nombre1 = request.getParameter("txtnombre");
                    String record1 = request.getParameter("txtrecord");
                    int recordInt1 = 0;
                    try {
                        recordInt1 = Integer.parseInt(record1);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    String fecha1 = request.getParameter("txtfecha");
                    String estado1 = request.getParameter("txtestado");
                    cli.setDNI(dni1);
                    cli.setNOMBRE_CLIENTE(nombre1);
                    cli.setRECORD_COMPRA(recordInt1);
                    cli.setFECHA_NACIMIENTO(fecha1);
                    cli.setESTADO_CLIENTE(estado1);
                    cli.setID_CLIENTE(ide);
                    clienteDAO.actualizar(cli);
                    request.getRequestDispatcher("Controlador_tabla?menu=Ventas&accion=Read").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    clienteDAO.eliminar(ide);
                    request.getRequestDispatcher("Controlador_tabla?menu=Ventas&accion=Read").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Boletas.jsp").forward(request, response);

        }
        if (menu.equals("ReportesVentas")) {
            switch (accion) {
                case "reporteventa":
                    List<Venta> listaVentas = ventaDAO.listar();
                    List<Cliente> listaClientes = clienteDAO.listar(); // Obtener lista de categorías
                    List<Cliente> listaVendedores = vendedorDAO.listar();
                    // Obtener lista de proveedores
                    request.setAttribute("ventas", listaVentas);
                    request.setAttribute("clientes", listaClientes);
                    request.setAttribute("vendedores", listaVendedores);

                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("reporteVentas.jsp").forward(request, response);
        }
        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("codigocliente");
                    cli.setDNI(dni);
                    cli = clienteDAO.buscar(dni);
                    request.setAttribute("c", cli);
                    break;
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    pro = productoDAO.listarId(id);
                    request.setAttribute("c", cli);
                    request.setAttribute("e", vende);
                    request.setAttribute("producto", pro);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", monto_total);
                    request.setAttribute("numeroserie", numero_serie);
                    break;
                case "BuscarEmpleado":
                    String dni_empleado = request.getParameter("codigoempleado");
                    vende.setDNI(dni_empleado);
                    vende = vendedorDAO.buscar(dni_empleado);
                    request.setAttribute("e", vende);
                    request.setAttribute("c", cli);
                    break;
                case "Agregar":
                    request.setAttribute("numeroserie", numero_serie);
                    request.setAttribute("c", cli);
                    request.setAttribute("e", vende);
                    item = item + 1;
                    cod = pro.getCOD_PRODUCTO();
                    descripcion = request.getParameter("nomproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cantidad = Integer.parseInt(request.getParameter("cantidad"));
                    subtotal = precio * cantidad;
                    bole = new Boleta();
                    bole.setItem(item);
                    bole.setIdproducto(cod);
                    bole.setDescripcion_pro(descripcion);
                    bole.setPrecio(precio);
                    bole.setCantidad(cantidad);
                    bole.setSubtotal(subtotal);
                    lista.add(bole);
                    monto_total = 0.0;
                    for (int i = 0; i < lista.size(); i++) {
                        monto_total = monto_total + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", monto_total);
                    request.setAttribute("lista", lista);
                    break;
                case "GenerarVenta":
                    //Actualizacion de la columna STOCK de la tabla PRODUCTO
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr = new Producto();
                        int cant = lista.get(i).getCantidad();
                        int idproducto = lista.get(i).getIdproducto();
                        ProductoDAO aDAO = new ProductoDAO();
                        pr = aDAO.buscar(idproducto);
                        int stock_actual = pr.getSTOCK() - cant;
                        aDAO.actualizarstock(idproducto, stock_actual);
                    }

                    //Aqui guardamos la boleta
                    bole.setIdcliente(cli.getID_CLIENTE());
                    bole.setIdempleado(vende.getID_VENDEDOR());
                    bole.setNumserie(numero_serie);
                    bole.setFecha("2019-06-15");
                    bole.setMonto(monto_total);
                    bole.setEstado("1");
                    boletaDAO.guardarBoleta(bole);
                    //Aqui guardamos el Detalle de Boleta
                    int idventa = Integer.parseInt(boletaDAO.NroBoleta());
                    for (int i = 0; i < lista.size(); i++) {
                        bole = new Boleta();
                        bole.setIdboleta(idventa);
                        bole.setIdproducto(lista.get(i).getIdproducto());
                        bole.setCantidad(lista.get(i).getCantidad());
                        bole.setPrecio(lista.get(i).getPrecio());
                        boletaDAO.guardarDetalleboletas(bole);
                    }
                    break;
                case "Editar": // Nuevo caso para la edición de productos
                    int index = Integer.parseInt(request.getParameter("index")); // Obtén el índice del producto a editar
                    int newCantidad = Integer.parseInt(request.getParameter("nuevaCantidad")); // Obtén la nueva cantidad
                    // Actualiza la cantidad y subtotal del producto en la lista
                    Boleta productoAEditar = lista.get(index);
                    productoAEditar.setCantidad(newCantidad);
                    productoAEditar.setSubtotal(productoAEditar.getPrecio() * newCantidad);
                    monto_total = 0.0;
                    for (int i = 0; i < lista.size(); i++) {
                        monto_total = monto_total + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", monto_total);
                    request.setAttribute("lista", lista);
                    break;
                case "Eliminar": // Nuevo caso para eliminar productos
                    int productIndex = Integer.parseInt(request.getParameter("index"));
                    lista.remove(productIndex);
                    // Recalcula el monto total
                    monto_total = 0.0;
                    for (Boleta producto : lista) {
                        monto_total += producto.getSubtotal();
                    }
                    request.setAttribute("totalpagar", monto_total);
                    request.setAttribute("lista", lista);
                    break;
                default:
                    lista.clear();
                    monto_total = 0.0;
                    bole = new Boleta();
                    numero_serie = boletaDAO.GenerarSerie();
                    if (numero_serie == null) {
                        numero_serie = "00000001";
                        request.setAttribute("numeroserie", numero_serie);
                    } else {
                        int incrementar = Integer.parseInt(numero_serie);
                        GenerarSerie gs = new GenerarSerie();
                        numero_serie = gs.NumeroSerie(incrementar);
                        request.setAttribute("numeroserie", numero_serie);
                    }
                    request.getRequestDispatcher("NuevaVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("NuevaVenta.jsp").forward(request, response);

        }
        if (menu.equals("ReportesVentas")) {
            switch (accion) {
                case "reporteventa":
                    List<Boleta> listaVentas = boletaDAO.listar(); // Cambia "listar" por el método adecuado que obtiene las ventas
                    request.setAttribute("lista", listaVentas);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("reporteVentas.jsp").forward(request, response);
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
