/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.TarjetasPersonalizadas;
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
public class TarjetasPersonalizadasJpaController implements Serializable {

    public TarjetasPersonalizadasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TarjetasPersonalizadas tarjetasPersonalizadas) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tarjetasPersonalizadas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTarjetasPersonalizadas(tarjetasPersonalizadas.getPinTarjeta()) != null) {
                throw new PreexistingEntityException("TarjetasPersonalizadas " + tarjetasPersonalizadas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TarjetasPersonalizadas tarjetasPersonalizadas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tarjetasPersonalizadas = em.merge(tarjetasPersonalizadas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tarjetasPersonalizadas.getPinTarjeta();
                if (findTarjetasPersonalizadas(id) == null) {
                    throw new NonexistentEntityException("The tarjetasPersonalizadas with id " + id + " no longer exists.");
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
            TarjetasPersonalizadas tarjetasPersonalizadas;
            try {
                tarjetasPersonalizadas = em.getReference(TarjetasPersonalizadas.class, id);
                tarjetasPersonalizadas.getPinTarjeta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tarjetasPersonalizadas with id " + id + " no longer exists.", enfe);
            }
            em.remove(tarjetasPersonalizadas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TarjetasPersonalizadas> findTarjetasPersonalizadasEntities() {
        return findTarjetasPersonalizadasEntities(true, -1, -1);
    }

    public List<TarjetasPersonalizadas> findTarjetasPersonalizadasEntities(int maxResults, int firstResult) {
        return findTarjetasPersonalizadasEntities(false, maxResults, firstResult);
    }

    private List<TarjetasPersonalizadas> findTarjetasPersonalizadasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TarjetasPersonalizadas.class));
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

    public TarjetasPersonalizadas findTarjetasPersonalizadas(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TarjetasPersonalizadas.class, id);
        } finally {
            em.close();
        }
    }

    public int getTarjetasPersonalizadasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TarjetasPersonalizadas> rt = cq.from(TarjetasPersonalizadas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
