/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import dao.MovilizacionJpaController;
import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;

/**
 *
 * @author Juan
 */
public class ControladorMovilizacion {
    
     private FabricaObjetos mi_fabrica;
    MovilizacionJpaController dao;
    
    //se requiere para elaborar consultas personalizadas
    EntityManager manager;
    ControladorTarjetasPersonalizadas controladorTPersonalizadas;
    ControladoresTarjetasGenericas controladorTGenericas;
    
    public ControladorMovilizacion(){
        
    }
}
