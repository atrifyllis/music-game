package gr.alx.game.ejb;

import gr.alx.game.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserDao
{
    @PersistenceContext
    EntityManager em;

    public List<User> listUsers(){
        return em.createQuery("select u from User u", User.class).getResultList();
    }
}