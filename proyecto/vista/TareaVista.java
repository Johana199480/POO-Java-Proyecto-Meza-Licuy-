/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tunombre.proyecto.vista;

import com.tunombre.proyecto.modelo.Tarea;
import java.util.List;

/**
 * Clase que muestra información al usuario.
 */
public class TareaVista {

    /**
     * Muestra un mensaje de bienvenida.
     */
    public void mostrarBienvenida() {
        System.out.println("Bienvenido a tu Gestor de Tareas!");
    }

    /**
     * Muestra la lista de tareas.
     * @param tareas Lista de tareas a mostrar.
     */
    public void mostrarTareas(List<Tarea> tareas) {
        if (tareas.isEmpty()) {
            System.out.println("No tienes tareas registradas.");
        } else {
            System.out.println("Lista de Tareas:");
            for (Tarea tarea : tareas) {
                System.out.println("- " + tarea);
            }
        }
    }
}