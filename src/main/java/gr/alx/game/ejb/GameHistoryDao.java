package gr.alx.game.ejb;

import gr.alx.game.model.GameHistory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Stateless
public class GameHistoryDao {
    @PersistenceContext
    EntityManager em;

//    public GameUser getUser(Long id) {
//        return em.find(GameUser.class, id);
//    }

//    public GameUser getUserByUsername(String username) {
//        Query query = em.createQuery("select u from GameUser u where u.username=:username");
//        query.setParameter("username", username);
//        return (GameUser) query.getSingleResult();
//    }

    public List<GameHistory> listGameHistoryForDate(Date date) {
        Query query = em.createQuery("select h from GameHistory h where h.date=:date");
        query.setParameter("date", date, TemporalType.DATE);
        return query.getResultList();
    }

    public void addGameHistoryEntry(GameHistory historyRecord) {
        em.persist(historyRecord);
    }
}