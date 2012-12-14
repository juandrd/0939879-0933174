/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.TarjetasGenericasJpaController;
import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.TarjetasGenericas;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author chokuno
 */
public class ControladoresTarjetasGenericas {
    
     private FabricaObjetos mi_fabrica;
     TarjetasGenericasJpaController daoTarjetasGenericas;
    
    //se requiere para elaborar consultas personalizadas
    EntityManager manager;
    
    public ControladoresTarjetasGenericas()
    {
    mi_fabrica = new FabricaObjetos();   
    manager= mi_fabrica.crear().createEntityManager();
    
    daoTarjetasGenericas= new TarjetasGenericasJpaController(mi_fabrica.getFactory());
    }
    
        public int insertar(String pin_tarjeta,int nro_pasajes,String estado)
    {
        if (!pin_tarjeta.isEmpty() && nro_pasajes>0 && !estado.isEmpty() ) {
        TarjetasGenericas tarjetasGenericas = new TarjetasGenericas();
        tarjetasGenericas.setPinTarjeta( pin_tarjeta );
        tarjetasGenericas.setNroPasajes( nro_pasajes );
        tarjetasGenericas.setEstado( estado );

        
        try 
        {
            daoTarjetasGenericas.create(tarjetasGenericas);
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
        
    public int modificar(String pin_tarjeta,int nro_pasajes,String estado)
    {
        if (!pin_tarjeta.isEmpty() && nro_pasajes>0 && !estado.isEmpty() )  {
            
        TarjetasGenericas tarjetasGenericasEncontrada = daoTarjetasGenericas.findTarjetasGenericas(pin_tarjeta);
        
        tarjetasGenericasEncontrada.setPinTarjeta(pin_tarjeta);
        tarjetasGenericasEncontrada.setNroPasajes(nro_pasajes);
        tarjetasGenericasEncontrada.setEstado(estado);
        
        try 
        {   
            daoTarjetasGenericas.edit(tarjetasGenericasEncontrada);
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
        
     public TarjetasGenericas consultar(String id){
          
           TarjetasGenericas t;
           
           t=daoTarjetasGenericas.findTarjetasGenericas(id);
           
         
            
           
           return t;
       }

        
        public LinkedList consultar(String pin_tarjeta,int nro_pasajes,String estado)
    {
                        //"SELECT r FROM TarjetasGenericas r"
            List lista;
            LinkedList listaTarjetasGenericas= new LinkedList();
            String sql_select="SELECT tg FROM TarjetasGenericas tg     ";
            if (!pin_tarjeta.equals("") || nro_pasajes>0|| !estado.equals("")) {
            sql_select += "WHERE";
            }
            
        if (!pin_tarjeta.equals("")) {
            sql_select += " tg.pinTarjeta = '" + pin_tarjeta + "' AND ";
        }
        
        if(nro_pasajes>0){
            sql_select += " tg.nroPasajes <= "+nro_pasajes+"  AND ";
        }
        
        if(!estado.equals("")){
            sql_select += " tg.estado = '"+estado+"' AND ";
        }
            
            
            sql_select = sql_select.substring(0, sql_select.length() - 5);
            System.out.println(sql_select);
            //sirve para ejecutar consultas
            if(sql_select.contains("WHERE"))
            lista = manager.createQuery(sql_select).getResultList();
            else lista = manager.createQuery("SELECT tg FROM TarjetasGenericas tg").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                TarjetasGenericas tg = (TarjetasGenericas) lista.get(i);
                listaTarjetasGenericas.add(tg);
            }
            
            return listaTarjetasGenericas;
    }
    
    
//    public String[] listar() {
//        LinkedList TarjetasGenericasConsultar = consultar("","");
//        String[] TarjetasGenericas = new String[TarjetasGenericasConsultar.size() + 1];
//        TarjetasGenericas[0] = " ";
//        for (int i = 0; i < TarjetasGenericasConsultar.size(); i++) {
//            TarjetasGenericas[i + 1] = ((TarjetasGenericas) TarjetasGenericasConsultar.get(i)).getNombre();
//        }
//        return TarjetasGenericas;
//    }

    
    
}
