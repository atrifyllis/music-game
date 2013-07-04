package gr.alx.game.gr.alx.game.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 * Created with IntelliJ IDEA.
 * User: alx
 * Date: 2/7/2013
 * Time: 9:19 μμ
 * To change this template use File | Settings | File Templates.
 */
@Named
public class WelcomeController {

    public String doWelcome(){
        return "test";
    }
}
