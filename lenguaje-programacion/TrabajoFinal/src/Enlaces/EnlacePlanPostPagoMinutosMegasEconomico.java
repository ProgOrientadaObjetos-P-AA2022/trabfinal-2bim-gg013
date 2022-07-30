/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enlaces;
import Planes.PlanPostPagoMinutosMegasEconomico;
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
public class EnlacePlanPostPagoMinutosMegasEconomico {
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
    
    public void insertarPlan(PlanPostPagoMinutosMegasEconomico plan) {  
  
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            plan.establecerPagoMensual();
            String data = String.format("INSERT INTO tabla4 (nombresPropietario,"
                    + " cedulaPropietario, ciudadPropietario, marcaCelular, "
                    + "modeloCelular, numeroCelular, minutos, costoMinuto, megasEngigas, "
                    + "costoGiga, descuento, pagoMensual) "
                    + "values ('%s', '%s', '%s', '%s', '%s', '%s', '%d', '%.2f' , '%d' , '%.2f' , '%.2f' , '%.2f')", 
                    plan.obtenerNombrePropietario(), 
                    plan.obtenerCedulaPropietario(), 
                    plan.obtenerCiudadPropietario(), 
                    plan.obtenerMarcaCelular(), 
                    plan.obtenerModeloCelular(), 
                    plan.obtenerNumeroCelular(),
                    
                    plan.obtenerMinutos(), 
                    plan.obtenerCostoMinutos(), 
                    plan.obtenerMegasEnGigas(), 
                    plan.obtenerCostoGigas(), 
                    plan.obtenerDescuento(),
                    plan.obtenerPagoMensual());
            
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarPlan");
             System.out.println(e.getMessage());  
             
        }  
    }
    
    public ArrayList<PlanPostPagoMinutosMegasEconomico> obtenerDataPlan() {  
        ArrayList<PlanPostPagoMinutosMegasEconomico> lista = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from tabla4";
            
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                PlanPostPagoMinutosMegasEconomico miPlan = new PlanPostPagoMinutosMegasEconomico(
                        rs.getInt("minutos"),
                        rs.getDouble("costoMinuto"),
                        rs.getInt("megasEnGigas"),
                        rs.getDouble("costoGiga"),
                        rs.getDouble("descuento"),
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
