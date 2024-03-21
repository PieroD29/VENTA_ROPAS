<%-- 
    Document   : Principal
    Created on : 22 oct 2023, 23:51:45
    Author     : HP SUPPORT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css">
        <title>Sistema de Ventas de Ropa</title>
        <style>
            /* Estilos personalizados */
            .header {
                background-color: #E6E6E6; /* Cambia a tu color de fondo deseado */
                height: 50px; /* Ajusta la altura fija para no superponerse con la barra de menú */
                text-align: center;
                display: flex;
                align-items: center; /* Centra verticalmente el contenido */
                justify-content: space-between; /* Alinea los elementos en lados opuestos */
            }

            .sidebar {
                height: 100%;
                width: 300px; /* Cambia el ancho de la barra de menú aquí */
                position: fixed;
                top: 0;
                left: 0;
                background-color: #333;
                padding-top: 20px;
                overflow-y: auto;
            }

            .sidebar a {
                padding: 10px 25px;
                text-decoration: none;
                font-size: 18px;
                color: #fff;
                display: block;
            }

            .sidebar a:hover {
                background-color: #007BFF;
            }

            .content {
                margin-left: 320px; /* Ajusta el margen izquierdo para dejar espacio al menú lateral */
                padding: 20px;
            }

            .nav-item {
                position: relative;
            }

            .nav-item a:after {
                content: "▶"; /* Agrega el carácter de la flecha */
                position: absolute;
                right: 10px; /* Ajusta la posición de la flecha */
                opacity: 0;
                transition: all 0.3s;
            }

            .nav-item:hover a:after {
                opacity: 1;
                transform: translateX(3px);
            }
            .footer {
                background-color: #333; /* Cambia el color de fondo del footer según tus preferencias */
                color: #fff;
                padding: 20px 0;
                text-align: center;
                position: absolute;
                bottom: 0;
                width: 100%;
            }
            iframe {
                border: none; /* Elimina el borde del iframe */
            }
            .user-info {
                display: flex;
                flex-direction: column;
                align-items: center;
                margin-top: 0px;
            }
        </style>
    </head>
    <body>
        <div class="header">
            <!-- Utiliza Bootstrap para alinear elementos en la cabecera -->
            <div class="d-flex">
                <h1 class="text-white"></h1>
            </div>
            <!-- Muestra el usuario ingresado en la cabecera -->
            <div class="user-info">
                <button style="position: relative; top: 30%; right: 30%;" class="btn btn-outline-info dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${usuario.getusuario()}
                </button>
                <div class="dropdown-menu text-center">
                    <a class="dropdown-item" href="#">                  
                        <img src="img/usuario.png" alt="60" width="60"/>
                    </a>
                    <a class="dropdown-item" href="#">${usuario.getperfil()}</a>
                    <a class="dropdown-item" href="#">${usuario.getotros()}</a>
                    <div class="dropdown-divider"></div>
                    <form action="Validar" method="POST"> 
                        <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="m-4" style="height: 650px;">
            <iframe name="myFrame" style="height: 100%; width: 100%; border:none"></iframe>
        </div>
        <footer class="footer">
            <div class="container text-center">
                <p>&copy; 2023 MODA Y ESTILO "BFKC"</p>
            </div>
        </footer>
        <nav class="navbar navbar-expand-lg navbar-light">
            <div class="container-fluid">
                <div class="row">
                    <!-- Barra lateral izquierda -->
                    <nav class="col-md-2 d-none d-md-block bg-dark sidebar">
                        <ul class="nav flex-column">
                            <li>
                                <a class="nav-link text-white" style="font-size: 25px" href="#"><i class="fas fa-store"></i> &nbsp; Tienda "BFKC" &nbsp; Moda&Estilo </a>
                            </li>
                            <br> <br> 
                            <li class="nav-item">
                                <a class="nav-link text-white" style="font-size: 20px" id="toggleSector1"><i class="fas fa-tags"></i>   &nbsp; CATALOGO</a>
                                <ul id="sector1" class="submenu" style="display: none;">
                                    <li class="nav-item">
                                        <a class="nav-link text-white" href="Controlador_tabla?menu=Productos&accion=Read" target="myFrame">Productos</a>
                                    </li>
                                     
                                    <li class="nav-item">
                                        <a class="nav-link text-white" href="Controlador_tabla?menu=Categorias&accion=Read" target="myFrame">Categorias</a>
                                    </li>
                                      
                                </ul>
                            </li>
                            <br> 
                            <li class="nav-item">
                                <a class="nav-link text-white" style="font-size: 20px" id="toggleSector2"><i class="fas fa-users"></i>   &nbsp;USUARIOS</a>
                                <ul id="sector2" class="submenu" style="display: none;">
                                    <li class="nav-item">
                                        <a class="nav-link text-white" href="Controlador_tabla?menu=Vendedores&accion=Read" target="myFrame">Usuarios</a>
                                    </li>
                                    
                                </ul>
                            </li>
                            <br> 
                           <br> 
                        </ul>
                    </nav>
                </div>
            </div>
        </nav>
        <script>
            // Agregar funciones para mostrar/ocultar los submenús al hacer clic en los sectores
            document.getElementById("toggleSector1").addEventListener("click", function (e) {
                toggleSubMenu("sector1");
                e.preventDefault();
            });

            document.getElementById("toggleSector2").addEventListener("click", function (e) {
                toggleSubMenu("sector2");
                e.preventDefault();
            });


            function toggleSubMenu(submenuId) {
                const submenu = document.getElementById(submenuId);
                if (submenu.style.display === "none") {
                    submenu.style.display = "block";
                } else {
                    submenu.style.display = "none";
                }
            }
        </script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
