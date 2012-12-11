/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import dao.EmpleadosJpaController;
import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import entidades.Buses;
import entidades.Empleados;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
/**
 *
 * @author Juan
 */
public class ControladorEmpleado {
    
       private FabricaObjetos mi_fabrica;
    EmpleadosJpaController daoEmpleado;
    
    //se requiere para elaborar consultas personalizadas
    EntityManager manager;
    
    public ControladorEmpleado()
    {
    mi_fabrica = new FabricaObjetos();   
    manager= mi_fabrica.crear().createEntityManager();
    
    daoEmpleado= new EmpleadosJpaController(mi_fabrica.getFactory());
    }
    
    public int insertar(String id,String nombre,String apellidos,
                String telefono,String direccion,String email,String genero,
                int salario)
    {
        if (!id.isEmpty() && !nombre.isEmpty() && !apellidos.isEmpty() 
                && !telefono.isEmpty()  && !direccion.isEmpty()
                && !email.isEmpty() && !genero.isEmpty() && salario>0 ) {
            
        Empleados empleado = new Empleados();
        empleado.setIdentificacion( id );
        empleado.setNombres( nombre );
        empleado.setApellidos(apellidos);
        empleado.setDireccion(direccion);
        empleado.setTelefono(telefono);
        empleado.setGenero(genero);
        empleado.setEmail(email);
        empleado.setSalario(salario);
        empleado.setPassword("0000");

        
        try 
        {
            daoEmpleado.create(empleado);
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
        
     public int modificar(String id,String nombre,String apellidos,
                String telefono,String direccion,String email,String genero,
                int salario, String password)
    {
        if (!id.isEmpty() && !nombre.isEmpty() && !apellidos.isEmpty() 
                && !telefono.isEmpty()  && !direccion.isEmpty()
                && !email.isEmpty() && !genero.isEmpty() && salario>0 &&
                !password.isEmpty()) {
        Empleados empleado = daoEmpleado.findEmpleados(id);
        
        empleado.setIdentificacion( id );
        empleado.setNombres( nombre );
        empleado.setApellidos(apellidos);
        empleado.setDireccion(direccion);
        empleado.setTelefono(telefono);
        empleado.setGenero(genero);
        empleado.setEmail(email);
        empleado.setSalario(salario);
        empleado.setPassword(password);
        
        try 
        {   
            daoEmpleado.edit(empleado);
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
        
   public LinkedList consultar(String id,String nombre,String apellido,String genero,
           int salario)
    {
                        //"SELECT r FROM buses r"
            List lista;
            LinkedList listaEmpleado= new LinkedList();
            String sql_select="SELECT e FROM Empleados e     ";
                if (!id.equals("") || !nombre.equals("") ||
                     salario>0 ||
                    !apellido.equals("") ||
                    !genero.equals(" ") ) {
                
            sql_select += "WHERE";
            }
            
        if (!id.equals("")) {
            sql_select += " e.identificacion = '" + id + "' AND ";
        }       
       
        
        if(!nombre.equals("")){
            sql_select += " e.nombres LIKE '%"+nombre+"%'"+" AND ";
        }
        
               
        if(!apellido.equals("")){
            sql_select += " e.apellidos LIKE '%" + apellido+"%'"+ " AND ";
        }

        if (!genero.equals(" ")) {
            sql_select += " e.genero = '"+genero+"'"+" AND ";
        }
        if (salario>0) {
            sql_select += " e.salario = '"+salario+"'"+" AND ";
        }

            
            
            sql_select = sql_select.substring(0, sql_select.length() - 5);
            System.out.println(sql_select);
            
            //sirve para ejecutar consultas
//            if(sql_select.contains("WHERE"))
               lista = manager.createQuery(sql_select).getResultList();
            //else lista = manager.createQuery("SELECT b FROM Buses b ").getResultList();
            
            for(int i=0;i<lista.size();i++)
            {
                Empleados e = (Empleados) lista.get(i);
                listaEmpleado.add(e);
            }
            
            return listaEmpleado;
    }
    
    
}
