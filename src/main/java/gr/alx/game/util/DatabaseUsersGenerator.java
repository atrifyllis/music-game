package gr.alx.game.util;

import gr.alx.game.ejb.UserDao;
import gr.alx.game.model.GameUser;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: trifyllalex
 * Date: 9/7/2013
 * Time: 2:17 μμ
 * To change this template use File | Settings | File Templates.
 */
@Singleton
@Startup
public class DatabaseUsersGenerator {

    @Inject
    UserDao userDao;

    @PostConstruct
    public void initGameUsers() {

        if (userDao.listUsers().size() == 0) {

            GameUser user = new GameUser("Alexandra", "alexkalantzi@gmail.com");
            userDao.addUser(user);
            user = new GameUser("Alexandros", "otinanism@gmail.com");
            userDao.addUser(user);
            user = new GameUser("Eleni", "epapageorgo@gmail.com");
            userDao.addUser(user);
            user = new GameUser("Ifi", "ifitaz@gmail.com");
            userDao.addUser(user);
            user = new GameUser("Kotz", "dkotzonis@gmail.com");
            userDao.addUser(user);
            user = new GameUser("Nota", "tsigarida@gmail.com");
            userDao.addUser(user);
            user = new GameUser("Myrto", "myrtokolyva@gmail.com");
            userDao.addUser(user);
            user = new GameUser("Varvara", "v.zania@gmail.com");
            userDao.addUser(user);
            user = new GameUser("Voula", "voulamit@gmail.com");
            userDao.addUser(user);
            user = new GameUser("Giorgos", "giorgermanos@googlemail.com");
            userDao.addUser(user);
        }
    }
}
