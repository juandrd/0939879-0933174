/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.TarjetasPersonalizadasJpaController;
import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.TarjetasGenericas;
import entidades.TarjetasPersonalizadas;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Juan
 */
public class ControladorTarjetasPersonalizadas {
    
     private FabricaObjetos mi_fabrica;
     TarjetasPersonalizadasJpaController daoTarjetasP;
    
    //se requiere para elaborar consultas personalizadas
    EntityManager manager;
    
    public  ControladorTarjetasPersonalizadas()
    {
    mi_fabrica = new FabricaObjetos();   
    manager= mi_fabrica.crear().createEntityManager();
    
    daoTarjetasP= new TarjetasPersonalizadasJpaController(mi_fabrica.getFactory());
    }
    
     public int insertar(String pin_tarjeta,int nro_pasajes,String estado 
           )
    {
        if (!pin_tarjeta.isEmpty() && nro_pasajes>0 && !estado.isEmpty()
                ) {
        TarjetasPersonalizadas tPersonalizadas = new TarjetasPersonalizadas();
        tPersonalizadas.setPinTarjeta( pin_tarjeta );
        tPersonalizadas.setNroPasajes( nro_pasajes );
        tPersonalizadas.setEstado( estado );
        tPersonalizadas.setAdelantoDisponible(3);

        
        try 
        {
            daoTarjetasP.create(tPersonalizadas);
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
         public int modificar(String pin_tarjeta,int nro_pasajes,String estado,
                 int adelantos_disponibles)
    {
        if (!pin_tarjeta.isEmpty() && nro_pasajes>0 && !estado.isEmpty() &&
                adelantos_disponibles>=0 && adelantos_disponibles<4)  {
            
        TarjetasPersonalizadas tPersonalizadas = daoTarjetasP.findTarjetasPersonalizadas(pin_tarjeta);
        tPersonalizadas.setPinTarjeta( pin_tarjeta );
        tPersonalizadas.setNroPasajes( nro_pasajes );
        tPersonalizadas.setEstado( estado );
        tPersonalizadas.setAdelantoDisponible(adelantos_disponibles);
        
        try 
        {   
            daoTarjetasP.edit(tPersonalizadas);
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
         
         
           public TarjetasPersonalizadas consultar(String id){
          
           TarjetasPersonalizadas t;
           
           t=daoTarjetasP.findTarjetasPersonalizadas(id);
           
         
                      
           return t;
       }
           
           public LinkedList consultar(String pin_tarjeta,int nro_pasajes,String estado)
    {
                        //"SELECT r FROM TarjetasGenericas r"
            List lista;
            LinkedList listaTarjetas= new LinkedList();
            String sql_select="SELECT tg FROM TarjetasPersonalizadas tg     ";
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
            else lista = manager.createQuery("SELECT tg FROM TarjetasPersonalizadas tg").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                TarjetasPersonalizadas tg = (TarjetasPersonalizadas) lista.get(i);
                listaTarjetas.add(tg);
            }
            
            return listaTarjetas;
    }
          public String[] listar() {
        LinkedList tarjetasConsulta = consultar("",0,"Disponible");
        String[] tarjetas = new String[tarjetasConsulta.size() + 1];
        tarjetas[0] = " ";
        for (int i = 0; i < tarjetasConsulta.size(); i++) {
            tarjetas[i + 1] = ((TarjetasPersonalizadas) tarjetasConsulta.get(i)).getPinTarjeta();
        }
        return tarjetas;
    }
}
