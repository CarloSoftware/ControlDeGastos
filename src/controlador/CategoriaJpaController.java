/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Ingreso;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Categoria;
import modelo.Egreso;

/**
 *
 * @author ARTESANO
 */
public class CategoriaJpaController implements Serializable {

    public CategoriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Categoria categoria) {
        if (categoria.getIngresoList() == null) {
            categoria.setIngresoList(new ArrayList<Ingreso>());
        }
        if (categoria.getEgresoList() == null) {
            categoria.setEgresoList(new ArrayList<Egreso>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Ingreso> attachedIngresoList = new ArrayList<Ingreso>();
            for (Ingreso ingresoListIngresoToAttach : categoria.getIngresoList()) {
                ingresoListIngresoToAttach = em.getReference(ingresoListIngresoToAttach.getClass(), ingresoListIngresoToAttach.getIdIngreso());
                attachedIngresoList.add(ingresoListIngresoToAttach);
            }
            categoria.setIngresoList(attachedIngresoList);
            List<Egreso> attachedEgresoList = new ArrayList<Egreso>();
            for (Egreso egresoListEgresoToAttach : categoria.getEgresoList()) {
                egresoListEgresoToAttach = em.getReference(egresoListEgresoToAttach.getClass(), egresoListEgresoToAttach.getIdEgreso());
                attachedEgresoList.add(egresoListEgresoToAttach);
            }
            categoria.setEgresoList(attachedEgresoList);
            em.persist(categoria);
            for (Ingreso ingresoListIngreso : categoria.getIngresoList()) {
                Categoria oldIdCategoriaOfIngresoListIngreso = ingresoListIngreso.getIdCategoria();
                ingresoListIngreso.setIdCategoria(categoria);
                ingresoListIngreso = em.merge(ingresoListIngreso);
                if (oldIdCategoriaOfIngresoListIngreso != null) {
                    oldIdCategoriaOfIngresoListIngreso.getIngresoList().remove(ingresoListIngreso);
                    oldIdCategoriaOfIngresoListIngreso = em.merge(oldIdCategoriaOfIngresoListIngreso);
                }
            }
            for (Egreso egresoListEgreso : categoria.getEgresoList()) {
                Categoria oldIdCategoriaOfEgresoListEgreso = egresoListEgreso.getIdCategoria();
                egresoListEgreso.setIdCategoria(categoria);
                egresoListEgreso = em.merge(egresoListEgreso);
                if (oldIdCategoriaOfEgresoListEgreso != null) {
                    oldIdCategoriaOfEgresoListEgreso.getEgresoList().remove(egresoListEgreso);
                    oldIdCategoriaOfEgresoListEgreso = em.merge(oldIdCategoriaOfEgresoListEgreso);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Categoria categoria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria persistentCategoria = em.find(Categoria.class, categoria.getIdCategoria());
            List<Ingreso> ingresoListOld = persistentCategoria.getIngresoList();
            List<Ingreso> ingresoListNew = categoria.getIngresoList();
            List<Egreso> egresoListOld = persistentCategoria.getEgresoList();
            List<Egreso> egresoListNew = categoria.getEgresoList();
            List<Ingreso> attachedIngresoListNew = new ArrayList<Ingreso>();
            for (Ingreso ingresoListNewIngresoToAttach : ingresoListNew) {
                ingresoListNewIngresoToAttach = em.getReference(ingresoListNewIngresoToAttach.getClass(), ingresoListNewIngresoToAttach.getIdIngreso());
                attachedIngresoListNew.add(ingresoListNewIngresoToAttach);
            }
            ingresoListNew = attachedIngresoListNew;
            categoria.setIngresoList(ingresoListNew);
            List<Egreso> attachedEgresoListNew = new ArrayList<Egreso>();
            for (Egreso egresoListNewEgresoToAttach : egresoListNew) {
                egresoListNewEgresoToAttach = em.getReference(egresoListNewEgresoToAttach.getClass(), egresoListNewEgresoToAttach.getIdEgreso());
                attachedEgresoListNew.add(egresoListNewEgresoToAttach);
            }
            egresoListNew = attachedEgresoListNew;
            categoria.setEgresoList(egresoListNew);
            categoria = em.merge(categoria);
            for (Ingreso ingresoListOldIngreso : ingresoListOld) {
                if (!ingresoListNew.contains(ingresoListOldIngreso)) {
                    ingresoListOldIngreso.setIdCategoria(null);
                    ingresoListOldIngreso = em.merge(ingresoListOldIngreso);
                }
            }
            for (Ingreso ingresoListNewIngreso : ingresoListNew) {
                if (!ingresoListOld.contains(ingresoListNewIngreso)) {
                    Categoria oldIdCategoriaOfIngresoListNewIngreso = ingresoListNewIngreso.getIdCategoria();
                    ingresoListNewIngreso.setIdCategoria(categoria);
                    ingresoListNewIngreso = em.merge(ingresoListNewIngreso);
                    if (oldIdCategoriaOfIngresoListNewIngreso != null && !oldIdCategoriaOfIngresoListNewIngreso.equals(categoria)) {
                        oldIdCategoriaOfIngresoListNewIngreso.getIngresoList().remove(ingresoListNewIngreso);
                        oldIdCategoriaOfIngresoListNewIngreso = em.merge(oldIdCategoriaOfIngresoListNewIngreso);
                    }
                }
            }
            for (Egreso egresoListOldEgreso : egresoListOld) {
                if (!egresoListNew.contains(egresoListOldEgreso)) {
                    egresoListOldEgreso.setIdCategoria(null);
                    egresoListOldEgreso = em.merge(egresoListOldEgreso);
                }
            }
            for (Egreso egresoListNewEgreso : egresoListNew) {
                if (!egresoListOld.contains(egresoListNewEgreso)) {
                    Categoria oldIdCategoriaOfEgresoListNewEgreso = egresoListNewEgreso.getIdCategoria();
                    egresoListNewEgreso.setIdCategoria(categoria);
                    egresoListNewEgreso = em.merge(egresoListNewEgreso);
                    if (oldIdCategoriaOfEgresoListNewEgreso != null && !oldIdCategoriaOfEgresoListNewEgreso.equals(categoria)) {
                        oldIdCategoriaOfEgresoListNewEgreso.getEgresoList().remove(egresoListNewEgreso);
                        oldIdCategoriaOfEgresoListNewEgreso = em.merge(oldIdCategoriaOfEgresoListNewEgreso);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = categoria.getIdCategoria();
                if (findCategoria(id) == null) {
                    throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria categoria;
            try {
                categoria = em.getReference(Categoria.class, id);
                categoria.getIdCategoria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.", enfe);
            }
            List<Ingreso> ingresoList = categoria.getIngresoList();
            for (Ingreso ingresoListIngreso : ingresoList) {
                ingresoListIngreso.setIdCategoria(null);
                ingresoListIngreso = em.merge(ingresoListIngreso);
            }
            List<Egreso> egresoList = categoria.getEgresoList();
            for (Egreso egresoListEgreso : egresoList) {
                egresoListEgreso.setIdCategoria(null);
                egresoListEgreso = em.merge(egresoListEgreso);
            }
            em.remove(categoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Categoria> findCategoriaEntities() {
        return findCategoriaEntities(true, -1, -1);
    }

    public List<Categoria> findCategoriaEntities(int maxResults, int firstResult) {
        return findCategoriaEntities(false, maxResults, firstResult);
    }

    private List<Categoria> findCategoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Categoria.class));
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

    public Categoria findCategoria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Categoria.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Categoria> rt = cq.from(Categoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
