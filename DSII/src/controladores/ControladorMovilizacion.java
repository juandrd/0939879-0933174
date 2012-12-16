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
    
    
      public int insertar(String p, String r, String fecha)
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
}
