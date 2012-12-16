/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import dao.PasajerosPersonalizadasJpaController;
import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.Pasajeros;
import entidades.PasajerosPersonalizadas;
import entidades.PasajerosPersonalizadasPK;
import entidades.TarjetasGenericas;
import entidades.TarjetasPersonalizadas;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
/**
 *
 * @author Juan
 */
public class ControladorPasajeroPersonalizado {
      private FabricaObjetos mi_fabrica;
    PasajerosPersonalizadasJpaController dao;
    
    //se requiere para elaborar consultas personalizadas
    EntityManager manager;
    ControladorTarjetasPersonalizadas controladorTPersonalizadas;
    ControladoresTarjetasGenericas controladorTGenericas;
    
    public ControladorPasajeroPersonalizado()
    {
    mi_fabrica = new FabricaObjetos();   
    manager= mi_fabrica.crear().createEntityManager();
    controladorTPersonalizadas= new ControladorTarjetasPersonalizadas();
    controladorTGenericas= new ControladoresTarjetasGenericas();
    
    dao= new PasajerosPersonalizadasJpaController(mi_fabrica.getFactory());
    }
    
        public int insertar(Pasajeros p, TarjetasPersonalizadas t)
    {
        if (!p.getIdentificacion().isEmpty() && !t.getPinTarjeta().isEmpty()  ) {
            
        PasajerosPersonalizadasPK venta = new PasajerosPersonalizadasPK();
        venta.setIdentificacion(p.getIdentificacion());
        venta.setPinTarjeta(t.getPinTarjeta());
        
        PasajerosPersonalizadas pasajeroPersonalizada=new PasajerosPersonalizadas(venta);
        
        TarjetasPersonalizadas tarjeta=controladorTPersonalizadas.consultar(venta.getPinTarjeta());
        tarjeta.setEstado("Vendida");
        try 
        {
            dao.create(pasajeroPersonalizada);
            controladorTPersonalizadas.modificar(tarjeta.getPinTarjeta(), 
                    tarjeta.getNroPasajes()
                    , tarjeta.getEstado(), tarjeta.getAdelantoDisponible());
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
        
        
         public int insertar(Pasajeros p, TarjetasGenericas t)
    {
        if (!p.getIdentificacion().isEmpty() && !t.getPinTarjeta().isEmpty()  ) {
            
        PasajerosPersonalizadasPK venta = new PasajerosPersonalizadasPK();
        venta.setIdentificacion(p.getIdentificacion());
        venta.setPinTarjeta(t.getPinTarjeta());
        
        PasajerosPersonalizadas pasajeroPersonalizada=new PasajerosPersonalizadas(venta);
        
        TarjetasGenericas tarjeta=controladorTGenericas.consultar(venta.getPinTarjeta());
        tarjeta.setEstado("Vendida");
        try 
        {
            dao.create(pasajeroPersonalizada);
            controladorTGenericas.modificar(tarjeta.getPinTarjeta(), 
                    tarjeta.getNroPasajes()
                    , tarjeta.getEstado());
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
        
        
           public LinkedList consultar(String pasajero)

    {
                        //"SELECT r FROM Rutas r"
            List lista;
            LinkedList listaPasajeros= new LinkedList();       
        
       
                      
           
            lista = dao.findPasajerosPersonalizadasEntities();
           // else lista = manager.createQuery("SELECT p FROM Pasajeros p").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                PasajerosPersonalizadas p = (PasajerosPersonalizadas) lista.get(i);
                if(p.getPasajerosPersonalizadasPK().getIdentificacion().equals(pasajero)){
                
                listaPasajeros.add(p);}
            }
            
            return listaPasajeros;
    }
        
          
}
