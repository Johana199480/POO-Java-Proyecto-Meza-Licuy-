/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapturaTeclaC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class CapturaTeclaC extends JFrame {

    public CapturaTeclaC() {
        setTitle("Mi Lista Interactiva"); // Título personalizado
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Lista personalizada
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Actividad 1");
        listModel.addElement("Actividad 2");
        listModel.addElement("Actividad 3");
        JList<String> lista = new JList<>(listModel);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Asegurar que la lista pueda recibir foco
        lista.setFocusable(true);
        lista.requestFocusInWindow();

        // Botón
        JButton boton = new JButton("Aceptar");

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(lista), BorderLayout.CENTER);
        panel.add(boton, BorderLayout.SOUTH);
        add(panel);

        // Key Binding para la tecla 'C' (mayúscula o minúscula)
        lista.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
             .put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "accionC");
        lista.getActionMap().put("accionC", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marcarElemento(lista, listModel);
            }
        });

        // El botón Aceptar también hace lo mismo
        boton.addActionListener(e -> marcarElemento(lista, listModel));
    }

    // Método para marcar elemento seleccionado
    private void marcarElemento(JList<String> lista, DefaultListModel<String> listModel) {
        int index = lista.getSelectedIndex();
        if (index != -1) {
            String elemento = listModel.get(index);
            System.out.println("¡Has marcado el elemento: " + elemento + " por Heidy!");
            listModel.set(index, elemento + " (Heidy)");
        } else {
            System.out.println("No hay ningún elemento seleccionado.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CapturaTeclaC ventana = new CapturaTeclaC();
            ventana.setVisible(true);
        });
    }
}