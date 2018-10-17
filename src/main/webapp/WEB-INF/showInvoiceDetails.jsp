<%-- 
    Document   : showInvoiceDetails
    Created on : 11-10-2018, 11:17:13
    Author     : leage
--%>

<%@page import="FunctionLayer.LegoHouseLayer"%>
<%@page import="FunctionLayer.LegoHouse"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List,java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <title>Show invoices</title>



    </head>
    <body>


        <%User user = (User) request.getSession().getAttribute("user");%>
        <%Order order = (Order) request.getSession().getAttribute("order");%>
        <%LegoHouse house = (LegoHouse) request.getSession().getAttribute("house");%>
        <%LegoHouseLayer layer1 = (LegoHouseLayer) house.getListOfLayers().get(0);%>
        <%LegoHouseLayer layer2 = (LegoHouseLayer) house.getListOfLayers().get(1);%>
        <%int allBricks = (int) request.getSession().getAttribute("bricks");%>


        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="invoice-title">
                        <h2>Invoice</h2><h3 class="pull-center">Order number: <%out.println(order.getId());%> </h3>
                        <form class="form-horizontal" name="showInvoices" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="showInvoices">
                            <input class="btn btn-default" type="submit" value="Go back to invoices" >
                        </form>
                        <%if (user.getRole().equals("employee")) {%>
                        <form class="form-horizontal" name="shipOrder" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="shipOrder">
                            <input class="btn btn-default" type="submit" value="Ship this order" >
                        </form>
                        <%}%>
                    </div>
                    <hr>
                    <div class="row">

                        <div class="col-xs-6 text-left">
                            <address>
                                <strong>Details:</strong><br>
                                Lenght : <%out.println(order.getLength());%><br>
                                Width: <%out.println(order.getWidth());%><br>
                                Layers: <%out.println(order.getLayers());%><br>
                                Shipped: <%out.print(order.isShipped());%><br> 
                                Bricks total for making the house: <%out.print(allBricks);%> 

                            </address>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6">

                        </div>

                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title"><strong>Order summary</strong></h3>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table border="1" style="text-align: center" >
                                    <tr>

                                        <th><p>Type of Bricks for layer 1 </th>
                                        <th><p>House Side East:</th>
                                        <th><p>House Side West:</th>
                                        <th><p>House Side South:</th>
                                        <th><p>House side North: </th>

                                    <tr>
                                        <th><p>4x2</th>
                                        <td><p><%out.print(layer1.getSideEast().getBrick4()); %></td>
                                        <td><p><%out.print(layer1.getSideWest().getBrick4()); %></td>
                                        <td><p><%out.print(layer1.getSideSouth().getBrick4()); %></td>
                                        <td><p><%out.print(layer1.getSideNorth().getBrick4());%></td>
                                    </tr>
                                    <tr>
                                        <th><p>2x2</th>
                                        <td><p><%out.print(layer1.getSideEast().getBrick2()); %></td>
                                        <td><p><%out.print(layer1.getSideWest().getBrick2()); %></td>
                                        <td><p><%out.print(layer1.getSideSouth().getBrick2()); %></td>
                                        <td><p><%out.print(layer1.getSideNorth().getBrick2());%></td>
                                    </tr>
                                    <tr>
                                        <th><p>1x2</th>
                                        <td><p><%out.print(layer1.getSideEast().getBrick1()); %></td>
                                        <td><p><%out.print(layer1.getSideWest().getBrick1()); %></td>
                                        <td><p><%out.print(layer1.getSideSouth().getBrick1()); %></td>
                                        <td><p><%out.print(layer1.getSideNorth().getBrick1());%></td>
                                    </tr>

                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title"><strong>Order summary</strong></h3>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table border="1" style="text-align: center" >
                                    <tr>

                                        <th><p>Type of Bricks for layer 2 </th>
                                        <th><p>House Side East:</th>
                                        <th><p>House Side West:</th>
                                        <th><p>House Side South:</th>
                                        <th><p>House side North: </th>

                                    <tr>
                                        <th><p>4x2</th>
                                        <td><p><%out.print(layer2.getSideEast().getBrick4()); %></td>
                                        <td><p><%out.print(layer2.getSideWest().getBrick4()); %></td>
                                        <td><p><%out.print(layer2.getSideSouth().getBrick4()); %></td>
                                        <td><p><%out.print(layer2.getSideNorth().getBrick4());%></td>
                                    </tr>
                                    <tr>
                                        <th><p>2x2</th>
                                        <td><p><%out.print(layer2.getSideEast().getBrick2()); %></td>
                                        <td><p><%out.print(layer2.getSideWest().getBrick2()); %></td>
                                        <td><p><%out.print(layer2.getSideSouth().getBrick2()); %></td>
                                        <td><p><%out.print(layer2.getSideNorth().getBrick2());%></td>
                                    </tr>
                                    <tr>
                                        <th><p>1x2</th>
                                        <td><p><%out.print(layer2.getSideEast().getBrick1()); %></td>
                                        <td><p><%out.print(layer2.getSideWest().getBrick1()); %></td>
                                        <td><p><%out.print(layer2.getSideSouth().getBrick1()); %></td>
                                        <td><p><%out.print(layer2.getSideNorth().getBrick1());%></td>
                                    </tr>
                                    <% String error = (String) request.getAttribute("error");
                                        if (error != null) {
                                            out.println("<H2>Error!!</h2>");
                                            out.println(error);
                                        }
                                    %>         
                                </table>


                            </div>
                        </div>
                    </div>
                </div>
            </div>      

        </div>
        <br>
    </body>

</html>

