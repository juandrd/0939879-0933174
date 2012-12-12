/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import dao.DirectoresOperativosJpaController;
import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.Empleados;
import entidades.DirectoresOperativos;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
/**
 *
 * @author Juan
 */
public class ControladorDirectorOperativo {
   
    
     private FabricaObjetos mi_fabrica;
    DirectoresOperativosJpaController daoDirectorOp;
    
    //se requiere para elaborar consultas personalizadas
    EntityManager manager;
    
    public ControladorDirectorOperativo()
    {
    mi_fabrica = new FabricaObjetos();   
    manager= mi_fabrica.crear().createEntityManager();
    
    daoDirectorOp= new DirectoresOperativosJpaController(mi_fabrica.getFactory());
    }
     public int insertar(Empleados emp)
    {
        if (!emp.getIdentificacion().isEmpty() ) {
            
       DirectoresOperativos dop=new DirectoresOperativos();
       dop.setIdentificacion(emp.getIdentificacion());

        
        try 
        {
            daoDirectorOp.create(dop);
            return 0;
        }
        catch (PreexistingEntityException ex) 
        {
            System.out.println(ex.getMessage());
            return 1;
        }
        catch (Exception ex) 
        {
            System.out.println(ex.getMessage());
        }
        }
        return -1;
    }
     
      public int modificar(Empleados emp)
    {
        if (!emp.getIdentificacion().isEmpty()) {
            
        DirectoresOperativos dop = daoDirectorOp.findDirectoresOperativos(emp.getIdentificacion());
        
         dop.setIdentificacion(emp.getIdentificacion());
        
        try 
        {   
            daoDirectorOp.edit(dop);
            return 0;
            
        }
        catch (NonexistentEntityException ex) 
        {
            System.out.println(ex.getMessage());
            return -1;
        }
        catch (Exception ex) 
        {
            System.out.println(ex.getMessage());
        }
        }
        return -1;
    }   
        
}
