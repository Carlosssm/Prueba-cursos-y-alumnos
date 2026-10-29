/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author Carlosssm
 */


public class Alumno {

    private String nombre;
    private String apellido;
    private int edad;
    private String dni;

    public Alumno(String nombre, String apellido, int edad, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
    }

    public Alumno() {}

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getEdad() { return edad; }
    public String getDni() { return dni; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setDni(String dni) { this.dni = dni; }

  
    public String toFile() {
        return nombre + ";" + apellido + ";" + edad + ";" + dni;
    }

    public static Alumno fromLine(String linea) {
        String[] p = linea.split(";");
        if (p.length != 4) return null;
        return new Alumno(p[0], p[1], Integer.parseInt(p[2]), p[3]);
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " " + edad + " " + dni ;
    }
}
