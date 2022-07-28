/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enlaces;

import Planes.PlanPostPagoMinutos;
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
public class EnlacePlanPostPagoMinutos {

    private Connection conn;

    public void establecerConexion() {

        try {
            String url = "jdbc:sqlite:bd/base01.db";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Connection obtenerConexion() {
        return conn;
    }

    public void insertarPlan(PlanPostPagoMinutos plan) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            plan.establecerPagoMensual();
            String data = String.format("INSERT INTO tabla1 (nombresPropietario,"
                    + " cedulaPropietario, ciudadPropietario, marcaCelular, "
                    + "modeloCelular, numeroCelular, minutosNacionales, costoMinutoNacional, "
                    + "minutosInternacionales, costoMinutoInternacional, pagoMensual) "
                    + "values ('%s', '%s', '%s', '%s', '%s', '%s',  '%d',  '%.2f',  '%d',  '%.2f', '%s')",
                    plan.obtenerNombrePropietario(),
                    plan.obtenerCedulaPropietario(),
                    plan.obtenerCiudadPropietario(),
                    plan.obtenerMarcaCelular(),
                    plan.obtenerModeloCelular(),
                    plan.obtenerNumeroCelular(),
                    plan.obtenerMinutosNacionales(),
                    plan.obtenerCostoMinutoNacional(),
                    plan.obtenerMinutosInternacionales(),
                    plan.obtenerCostoMinutosInternacionales(),
                    plan.obtenerPagoMensual());

            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPlan");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<PlanPostPagoMinutos> obtenerDataPlan() {
        ArrayList<PlanPostPagoMinutos> lista = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from tabla1";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMinutos p = new PlanPostPagoMinutos(
                        rs.getInt("minutosNacionales"),
                        rs.getDouble("costoMinutoNacional"),
                        rs.getInt("minutosInternacionales"),
                        rs.getDouble("costoMinutoInternacional"),
                        rs.getString("nombresPropietario"),
                        rs.getString("cedulaPropietario"),
                        rs.getString("ciudadPropietario"),
                        rs.getString("marcaCelular"),
                        rs.getString("modeloCelular"),
                        rs.getString("numeroCelular"));
                p.establecerPagoMensual();
                lista.add(p);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPlan");
            System.out.println(e.getMessage());

        }
        return lista;
    }
}
