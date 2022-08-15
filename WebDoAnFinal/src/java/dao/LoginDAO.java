/**
 *
 * @author thanh
 */
package dao;

import entity.Clients;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class LoginDAO {
    private EntityManager em;
    

    public LoginDAO(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }
    
    public Clients searchById(String id) {
        return em.find(Clients.class, id);
    }
    
    public void addClient(Clients client){
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.persist(client);
            trans.commit();
        } catch (Exception ex){
            if (trans != null && trans.isActive()) {
                trans.rollback();
            }
        }
    }
    
    public void close() {
        em.close();
    }
}
