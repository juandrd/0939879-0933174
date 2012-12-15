/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import dao.TurnosJpaController;
import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.Turnos;
import entidades.TurnosPK;
import java.sql.Time;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author chokuno
 */
public class ControladorTurnos {
    private FabricaObjetos mi_fabrica;
    TurnosJpaController daoTurnos;
    
    //se requiere para elaborar consultas personalizadas
    EntityManager manager;
    
    public ControladorTurnos()
    {
    mi_fabrica = new FabricaObjetos();   
    manager= mi_fabrica.crear().createEntityManager();
    
    daoTurnos= new TurnosJpaController(mi_fabrica.getFactory());
    }
    
        public int insertar(String conductor,String bus,Time hora_inicio,Time hora_fin)
    {
        if (!conductor.isEmpty() && !bus.isEmpty() && !hora_inicio.toString().isEmpty()
                && !hora_fin.toString().isEmpty()) {
        TurnosPK turnosPK = new TurnosPK();
        turnosPK.setConductor( conductor );
        turnosPK.setBus( bus );
        turnosPK.setHoraInicio( hora_inicio );
        Turnos turnos = new Turnos();
        turnos.setTurnosPK(turnosPK);
        turnos.setHoraFin(hora_fin);

        
        try 
        {
            daoTurnos.create(turnos);
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
        
    public int modificar(String conductor,String bus,Time hora_inicio,Time hora_fin)
    {
        if (!conductor.isEmpty() && !bus.isEmpty() && !hora_inicio.toString().isEmpty()
                && !hora_fin.toString().isEmpty() ) {
            
        TurnosPK turnosPK= new TurnosPK(conductor, bus, hora_inicio);
            
        Turnos turnoEncontrado = daoTurnos.findTurnos(turnosPK);
        
        turnoEncontrado.setHoraFin(hora_fin);
        
        try 
        {   
            daoTurnos.edit(turnoEncontrado);
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
        
public LinkedList consultarAll(){
     List lista;
            LinkedList listaTurnos= new LinkedList();    
        
                            
                lista = daoTurnos.findTurnosEntities();
           // else lista = manager.createQuery("SELECT p FROM Pasajeros p").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                Turnos turno = (Turnos) lista.get(i);               
                               
                listaTurnos.add(turno);}
            
            
            return listaTurnos;
    
}
 public LinkedList consultar(String conductor, String bus)

    {
                       
            List lista;
            LinkedList listaTurnos= new LinkedList();    
        
                            
                lista = daoTurnos.findTurnosEntities();
           // else lista = manager.createQuery("SELECT p FROM Pasajeros p").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                Turnos turno = (Turnos) lista.get(i);
                System.out.println(turno.getTurnosPK().getConductor());
                if(turno.getTurnosPK().getConductor().equals(conductor)
                                                &&
                        turno.getTurnosPK().getBus().equals(bus)){
                
                listaTurnos.add(turno);}
            }
            
            return listaTurnos;
    }
        
        
  
     public LinkedList consultarporConductor(String conductor)

    {
                       
            List lista;
            LinkedList listaTurnos= new LinkedList();    
        
                            
                lista = daoTurnos.findTurnosEntities();
           // else lista = manager.createQuery("SELECT p FROM Pasajeros p").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                Turnos turno = (Turnos) lista.get(i);
                System.out.println(turno.getTurnosPK().getConductor());
                if(turno.getTurnosPK().getConductor().equals(conductor)
                                  ){
                
                listaTurnos.add(turno);}
            }
            
            return listaTurnos;
    }
        

  public LinkedList consultarporBus(String bus)

    {
                       
            List lista;
            LinkedList listaTurnos= new LinkedList();    
        
                            
                lista = daoTurnos.findTurnosEntities();
           // else lista = manager.createQuery("SELECT p FROM Pasajeros p").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                Turnos turno = (Turnos) lista.get(i);
               
                if(turno.getTurnosPK().getBus().equals(bus)
                                  ){
                
                listaTurnos.add(turno);}
            }
            
            return listaTurnos;
    }
        
    
}
