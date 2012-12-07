/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.Reclamos;
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
public class ReclamosJpaController implements Serializable {

    public ReclamosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reclamos reclamos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(reclamos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findReclamos(reclamos.getCodigo()) != null) {
                throw new PreexistingEntityException("Reclamos " + reclamos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reclamos reclamos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            reclamos = em.merge(reclamos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = reclamos.getCodigo();
                if (findReclamos(id) == null) {
                    throw new NonexistentEntityException("The reclamos with id " + id + " no longer exists.");
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
            Reclamos reclamos;
            try {
                reclamos = em.getReference(Reclamos.class, id);
                reclamos.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reclamos with id " + id + " no longer exists.", enfe);
            }
            em.remove(reclamos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reclamos> findReclamosEntities() {
        return findReclamosEntities(true, -1, -1);
    }

    public List<Reclamos> findReclamosEntities(int maxResults, int firstResult) {
        return findReclamosEntities(false, maxResults, firstResult);
    }

    private List<Reclamos> findReclamosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reclamos.class));
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

    public Reclamos findReclamos(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reclamos.class, id);
        } finally {
            em.close();
        }
    }

    public int getReclamosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reclamos> rt = cq.from(Reclamos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
