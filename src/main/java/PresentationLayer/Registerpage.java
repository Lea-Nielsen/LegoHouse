/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.exceptions.LoginException;
import FunctionLayer.exceptions.RegisterException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leage
 */
public class Registerpage extends Command {

    public Registerpage() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws RegisterException {
      return "register"; 
    }
    
}
