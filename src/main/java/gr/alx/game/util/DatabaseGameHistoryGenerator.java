package gr.alx.game.util;

import gr.alx.game.ejb.GameHistoryDao;
import gr.alx.game.ejb.UserDao;
import gr.alx.game.model.GameHistory;
import gr.alx.game.model.GameUser;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.Date;
import java.util.HashMap;
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
@DependsOn("DatabaseUsersGenerator")
public class DatabaseGameHistoryGenerator {

    @Inject
    UserDao userDao;
    @Inject
    GameHistoryDao historyDao;

    @PostConstruct
    public void initGameUsers() {
        Date now = new Date();
        if (historyDao.listGameHistoryForDate(now).size() == 0) {
            GameUser user = userDao.getUserByUsername("Alexandra");

            GameHistory history = new GameHistory(now, user, "test", "http://youtube.com", "");
            historyDao.addGameHistoryEntry(history);

            user = userDao.getUserByUsername("Alexandros");
            history = new GameHistory(now, user, "test", "http://youtube.com", "");
            historyDao.addGameHistoryEntry(history);

            user = userDao.getUserByUsername("Eleni");
            history = new GameHistory(now, user, "test", "http://youtube.com", "");
            historyDao.addGameHistoryEntry(history);

            user = userDao.getUserByUsername("Ifi");
            history = new GameHistory(now, user, "test", "http://youtube.com", "");
            historyDao.addGameHistoryEntry(history);
        }
    }
}
