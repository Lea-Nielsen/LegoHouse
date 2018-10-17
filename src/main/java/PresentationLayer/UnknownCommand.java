package PresentationLayer;

import FunctionLayer.exceptions.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UnknownCommand extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginException {
        String msg = "Unknown command";
        throw new LoginException( msg );
        
    }

}
