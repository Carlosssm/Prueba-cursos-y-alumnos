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
import modelo.GestorCursos;
import vista.VentanaPrincipal;

public class cursosControlador {

    private GestorCursos gestor;
    private VentanaPrincipal vista;

    public cursosControlador(GestorCursos gestor, VentanaPrincipal vista) {
        this.gestor = gestor;
        this.vista = vista;
        cargarCursosEnVista();
    }

    public void cargarCursosEnVista() {
        vista.getModeloCursos().clear();
        for (String c : gestor.listarCursos()) {
            vista.getModeloCursos().addElement(c);
        }
    }


    public boolean crearCurso(String nombre) {

        if (nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tiene que haber un nombre del curso");
            return false;
        }

        if (gestor.listarCursos().contains(nombre)) {
            JOptionPane.showMessageDialog(null, "El curso ya existe");
            return false;
        }

        boolean ok = gestor.crearCurso(nombre);

        if (!ok) {
            JOptionPane.showMessageDialog(null, "No se ha podido crear el curso");
        }

        cargarCursosEnVista();
        return ok;
    }

    public boolean eliminarCurso(String nombre) {
        boolean ok = gestor.eliminarCurso(nombre);
        if (!ok) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar el curso");
        }
        cargarCursosEnVista();
        return ok;
    }

    public int contarAlumnos(String curso) {
        return gestor.contarAlumnos(curso);
    }
}
