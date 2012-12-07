/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.BusesJpaController;
import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.Buses;
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
                String tipo,int nro_asientos,int capacidad,String ruta)
    {
        if (!placa.isEmpty() && !marca.isEmpty() && !nro_chasis.isEmpty() 
                && !tipo.isEmpty()  && !ruta.isEmpty()  && nro_asientos>0 
                && capacidad>0 ) {
            
        Buses bus = new Buses();
        bus.setPlaca( placa );
        bus.setMarca( marca );
        bus.setCapacidad(capacidad);
        bus.setNroAsientos(nro_asientos);
        bus.getNroChasis();
        bus.getRuta();
        bus.getTipo();

        
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
                String tipo,int nro_asientos,int capacidad,String ruta)
    {
        if (!placa.isEmpty() && !marca.isEmpty() && !nro_chasis.isEmpty() 
                && !tipo.isEmpty()  && !ruta.isEmpty()  && nro_asientos>0 
                && capacidad>0 ) {
        Buses busEncontrado = daoBuses.findBuses(placa);
        
        busEncontrado.setMarca( marca );
        busEncontrado.setCapacidad(capacidad);
        busEncontrado.setNroAsientos(nro_asientos);
        busEncontrado.getNroChasis();
        busEncontrado.getRuta();
        busEncontrado.getTipo();
        
        try 
        {   
            daoBuses.edit(busEncontrado);
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
        

        
        public LinkedList consultar(String placa,String marca,String nro_chasis,
                String tipo,String nro_asientos,String capacidad,String ruta)
    {
                        //"SELECT r FROM buses r"
            List lista;
            LinkedList listabuses= new LinkedList();
            String sql_select="SELECT b FROM buses b   ";
                if (!placa.equals("") || !marca.equals("") ||
                    !nro_chasis.equals("") || !tipo.equals("") ||
                    !nro_asientos.equals("") || !capacidad.equals("") ||
                    !ruta.equals("") ) {
                
            sql_select += "WHERE ";
            }
            
        if (!placa.equals("")) {
            sql_select += "b.placa = '" + placa + "' AND ";
        }
        
        if(!marca.equals("")){
            sql_select += "b.marca LIKE '%"+marca+"%'"+" AND ";
        }
         
        if (!nro_chasis.equals("")) {
            sql_select += "b.nro_chasis LIKE '%"+nro_chasis+"%'"+" AND ";
        }
        
        if(!tipo.equals("")){
            sql_select += "b.tipo LIKE '%"+tipo+"%'"+" AND ";
        }
        
        if (!nro_asientos.equals("")) {
            sql_select += "b.nombre = " + nro_asientos + " AND ";
        }
        
        if(!capacidad.equals("")){
            sql_select += "b.capacidad = " + capacidad + " AND ";
        }

        if (!ruta.equals("")) {
            sql_select += "b.ruta LIKE '%"+ruta+"%'"+" AND ";
        }
        

            
            
            sql_select = sql_select.substring(0, sql_select.length() - 5);
            
            //sirve para ejecutar consultas
            if(sql_select.contains("WHERE"))
            lista = manager.createQuery(sql_select).getResultList();
            else lista = manager.createQuery("SELECT b FROM buses b").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                Buses b = (Buses) lista.get(i);
                listabuses.add(b);
            }
            
            return listabuses;
    }
    
}
