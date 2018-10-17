/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.exceptions.OrderException;
import FunctionLayer.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leage
 */
public class ShowInvoices extends Command {

    public ShowInvoices() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws OrderException {
        User user = (User) request.getSession().getAttribute("user");
        List<Order> orders = new ArrayList<>();

        if (user.getRole().equals("customer")) {
            orders = LogicFacade.getUserOrder(user);
        } else if (user.getRole().equals("employee")) {
            orders = LogicFacade.getAllOrders();
        }

        request.getSession().setAttribute("orders", orders);

        return "showInvoices";

    }

}
