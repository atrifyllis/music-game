package gr.alx.game.ejb;

import gr.alx.game.model.GameUser;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserDao
{
    @PersistenceContext
    EntityManager em;

    public List<GameUser> listUsers(){
        return em.createQuery("select u from GameUser u", GameUser.class).getResultList();
    }

    public void addUser(GameUser user){
        em.persist(user);
    }
}