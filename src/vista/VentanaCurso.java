package vista;

import javax.swing.*;
import java.awt.*;

public class VentanaCurso extends JFrame {

    private String curso;

    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEdad;
    private JTextField txtDni;

    private JButton btnAgregar;
    private JButton btnEliminar;

    private JList<Object> listaAlumnos;
    private DefaultListModel<Object> modeloAlumnos;

    public VentanaCurso(String curso) {
        this.curso = curso;

        setTitle("Gestión alumnos - " + curso);
        setSize(450, 450);
        setLocationRelativeTo(null);

        modeloAlumnos = new DefaultListModel<>();
        listaAlumnos = new JList<>(modeloAlumnos);

        txtNombre = new JTextField(10);
        txtApellido = new JTextField(10);
        txtEdad = new JTextField(5);
        txtDni = new JTextField(10);

        btnAgregar = new JButton("Añadir");
        btnEliminar = new JButton("Eliminar");

        JPanel panelForm = new JPanel();
        panelForm.add(new JLabel("Nombre"));
        panelForm.add(txtNombre);
        panelForm.add(new JLabel("Apellido"));
        panelForm.add(txtApellido);
        panelForm.add(new JLabel("Edad"));
        panelForm.add(txtEdad);
        panelForm.add(new JLabel("DNI"));
        panelForm.add(txtDni);

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);

        setLayout(new BorderLayout());
        add(panelForm, BorderLayout.NORTH);
        add(new JScrollPane(listaAlumnos), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    public DefaultListModel<Object> getModeloAlumnos() {
        return modeloAlumnos;
    }

    public JList<Object> getListaAlumnos() {
        return listaAlumnos;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtApellido() {
        return txtApellido;
    }

    public JTextField getTxtEdad() {
        return txtEdad;
    }

    public JTextField getTxtDni() {
        return txtDni;
    }

    public String getCurso() {
        return curso;
    }
}
