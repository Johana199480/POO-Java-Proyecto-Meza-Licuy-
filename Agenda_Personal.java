/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgendaPersonal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Agenda_Personal extends JFrame {

    // Componentes del GUI
    private JSpinner fechaSpinner, horaSpinner;
    private JTextField descripcionCampo;
    private JTable tablaEventos;
    private DefaultTableModel modeloTabla;
    private JButton agregarBtn, eliminarBtn, salirBtn;

    public Agenda_Personal() {
        setTitle("Agenda Personal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // --- Panel de la tabla (mostrando eventos existentes) ---
        modeloTabla = new DefaultTableModel(new Object[]{"Fecha", "Hora", "Descripción"}, 0);
        tablaEventos = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaEventos);
        add(scrollPane, BorderLayout.CENTER);

        // --- Panel de entrada de nuevos eventos ---
        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new GridLayout(3, 2, 10, 10));
        panelEntrada.setBorder(BorderFactory.createTitledBorder("Nuevo Acontecimiento"));
        panelEntrada.setBackground(Color.YELLOW); // color amarillo de fondo

        // Etiquetas y campos
        panelEntrada.add(new JLabel("Fecha (dd/MM/yyyy):"));
        fechaSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editorFecha = new JSpinner.DateEditor(fechaSpinner, "dd/MM/yyyy");
        fechaSpinner.setEditor(editorFecha);
        panelEntrada.add(fechaSpinner);

        panelEntrada.add(new JLabel("Hora (HH:mm):"));
        horaSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editorHora = new JSpinner.DateEditor(horaSpinner, "HH:mm");
        horaSpinner.setEditor(editorHora);
        panelEntrada.add(horaSpinner);

        panelEntrada.add(new JLabel("Descripción:"));
        descripcionCampo = new JTextField();
        panelEntrada.add(descripcionCampo);

        add(panelEntrada, BorderLayout.NORTH);

        // --- Panel de botones ---
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(Color.BLACK); // fondo negro
        agregarBtn = new JButton("Agregar");
        agregarBtn.setBackground(Color.GREEN); // verde
        eliminarBtn = new JButton("Eliminar");
        eliminarBtn.setBackground(Color.YELLOW); // amarillo
        salirBtn = new JButton("Salir");
        salirBtn.setBackground(Color.RED); // opcional, puedes cambiarlo

        panelBotones.add(agregarBtn);
        panelBotones.add(eliminarBtn);
        panelBotones.add(salirBtn);

        add(panelBotones, BorderLayout.SOUTH);

        // --- Acciones de los botones ---
        agregarBtn.addActionListener(e -> agregarEvento());
        eliminarBtn.addActionListener(e -> eliminarEvento());
        salirBtn.addActionListener(e -> dispose());
    }

    // --- Método para agregar un evento ---
    private void agregarEvento() {
        String descripcion = descripcionCampo.getText().trim();
        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Se requiere escribir una descripción previamente de agregar",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            descripcionCampo.requestFocus();
            return;
        }

        // Formateo de fecha y hora
        Date fecha = (Date) fechaSpinner.getValue();
        Date hora = (Date) horaSpinner.getValue();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

        String strFecha = formatoFecha.format(fecha);
        String strHora = formatoHora.format(hora);

        // Agregar fila a la tabla
        modeloTabla.addRow(new Object[]{strFecha, strHora, descripcion});

        // Limpiar campo de descripción
        descripcionCampo.setText("");
        descripcionCampo.requestFocus();
    }

    // --- Método para eliminar un evento seleccionado ---
    private void eliminarEvento() {
        int filaSeleccionada = tablaEventos.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                    "Selecciona un evento primero",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Eliminar el evento seleccionado?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            modeloTabla.removeRow(filaSeleccionada);
        }
    }

    // --- Método main para ejecutar la aplicación ---
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Agenda_Personal().setVisible(true));
    }
}

