
package PresentationLayer;

import FunctionLayer.exceptions.LoginException;
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
public class CreateOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws OrderException, LoginException {
        HttpSession session = request.getSession();
        
        User user = (User) session.getAttribute("user");
        List orders = LogicFacade.getUserOrder(user);

        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int layers = Integer.parseInt(request.getParameter("layers"));

        
        Order order = LogicFacade.createOrder(length, width, layers, user);
        orders.add(order);

        session.setAttribute("order", order);
        session.setAttribute("orders", orders);
        return user.getRole() + "page";

    }

}
