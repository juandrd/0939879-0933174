/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.DirectoresOperativos;
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
public class DirectoresOperativosJpaController implements Serializable {

    public DirectoresOperativosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DirectoresOperativos directoresOperativos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(directoresOperativos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDirectoresOperativos(directoresOperativos.getIdentificacion()) != null) {
                throw new PreexistingEntityException("DirectoresOperativos " + directoresOperativos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DirectoresOperativos directoresOperativos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            directoresOperativos = em.merge(directoresOperativos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = directoresOperativos.getIdentificacion();
                if (findDirectoresOperativos(id) == null) {
                    throw new NonexistentEntityException("The directoresOperativos with id " + id + " no longer exists.");
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
            DirectoresOperativos directoresOperativos;
            try {
                directoresOperativos = em.getReference(DirectoresOperativos.class, id);
                directoresOperativos.getIdentificacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The directoresOperativos with id " + id + " no longer exists.", enfe);
            }
            em.remove(directoresOperativos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DirectoresOperativos> findDirectoresOperativosEntities() {
        return findDirectoresOperativosEntities(true, -1, -1);
    }

    public List<DirectoresOperativos> findDirectoresOperativosEntities(int maxResults, int firstResult) {
        return findDirectoresOperativosEntities(false, maxResults, firstResult);
    }

    private List<DirectoresOperativos> findDirectoresOperativosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DirectoresOperativos.class));
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

    public DirectoresOperativos findDirectoresOperativos(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DirectoresOperativos.class, id);
        } finally {
            em.close();
        }
    }

    public int getDirectoresOperativosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DirectoresOperativos> rt = cq.from(DirectoresOperativos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
