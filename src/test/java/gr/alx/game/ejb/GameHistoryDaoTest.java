package gr.alx.game.ejb;

import gr.alx.game.model.GameHistory;
import gr.alx.game.model.GameUser;
import gr.alx.game.util.DatabaseGameHistoryGenerator;
import gr.alx.game.util.DatabaseUsersGenerator;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(Arquillian.class)
public class GameHistoryDaoTest {
    @Inject
    private GameHistoryDao gamehistorydao;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addClasses(UserDao.class, GameHistoryDao.class, DatabaseUsersGenerator.class, DatabaseGameHistoryGenerator.class)
                .addPackage(GameUser.class.getPackage())
                .addAsManifestResource("test-persistence.xml",
                        ArchivePaths.create("persistence.xml"))
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testIsDeployed() {
        Assert.assertNotNull(gamehistorydao);
    }

    @Test
    public void testListGameHistoriesForToday() {
        List<GameHistory> histories = gamehistorydao.listGameHistoryForDate(new Date());
        assertNotNull(histories);
        assertThat(histories.size(), is(4));
    }
}
