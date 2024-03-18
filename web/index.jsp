<%-- 
    Document   : index
    Created on : 18 oct 2023, 0:09:32
    Author     : HP SUPPORT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
        <style>

            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;

            }

            input[type="submit"] {
                background-color:  turquoise ;
                color: white;
                border: none;
                border-radius: 15px;


                padding: 10px 20px;
                font-weight: bold;
                cursor: pointer;
                transition: background-color 0.3s;
                margin-top: 20px;
                margin-left: auto;
                margin-right: auto;
                display: block; /* Esto asegura que el botón ocupe todo el ancho disponible. */
            }
        </style>
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card col-sm-10">
                <div class="card-body">
                    <form class="form-sing " action="Validar" method="POST">
                        <div class="form-group text-center">
                            <h3 style="font-size: 45px;">LOGIN</h3>
                            <img src="img/tienda.png" alt="70" width="170">
                            <br><br>
                            <label style="font-size: 30px;">Bienvenidos al sistema "BFKC" Moda y Estilo</label>
                        </div>
                        <div class="form-group">
                            <label>Usuario:</label>
                            <input type="text" name="txtuser" placeholder="Username" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Password:</label>
                            <input type="password" name="txtpass" placeholder="Password" class="form-control"> 
                        </div>
                        <input type="submit" name="accion" style="color: black;" value="Ingresar" class="btn-btn-primary" class="bt-block">
                    </form>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>