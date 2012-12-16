/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import java.sql.*;
import javax.swing.*;
import net.sf.jasperreports.engine.*;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.view.JasperViewer;





/**
 *
 * @author chokuno
 */
public class GenerarReporte {
     String url, usuario, password;
    Connection conexion;
        //TOCO HACERLO ASI PORQUE ORM NO SE COMO SACARLE LA CONEXION A ESA PERSISTENCIA
    
    public GenerarReporte()
    {
            url="jdbc:mysql://localhost:3306/DSII";
            usuario="root";
            password="chokuno";

    }
    
    
    public void generarReporte(String tipo){
    Connection conn=conectar();
        
   JasperReport report=null;

        try{
         if(tipo.equals("pasajeros"))
    report = JasperCompileManager.compileReport(
          "Reportes/reportePasajerosTarjeta.jrxml");
         
         if(tipo.equals("pasajerosMovilizados"))
    report = JasperCompileManager.compileReport(
          "Reportes/PasajerosMovilizados.jrxml");
         
         if(tipo.equals("tarjetasVendidas"))
    report = JasperCompileManager.compileReport(
          "Reportes/tarjetasVendidas.jrxml");
         
         if(tipo.equals("quejas"))
    report = JasperCompileManager.compileReport(
          "Reportes/reporteQuejas.jrxml");
         
         if(tipo.equals("buses"))
    report = JasperCompileManager.compileReport(
          "Reportes/reporteTurnos.jrxml");
         
         if(tipo.equals("rutas"))
    report = JasperCompileManager.compileReport(
          "Reportes/reporteRutas.jrxml");
         
         if(tipo.equals("quejasComunes"))
    report = JasperCompileManager.compileReport(
          "Reportes/quejasComunes.jrxml");
         
         
      JasperPrint print = JasperFillManager.fillReport(report, null, conn);
      // Exporta el informe a PDF
      JasperExportManager.exportReportToPdfFile(print,
          "Reportes/PDF");
      //Para visualizar el pdf directamente desde java
      
      JasperViewer.viewReport(print, false);
     
        }
        catch(Exception ej){ej.printStackTrace();}
        cerrarConexion();
    }
    
    
        public Connection conectar() {
        try {
            // Se carga el driver
            Class.forName("org.mysql.Driver");
            //System.out.println( "Driver Cargado" );
        } catch (Exception e) {
            System.out.println("No se pudo cargar el driver.");
        }

        try {
            //Crear el objeto de conexion a la base de datos
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion Abierta");
            return conexion;
            //Crear objeto Statement para realizar queries a la base de datos
        } catch (Exception e) {
            System.out.println("No se pudo abrir la bd.");
            return null;
        }

    }//end connectar

    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            System.out.println("No se pudo cerrar.");
        }
    }
    
    
        
}
