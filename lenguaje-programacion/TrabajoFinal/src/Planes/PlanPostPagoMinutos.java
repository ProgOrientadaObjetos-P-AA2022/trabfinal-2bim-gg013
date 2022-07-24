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
public class PlanPostPagoMinutos extends PlanCelular {

    private int minutosNacionales;
    private double costoMinutoNacional;
    private int minutosInternacionales;
    private double costoMinutosInternacionales;

    public PlanPostPagoMinutos(int na, double cosNa, int it, double cosIt,
            String n, String ced, String ciud, String mar,
            String mod, String num) {
        super(n, ced, ciud, mar, mod, num);

        minutosNacionales = na;
        costoMinutoNacional = cosNa;
        minutosInternacionales = it;
        costoMinutosInternacionales = cosIt;

    }

    public void establecerMinutosNacionales(int m) {
        minutosNacionales = m;
    }

    public int obtenerMinutosNacionales() {
        return minutosNacionales;
    }

    public void establecerCostoMinutoNacional(double c) {
        costoMinutoNacional = c;
    }

    public double obtenerCostoMinutoNacional() {
        return costoMinutoNacional;
    }

    public void establecerMinutosInternacionales(int m) {
        minutosInternacionales = m;
    }

    public int obtenerMinutosInternacionales() {
        return minutosInternacionales;
    }

    public void establecerCostoMinutosInternacionales(double c) {
        costoMinutosInternacionales = c;
    }

    public double obtenerCostoMinutosInternacionales() {
        return costoMinutosInternacionales;
    }

    @Override
    public void establecerPagoMensual() {
        pagoMensual = (minutosNacionales * costoMinutoNacional)
                + (minutosInternacionales * costoMinutosInternacionales);
    }

    @Override
    public String toString() {
        String cadena = "--> Plan Post Pago Minutos";

        cadena = String.format("""
                               %s%s\n
                               \tMinutos Nacionales              : %d
                               \tCosto Del Minuto Nacional       : %.2f
                               \tMinutos Internacionales         : %d
                               \tCosto Del Minuto Internacional  : %.2f
                               \tVALOR PAGO MENSUAL              : %.2f
                               """,
                super.toString(),
                cadena,
                minutosNacionales,
                costoMinutoNacional,
                minutosInternacionales,
                costoMinutosInternacionales,
                pagoMensual);
        return cadena;

    }
}
