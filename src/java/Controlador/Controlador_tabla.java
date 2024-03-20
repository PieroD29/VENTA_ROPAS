package Controlador;

import Config.GenerarSerie;
import Modelo.Boleta;
import Modelo.Clasificacion;
import Modelo.Categoria;
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
    Empleado vende = new Empleado();
    EmpleadoDAO vendedorDAO = new EmpleadoDAO();
    int ide;

//--------------------------------------------------
    Proveedor prove = new Proveedor();
    ProveedorDAO proveedorDAO = new ProveedorDAO();

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

        if (menu.equals("Vendedores")) {
            switch (accion) {
                case "BuscarEmpleado":
                    String DNI = request.getParameter("codigoempleado");
                    if (DNI != null && !DNI.isEmpty()) {
                        List<Empleado> lista = new ArrayList<>();
                       Empleado vende = vendedorDAO.buscar(DNI);
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
                    String dni = request.getParameter("txtdni");
                    String nombre = request.getParameter("txtnombres");
                    String fecha = request.getParameter("txtfecha");
                    String salario = request.getParameter("txtsalario");
                    String estado = request.getParameter("txtestado");

                    double salarioDouble = 0.0;
                    try {
                        salarioDouble = Double.parseDouble(salario);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    String usuario = request.getParameter("txtusuario");
                    vende.setDNI(dni);
                    vende.setNOMBRE_VENDEDOR(nombre);
                    vende.setFECHA_CONTRATO(fecha);
                    vende.setSALARIO(salarioDouble);
                    vende.setESTADO_VENDEDOR(estado);
                    vende.setUSUARIO(usuario);
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
                    String dni1 = request.getParameter("txtdni");
                    String nombre1 = request.getParameter("txtnombres");
                    String fecha1 = request.getParameter("txtfecha");
                    String salario1 = request.getParameter("txtsalario");
                    double salarioDouble1 = 0.0;
                    try {
                        salarioDouble1 = Double.parseDouble(salario1);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    String estado1 = request.getParameter("txtestado");
                    String usuario1 = request.getParameter("txtusuario");
                    vende.setDNI(dni1);
                    vende.setNOMBRE_VENDEDOR(nombre1);
                    vende.setFECHA_CONTRATO(fecha1);
                    vende.setSALARIO(salarioDouble1);
                    vende.setESTADO_VENDEDOR(estado1);
                    vende.setUSUARIO(usuario1);
                    vende.setID_VENDEDOR(ide);
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
        if (menu.equals("Reportes")) {
            switch (accion) {
                case "reporte":
                    List<Empleado> lista = vendedorDAO.listar();
                    request.setAttribute("vendedores", lista);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("reporteExcel.jsp").forward(request, response);

        }
        if (menu.equals("Proveedores")) {
            switch (accion) {
                case "BuscarProveedor":
                    String RUC = request.getParameter("codigoproveedor");
                    if (RUC != null && !RUC.isEmpty()) {
                        List<Proveedor> lista = new ArrayList<>();
                        Proveedor prove = proveedorDAO.buscar(RUC);
                        if (prove != null) {
                            lista.add(prove);
                        }
                        request.setAttribute("proveedores", lista);
                    } else {
                        // Si el campo de búsqueda está vacío, muestra todos los proveedores.
                        List<Proveedor> lista = proveedorDAO.listar();
                        request.setAttribute("proveedores", lista);
                    }
                    break;
                case "Read":
                    List<Proveedor> lista = proveedorDAO.listar();
                    request.setAttribute("proveedores", lista);
                    break;
                case "Agregar":
                    String nombre = request.getParameter("txtnombre");
                    String ruc = request.getParameter("txtruc");
                    String estado = request.getParameter("txtestado");
                    prove.setNOM_PROVEEDOR(nombre);
                    prove.setRUC(ruc);
                    prove.setESTADO_PROVEEDOR(estado);
                    proveedorDAO.agregar(prove);
                    request.getRequestDispatcher("Controlador_tabla?menu=Proveedores&accion=Read").forward(request, response);
                    break;
                case "Update":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Proveedor p = proveedorDAO.listarId(ide);
                    request.setAttribute("proveedor", p);
                    request.getRequestDispatcher("Controlador_tabla?menu=Proveedores&accion=Read").forward(request, response);
                    break;
                case "Actualizar":
                    String nombre1 = request.getParameter("txtnombre");
                    String ruc1 = request.getParameter("txtruc");
                    String estado1 = request.getParameter("txtestado");
                    prove.setNOM_PROVEEDOR(nombre1);
                    prove.setRUC(ruc1);
                    prove.setESTADO_PROVEEDOR(estado1);
                    prove.setID_PROVEEDOR(ide);
                    proveedorDAO.actualizar(prove);
                    request.getRequestDispatcher("Controlador_tabla?menu=Proveedores&accion=Read").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    proveedorDAO.eliminar(ide);
                    request.getRequestDispatcher("Controlador_tabla?menu=Proveedores&accion=Read").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Proveedores.jsp").forward(request, response);

        }
        if (menu.equals("ReportesProveedores")) {
            switch (accion) {
                case "reporteproveedor":
                    List<Proveedor> lista = proveedorDAO.listar();
                    request.setAttribute("proveedores", lista);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("reporteProveedores.jsp").forward(request, response);

        }
        if (menu.equals("Clientes")) {
            switch (accion) {
                case "BuscarCliente":
                    String DNI = request.getParameter("codigocliente");
                    if (DNI != null && !DNI.isEmpty()) {
                        List<Cliente> lista = new ArrayList<>();
                        Cliente cli = clienteDAO.buscar(DNI);
                        if (cli != null) {
                            lista.add(cli);
                        }
                        request.setAttribute("clientes", lista);
                    } else {
                        // Si el campo de búsqueda está vacío, muestra todos los clientes
                        List<Cliente> lista = clienteDAO.listar();
                        request.setAttribute("clientes", lista);
                    }
                    break;
                case "Read":
                    List<Cliente> lista = clienteDAO.listar();
                    request.setAttribute("clientes", lista);
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
                    request.getRequestDispatcher("Controlador_tabla?menu=Clientes&accion=Read").forward(request, response);
                    break;
                case "Update":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Cliente c = clienteDAO.listarId(ide);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador_tabla?menu=Clientes&accion=Read").forward(request, response);
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
                    request.getRequestDispatcher("Controlador_tabla?menu=Clientes&accion=Read").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    clienteDAO.eliminar(ide);
                    request.getRequestDispatcher("Controlador_tabla?menu=Clientes&accion=Read").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);

        }
        if (menu.equals("ReportesClientes")) {
            switch (accion) {
                case "reportecliente":
                    List<Cliente> lista = clienteDAO.listar();
                    request.setAttribute("clientes", lista);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("reporteClientes.jsp").forward(request, response);
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
        //-----------------------
        
        //----------------------------------------CATEGORIA
        if (menu.equals("Categorias")) {
            switch (accion) {
                case "Read":
                    List<Categoria> lista = categoriaDAO.listar();
                    request.setAttribute("categorias", lista);
                    break;
                case "Agregar":
                    String id_cat = request.getParameter("txtnombre");
                    String descripcion = request.getParameter("txtdescripcion");
                    String img_dir = request.getParameter("txtestado");

                    cate.setId_cat(Integer.parseInt(id_cat));
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
                    String img_dir1 = request.getParameter("txtestado");
                    
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
        //-----------------------
        
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
        if (menu.equals("Telefonos")) {
            switch (accion) {
                case "Read":
                    List<Telefono> lista = telefonoDAO.listar();
                    List<Cliente> clientes = clienteDAO.obtenerTodosLosClientes();
                    request.setAttribute("clientes", clientes);
                    request.setAttribute("telefonos", lista);
                    break;
                case "Agregar":
                    String telefono_1 = request.getParameter("txttelefono1");
                    String telefono_2 = request.getParameter("txttelefono2");
                    String tel_cliente = request.getParameter("txt_telcliente");
                    int tel_clienteInt = 0;
                    try {
                        tel_clienteInt = Integer.parseInt(tel_cliente);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    tel.setTELEFONO_1(telefono_1);
                    tel.setTELEFONO_2(telefono_2);
                    tel.setID_CLIENTE(tel_clienteInt);
                    telefonoDAO.agregar(tel);
                    request.getRequestDispatcher("Controlador_tabla?menu=Telefonos&accion=Read").forward(request, response);
                    break;
                case "Update":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Telefono te = telefonoDAO.listarId(ide);
                    request.setAttribute("telefono", te);
                    request.getRequestDispatcher("Controlador_tabla?menu=Telefonos&accion=Read").forward(request, response);
                    break;
                case "Actualizar":
                    String telefono1_1 = request.getParameter("txttelefono1");
                    String telefono2_2 = request.getParameter("txttelefono2");
                    String tel_cliente1 = request.getParameter("txt_telcliente");
                    int tel_clienteInt1 = 0;
                    try {
                        tel_clienteInt1 = Integer.parseInt(tel_cliente1);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    tel.setTELEFONO_1(telefono1_1);
                    tel.setTELEFONO_2(telefono2_2);
                    tel.setID_CLIENTE(tel_clienteInt1);
                    tel.setID_TELEFONO(ide);
                    telefonoDAO.actualizar(tel);
                    request.getRequestDispatcher("Controlador_tabla?menu=Telefonos&accion=Read").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    telefonoDAO.eliminar(ide);
                    request.getRequestDispatcher("Controlador_tabla?menu=Telefonos&accion=Read").forward(request, response);
                    break;

                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Telefonos.jsp").forward(request, response);

        }
        if (menu.equals("ReportesTelefonos")) {
            switch (accion) {
                case "reportetelefono":
                    List<Telefono> listaTelefonos = telefonoDAO.listar();
                    List<Cliente> listaClientes = clienteDAO.listar(); // Obtener lista de categorías
                    // Obtener lista de proveedores
                    request.setAttribute("telefonos", listaTelefonos);
                    request.setAttribute("clientes", listaClientes);

                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("reporteTelefonos.jsp").forward(request, response);
        }
        if (menu.equals("Direcciones")) {
            switch (accion) {
                case "Read":
                    List<Direccion> lista = direccionDAO.listar();
                    request.setAttribute("direcciones", lista);
                    break;
                case "Agregar":
                    String calle = request.getParameter("txtcalle");
                    String distrito = request.getParameter("txtdistrito");
                    String ciudad = request.getParameter("txtciudad");
                    dir.setCALLE(calle);
                    dir.setDISTRITO(distrito);
                    dir.setCIUDAD(ciudad);
                    direccionDAO.agregar(dir);
                    request.getRequestDispatcher("Controlador_tabla?menu=Direcciones&accion=Read").forward(request, response);
                    break;
                case "Update":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Direccion d = direccionDAO.listarId(ide);
                    request.setAttribute("direccion", d);
                    request.getRequestDispatcher("Controlador_tabla?menu=Direcciones&accion=Read").forward(request, response);
                    break;
                case "Actualizar":
                    String calle1 = request.getParameter("txtcalle");
                    String distrito1 = request.getParameter("txtdistrito");
                    String ciudad1 = request.getParameter("txtciudad");
                    dir.setCALLE(calle1);
                    dir.setDISTRITO(distrito1);
                    dir.setCIUDAD(ciudad1);
                    dir.setID_DIRECCION(ide);
                    direccionDAO.actualizar(dir);
                    request.getRequestDispatcher("Controlador_tabla?menu=Direcciones&accion=Read").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    direccionDAO.eliminar(ide);
                    request.getRequestDispatcher("Controlador_tabla?menu=Direcciones&accion=Read").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Direcciones.jsp").forward(request, response);

        }
        if (menu.equals("ReportesDirecciones")) {
            switch (accion) {
                case "reportedireccion":
                    List<Direccion> lista = direccionDAO.listar();
                    request.setAttribute("direcciones", lista);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("reporteDirecciones.jsp").forward(request, response);

        }
        if (menu.equals("Clientes_direcciones")) {
            switch (accion) {
                case "Read":
                    List<Cliente_direccion> lista = cliente_direccionDAO.listar();
                    List<Direccion> direcciones = direccionDAO.obtenerTodasLasDirecciones();
                    List<Cliente> clientes = clienteDAO.obtenerTodosLosClientes();
                    request.setAttribute("clientes", clientes);
                    request.setAttribute("direcciones", direcciones);
                    request.setAttribute("clientes_direcciones", lista);
                    break;
                case "Agregar":
                    String cliente = request.getParameter("txtcliente");
                    String direccion = request.getParameter("txtdireccion");
                    int clienteInt = 0;
                    try {
                        clienteInt = Integer.parseInt(cliente);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    int direccionInt = 0;
                    try {
                        direccionInt = Integer.parseInt(direccion);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    cli_dir.setID_CLIENTE(clienteInt);
                    cli_dir.setID_DIRECCION(direccionInt);
                    cliente_direccionDAO.agregar(cli_dir);
                    request.getRequestDispatcher("Controlador_tabla?menu=Clientes_direcciones&accion=Read").forward(request, response);
                    break;
                case "Update":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Cliente_direccion clie_dire = cliente_direccionDAO.listarId(ide);
                    request.setAttribute("cliente_direccion", clie_dire);
                    request.getRequestDispatcher("Controlador_tabla?menu=Clientes_direcciones&accion=Read").forward(request, response);
                    break;
                case "Actualizar":
                    String cliente1 = request.getParameter("txtcliente");
                    String direccion1 = request.getParameter("txtdireccion");
                    int clienteInt1 = 0;
                    try {
                        clienteInt1 = Integer.parseInt(cliente1);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    int direccionInt1 = 0;
                    try {
                        direccionInt1 = Integer.parseInt(direccion1);
                    } catch (NumberFormatException e) {
                        // Manejo de error: Aquí puedes mostrar un mensaje de error o realizar alguna otra acción en caso de que la conversión falle.
                        // También puedes establecer un valor predeterminado o enviar una respuesta al usuario.
                    }
                    cli_dir.setID_CLIENTE(clienteInt1);
                    cli_dir.setID_DIRECCION(direccionInt1);
                    cli_dir.setID_CLIENTE_DIRECCION(ide);
                    cliente_direccionDAO.actualizar(cli_dir);
                    request.getRequestDispatcher("Controlador_tabla?menu=Clientes_direcciones&accion=Read").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    cliente_direccionDAO.eliminar(ide);
                    request.getRequestDispatcher("Controlador_tabla?menu=Clientes_direcciones&accion=Read").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes_direcciones.jsp").forward(request, response);

        }
        if (menu.equals("ReportesDirecciones_Clientes")) {
            switch (accion) {
                case "reportedireccion_cliente":
                    List<Cliente_direccion> listacliente_dir = cliente_direccionDAO.listar();
                    List<Cliente> listaClientes = clienteDAO.listar();
                    List<Direccion> listaDirecciones = direccionDAO.listar();// Obtener lista de categorías
                    // Obtener lista de proveedores
                    request.setAttribute("clientes_direcciones", listacliente_dir);
                    request.setAttribute("clientes", listaClientes);
                    request.setAttribute("direcciones", listaDirecciones);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("reporteDirecciones_Clientes.jsp").forward(request, response);
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
