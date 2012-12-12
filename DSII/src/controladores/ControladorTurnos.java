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
    
        public int insertar(String conductor,String bus,Date hora_inicio,Date hora_fin)
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
        
    public int modificar(String conductor,String bus,Date hora_inicio,Date hora_fin)
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
        


        
        public LinkedList consultar(String conductor,String bus,String hora_inicio,String hora_fin)
    {
                        //"SELECT r FROM Rutas r"
            List lista;
            LinkedList listaTurnos= new LinkedList();
            String sql_select="SELECT t FROM Turnos t   ";
            if (!conductor.equals("") || !bus.equals("") || !hora_inicio.equals("") || !hora_fin.equals("")) {
            sql_select += "WHERE ";
            }
            
        if (!conductor.equals("")) {
            sql_select += "t.conductor = '" + conductor + "' AND ";
        }
        
        if(!bus.equals("")){
            sql_select += "t.bus = '"+bus+"'"+" AND ";
        }
        
        if(!hora_inicio.equals("")){
            sql_select += "t.hora_inicio = '"+hora_inicio+"'"+" AND ";
        }
        
        if(!hora_fin.equals("")){
            sql_select += "t.hora_fin = '"+hora_fin+"'"+" AND ";
        }
            
            
            sql_select = sql_select.substring(0, sql_select.length() - 5);
            
            //sirve para ejecutar consultas
            if(sql_select.contains("WHERE"))
            lista = manager.createQuery(sql_select).getResultList();
            else lista = manager.createQuery("SELECT t FROM Turnos t").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                Turnos t = (Turnos) lista.get(i);
                listaTurnos.add(t);
            }
            
            return listaTurnos;
    }
    
    


    
}
