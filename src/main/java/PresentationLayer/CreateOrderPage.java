package PresentationLayer;

import FunctionLayer.User;
import FunctionLayer.exceptions.LoginException;
import FunctionLayer.exceptions.OrderException;
import FunctionLayer.exceptions.RegisterException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author leage
 */
public class CreateOrderPage extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException, OrderException, RegisterException {
        User user = (User) request.getSession().getAttribute("user");
        return user.getRole() + "page";

    }
}
