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
public class JpaMahasiswa {

    public JpaMahasiswa() {
        emf = Persistence.createEntityManagerFactory("SmashPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Fungsi untuk membuat mahasiswa baru
     */
    public void create(Mahasiswa mahasiswa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mahasiswa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMahasiswa(mahasiswa.getNama()) != null) {
                throw new PreexistingEntityException("Mahasiswa " + mahasiswa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Fungsi untuk mengedit mahasiswa dengan input berupa objek mahasiswa
     */
    public void edit(Mahasiswa mahasiswa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mahasiswa = em.merge(mahasiswa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = mahasiswa.getNama();
                if (findMahasiswa(id) == null) {
                    throw new NonexistentEntityException("The mahasiswa with id " + id + " no longer exists.");
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
     * Fungsi untuk menghapus mahasiswa yang ada dengan input berupa nrp
     */
    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mahasiswa mahasiswa;
            try {
                mahasiswa = em.getReference(Mahasiswa.class, id);
                mahasiswa.getNama();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mahasiswa with id " + id + " no longer exists.", enfe);
            }
            em.remove(mahasiswa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    public Mahasiswa findMahasiswa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mahasiswa.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Fungsi untuk mencari mahasiswa berdasarkan nrp
     */
     public Mahasiswa findMahasiswaByNrp(String nrp) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Mahasiswa c WHERE c.nrp =:nrp");
            query.setParameter("nrp", nrp);
            List list = query.getResultList();
            if (list.size() == 1) {

                return (Mahasiswa) list.get(0);


            } else {
                return null;
            }
        } finally {
            em.close();
        }
    }

     /**
     * Fungsi untuk mengambil seluruh mahasiswa yang tersimpan dalam DB
     */
      public List<Mahasiswa> getAllMahasiswa() {
        List<Mahasiswa> mahasiswa = new ArrayList<Mahasiswa>();
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT o FROM Mahasiswa o WHERE o.isadmin=:isadmin");
            q.setParameter("isadmin", false);
            mahasiswa = q.getResultList();

        } finally {
            if (em != null) {
                em.close();
            }
        }
        return mahasiswa;
    }

}
