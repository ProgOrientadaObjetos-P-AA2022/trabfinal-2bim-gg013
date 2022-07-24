/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;

/**
 *
 * @author Usuario iTC
 */
public abstract class PlanCelular {

    protected String nombrePropietario;
    protected String cedulaPropietario;
    protected String ciudadPropietario;
    protected String marcaCelular;
    protected String modeloCelular;
    protected String numeroCelular;
    protected double pagoMensual; // abstracto

    public PlanCelular(String n, String ced, String ciud, String mar,
            String mod, String num) {
        nombrePropietario = n;
        cedulaPropietario = ced;
        ciudadPropietario = ciud;
        marcaCelular = mar;
        modeloCelular = mod;
        numeroCelular = num;

    }

    public void establecerNombrePropietario(String n) {
        nombrePropietario = n;
    }

    public String obtenerNombrePropietario() {
        return nombrePropietario;
    }

    public void establecerCedulaPropietario(String c) {
        cedulaPropietario = c;
    }

    public String obtenerCedulaPropietario() {
        return cedulaPropietario;
    }

    public void establecerCiudadPropietario(String c) {
        ciudadPropietario = c;
    }

    public String obtenerCiudadPropietario() {
        return ciudadPropietario;
    }

    public void establecerMarcaCelular(String m) {
        marcaCelular = m;
    }

    public String obtenerMarcaCelular() {
        return marcaCelular;
    }

    public void establecerModeloCelular(String m) {
        modeloCelular = m;
    }

    public String obtenerModeloCelular() {
        return modeloCelular;
    }

    public void establecerNumeroCelular(String n) {
        numeroCelular = n;
    }

    public String obtenerNumeroCelular() {
        return numeroCelular;
    }

    public abstract void establecerPagoMensual();

    public double obtenerPagoMensual() {
        return pagoMensual;
    }

    @Override
    public String toString() {
        String cadena = "       *** Datos Del Plan Celular ***";

        cadena = String.format("""
                               %s\nNombre Del Propietario: %s
                               Cedula Del Propietario: %s
                               Ciudad Del Propietario: %s
                               Marca Del Movil       : %s
                               Modelo Del Movil      : %s
                               Numero De Celular     : %s\n
                               """,
                cadena,
                nombrePropietario,
                cedulaPropietario,
                ciudadPropietario,
                marcaCelular,
                modeloCelular,
                numeroCelular);
        return cadena;
    }

}
