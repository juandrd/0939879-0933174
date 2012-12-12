/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import dao.EstacionesJpaController;
import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class ControladorEstacion {
     private FabricaObjetos mi_fabrica;
    EstacionesJpaController daoEstacion;
    
    //se requiere para elaborar consultas personalizadas
    EntityManager manager;
    
    public ControladorEstacion()
    {
    mi_fabrica = new FabricaObjetos();   
    manager= mi_fabrica.crear().createEntityManager();
    
    daoEstacion= new EstacionesJpaController(mi_fabrica.getFactory());
    }
    
     public int insertar(String nombre,String ubicacion, DirectoresEstacion director)
    {
        if (!nombre.isEmpty() && !ubicacion.isEmpty() &&
                !director.getIdentificacion().isEmpty()) {
        Estaciones estacion = new Estaciones();
        estacion.setNombre( nombre );
        estacion.setUbicacion(ubicacion);
        estacion.setDirector(director.getIdentificacion());

        
        try 
        {
            daoEstacion.create(estacion);
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
     
      public int modificar(String nombre,String ubicacion, DirectoresEstacion director)
    {
        if (!nombre.isEmpty() && !ubicacion.isEmpty() &&
                !director.getIdentificacion().isEmpty() ) {
        Estaciones estacionEncontrada = daoEstacion.findEstaciones(nombre);
        
        estacionEncontrada.setNombre(nombre);
        estacionEncontrada.setUbicacion(ubicacion);
        estacionEncontrada.setDirector(director.getIdentificacion());
        try 
        {   
            daoEstacion.edit(estacionEncontrada);
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
      
       public Estaciones consultar(String nombre){
          
           Estaciones e;
           
           e=daoEstacion.findEstaciones(nombre);        
         
                      
           return e;
       }

         public LinkedList consultar(String nombre,String ubicacion, String director)
    {
                        //"SELECT r FROM Rutas r"
            List lista;
            LinkedList listaEstaciones= new LinkedList();
            String sql_select="SELECT e FROM Estaciones e     ";
            if (!nombre.equals("") || !ubicacion.equals("")
                    || !director.equals("")) {
            sql_select += " WHERE";
            }
            
        if (!nombre.equals("")) {
            sql_select += " e.nombre = '" + nombre + "' AND ";
        }
        
        if(!ubicacion.equals("")){
            sql_select += " e.ubicacion LIKE '%"+ubicacion+"%'"+" AND ";
        }
         if (!director.equals("")) {
            sql_select += " e.director = '" + director + "' AND ";
        }
            
            
            sql_select = sql_select.substring(0, sql_select.length() - 5);
            System.out.println(sql_select);
            
            //sirve para ejecutar consultas
            if(sql_select.contains("WHERE"))
            lista = manager.createQuery(sql_select).getResultList();
            else lista = manager.createQuery("SELECT e FROM Estaciones e").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                Estaciones e = (Estaciones) lista.get(i);
                listaEstaciones.add(e);
            }
            
            return listaEstaciones;
    }
    
    
    public String[] listar() {
        LinkedList estacionConsultar = consultar("","","");
        String[] estaciones = new String[estacionConsultar.size() + 1];
        estaciones[0] = " ";
        for (int i = 0; i < estacionConsultar.size(); i++) {
            estaciones[i + 1] = ((Estaciones) estacionConsultar.get(i)).getNombre();
        }
        return estaciones;
    }

        
}
