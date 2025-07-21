/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tunombre.proyecto.servicio;


import com.tunombre.proyecto.modelo.Tarea;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona la lista de tareas.
 */
public class TareaServicio {
    private List<Tarea> listaTareas = new ArrayList<>();

    /**
     * Agrega una nueva tarea a la lista.
     * @param nombre Nombre de la tarea.
     */
    public void agregarTarea(String nombre) {
        listaTareas.add(new Tarea(nombre));
    }

    /**
     * Obtiene la lista completa de tareas.
     * @return Lista de tareas.
     */
    public List<Tarea> obtenerTareas() {
        return listaTareas;
    }
}
