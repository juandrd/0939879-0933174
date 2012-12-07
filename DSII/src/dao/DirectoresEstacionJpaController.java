/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.DirectoresEstacion;
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
public class DirectoresEstacionJpaController implements Serializable {

    public DirectoresEstacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DirectoresEstacion directoresEstacion) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(directoresEstacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDirectoresEstacion(directoresEstacion.getIdentificacion()) != null) {
                throw new PreexistingEntityException("DirectoresEstacion " + directoresEstacion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DirectoresEstacion directoresEstacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            directoresEstacion = em.merge(directoresEstacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = directoresEstacion.getIdentificacion();
                if (findDirectoresEstacion(id) == null) {
                    throw new NonexistentEntityException("The directoresEstacion with id " + id + " no longer exists.");
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
            DirectoresEstacion directoresEstacion;
            try {
                directoresEstacion = em.getReference(DirectoresEstacion.class, id);
                directoresEstacion.getIdentificacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The directoresEstacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(directoresEstacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DirectoresEstacion> findDirectoresEstacionEntities() {
        return findDirectoresEstacionEntities(true, -1, -1);
    }

    public List<DirectoresEstacion> findDirectoresEstacionEntities(int maxResults, int firstResult) {
        return findDirectoresEstacionEntities(false, maxResults, firstResult);
    }

    private List<DirectoresEstacion> findDirectoresEstacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DirectoresEstacion.class));
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

    public DirectoresEstacion findDirectoresEstacion(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DirectoresEstacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getDirectoresEstacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DirectoresEstacion> rt = cq.from(DirectoresEstacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
