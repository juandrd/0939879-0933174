/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.DirectoresEstacionJpaController;
import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.Empleados;
import entidades.DirectoresEstacion;
import entidades.Estaciones;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
/**
 *
 * @author Juan
 */
public class ControladorDirectorEstacion {
    private FabricaObjetos mi_fabrica;
    DirectoresEstacionJpaController daoDirectorEst;
    
    //se requiere para elaborar consultas personalizadas
    EntityManager manager;
    
    public ControladorDirectorEstacion()
    {
    mi_fabrica = new FabricaObjetos();   
    manager= mi_fabrica.crear().createEntityManager();
    
    daoDirectorEst= new DirectoresEstacionJpaController(mi_fabrica.getFactory());
    }
     public int insertar(Empleados emp)
    {
        if (!emp.getIdentificacion().isEmpty() ) {
            
       DirectoresEstacion dirEst=new DirectoresEstacion();
       dirEst.setIdentificacion(emp.getIdentificacion());

        
        try 
        {
            daoDirectorEst.create(dirEst);
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
            
        DirectoresEstacion dirEsta = daoDirectorEst.findDirectoresEstacion(emp.getIdentificacion());
        
         dirEsta.setIdentificacion(emp.getIdentificacion());
        
        try 
        {   
            daoDirectorEst.edit(dirEsta);
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
      
      public DirectoresEstacion consultar(String id){
          DirectoresEstacion e=daoDirectorEst.findDirectoresEstacion(id);
          
          return e;
      }
        public LinkedList consultarAll()
    {
                        //"SELECT r FROM Rutas r"
         List lista;
            LinkedList listaDirectores= new LinkedList();
           
            lista=daoDirectorEst.findDirectoresEstacionEntities();
            
            for(int i=0;i<lista.size();i++)
            {
                DirectoresEstacion r = (DirectoresEstacion) lista.get(i);
                listaDirectores.add(r);
            }
            
            return listaDirectores;
           
    }
      
       public String[] listar() {
        LinkedList directoresConsultar = consultarAll();
        String[] directores = new String[directoresConsultar.size() + 1];
        directores[0] = " ";
        for (int i = 0; i < directoresConsultar.size(); i++) {
            directores[i + 1] = ((DirectoresEstacion) directoresConsultar.get(i)).getIdentificacion();
        }
        return directores;
    }

        
}
