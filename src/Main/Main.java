/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author Carlosssm
 */

import controlador.alumnosControlador;
import controlador.cursosControlador;
import modelo.GestorAlumnos;
import modelo.GestorCursos;
import vista.VentanaCurso;
import vista.VentanaPrincipal;

public class Main {

    public static void main(String[] args) {

        
        VentanaPrincipal vista = new VentanaPrincipal();
        vista.setVisible(true);

        GestorCursos gestor = new GestorCursos();
        cursosControlador controlador = new cursosControlador(gestor, vista);

        vista.getBtnCrear().addActionListener(e -> {
            String nombre = javax.swing.JOptionPane.showInputDialog("Nombre del curso:");
            if (nombre != null && !nombre.trim().isEmpty()) {
                if (!controlador.crearCurso(nombre.trim())) {
                    javax.swing.JOptionPane.showMessageDialog(null, "El curso ya existe");
                }
            }
        });

        vista.getBtnEliminar().addActionListener(e -> {
            String curso = vista.getListaCursos().getSelectedValue();
            if (curso == null) {
                
                javax.swing.JOptionPane.showMessageDialog(null, "Selecciona un curso");
                return;
            }
            controlador.eliminarCurso(curso);
        });

        vista.getBtnAbrir().addActionListener(e -> {
            String curso = vista.getListaCursos().getSelectedValue();
            if (curso == null) {
                javax.swing.JOptionPane.showMessageDialog(null, "Selecciona un curso");
                return;
            }

  
            VentanaCurso ventana = new VentanaCurso(curso);

    
            alumnosControlador ctrl = new alumnosControlador(
                    new GestorAlumnos(),
                    ventana,
                    curso
            );

  
            ventana.setVisible(true);
        });

        vista.getListaCursos().addListSelectionListener(e -> {
            String curso = vista.getListaCursos().getSelectedValue();
            if (curso != null) {
                vista.getLblNumAlumnos().setText(
                        "Número alumnos: " + controlador.contarAlumnos(curso)
                );
            }
        });
        
        // a
    }
}
