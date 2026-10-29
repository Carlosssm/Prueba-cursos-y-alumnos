/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;

/**
 *
 * @author Carlosssm
 */

import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.GestorAlumnos;
import vista.VentanaCurso;

public class alumnosControlador {

    private GestorAlumnos gestor;
    private VentanaCurso vista;
    private String curso;

    public alumnosControlador(GestorAlumnos gestor, VentanaCurso vista, String curso) {
        this.gestor = gestor;
        this.vista = vista;
        this.curso = curso;

        cargarAlumnosEnVista();
        configurarEventos();
    }

    public void cargarAlumnosEnVista() {
        vista.getModeloAlumnos().clear();
        for (Alumno a : gestor.listarAlumnos(curso)) {
            vista.getModeloAlumnos().addElement(a);
        }
    }

    private void configurarEventos() {

   
        vista.getBtnAgregar().addActionListener(e -> {

            String nombre = vista.getTxtNombre().getText().trim();
            String apellido = vista.getTxtApellido().getText().trim();
            String edadStr = vista.getTxtEdad().getText().trim();
            String dni = vista.getTxtDni().getText().trim();

        
            if (nombre.isEmpty() || apellido.isEmpty() || edadStr.isEmpty() || dni.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Los campos son obligatorios");
                return;
            }

  
            int edad;
            try {
                edad = Integer.parseInt(edadStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "La edad debe ser un número");
                return;
            }

     
            for (Alumno a : gestor.listarAlumnos(curso)) {
                if (a.getDni().equalsIgnoreCase(dni)) {
                    JOptionPane.showMessageDialog(null, "Ya existe un alumno con este DNI");
                    return;
                }
            }

            Alumno nuevo = new Alumno(nombre, apellido, edad, dni);

            if (gestor.agregarAlumno(curso, nuevo)) {
                cargarAlumnosEnVista();
                vista.getTxtNombre().setText("");
                vista.getTxtApellido().setText("");
                vista.getTxtEdad().setText("");
                vista.getTxtDni().setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el alumno");
            }
        });

        vista.getBtnEliminar().addActionListener(e -> {

            Object seleccionado = vista.getListaAlumnos().getSelectedValue();

            if (seleccionado == null) {
                JOptionPane.showMessageDialog(null, "Selecciona un alumno");
                return;
            }

            Alumno a = (Alumno) seleccionado;

            if (gestor.eliminarAlumno(curso, a.getDni())) {
                cargarAlumnosEnVista();
            } else {
                JOptionPane.showMessageDialog(null, "No se puede eliminar el alumno");
            }
        });
    }
}
