package gr.alx.game.controllers;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Created with IntelliJ IDEA.
 * User: alx
 * Date: 2/7/2013
 * Time: 9:19 μμ
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class WelcomeController {

    public String doWelcome(){
        return "test";
    }
}
