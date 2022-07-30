/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enlaces;
import Planes.PlanPostPagoMinutosMegas;
import java.sql.Statement;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Usuario iTC
 */
public class EnlacePlanPostPagoMinutosMegas {
     private Connection conn;
       
    public void establecerConexion() {  

        try {  
            String url = "jdbc:sqlite:bd/base01.db";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
        
    } 
    
    public Connection obtenerConexion(){
        return conn;
    }
    
    public void insertarPlan(PlanPostPagoMinutosMegas plan) {  
  
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            plan.establecerPagoMensual();
            String data = String.format("INSERT INTO tabla3 (nombresPropietario,"
                    + " cedulaPropietario, ciudadPropietario, marcaCelular, "
                    + "modeloCelular, numeroCelular, minutos, costoMinuto, megasEnGigas, costoGiga, pagoMensual) "
                    + "values ('%s', '%s', '%s', '%s', '%s', '%s', '%d',  '%.2f', '%d', '%.2f', '%.2f')", 
                    plan.obtenerNombrePropietario(), 
                    plan.obtenerCedulaPropietario(), 
                    plan.obtenerCiudadPropietario(), 
                    plan.obtenerMarcaCelular(), 
                    plan.obtenerModeloCelular(), 
                    plan.obtenerNumeroCelular(),
                    
                    plan.obtenerMinutos(),
                    plan.obtenerCostoMinutos(),
                    plan.obtenerMegasEnGigas(), 
                    plan.obtenerCostoGiga(), 
                    plan.obtenerPagoMensual());
            
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarPlan");
             System.out.println(e.getMessage());  
             
        }  
    }
    
    public ArrayList<PlanPostPagoMinutosMegas> obtenerDataPlan() {  
        ArrayList<PlanPostPagoMinutosMegas> lista = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from tabla3";
            
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                PlanPostPagoMinutosMegas miPlan = new PlanPostPagoMinutosMegas(
                        rs.getInt("minutos"),
                        rs.getDouble("costoMinuto"),
                        rs.getInt("megasEnGigas"),
                        rs.getDouble("costoGiga"),
                        rs.getString("nombresPropietario"),
                        rs.getString("cedulaPropietario"),
                        rs.getString("ciudadPropietario"),
                        rs.getString("marcaCelular"),
                        rs.getString("modeloCelular"),
                        rs.getString("numeroCelular"));
                miPlan.establecerPagoMensual();
                lista.add(miPlan);
            }
            
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarPlan");
             System.out.println(e.getMessage());  
             
        }  
        return lista;
    }
}
