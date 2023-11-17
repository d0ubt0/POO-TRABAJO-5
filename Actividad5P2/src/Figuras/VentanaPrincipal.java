package Figuras;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JButton cilindro, esfera, piramide;

    public VentanaPrincipal() {
        inicio();
        setTitle("Figuras");
        setSize(350, 80);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        contenedor.setBackground(Color.black);

        cilindro = new JButton();
        cilindro.setText("Cilindro");
        cilindro.setBounds(20, 10, 80, 20);
        cilindro.setForeground(Color.black);
        cilindro.setBackground(Color.white);
        cilindro.addActionListener(this);

        esfera = new JButton();
        esfera.setText("Esfera");
        esfera.setBounds(125, 10, 80, 20);
        esfera.setForeground(Color.black);
        esfera.setBackground(Color.white);
        esfera.addActionListener(this);

        piramide = new JButton();
        piramide.setText("Piramide");
        piramide.setBounds(225, 10, 100, 20);
        piramide.setForeground(Color.black);
        piramide.setBackground(Color.white);
        piramide.addActionListener(this);

        contenedor.add(cilindro);
        contenedor.add(esfera);
        contenedor.add(piramide);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == esfera) {
            VentanaEsfera esfera = new VentanaEsfera();
            esfera.setVisible(true);
        }
        if (event.getSource() == cilindro) {
            VentanaCilindro cilindro = new VentanaCilindro();
            cilindro.setVisible(true);
        }
        if (event.getSource() == piramide) {
            VentanaPiramide piramide = new VentanaPiramide();
            piramide.setVisible(true);
        }
    }
}
