/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.TarjetasGenericas;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author chokuno
 */
public class TarjetasGenericasJpaController implements Serializable {

    public TarjetasGenericasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TarjetasGenericas tarjetasGenericas) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tarjetasGenericas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTarjetasGenericas(tarjetasGenericas.getPinTarjeta()) != null) {
                throw new PreexistingEntityException("TarjetasGenericas " + tarjetasGenericas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TarjetasGenericas tarjetasGenericas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tarjetasGenericas = em.merge(tarjetasGenericas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tarjetasGenericas.getPinTarjeta();
                if (findTarjetasGenericas(id) == null) {
                    throw new NonexistentEntityException("The tarjetasGenericas with id " + id + " no longer exists.");
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
            TarjetasGenericas tarjetasGenericas;
            try {
                tarjetasGenericas = em.getReference(TarjetasGenericas.class, id);
                tarjetasGenericas.getPinTarjeta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tarjetasGenericas with id " + id + " no longer exists.", enfe);
            }
            em.remove(tarjetasGenericas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TarjetasGenericas> findTarjetasGenericasEntities() {
        return findTarjetasGenericasEntities(true, -1, -1);
    }

    public List<TarjetasGenericas> findTarjetasGenericasEntities(int maxResults, int firstResult) {
        return findTarjetasGenericasEntities(false, maxResults, firstResult);
    }

    private List<TarjetasGenericas> findTarjetasGenericasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TarjetasGenericas.class));
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

    public TarjetasGenericas findTarjetasGenericas(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TarjetasGenericas.class, id);
        } finally {
            em.close();
        }
    }

    public int getTarjetasGenericasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TarjetasGenericas> rt = cq.from(TarjetasGenericas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
