/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajofinal;

import Enlaces.EnlacePlanPostPagoMegas;
import Enlaces.EnlacePlanPostPagoMinutos;
import Enlaces.EnlacePlanPostPagoMinutosMegas;
import Enlaces.EnlacePlanPostPagoMinutosMegasEconomico;
import java.util.Scanner;
import Planes.PlanPostPagoMinutos;
import Planes.PlanPostPagoMegas;
import Planes.PlanPostPagoMinutosMegas;
import Planes.PlanPostPagoMinutosMegasEconomico;
import java.util.Locale;

/**
 *
 * David Ernesto Carrion Acosta Pablo Andres Costa Torres Jose Xavier Guerrero
 * Morillo
 */
public class Ejecutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        PlanPostPagoMinutos p1;
        PlanPostPagoMegas p2;
        PlanPostPagoMinutosMegas p3;
        PlanPostPagoMinutosMegasEconomico p4;

        boolean bandera = true;
        int opcion;

        String nombreUsuario = "";
        String cedula = "";
        String ciudad = "";
        String marca = "";
        String modelo = "";
        String numero = "";

        EnlacePlanPostPagoMinutos enlace1 = new EnlacePlanPostPagoMinutos();
        EnlacePlanPostPagoMegas enlace2 = new EnlacePlanPostPagoMegas();
        EnlacePlanPostPagoMinutosMegas enlace3 = new EnlacePlanPostPagoMinutosMegas();
        EnlacePlanPostPagoMinutosMegasEconomico enlace4 = new EnlacePlanPostPagoMinutosMegasEconomico();

        while (bandera) {
            opcion = Interfaz();

            System.out.println("---------------------------------------------");
            if (opcion < 5) {
                System.out.println("A Continuacion Se van a asignar los datos "
                        + "para crear"
                        + " un nuevo Plan Celular");
                System.out.println("--------------------------------------"
                        + "-------");
                System.out.println("Porfavor Ingrese el nombre del Usuario");
                nombreUsuario = sc.nextLine();
                System.out.println("Porfavor Ingrese la cedula del Usuario");
                cedula = sc.nextLine();
                System.out.println("Porfavor Ingrese la ciudad del Usuario");
                ciudad = sc.nextLine();
                System.out.println("Porfavor Ingrese la marca del movil");
                marca = sc.nextLine();
                System.out.println("Porfavor Ingrese el modelo del movil");
                modelo = sc.nextLine();
                System.out.println("Porfavor Ingrese el numero del movil");
                numero = sc.nextLine();
            }
            System.out.println("---------------------------------------------");

            switch (opcion) {
                case 1:
                    p1 = PlanPostPagoMinutos(nombreUsuario, cedula, ciudad,
                            marca, modelo, numero);
                    p1.establecerPagoMensual();
                    enlace1.insertarPlan(p1);
                    break;

                case 2:
                    p2 = PlanPostPagoMegas(nombreUsuario, cedula, ciudad, marca,
                            modelo, numero);
                    p2.establecerPagoMensual();
                    enlace2.insertarPlan(p2);
                    break;

                case 3:
                    p3 = PlanPostPagoMinutosMegas(nombreUsuario, cedula, ciudad,
                            marca, modelo, numero);
                    p3.establecerPagoMensual();
                    enlace3.insertarPlan(p3);
                    break;

                case 4:
                    p4 = PlanPostPagoMegasEconomico(nombreUsuario, cedula,
                            ciudad, marca, modelo, numero);
                    p4.establecerPagoMensual();
                    enlace4.insertarPlan(p4);
                    break;
                case 5:
                    for (int i = 0; i < enlace1.obtenerDataPlan().size(); i++) {
                        System.out.printf("%s", enlace1.obtenerDataPlan().get(i));
                    }
                    
                    System.out.println("");

                    for (int i = 0; i < enlace2.obtenerDataPlan().size(); i++) {
                        System.out.printf("%s", enlace2.obtenerDataPlan().get(i));
                    }

                    System.out.println("");
                    
                    for (int i = 0; i < enlace3.obtenerDataPlan().size(); i++) {
                        System.out.printf("%s", enlace3.obtenerDataPlan().get(i));
                    }

                    System.out.println("");
                    
                    for (int i = 0; i < enlace4.obtenerDataPlan().size(); i++) {
                        System.out.printf("%s", enlace4.obtenerDataPlan().get(i));
                    }
                    break;

                case 6:
                    System.out.println("Muchas Gracias Por Usar Nuestro Programa"
                            + " Que Tenga Un Lindo Dia");
                    bandera = false;
                    break;
            }
        }

    }

    public static int Interfaz() {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int op;

        System.out.println("    ********** Menu De Ingreso De Datos **********");
        System.out.printf(""
                + "Crear Un Nuevo Plan Post Pago Minutos:.................[1]\n"
                + "Crear Un Nuevo Plan Post Pago Megas:...................[2]\n"
                + "Crear Un Nuevo Plan Post Pago Minutos Megas:...........[3]\n"
                + "Crear Un Nuevo Plan Post Pago Minutos Megas(Economico):[4]\n"
                + "Mostrar La Lista De Planes:............................[5]\n"
                + "Salir Del Programa:....................................[6]\n"
                + "");
        op = sc.nextInt();

        if (op < 1 || op > 6) {
            do {
                System.out.println("El valor esta fuera de los parametros, "
                        + "ingrese otro valor");
                op = sc.nextInt();
            } while (op < 1 || op > 6);
        }

        return op;

    }

    public static PlanPostPagoMinutos PlanPostPagoMinutos(String nombreUsuario,
            String cedula, String ciudad, String marca,
            String modelo, String numero) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        PlanPostPagoMinutos p;

        System.out.println("A Continuacion Se van a asignar los datos para crear"
                + " un nuevo Plan Post Pago Minutos");
        System.out.println("---------------------------------------------");
        System.out.println("Ingrese el numero de los minutos nacionales");
        int minutosNacionales = sc.nextInt();
        System.out.println("Ingrese el valor del costo de los minutos "
                + "nacionales");
        double costoMinutosNacionales = sc.nextDouble();
        System.out.println("Ingrese el numero de minutos Internacionales");
        int minutosInternacionales = sc.nextInt();
        System.out.println("Ingrese el valor del costo de los minutos "
                + "internacionales");
        double costoMinutosInternacionales = sc.nextDouble();

        p = new PlanPostPagoMinutos(minutosNacionales, costoMinutosNacionales,
                minutosInternacionales, costoMinutosInternacionales,
                nombreUsuario, cedula, ciudad, marca, modelo, numero);

        return p;
    }

    public static PlanPostPagoMegas PlanPostPagoMegas(String nombreUsuario,
            String cedula, String ciudad, String marca, String modelo,
            String numero) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        PlanPostPagoMegas p;

        System.out.println("A Continuacion Se van a asignar los datos para crear"
                + " un nuevo Plan Post Pago Megas");
        System.out.println("---------------------------------------------");
        System.out.println("Ingrese la cantidad de megas");
        int cantidadMegas = sc.nextInt();
        System.out.println("Ingrese el valor del precio de los Gigas");
        double precioGigas = sc.nextDouble();
        System.out.println("Ingrese el valor de la tarifa base");
        double tarifaBase = sc.nextInt();

        p = new PlanPostPagoMegas(cantidadMegas, precioGigas, tarifaBase,
                nombreUsuario, cedula, ciudad, marca, modelo, numero);

        return p;
    }

    public static PlanPostPagoMinutosMegas PlanPostPagoMinutosMegas(
            String nombreUsuario, String cedula, String ciudad, String marca,
            String modelo, String numero) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        PlanPostPagoMinutosMegas p;
        System.out.println("A Continuacion Se van a asignar los datos para crear"
                + " un nuevo Plan Post Pago Minutos Megas");
        System.out.println("---------------------------------------------");

        System.out.println("Ingrese la cantidad de minutos consumidos");
        int minutos = sc.nextInt();
        System.out.println("Ingrese el valor del costo de los minutos");
        double costoMinutos = sc.nextDouble();
        System.out.println("Ingrese la cantidad de Megas");
        int cantidadMegas = sc.nextInt();
        System.out.println("Ingrese el precio del Giga");
        double precioGiga = sc.nextDouble();

        p = new PlanPostPagoMinutosMegas(minutos, costoMinutos, cantidadMegas,
                precioGiga, nombreUsuario, cedula, ciudad, marca, modelo, numero);

        return p;
    }

    public static PlanPostPagoMinutosMegasEconomico PlanPostPagoMegasEconomico(
            String nombreUsuario, String cedula, String ciudad, String marca,
            String modelo, String numero) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        PlanPostPagoMinutosMegasEconomico p;

        System.out.println("A Continuacion Se van a asignar los datos para crear"
                + " un nuevo Plan Post Pago Minutos Megas(Economico)");
        System.out.println("---------------------------------------------");

        System.out.println("Ingrese la cantidad de minutos consumidos");
        int minutos = sc.nextInt();
        System.out.println("Ingrese el valor del costo de los minutos");
        double costoMinutos = sc.nextDouble();
        System.out.println("Ingrese la cantidad de Megas");
        int cantidadMegas = sc.nextInt();
        System.out.println("Ingrese el precio del Giga");
        double precioGiga = sc.nextDouble();
        System.out.println("Ingrese el valor del descunto");
        double descuento = sc.nextDouble();

        p = new PlanPostPagoMinutosMegasEconomico(minutos, costoMinutos,
                cantidadMegas, precioGiga, descuento, nombreUsuario, cedula,
                ciudad, marca, modelo, numero);

        return p;
    }

}
