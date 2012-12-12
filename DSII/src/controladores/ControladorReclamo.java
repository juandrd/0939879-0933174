/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.ReclamosJpaController;
import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.Estaciones;
import entidades.Pasajeros;
import entidades.Reclamos;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Juan
 */
public class ControladorReclamo {
      private FabricaObjetos mi_fabrica;
    ReclamosJpaController daoReclamo;
    
    //se requiere para elaborar consultas personalizadas
    EntityManager manager;
    
    public ControladorReclamo()
    {
    mi_fabrica = new FabricaObjetos();   
    manager= mi_fabrica.crear().createEntityManager();
    
    daoReclamo= new ReclamosJpaController(mi_fabrica.getFactory());
    }
    public int insertar(String codigo,String descripcion,Pasajeros pasajero,
              Estaciones estacion)
    {
        if (!codigo.isEmpty() && !descripcion.isEmpty() && !pasajero.getNombres().isEmpty() 
                 && !estacion.getNombre().isEmpty()
              ) {
            
        Reclamos r = new Reclamos();
        r.setCodigo(codigo);
        r.setDescripcion(descripcion);
        r.setPasajero(pasajero.getIdentificacion());
        r.setEstacion(estacion.getNombre());
     

        
        try 
        {
            daoReclamo.create(r);
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
          public int modificar(String codigo,String descripcion,Pasajeros pasajero,
              Estaciones estacion)
    {
        if (!codigo.isEmpty() && !descripcion.isEmpty() && !pasajero.getNombres().isEmpty() 
                 && !estacion.getNombre().isEmpty()
             ) {
        Reclamos r = daoReclamo.findReclamos(codigo);
        
       r.setCodigo(codigo);
        r.setDescripcion(descripcion);
        r.setPasajero(pasajero.getIdentificacion());
        r.setEstacion(estacion.getNombre());
        
        try 
        {   
            daoReclamo.edit(r);
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
          
           public LinkedList consultar(String codigo, String pasajero, String estacion)
    {
                        //"SELECT r FROM buses r"
            List lista;
            LinkedList listabuses= new LinkedList();
            String sql_select="SELECT r FROM Reclamos r     ";
                if (!codigo.equals("") || !pasajero.equals("") ||                   
                              !estacion.equals("") ) {
                
            sql_select += "WHERE";
            }
            
        if (!codigo.equals("")) {
            sql_select += " r.codigo = '" + codigo + "' AND ";
        }       
       
        
        if(!pasajero.equals("")){
            sql_select += " r.pasajero = '"+pasajero+"'"+" AND ";
        }
        
               
        if(!estacion.equals("")){
            sql_select += " r.estacion < " + estacion + " AND ";
        }

                    
            
            sql_select = sql_select.substring(0, sql_select.length() - 5);
            System.out.println(sql_select);
            
            //sirve para ejecutar consultas
//            if(sql_select.contains("WHERE"))
               lista = manager.createQuery(sql_select).getResultList();
            //else lista = manager.createQuery("SELECT b FROM Buses b ").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                Reclamos b = (Reclamos) lista.get(i);
                listabuses.add(b);
            }
            
            return listabuses;
    }
    
        
}
