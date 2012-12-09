/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.RutasJpaController;
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
 * @author chokuno
 */
public class ControladorRuta {
    
    private FabricaObjetos mi_fabrica;
    RutasJpaController daoRutas;
    
    //se requiere para elaborar consultas personalizadas
    EntityManager manager;
    
    public ControladorRuta()
    {
    mi_fabrica = new FabricaObjetos();   
    manager= mi_fabrica.crear().createEntityManager();
    
    daoRutas= new RutasJpaController(mi_fabrica.getFactory());
    }
    
        public int insertar(String nombre,String descripcion)
    {
        if (!nombre.isEmpty() && !descripcion.isEmpty() ) {
        Rutas ruta = new Rutas();
        ruta.setNombre( nombre );
        ruta.setDescripcion( descripcion );

        
        try 
        {
            daoRutas.create(ruta);
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
        
    public int modificar(String nombre,String descripcion)
    {
        if (!nombre.isEmpty() && !descripcion.isEmpty() ) {
        Rutas rutaEncontrada = daoRutas.findRutas(nombre);
        
        rutaEncontrada.setDescripcion(descripcion);
        
        try 
        {   
            daoRutas.edit(rutaEncontrada);
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
        
     public Rutas consultar(String id){
          
           Rutas r;
           
           r=daoRutas.findRutas(id);
           
         
            
           
           return r;
       }

        
        public LinkedList consultar(String nombre,String descripcion)
    {
                        //"SELECT r FROM Rutas r"
            List lista;
            LinkedList listaRutas= new LinkedList();
            String sql_select="SELECT r FROM Rutas r   ";
            if (!nombre.equals("") || !descripcion.equals("")) {
            sql_select += "WHERE ";
            }
            
        if (!nombre.equals("")) {
            sql_select += "r.nombre = '" + nombre + "' AND ";
        }
        
        if(!descripcion.equals("")){
            sql_select += "r.descripcion LIKE '%"+descripcion+"%'"+" AND ";
        }
            
            
            sql_select = sql_select.substring(0, sql_select.length() - 5);
            
            //sirve para ejecutar consultas
            if(sql_select.contains("WHERE"))
            lista = manager.createQuery(sql_select).getResultList();
            else lista = manager.createQuery("SELECT r FROM Rutas r").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                Rutas r = (Rutas) lista.get(i);
                listaRutas.add(r);
            }
            
            return listaRutas;
    }
    
    
    public String[] listar() {
        LinkedList rutaConsultar = consultar("","");
        String[] rutas = new String[rutaConsultar.size() + 1];
        rutas[0] = " ";
        for (int i = 0; i < rutaConsultar.size(); i++) {
            rutas[i + 1] = ((Rutas) rutaConsultar.get(i)).getNombre();
        }
        return rutas;
    }

    
}
