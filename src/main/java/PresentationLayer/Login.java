package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.exceptions.LoginException;
import FunctionLayer.Order;
import FunctionLayer.exceptions.OrderException;
import FunctionLayer.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException, OrderException {
        HttpSession session = request.getSession();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = LogicFacade.login(email, password);

        List<Order> orders = null;
        if (user.getRole().equals("customer")) {
            orders = LogicFacade.getUserOrder(user);

        } else if (user.getRole().equals("employee")) {
            orders = LogicFacade.getAllOrders();
            session.setAttribute("user", user);
            session.setAttribute("orders", orders);
            return "showInvoices";
        }

        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        session.setAttribute("user_id", user.getId());
        session.setAttribute("orders", orders);

        return user.getRole() + "page";
    }

}
