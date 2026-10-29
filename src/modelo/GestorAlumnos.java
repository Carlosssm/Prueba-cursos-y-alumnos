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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorAlumnos {

    public ArrayList<Alumno> listarAlumnos(String curso) {
        ArrayList<Alumno> lista = new ArrayList<>();
        File archivo = new File("datos/" + curso + "/alumnos.txt");

        if (!archivo.exists()) {
            return lista;
        }

        try (Scanner sc = new Scanner(archivo)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine().trim();
                if (!linea.isEmpty()) {
                    Alumno a = Alumno.fromLine(linea);
                    if (a != null) {
                        lista.add(a);
                    }
                }
            }
        } catch (Exception e) {
         
        }

        return lista;
    }

    public boolean agregarAlumno(String curso, Alumno a) {
        File archivo = new File("datos/" + curso + "/alumnos.txt");

        try {
      
            
            ArrayList<String> lineas = new ArrayList<>();
            if (archivo.exists()) {
                try (Scanner sc = new Scanner(archivo)) {
                    while (sc.hasNextLine()) {
                        lineas.add(sc.nextLine());
                    }
                }
            }

         
            lineas.add(a.toFile());

            try (PrintWriter pw = new PrintWriter(archivo)) {
                for (String l : lineas) {
                    pw.println(l);
                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminarAlumno(String curso, String dni) {
        File archivo = new File("datos/" + curso + "/alumnos.txt");

        if (!archivo.exists()) return false;

        try {
            ArrayList<String> lineas = new ArrayList<>();
            try (Scanner sc = new Scanner(archivo)) {
                while (sc.hasNextLine()) {
                    
                    String linea = sc.nextLine();
                    Alumno a = Alumno.fromLine(linea);
                    if (a != null && !a.getDni().equalsIgnoreCase(dni)) {
                        lineas.add(linea);
                    }
                }
            }

            try (PrintWriter pw = new PrintWriter(archivo)) {
                for (String l : lineas) {
                    pw.println(l);
                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
