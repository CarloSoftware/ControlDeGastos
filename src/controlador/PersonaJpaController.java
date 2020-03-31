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
import modelo.Usuario;
import modelo.Egreso;
import modelo.Persona;

/**
 *
 * @author ARTESANO
 */
public class PersonaJpaController implements Serializable {

    public PersonaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Persona persona) {
        if (persona.getIngresoList() == null) {
            persona.setIngresoList(new ArrayList<Ingreso>());
        }
        if (persona.getUsuarioList() == null) {
            persona.setUsuarioList(new ArrayList<Usuario>());
        }
        if (persona.getEgresoList() == null) {
            persona.setEgresoList(new ArrayList<Egreso>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Ingreso> attachedIngresoList = new ArrayList<Ingreso>();
            for (Ingreso ingresoListIngresoToAttach : persona.getIngresoList()) {
                ingresoListIngresoToAttach = em.getReference(ingresoListIngresoToAttach.getClass(), ingresoListIngresoToAttach.getIdIngreso());
                attachedIngresoList.add(ingresoListIngresoToAttach);
            }
            persona.setIngresoList(attachedIngresoList);
            List<Usuario> attachedUsuarioList = new ArrayList<Usuario>();
            for (Usuario usuarioListUsuarioToAttach : persona.getUsuarioList()) {
                usuarioListUsuarioToAttach = em.getReference(usuarioListUsuarioToAttach.getClass(), usuarioListUsuarioToAttach.getIdUsuario());
                attachedUsuarioList.add(usuarioListUsuarioToAttach);
            }
            persona.setUsuarioList(attachedUsuarioList);
            List<Egreso> attachedEgresoList = new ArrayList<Egreso>();
            for (Egreso egresoListEgresoToAttach : persona.getEgresoList()) {
                egresoListEgresoToAttach = em.getReference(egresoListEgresoToAttach.getClass(), egresoListEgresoToAttach.getIdEgreso());
                attachedEgresoList.add(egresoListEgresoToAttach);
            }
            persona.setEgresoList(attachedEgresoList);
            em.persist(persona);
            for (Ingreso ingresoListIngreso : persona.getIngresoList()) {
                Persona oldIdPersonaOfIngresoListIngreso = ingresoListIngreso.getIdPersona();
                ingresoListIngreso.setIdPersona(persona);
                ingresoListIngreso = em.merge(ingresoListIngreso);
                if (oldIdPersonaOfIngresoListIngreso != null) {
                    oldIdPersonaOfIngresoListIngreso.getIngresoList().remove(ingresoListIngreso);
                    oldIdPersonaOfIngresoListIngreso = em.merge(oldIdPersonaOfIngresoListIngreso);
                }
            }
            for (Usuario usuarioListUsuario : persona.getUsuarioList()) {
                Persona oldIdPersonaOfUsuarioListUsuario = usuarioListUsuario.getIdPersona();
                usuarioListUsuario.setIdPersona(persona);
                usuarioListUsuario = em.merge(usuarioListUsuario);
                if (oldIdPersonaOfUsuarioListUsuario != null) {
                    oldIdPersonaOfUsuarioListUsuario.getUsuarioList().remove(usuarioListUsuario);
                    oldIdPersonaOfUsuarioListUsuario = em.merge(oldIdPersonaOfUsuarioListUsuario);
                }
            }
            for (Egreso egresoListEgreso : persona.getEgresoList()) {
                Persona oldIdPersonaOfEgresoListEgreso = egresoListEgreso.getIdPersona();
                egresoListEgreso.setIdPersona(persona);
                egresoListEgreso = em.merge(egresoListEgreso);
                if (oldIdPersonaOfEgresoListEgreso != null) {
                    oldIdPersonaOfEgresoListEgreso.getEgresoList().remove(egresoListEgreso);
                    oldIdPersonaOfEgresoListEgreso = em.merge(oldIdPersonaOfEgresoListEgreso);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Persona persona) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona persistentPersona = em.find(Persona.class, persona.getIdPersona());
            List<Ingreso> ingresoListOld = persistentPersona.getIngresoList();
            List<Ingreso> ingresoListNew = persona.getIngresoList();
            List<Usuario> usuarioListOld = persistentPersona.getUsuarioList();
            List<Usuario> usuarioListNew = persona.getUsuarioList();
            List<Egreso> egresoListOld = persistentPersona.getEgresoList();
            List<Egreso> egresoListNew = persona.getEgresoList();
            List<Ingreso> attachedIngresoListNew = new ArrayList<Ingreso>();
            for (Ingreso ingresoListNewIngresoToAttach : ingresoListNew) {
                ingresoListNewIngresoToAttach = em.getReference(ingresoListNewIngresoToAttach.getClass(), ingresoListNewIngresoToAttach.getIdIngreso());
                attachedIngresoListNew.add(ingresoListNewIngresoToAttach);
            }
            ingresoListNew = attachedIngresoListNew;
            persona.setIngresoList(ingresoListNew);
            List<Usuario> attachedUsuarioListNew = new ArrayList<Usuario>();
            for (Usuario usuarioListNewUsuarioToAttach : usuarioListNew) {
                usuarioListNewUsuarioToAttach = em.getReference(usuarioListNewUsuarioToAttach.getClass(), usuarioListNewUsuarioToAttach.getIdUsuario());
                attachedUsuarioListNew.add(usuarioListNewUsuarioToAttach);
            }
            usuarioListNew = attachedUsuarioListNew;
            persona.setUsuarioList(usuarioListNew);
            List<Egreso> attachedEgresoListNew = new ArrayList<Egreso>();
            for (Egreso egresoListNewEgresoToAttach : egresoListNew) {
                egresoListNewEgresoToAttach = em.getReference(egresoListNewEgresoToAttach.getClass(), egresoListNewEgresoToAttach.getIdEgreso());
                attachedEgresoListNew.add(egresoListNewEgresoToAttach);
            }
            egresoListNew = attachedEgresoListNew;
            persona.setEgresoList(egresoListNew);
            persona = em.merge(persona);
            for (Ingreso ingresoListOldIngreso : ingresoListOld) {
                if (!ingresoListNew.contains(ingresoListOldIngreso)) {
                    ingresoListOldIngreso.setIdPersona(null);
                    ingresoListOldIngreso = em.merge(ingresoListOldIngreso);
                }
            }
            for (Ingreso ingresoListNewIngreso : ingresoListNew) {
                if (!ingresoListOld.contains(ingresoListNewIngreso)) {
                    Persona oldIdPersonaOfIngresoListNewIngreso = ingresoListNewIngreso.getIdPersona();
                    ingresoListNewIngreso.setIdPersona(persona);
                    ingresoListNewIngreso = em.merge(ingresoListNewIngreso);
                    if (oldIdPersonaOfIngresoListNewIngreso != null && !oldIdPersonaOfIngresoListNewIngreso.equals(persona)) {
                        oldIdPersonaOfIngresoListNewIngreso.getIngresoList().remove(ingresoListNewIngreso);
                        oldIdPersonaOfIngresoListNewIngreso = em.merge(oldIdPersonaOfIngresoListNewIngreso);
                    }
                }
            }
            for (Usuario usuarioListOldUsuario : usuarioListOld) {
                if (!usuarioListNew.contains(usuarioListOldUsuario)) {
                    usuarioListOldUsuario.setIdPersona(null);
                    usuarioListOldUsuario = em.merge(usuarioListOldUsuario);
                }
            }
            for (Usuario usuarioListNewUsuario : usuarioListNew) {
                if (!usuarioListOld.contains(usuarioListNewUsuario)) {
                    Persona oldIdPersonaOfUsuarioListNewUsuario = usuarioListNewUsuario.getIdPersona();
                    usuarioListNewUsuario.setIdPersona(persona);
                    usuarioListNewUsuario = em.merge(usuarioListNewUsuario);
                    if (oldIdPersonaOfUsuarioListNewUsuario != null && !oldIdPersonaOfUsuarioListNewUsuario.equals(persona)) {
                        oldIdPersonaOfUsuarioListNewUsuario.getUsuarioList().remove(usuarioListNewUsuario);
                        oldIdPersonaOfUsuarioListNewUsuario = em.merge(oldIdPersonaOfUsuarioListNewUsuario);
                    }
                }
            }
            for (Egreso egresoListOldEgreso : egresoListOld) {
                if (!egresoListNew.contains(egresoListOldEgreso)) {
                    egresoListOldEgreso.setIdPersona(null);
                    egresoListOldEgreso = em.merge(egresoListOldEgreso);
                }
            }
            for (Egreso egresoListNewEgreso : egresoListNew) {
                if (!egresoListOld.contains(egresoListNewEgreso)) {
                    Persona oldIdPersonaOfEgresoListNewEgreso = egresoListNewEgreso.getIdPersona();
                    egresoListNewEgreso.setIdPersona(persona);
                    egresoListNewEgreso = em.merge(egresoListNewEgreso);
                    if (oldIdPersonaOfEgresoListNewEgreso != null && !oldIdPersonaOfEgresoListNewEgreso.equals(persona)) {
                        oldIdPersonaOfEgresoListNewEgreso.getEgresoList().remove(egresoListNewEgreso);
                        oldIdPersonaOfEgresoListNewEgreso = em.merge(oldIdPersonaOfEgresoListNewEgreso);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = persona.getIdPersona();
                if (findPersona(id) == null) {
                    throw new NonexistentEntityException("The persona with id " + id + " no longer exists.");
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
            Persona persona;
            try {
                persona = em.getReference(Persona.class, id);
                persona.getIdPersona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The persona with id " + id + " no longer exists.", enfe);
            }
            List<Ingreso> ingresoList = persona.getIngresoList();
            for (Ingreso ingresoListIngreso : ingresoList) {
                ingresoListIngreso.setIdPersona(null);
                ingresoListIngreso = em.merge(ingresoListIngreso);
            }
            List<Usuario> usuarioList = persona.getUsuarioList();
            for (Usuario usuarioListUsuario : usuarioList) {
                usuarioListUsuario.setIdPersona(null);
                usuarioListUsuario = em.merge(usuarioListUsuario);
            }
            List<Egreso> egresoList = persona.getEgresoList();
            for (Egreso egresoListEgreso : egresoList) {
                egresoListEgreso.setIdPersona(null);
                egresoListEgreso = em.merge(egresoListEgreso);
            }
            em.remove(persona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Persona> findPersonaEntities() {
        return findPersonaEntities(true, -1, -1);
    }

    public List<Persona> findPersonaEntities(int maxResults, int firstResult) {
        return findPersonaEntities(false, maxResults, firstResult);
    }

    private List<Persona> findPersonaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Persona.class));
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

    public Persona findPersona(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Persona.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersonaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Persona> rt = cq.from(Persona.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
