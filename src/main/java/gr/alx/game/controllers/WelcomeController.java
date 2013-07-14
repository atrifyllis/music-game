package gr.alx.game.controllers;


import gr.alx.game.ejb.UserDao;
import gr.alx.game.model.GameUser;
import gr.alx.game.util.DatabaseUsersGenerator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * GameUser: alx
 * Date: 2/7/2013
 * Time: 9:19 μμ
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class WelcomeController {

    @Inject
    UserDao userDao;

    public String doWelcome(){

        GameUser user = new GameUser("test", "test");

        try {
            userDao.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<GameUser> gameUserList = userDao.listUsers();
        return "Users in database: "+gameUserList.size();
    }
}
