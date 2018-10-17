/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LegoHouse;
import FunctionLayer.LegoHouseLayer;
import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.exceptions.OrderException;
import FunctionLayer.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author leage
 */
public class ShowInvoiceDetails extends Command {

    public ShowInvoiceDetails() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws OrderException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Order> orders = (List<Order>) session.getAttribute("orders");

        Order order = LogicFacade.getOrderById(Integer.parseInt(request.getParameter("invoiceId")), user);
        LegoHouse house = LogicFacade.getHouse(order.getLength(), order.getWidth(), order.getLayers());
        LegoHouseLayer layer = LogicFacade.getSingleLayer(house);
        int bricks = LogicFacade.getAllBricksForLegoHouse(layer, order);

        session.setAttribute("orders", orders);
        session.setAttribute("house", house);
        session.setAttribute("layer", layer);
        session.setAttribute("bricks", bricks);
        session.setAttribute("order", order);

        return "showInvoiceDetails";
    }
    
}
