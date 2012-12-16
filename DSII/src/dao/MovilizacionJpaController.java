/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.Movilizacion;
import entidades.MovilizacionPK;
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
public class MovilizacionJpaController implements Serializable {

    public MovilizacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movilizacion movilizacion) throws PreexistingEntityException, Exception {
        if (movilizacion.getMovilizacionPK() == null) {
            movilizacion.setMovilizacionPK(new MovilizacionPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(movilizacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovilizacion(movilizacion.getMovilizacionPK()) != null) {
                throw new PreexistingEntityException("Movilizacion " + movilizacion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movilizacion movilizacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            movilizacion = em.merge(movilizacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                MovilizacionPK id = movilizacion.getMovilizacionPK();
                if (findMovilizacion(id) == null) {
                    throw new NonexistentEntityException("The movilizacion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(MovilizacionPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movilizacion movilizacion;
            try {
                movilizacion = em.getReference(Movilizacion.class, id);
                movilizacion.getMovilizacionPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movilizacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(movilizacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movilizacion> findMovilizacionEntities() {
        return findMovilizacionEntities(true, -1, -1);
    }

    public List<Movilizacion> findMovilizacionEntities(int maxResults, int firstResult) {
        return findMovilizacionEntities(false, maxResults, firstResult);
    }

    private List<Movilizacion> findMovilizacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movilizacion.class));
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

    public Movilizacion findMovilizacion(MovilizacionPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movilizacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovilizacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movilizacion> rt = cq.from(Movilizacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
