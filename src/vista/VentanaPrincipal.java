package vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private JList<String> listaCursos;
    private DefaultListModel<String> modeloCursos;

    private JButton btnCrear;
    private JButton btnEliminar;
    private JButton btnAbrir;

    private JLabel lblNumAlumnos;

    public VentanaPrincipal() {
        setTitle("Gestor Cursos");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        modeloCursos = new DefaultListModel<>();
        listaCursos = new JList<>(modeloCursos);

        btnCrear = new JButton("Crear curso");
        btnEliminar = new JButton("Eliminar curso");
        btnAbrir = new JButton("Abrir curso");

        lblNumAlumnos = new JLabel("Número alumnos: 0");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnCrear);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnAbrir);

        setLayout(new BorderLayout());
        add(lblNumAlumnos, BorderLayout.NORTH);
        add(new JScrollPane(listaCursos), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    public DefaultListModel<String> getModeloCursos() {
        return modeloCursos;
    }

    public JList<String> getListaCursos() {
        return listaCursos;
    }

    public JButton getBtnCrear() {
        return btnCrear;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnAbrir() {
        return btnAbrir;
    }

    public JLabel getLblNumAlumnos() {
        return lblNumAlumnos;
    }
}
