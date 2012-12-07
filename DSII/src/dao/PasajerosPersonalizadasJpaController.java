/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.PasajerosPersonalizadas;
import entidades.PasajerosPersonalizadasPK;
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
public class PasajerosPersonalizadasJpaController implements Serializable {

    public PasajerosPersonalizadasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PasajerosPersonalizadas pasajerosPersonalizadas) throws PreexistingEntityException, Exception {
        if (pasajerosPersonalizadas.getPasajerosPersonalizadasPK() == null) {
            pasajerosPersonalizadas.setPasajerosPersonalizadasPK(new PasajerosPersonalizadasPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pasajerosPersonalizadas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPasajerosPersonalizadas(pasajerosPersonalizadas.getPasajerosPersonalizadasPK()) != null) {
                throw new PreexistingEntityException("PasajerosPersonalizadas " + pasajerosPersonalizadas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PasajerosPersonalizadas pasajerosPersonalizadas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pasajerosPersonalizadas = em.merge(pasajerosPersonalizadas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PasajerosPersonalizadasPK id = pasajerosPersonalizadas.getPasajerosPersonalizadasPK();
                if (findPasajerosPersonalizadas(id) == null) {
                    throw new NonexistentEntityException("The pasajerosPersonalizadas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PasajerosPersonalizadasPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PasajerosPersonalizadas pasajerosPersonalizadas;
            try {
                pasajerosPersonalizadas = em.getReference(PasajerosPersonalizadas.class, id);
                pasajerosPersonalizadas.getPasajerosPersonalizadasPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pasajerosPersonalizadas with id " + id + " no longer exists.", enfe);
            }
            em.remove(pasajerosPersonalizadas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PasajerosPersonalizadas> findPasajerosPersonalizadasEntities() {
        return findPasajerosPersonalizadasEntities(true, -1, -1);
    }

    public List<PasajerosPersonalizadas> findPasajerosPersonalizadasEntities(int maxResults, int firstResult) {
        return findPasajerosPersonalizadasEntities(false, maxResults, firstResult);
    }

    private List<PasajerosPersonalizadas> findPasajerosPersonalizadasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PasajerosPersonalizadas.class));
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

    public PasajerosPersonalizadas findPasajerosPersonalizadas(PasajerosPersonalizadasPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PasajerosPersonalizadas.class, id);
        } finally {
            em.close();
        }
    }

    public int getPasajerosPersonalizadasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PasajerosPersonalizadas> rt = cq.from(PasajerosPersonalizadas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
