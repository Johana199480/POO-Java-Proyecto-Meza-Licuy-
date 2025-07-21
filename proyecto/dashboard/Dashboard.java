/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tunombre.proyecto.dashboard;

import com.tunombre.proyecto.servicio.TareaServicio;
import com.tunombre.proyecto.vista.TareaVista;
import java.util.Scanner;

/**
 * Clase principal que controla el menú y gestión de tareas.
 */
public class Dashboard {

    private final TareaServicio servicio;
    private final TareaVista vista;

    public Dashboard() {
        servicio = new TareaServicio();
        vista = new TareaVista();
    }

    /**
     * Método para iniciar el menú principal.
     */
    public void iniciar() {
    vista.mostrarBienvenida();
    Scanner scanner = new Scanner(System.in);
    int opcion;

    do {
        mostrarMenu();
        System.out.print("Ingrese una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        switch (opcion) {
            case 1 -> {
                System.out.print("Ingrese el nombre de la tarea: ");
                String nombre = scanner.nextLine();
                servicio.agregarTarea(nombre);
                System.out.println("Tarea registrada exitosamente.");
            }
            case 2 -> vista.mostrarTareas(servicio.obtenerTareas());
            case 0 -> System.out.println("Saliendo del sistema. ¡Hasta luego!");
            default -> System.out.println("Opción inválida. Intente de nuevo.");
        }
    } while (opcion != 0);

    scanner.close();
}

private void mostrarMenu() {
    System.out.println("\n===== MENU =====");
    System.out.println("1. Registrar tarea");
    System.out.println("2. Mostrar tareas");
    System.out.println("0. Salir");
}
public static void main(String[] args) {
        new Dashboard().iniciar();
    }
}