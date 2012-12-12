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
        

        
//        public LinkedList consultar(String placa,String tipo,int capacidad,String ruta)
//    {
//                        //"SELECT r FROM buses r"
//            List lista;
//            LinkedList listabuses= new LinkedList();
//            String sql_select="SELECT b FROM Buses b     ";
//                if (!placa.equals("") || !tipo.equals("") ||
//                     capacidad>0 ||
//                    (!ruta.equals("Cargar") && 
//                    !ruta.equals(" ") )) {
//                
//            sql_select += "WHERE";
//            }
//            
//        if (!placa.equals("")) {
//            sql_select += " b.placa = '" + placa + "' AND ";
//        }       
//       
//        
//        if(!tipo.equals("")){
//            sql_select += " b.tipo = '"+tipo+"'"+" AND ";
//        }
//        
//               
//        if(capacidad>0){
//            sql_select += " b.capacidad < " + capacidad + " AND ";
//        }
//
//        if (!ruta.equals("Cargar") && !ruta.equals(" ")) {
//            sql_select += " b.ruta = '"+ruta+"'"+" AND ";
//        }
//        
//
//            
//            
//            sql_select = sql_select.substring(0, sql_select.length() - 5);
//            System.out.println(sql_select);
//            
//            //sirve para ejecutar consultas
////            if(sql_select.contains("WHERE"))
//               lista = manager.createQuery(sql_select).getResultList();
//            //else lista = manager.createQuery("SELECT b FROM Buses b ").getResultList();
//            
//            for(int i=0;i<lista.size();i++)
//            {
//                Buses b = (Buses) lista.get(i);
//                listabuses.add(b);
//            }
//            
//            return listabuses;
//    }
}
