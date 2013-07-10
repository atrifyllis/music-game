package gr.alx.game.ejb;

import gr.alx.game.model.GameUser;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserDao {
    @PersistenceContext
    EntityManager em;

    public GameUser getUser(Long id) {
        return em.find(GameUser.class, id);
    }

    public GameUser getUserByUsername(String username) {
        Query query = em.createQuery("select u from GameUser u where u.username=:username");
        query.setParameter("username", username);
        return (GameUser) query.getSingleResult();
    }

    public List<GameUser> listUsers() {
        return em.createQuery("select u from GameUser u", GameUser.class).getResultList();
    }

    public void addUser(GameUser user) {
        em.persist(user);
    }
}