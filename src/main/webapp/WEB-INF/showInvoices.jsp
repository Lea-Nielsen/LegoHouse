<%-- 
    Document   : showInvoices
    Created on : 10-10-2018, 20:28:12
    Author     : leage
--%>

<%@page import="FunctionLayer.LegoHouse"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <h1 class="col-sm-4" style="text-align: center">Recipes</h1>

        <div align="center" class="text-muted col-sm-4" padding="4px">
            <%User user = (User) request.getSession().getAttribute("user");%>
            <%List<Order> orders = (List) request.getSession().getAttribute("orders");%>
        
            <ul class="list-group pre-scrollable">



                <% if (orders == null || orders.isEmpty()) {
                        out.println("You have no orders, try making one");
                    } else {
                        for (Order order : orders) {
                            out.println("<li><a href=\"FrontController?command=showInvoiceDetails&invoiceId=" + order.getId() + "\">InvoiceID: " + order.getId() + "</li><br>");
                        }
                    }
                %>    
            </ul>
            <%if (user.getRole().equals("customer")) {%>
            <form class="form-horizontal" name="CreateOrderPage" action="FrontController" method="POST">
                <input type="hidden" name="command" value="CreateOrderPage">
                <input class="btn btn-default" type="submit" value="Go back to create order" >
            </form>
            <%}%>
        </div>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {
                out.println("<H2>Error!!</h2>");
                out.println(error);
            }
        %>
    </body>
</html>

<br><br>
