<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>
        
        
        <form class="form-horizontal" name="showInvoices" action="FrontController" method="POST">
               <input type="hidden" name="command" value="showInvoices">
               <input class="btn btn-default" type="submit" value="Show your invoices" >
         </form>
               <% String error = (String) request.getAttribute("error");
            if (error != null) {
                out.println("<H2>Error!!</h2>");
                out.println(error);
            }
        %>
    </body>
</html>
