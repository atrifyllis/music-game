package gr.alx.game.ejb;

import gr.alx.game.model.GameUser;
import gr.alx.game.util.DatabaseUsersGenerator;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class UserDaoTest {
    @Inject
    private UserDao userdao;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addClasses(UserDao.class, DatabaseUsersGenerator.class)
                .addPackage(GameUser.class.getPackage())
//                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("test-persistence.xml",
                        ArchivePaths.create("persistence.xml"))
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testIsDeployed() {
        assertNotNull(userdao);
    }

    @Test
    public void testListUsers() {
        List<GameUser> users = userdao.listUsers();
        assertNotNull(users);
        assertThat(users.size(), is(10));
    }

    @Test
    @Transactional(TransactionMode.ROLLBACK)
    public void testAddUser() {
        userdao.addUser(new GameUser("test", "test@test.com"));
        GameUser user = userdao.getUserByUsername("test");
        assertNotNull(user);
        assertThat(user.getEmail(), is("test@test.com"));
    }
}
