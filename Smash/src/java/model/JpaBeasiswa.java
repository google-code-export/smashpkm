/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author yosua
 */
public class JpaBeasiswa {

    public JpaBeasiswa() {
        emf = Persistence.createEntityManagerFactory("SmashPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Fungsi untuk membuat beasiswa baru
     */
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

    /**
     * Fungsi untuk mengedit beasiswa dengan input berupa objek beasiswa
     */
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

    /**
     * Fungsi untuk menghapus beasiswa yang ada dengan input berupa idbeasiswa
     */
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

    public Beasiswa findBeasiswa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Beasiswa.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Fungsi untuk mengambil seluruh beasiswa yang tersimpan dalam DB
     */
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

    /**
     * Fungsi untuk mencari beasiswa berdasarkan idbeasiswa
     */
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
