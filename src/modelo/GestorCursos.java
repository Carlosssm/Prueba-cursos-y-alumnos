/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author Carlosssm
 */

import java.io.File;
import java.util.ArrayList;

public class GestorCursos {

    private final File carpetaDatos;

    public GestorCursos() {
        carpetaDatos = new File("datos");
        if (!carpetaDatos.exists()) {
            carpetaDatos.mkdir();
        }
    }

    public ArrayList<String> listarCursos() {
        ArrayList<String> lista = new ArrayList<>();
        File[] carpetas = carpetaDatos.listFiles();

        if (carpetas != null) {
            for (File f : carpetas) {
                if (f.isDirectory()) {
                    lista.add(f.getName());
                }
            }
        }
        return lista;
    }

    public boolean crearCurso(String nombre) {
        File carpetaCurso = new File(carpetaDatos, nombre);

        if (carpetaCurso.exists()) {
            return false;
        }

        carpetaCurso.mkdir();

        try {
            File archivo = new File(carpetaCurso, "alumnos.txt");
            archivo.createNewFile();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean eliminarCurso(String nombre) {
        File carpetaCurso = new File(carpetaDatos, nombre);

        if (!carpetaCurso.exists()) return false;

        File archivo = new File(carpetaCurso, "alumnos.txt");
        archivo.delete();

        return carpetaCurso.delete();
    }

    public int contarAlumnos(String curso) {
        File archivo = new File("datos/" + curso + "/alumnos.txt");

        if (!archivo.exists()) return 0;

        try (java.util.Scanner sc = new java.util.Scanner(archivo)) {
            int count = 0;
            while (sc.hasNextLine()) {
                if (!sc.nextLine().trim().isEmpty()) count++;
            }
            return count;
        } catch (Exception e) {
            return 0;
        }
    }
}
