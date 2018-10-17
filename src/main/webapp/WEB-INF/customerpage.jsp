<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Customer page</title>


        <!--Bootsrap 4 CDN-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <!--Fontawesome CDN-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

        <!--Custom styles-->
        <link rel="stylesheet" type="text/css" href="css.css">

    </head>
    <body>

     
        <% String error = (String) request.getAttribute("error");
            if (error != null) {
                out.println("<H2>Error!!</h2>");
                out.println(error);
            }
        %>  


        <div class="container">
            <div class="d-flex justify-content-center h-100">
                <div class="card">
                    <div class="card-header">
                        <h3>Create your order</h3>

                    </div>
                    <div class="card-body">
                        <form class="form-horizontal" name="createOrder" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="createOrder">
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i></i></span>
                                </div>
                                <input type="number" class="form-control" placeholder="Type in length here"required min="3" name="length">

                            </div>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i></i></span>
                                </div>
                                <input type="number" class="form-control" placeholder="Type in width here"required min="3" name="width">
                            </div>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i></i></span>
                                </div>
                                <input type="number" class="form-control" placeholder="Type in number of layers here" min="2" name="layers">
                            </div>

                            <div class="form-group">
                                <input type="submit" value="Create" class="btn float-right login_btn">
                            </div>
                        </form>
                        <form class="form-horizontal" name="showInvoices" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="showInvoices">
                            <input class="btn btn-default" type="submit" value="Show your invoices" >
                        </form>

                    </div>

                </div>
            </div>
        </div>
    </body>
</html>




