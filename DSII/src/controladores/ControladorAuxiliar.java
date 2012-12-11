/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import dao.AuxiliaresJpaController;
import dao.BusesJpaController;
import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.Auxiliares;
import entidades.Buses;
import entidades.Empleados;
import entidades.Estaciones;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
/**
 *
 * @author Juan
 */
public class ControladorAuxiliar {
      private FabricaObjetos mi_fabrica;
    AuxiliaresJpaController daoAuxiliar;
    
    //se requiere para elaborar consultas personalizadas
    EntityManager manager;
    
    public ControladorAuxiliar()
    {
    mi_fabrica = new FabricaObjetos();   
    manager= mi_fabrica.crear().createEntityManager();
    
    daoAuxiliar= new AuxiliaresJpaController(mi_fabrica.getFactory());
    }
    
     public int insertar(Empleados empleado,Estaciones estacion)
    {
        if (!empleado.getIdentificacion().isEmpty() && !estacion.getNombre().isEmpty()
                ) {
            
        Auxiliares aux = new Auxiliares();
        aux.setIdentificacion(empleado.getIdentificacion() );
        aux.setEstacion(estacion.getNombre());       

        
        try 
        {
            daoAuxiliar.create(aux);
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
     
      public int modificar(Empleados empleado,Estaciones estacion)
    {
        if (!empleado.getIdentificacion().isEmpty() && !estacion.getNombre().isEmpty()
               ) {
        Auxiliares auxiliar = daoAuxiliar.findAuxiliares(empleado.getIdentificacion());
        
         auxiliar.setIdentificacion(empleado.getIdentificacion());
        auxiliar.setEstacion(estacion.getNombre());
        
        try 
        {   
            daoAuxiliar.edit(auxiliar);
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
        
      // public LinkedList consultar(String empleado,String estacion)
     //   {
//                        //"SELECT r FROM buses r"
//            List lista;
//            LinkedList listaAuxiliares= new LinkedList();
//            String sql_select="SELECT aux FROM Auxiliares aux     ";
//                if (!empleado.equals("") || !tipo.equals("") ||
//                     capacidad>0 ||
//                    (!ruta.equals("Cargar") && 
//                    !ruta.equals(" ") )) {
//                
//            sql_select += "WHERE";
//            }
//            
//        if (!placa.equals("")) {
//            sql_select += " b.placa = '" + placa + "' AND ";
//        }       
//       
//        
//        if(!tipo.equals("")){
//            sql_select += " b.tipo = '"+tipo+"'"+" AND ";
//        }
//        
//               
//        if(capacidad>0){
//            sql_select += " b.capacidad < " + capacidad + " AND ";
//        }
//
//        if (!ruta.equals("Cargar") && !ruta.equals(" ")) {
//            sql_select += " b.ruta = '"+ruta+"'"+" AND ";
//        }
//        
//
//            
//            
//            sql_select = sql_select.substring(0, sql_select.length() - 5);
//            System.out.println(sql_select);
//            
//            //sirve para ejecutar consultas
////            if(sql_select.contains("WHERE"))
//               lista = manager.createQuery(sql_select).getResultList();
//            //else lista = manager.createQuery("SELECT b FROM Buses b ").getResultList();
//            
//            for(int i=0;i<lista.size();i++)
//            {
//                Buses b = (Buses) lista.get(i);
//                listaAuxiliares.add(b);
//            }
//            
//            return listaAuxiliares;
   // }
}
