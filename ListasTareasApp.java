/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HeidyMeza_ListasTareas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.Map;

public class ListasTareasApp extends JFrame {

    private DefaultListModel<String> modeloTareas;
    private JList<String> listaTareas;
    private JTextField campoTarea;
    private JButton btnAñadir, btnCompletar, btnEliminar;

    public ListasTareasApp() {
        setTitle("¡Mi Lista de Tareas, by Heidy!");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Colores pastel
        Color rosaPastel = new Color(255, 204, 229);
        Color celestePastel = new Color(204, 229, 255);
        Color verdePastel = new Color(204, 255, 204);

        getContentPane().setBackground(rosaPastel);

        // Modelo y lista de tareas
        modeloTareas = new DefaultListModel<>();
        listaTareas = new JList<>(modeloTareas);
        listaTareas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaTareas.setCellRenderer(new TareaRenderer());
        listaTareas.setBackground(celestePastel);
        listaTareas.setFont(new Font("Arial", Font.PLAIN, 14));

        // Doble clic para señalar como completada
        listaTareas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = listaTareas.locationToIndex(e.getPoint());
                    if (index != -1) {
                        String tarea = modeloTareas.getElementAt(index);
                        if (!tarea.startsWith("✔ ")) {
                            modeloTareas.set(index, "✔ " + tarea);
                        }
                    }
                }
            }
        });

        // Campo de texto
        campoTarea = new JTextField();
        campoTarea.addActionListener(e -> añadirTarea());

        // Botones con colores y texto personalizado
        btnAñadir = new JButton("Añadir ✅");
        btnCompletar = new JButton("Completar ✔");
        btnEliminar = new JButton("Eliminar ❌");

        btnAñadir.setBackground(verdePastel);
        btnCompletar.setBackground(verdePastel);
        btnEliminar.setBackground(verdePastel);

        // Eventos de botones
        btnAñadir.addActionListener(e -> añadirTarea());
        btnCompletar.addActionListener(e -> marcarComoCompletada());
        btnEliminar.addActionListener(e -> eliminarTarea());

        // Panel superior (campo + botón Añadir)
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(rosaPastel);
        panelSuperior.add(campoTarea, BorderLayout.CENTER);
        panelSuperior.add(btnAñadir, BorderLayout.EAST);

        // Panel inferior (botones Completar y Eliminar)
        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(rosaPastel);
        panelInferior.add(btnCompletar);
        panelInferior.add(btnEliminar);

        // Agregar todo a la ventana
        add(panelSuperior, BorderLayout.NORTH);
        add(new JScrollPane(listaTareas), BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Añadir tarea
    private void añadirTarea() {
        String tarea = campoTarea.getText().trim();
        if (!tarea.isEmpty()) {
            modeloTareas.addElement(tarea);
            campoTarea.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Introduzca una tarea correcta");
        }
    }

    // Marcar tarea como completada
    private void marcarComoCompletada() {
        int index = listaTareas.getSelectedIndex();
        if (index != -1) {
            String tarea = modeloTareas.getElementAt(index);
            if (!tarea.startsWith("✔ ")) {
                modeloTareas.set(index, "✔ " + tarea);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Elija una tarea primero");
        }
    }

    // Eliminar tarea
    private void eliminarTarea() {
        int index = listaTareas.getSelectedIndex();
        if (index != -1) {
            modeloTareas.remove(index);
        } else {
            JOptionPane.showMessageDialog(this, "Elija una tarea primero");
        }
    }

    // Renderer para mostrar tachado en tareas completadas
    private class TareaRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            String tarea = (String) value;
            if (tarea.startsWith("✔ ")) {
                label.setForeground(Color.GRAY);
                Map<TextAttribute, Object> atributos = (Map<TextAttribute, Object>) label.getFont().getAttributes();
                atributos.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                label.setFont(label.getFont().deriveFont(atributos).deriveFont(Font.ITALIC));
            } else {
                label.setForeground(Color.BLACK);
                label.setFont(label.getFont().deriveFont(Font.PLAIN));
            }
            return label;
        }
    }

    // Método principal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ListasTareasApp());
    }
}