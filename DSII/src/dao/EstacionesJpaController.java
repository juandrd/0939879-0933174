/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.Estaciones;
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
public class EstacionesJpaController implements Serializable {

    public EstacionesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estaciones estaciones) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(estaciones);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEstaciones(estaciones.getNombre()) != null) {
                throw new PreexistingEntityException("Estaciones " + estaciones + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estaciones estaciones) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            estaciones = em.merge(estaciones);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = estaciones.getNombre();
                if (findEstaciones(id) == null) {
                    throw new NonexistentEntityException("The estaciones with id " + id + " no longer exists.");
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
            Estaciones estaciones;
            try {
                estaciones = em.getReference(Estaciones.class, id);
                estaciones.getNombre();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estaciones with id " + id + " no longer exists.", enfe);
            }
            em.remove(estaciones);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estaciones> findEstacionesEntities() {
        return findEstacionesEntities(true, -1, -1);
    }

    public List<Estaciones> findEstacionesEntities(int maxResults, int firstResult) {
        return findEstacionesEntities(false, maxResults, firstResult);
    }

    private List<Estaciones> findEstacionesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estaciones.class));
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

    public Estaciones findEstaciones(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estaciones.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstacionesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estaciones> rt = cq.from(Estaciones.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
