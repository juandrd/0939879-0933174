/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import dao.MovilizacionJpaController;
import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.Movilizacion;
import entidades.MovilizacionPK;
import entidades.Pasajeros;
import entidades.Rutas;
import java.sql.Date;

/**
 *
 * @author Juan
 */
public class ControladorMovilizacion {
    
     private FabricaObjetos mi_fabrica;
    MovilizacionJpaController dao;
    
    //se requiere para elaborar consultas personalizadas
    EntityManager manager;
   
    
    public ControladorMovilizacion(){
        mi_fabrica = new FabricaObjetos();   
    manager= mi_fabrica.crear().createEntityManager();
  
    dao= new MovilizacionJpaController(mi_fabrica.getFactory());
    }
    
    
      public int insertar(Pasajeros p, Rutas r, Date fecha)
    {
        if (!p.getIdentificacion().isEmpty() && !r.getNombre().isEmpty() && !fecha.toString().isEmpty() ) {
            
        MovilizacionPK mPK=new MovilizacionPK();    
        mPK.setPasajero(p.getIdentificacion());   
        mPK.setRuta(r.getNombre());
        mPK.setFecha(fecha);
        
        Movilizacion m = new Movilizacion();
        m.setMovilizacionPK(mPK);
        
        
        try 
        {
            dao.create(m);
            
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
      
      public LinkedList consultarAll(){
     List lista;
            LinkedList listaM= new LinkedList();    
        
                            
                lista = dao.findMovilizacionEntities();
           // else lista = manager.createQuery("SELECT p FROM Pasajeros p").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                Movilizacion m = (Movilizacion) lista.get(i);               
                               
                listaM.add(m);}
            
            
            return listaM;
    
}
      
       public LinkedList consultar(String pasajero, String ruta)

    {
                        //"SELECT r FROM Rutas r"
            List lista;
            LinkedList listaM =new LinkedList();          
       
                   
           
            lista = dao.findMovilizacionEntities();
           // else lista = manager.createQuery("SELECT p FROM Pasajeros p").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                Movilizacion p = (Movilizacion) lista.get(i);
                 if(p.getMovilizacionPK().getPasajero().equals(pasajero)
                                                &&
                        p.getMovilizacionPK().getRuta().equals(ruta)){ 
                listaM.add(p);}
            }
            
            return listaM;
    }
       
         public LinkedList consultarporPasajero(String pasajero)

    {
                       
            List lista;
            LinkedList listaTurnos= new LinkedList();    
        
                            
                lista = dao.findMovilizacionEntities();
           // else lista = manager.createQuery("SELECT p FROM Pasajeros p").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                Movilizacion turno = (Movilizacion) lista.get(i);
                if(turno.getMovilizacionPK().getPasajero().equals(pasajero)
                                  ){
                
                listaTurnos.add(turno);}
            }
            
            return listaTurnos;
    }
        
              public LinkedList consultarporRuta(String ruta)

    {
                       
            List lista;
            LinkedList listaTurnos= new LinkedList();    
        
                            
                lista = dao.findMovilizacionEntities();
           // else lista = manager.createQuery("SELECT p FROM Pasajeros p").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                Movilizacion turno = (Movilizacion) lista.get(i);
                if(turno.getMovilizacionPK().getRuta().equals(ruta)
                                  ){
                
                listaTurnos.add(turno);}
            }
            
            return listaTurnos;
    }
        
}
