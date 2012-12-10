/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.BusesJpaController;
import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.Buses;
import entidades.Rutas;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author chokuno
 */
public class ControladorBus {
    
     private FabricaObjetos mi_fabrica;
    BusesJpaController daoBuses;
    
    //se requiere para elaborar consultas personalizadas
    EntityManager manager;
    
    public ControladorBus()
    {
    mi_fabrica = new FabricaObjetos();   
    manager= mi_fabrica.crear().createEntityManager();
    
    daoBuses= new BusesJpaController(mi_fabrica.getFactory());
    }
    
        public int insertar(String placa,String marca,String nro_chasis,
                String tipo,int nro_asientos,int capacidad,Rutas ruta)
    {
        if (!placa.isEmpty() && !marca.isEmpty() && !nro_chasis.isEmpty() 
                && !tipo.isEmpty()  && !ruta.getNombre().isEmpty()
                && nro_asientos>0 && capacidad>0 ) {
            
        Buses bus = new Buses();
        bus.setPlaca( placa );
        bus.setMarca( marca );
        bus.setCapacidad(capacidad);
        bus.setNroAsientos(nro_asientos);
        bus.setNroChasis(nro_chasis);
        bus.setRuta(ruta.getNombre());
        bus.setTipo(tipo);

        
        try 
        {
            daoBuses.create(bus);
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
        
        
    public int modificar(String placa,String marca,String nro_chasis,
                String tipo,int nro_asientos,int capacidad,Rutas ruta)
    {
        if (!placa.isEmpty() && !marca.isEmpty() && !nro_chasis.isEmpty() 
                && !tipo.isEmpty()  && !ruta.getNombre().isEmpty()  && nro_asientos>0 
                && capacidad>0 ) {
        Buses bus = daoBuses.findBuses(placa);
        
         bus.setPlaca( placa );
        bus.setMarca( marca );
        bus.setCapacidad(capacidad);
        bus.setNroAsientos(nro_asientos);
        bus.setNroChasis(nro_chasis);
        bus.setRuta(ruta.getNombre());
        bus.setTipo(tipo);
        
        try 
        {   
            daoBuses.edit(bus);
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
        

        
        public LinkedList consultar(String placa,String tipo,int capacidad,String ruta)
    {
                        //"SELECT r FROM buses r"
            List lista;
            LinkedList listabuses= new LinkedList();
            String sql_select="SELECT b FROM Buses b     ";
                if (!placa.equals("") || !tipo.equals("") ||
                     capacidad>0 ||
                    (!ruta.equals("Cargar") && 
                    !ruta.equals(" ") )) {
                
            sql_select += "WHERE";
            }
            
        if (!placa.equals("")) {
            sql_select += " b.placa = '" + placa + "' AND ";
        }       
       
        
        if(!tipo.equals("")){
            sql_select += " b.tipo = '"+tipo+"'"+" AND ";
        }
        
               
        if(capacidad>0){
            sql_select += " b.capacidad < " + capacidad + " AND ";
        }

        if (!ruta.equals("Cargar") && !ruta.equals(" ")) {
            sql_select += " b.ruta = '"+ruta+"'"+" AND ";
        }
        

            
            
            sql_select = sql_select.substring(0, sql_select.length() - 5);
            System.out.println(sql_select);
            
            //sirve para ejecutar consultas
//            if(sql_select.contains("WHERE"))
               lista = manager.createQuery(sql_select).getResultList();
            //else lista = manager.createQuery("SELECT b FROM Buses b ").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                Buses b = (Buses) lista.get(i);
                listabuses.add(b);
            }
            
            return listabuses;
    }
    
}
