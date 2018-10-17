
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.exceptions.OrderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author leage
 */
public class ShipOrder extends Command {

    public ShipOrder() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws OrderException {
        HttpSession session = request.getSession();

        Order order = (Order) session.getAttribute("order");
        order = LogicFacade.shipOrder(order);
        order.setShipped(true);

        session.setAttribute("order", order);

        return "showInvoiceDetails";
    }

}
