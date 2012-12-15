/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.PasajerosJpaController;
import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.Pasajeros;
import entidades.Rutas;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Juan
 */
public class ControladorPasajero {
     private FabricaObjetos mi_fabrica;
    PasajerosJpaController daoPasajero;
    
    //se requiere para elaborar consultas personalizadas
    EntityManager manager;
    
    
     public ControladorPasajero()
    {
    mi_fabrica = new FabricaObjetos();   
    manager= mi_fabrica.crear().createEntityManager();
    
    daoPasajero= new PasajerosJpaController(mi_fabrica.getFactory());
    }
     
     
       public int insertar(String id, String nombre,String apellidos, String telefono,
               String direccion, String genero, String email)
    {
        if (!id.isEmpty() && !nombre.isEmpty() && !apellidos.isEmpty() &&
                !telefono.isEmpty() && !direccion.isEmpty()  && !genero.isEmpty() &&
               !email.isEmpty())
                {
        Pasajeros p = new Pasajeros();
        p.setIdentificacion(id);
        p.setNombres( nombre );
        p.setApellidos( apellidos );
        p.setTelefono(telefono);
        p.setDireccion(direccion);
        p.setGenero(genero);
        p.setEmail(email);
        p.setPassword("0000");

        
        try 
        {
            daoPasajero.create(p);
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
       
       
       public int modificar(String id, String nombre,String apellidos, String telefono,
               String direccion, String genero, String email, String pass)
    {
        if (!id.isEmpty() && !nombre.isEmpty() && !apellidos.isEmpty() &&
                !telefono.isEmpty() && !direccion.isEmpty()  && !genero.isEmpty() &&
               !email.isEmpty() && !pass.isEmpty()) {
            
        Pasajeros p = daoPasajero.findPasajeros(id);
        
        p.setIdentificacion(id);
        p.setNombres( nombre );
        p.setApellidos( apellidos );
        p.setTelefono(telefono);
        p.setDireccion(direccion);
        p.setGenero(genero);
        p.setEmail(email);
        p.setPassword(pass);
        
        try 
        {   
            daoPasajero.edit(p);
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
       
       public Pasajeros consultar(String id){
          
           Pasajeros p;
           
           p=daoPasajero.findPasajeros(id);        
         
            
           
           return p;
       }
       
       public String login(String id){
           Pasajeros p;
           p=consultar(id);
           String retorno;
           retorno=p.getPassword();
           return retorno;
           
       }
       
        public LinkedList consultar(String id, String nombres, String apellidos
                ,String genero, String email)

    {
                        //"SELECT r FROM Rutas r"
            List lista;
            LinkedList listaPasajeros= new LinkedList();
            String sql_select="SELECT p FROM Pasajeros p   ";
            if (!id.equals("") || !nombres.equals("") ||
                    !apellidos.equals("") || !genero.equals("")
                    || !email.equals("")) {
            sql_select += "WHERE ";
            }
            
        if (!id.equals("")) {
            sql_select += "p.identificacion = '" + id + "' AND ";
        }
        
        if(!nombres.equals("")){
            sql_select += "p.nombres LIKE '%"+nombres+"%'"+" AND ";
        }
        if(!apellidos.equals("")){
            sql_select += "p.apellidos LIKE '%"+apellidos+"%'"+" AND ";
        }
        if(!genero.equals("")){
            sql_select += "p.genero = '"+genero+"'"+" AND ";
        }
        
        if(!email.equals("")){
            sql_select += "p.email = '"+apellidos+"'"+" AND ";
        }
            
            
            sql_select = sql_select.substring(0, sql_select.length() - 5);
            System.out.println(sql_select);
            //sirve para ejecutar consultas
            if(sql_select.contains("WHERE"))
            lista = manager.createQuery(sql_select).getResultList();
            else lista = manager.createQuery("SELECT p FROM Pasajeros p").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                Pasajeros p = (Pasajeros) lista.get(i);
                listaPasajeros.add(p);
            }
            
            return listaPasajeros;
    }
        
          public String[] listar() {
        LinkedList pasajerosConsulta = consultar("","","","","");
        String[] pasajeros = new String[pasajerosConsulta.size() + 1];
        pasajeros[0] = " ";
        for (int i = 0; i < pasajerosConsulta.size(); i++) {
            pasajeros[i + 1] = ((Pasajeros) pasajerosConsulta.get(i)).getIdentificacion();
        }
        return pasajeros;
    }
}
