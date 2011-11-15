 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Beasiswa;

/**
 *
 * @author yosua
 */
public class BeasiswaJpaController {


    public BeasiswaJpaController() {
        emf = Persistence.createEntityManagerFactory("SmashPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Beasiswa beasiswa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(beasiswa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBeasiswa(beasiswa.getIdbeasiswa()) != null) {
                throw new PreexistingEntityException("Beasiswa " + beasiswa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Beasiswa beasiswa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            beasiswa = em.merge(beasiswa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = beasiswa.getIdbeasiswa();
                if (findBeasiswa(id) == null) {
                    throw new NonexistentEntityException("The beasiswa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Beasiswa beasiswa;
            try {
                beasiswa = em.getReference(Beasiswa.class, id);
                beasiswa.getIdbeasiswa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The beasiswa with id " + id + " no longer exists.", enfe);
            }
            em.remove(beasiswa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Beasiswa> findBeasiswaEntities() {
        return findBeasiswaEntities(true, -1, -1);
    }

    public List<Beasiswa> findBeasiswaEntities(int maxResults, int firstResult) {
        return findBeasiswaEntities(false, maxResults, firstResult);
    }

    private List<Beasiswa> findBeasiswaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Beasiswa.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Beasiswa> getAllBeasiswa() {
        List<Beasiswa> beasiswa = new ArrayList<Beasiswa>();
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT o FROM Beasiswa o");
            beasiswa = q.getResultList();

        } finally {
            if (em != null) {
                em.close();
            }
        }
        return beasiswa;
    }


    public Beasiswa findBeasiswa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Beasiswa.class, id);
        } finally {
            em.close();
        }
    }

    public int getBeasiswaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Beasiswa> rt = cq.from(Beasiswa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

     public Beasiswa findBeasiswaById(String idBeasiswa) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Beasiswa c WHERE c.idbeasiswa =:idbeasiswa");
            query.setParameter("idbeasiswa", idBeasiswa);
            List list = query.getResultList();
            if (list.size() == 1) {

                return (Beasiswa) list.get(0);


            } else {
                return null;
            }
        } finally {
            em.close();
        }
    }
}
