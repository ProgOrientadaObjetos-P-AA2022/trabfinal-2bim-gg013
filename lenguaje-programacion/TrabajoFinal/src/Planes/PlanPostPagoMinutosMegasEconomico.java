/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Planes;

import trabajofinal.PlanCelular;

/**
 *
 * @author Usuario iTC
 */
public class PlanPostPagoMinutosMegasEconomico extends PlanCelular {

    private int minutos;
    private double costoMinutos;
    private int megasEnGigas;
    private double costoGigas;
    private double descuento;

    public PlanPostPagoMinutosMegasEconomico(int m, double cos, int gg,
            double cosgg, double des,
            String n, String ced, String ciud, String mar,
            String mod, String num) {
        super(n, ced, ciud, mar, mod, num);

        minutos = m;
        costoMinutos = cos;
        megasEnGigas = gg;
        costoGigas = cosgg;
        descuento = des;
    }

    public void establecerMinutos(int m) {
        minutos = m;
    }

    public int obtenerMinutos() {
        return minutos;
    }

    public void establecerCostoMinutos(double c) {
        costoMinutos = c;
    }

    public double obtenerCostoMinutos() {
        return costoMinutos;
    }

    public void establecerMegasEnGigas(int m) {
        megasEnGigas = m;
    }

    public int obtenerMegasEnGigas() {
        return megasEnGigas;
    }

    public void establecerCostoGigas(double C) {
        costoGigas = C;
    }

    public double obtenerCostoGigas() {
        return costoGigas;
    }

    public void establecerDescuento(double d) {
        descuento = d;
    }

    public double obtenerDescuento() {
        return descuento;
    }

    @Override
    public void establecerPagoMensual() {
        pagoMensual = (minutos * costoMinutos) + (megasEnGigas * costoGigas);
        pagoMensual = pagoMensual - (pagoMensual * (descuento / 100));
    }

     @Override
    public String toString() {
        String cadena = "--> Plan Post Pago Minutos Megas";

        cadena = String.format("""
                               %s%s\n
                               \tCantidad De Minutos       : %d
                               \tCosto Del Minuto          : %.2f
                               \tCantidad De Megas         : %d
                               \tCosto De Los Gigas        : %.2f
                               \tValor Del Descuento       : %.2f
                               \tVALOR PAGO MENSUAL        : %.2f
                               """,
                super.toString(),
                cadena,
                minutos,
                costoMinutos,
                megasEnGigas,
                costoGigas,
                descuento,
                pagoMensual);
        return cadena;

    }
}
