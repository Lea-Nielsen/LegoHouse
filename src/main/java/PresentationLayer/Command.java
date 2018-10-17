package PresentationLayer;

import FunctionLayer.exceptions.LoginException;
import FunctionLayer.exceptions.OrderException;
import FunctionLayer.exceptions.RegisterException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "createOrder", new CreateOrder() );
        commands.put( "showInvoices", new ShowInvoices() );
        commands.put( "showInvoiceDetails", new ShowInvoiceDetails() );
        commands.put( "registerpage", new Registerpage() );
        commands.put( "shipOrder", new ShipOrder() );
        commands.put( "CreateOrderPage", new CreateOrderPage());
     
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginException, OrderException, RegisterException;
       

}
