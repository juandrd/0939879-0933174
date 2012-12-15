/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.ConductoresJpaController;
import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.Empleados;
import entidades.Conductores;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Juan
 */
public class ControladorConductor {
       private FabricaObjetos mi_fabrica;
    ConductoresJpaController daoConductor;
    
    //se requiere para elaborar consultas personalizadas
    EntityManager manager;
    
    public ControladorConductor()
    {
    mi_fabrica = new FabricaObjetos();   
    manager= mi_fabrica.crear().createEntityManager();
    
    daoConductor= new ConductoresJpaController(mi_fabrica.getFactory());
    }
    
     public int insertar(Empleados empleado,Time hora_ent,Time hora_sal
                )
    {
        
        if (!empleado.getIdentificacion().isEmpty()
                && !hora_ent.equals("") && !hora_sal.equals("")) {
            
        Conductores conductor = new Conductores();
        conductor.setIdentificacion(empleado.getIdentificacion());
        
        conductor.setHoraEntrada(hora_ent);
        conductor.setHoraSalida(hora_sal);
        

        
        try 
        {
            daoConductor.create(conductor);
            return 0;
        }
        catch (PreexistingEntityException ex) 
        {
            System.out.println(ex.getMessage());
            return 1;
        }
        catch (Exception ex) 
        {
            
            ex.printStackTrace();
        }
        }
        return -1;
    }
        
        
    public int modificar(Empleados empleado,Time hora_ent,Time hora_sal
          )
    {
        if (!empleado.getIdentificacion().isEmpty()
                && !hora_ent.equals("") && !hora_sal.equals("")) {
        Conductores conductor = daoConductor.findConductores(empleado.getIdentificacion());
        conductor.setIdentificacion(empleado.getIdentificacion());
        conductor.setHoraEntrada(hora_ent);
        conductor.setHoraSalida(hora_sal);
        
        
        try 
        {   
            daoConductor.edit(conductor);
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
        
public Conductores consultar(String id){
    Conductores c=daoConductor.findConductores(id);
    
    return c;
}
        
  public LinkedList consultarAll()
        {
                      
            List lista;
            LinkedList listaAuxiliares= new LinkedList();
            
            
            //sirve para ejecutar consultas
//            if(sql_select.contains("WHERE"))
               lista = daoConductor.findConductoresEntities();
            //else lista = manager.createQuery("SELECT b FROM Buses b ").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                Conductores a = (Conductores) lista.get(i);
                listaAuxiliares.add(a);
            }
            
            return listaAuxiliares;
    }
  
    public String[] listar() {
        LinkedList conductoresConsulta = consultarAll();
        String[] conductor = new String[conductoresConsulta.size() + 1];
        conductor[0] = " ";
        for (int i = 0; i < conductoresConsulta.size(); i++) {
            conductor[i + 1] = ((Conductores) conductoresConsulta.get(i)).getIdentificacion();
        }
        return conductor;
    }
}
