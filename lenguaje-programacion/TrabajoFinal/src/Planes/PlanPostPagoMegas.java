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
public class PlanPostPagoMegas extends PlanCelular {

    private int megasEnGigas;
    private double costoGiga;
    private double tarifaBase;

    public PlanPostPagoMegas(int d, double c, double t,
            String n, String ced, String ciud, String mar, String mod,
            String num) {
        super(n, ced, ciud, mar, mod, num);

        megasEnGigas = d;
        costoGiga = c;
        tarifaBase = t;

    }

    public void establecerMegasEnGigas(int m) {
        megasEnGigas = m;
    }

    public int obtenerMegasEnGigas() {
        return megasEnGigas;
    }

    public void establecerCostoGiga(double c) {
        costoGiga = c;
    }

    public double obtenerCostoGiga() {
        return costoGiga;
    }

    public void establecerTarifaBase(double t) {
        tarifaBase = t;
    }

    public double obtenerTarifaBase() {
        return tarifaBase;
    }

    @Override
    public void establecerPagoMensual() {
        pagoMensual = (megasEnGigas * costoGiga) + tarifaBase;
    }

    @Override
    public String toString() {
        String cadena = "--> Plan Post Pago Megas";

        cadena = String.format("""
                               %s%s\n
                               \tCantidad De Megas        : %d
                               \tCosto Del Giga           : %.2f
                               \tValor De La Tarifa Base  : %.2f
                               \tVALOR PAGO MENSUAL       : %.2f
                               """,
                super.toString(),
                cadena,
                megasEnGigas,
                costoGiga,
                tarifaBase,
                pagoMensual);
        return cadena;

    }

}
