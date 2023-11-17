package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPiramide extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel base, altura, apotema, volumen, superficie;
    private JTextField campoBase, campoAltura, campoApotema;
    private JButton calcular;

    public VentanaPiramide() {
        inicio();
        setTitle("Piramide");
        setSize(280, 240);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        contenedor.setBackground(Color.black);

        base = new JLabel();
        base.setText("Base (cms):");
        base.setForeground(Color.white);
        base.setBounds(20, 20, 135, 23);
        campoBase = new JTextField();
        campoBase.setBounds(120, 20, 135, 23);

        altura = new JLabel();
        altura.setText("Altura (cms):");
        altura.setForeground(Color.white);
        altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(120, 50, 135, 23);

        apotema = new JLabel();
        apotema.setText("Apotema (cms):");
        apotema.setForeground(Color.white);
        apotema.setBounds(20, 80, 135, 23);
        campoApotema = new JTextField();
        campoApotema.setBounds(120, 80, 135, 23);

        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(120, 110, 135, 23);
        calcular.setForeground(Color.black);
        calcular.setBackground(Color.white);
        calcular.addActionListener(this);

        volumen = new JLabel();
        volumen.setText("Volumen (cm3):");
        volumen.setForeground(Color.white);
        volumen.setBounds(20, 140, 135, 23);

        superficie = new JLabel();
        superficie.setText("Superficie (cm2):");
        superficie.setForeground(Color.white);
        superficie.setBounds(20, 170, 135, 23);

        contenedor.add(base);
        contenedor.add(campoBase);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(apotema);
        contenedor.add(campoApotema);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    public void actionPerformed(ActionEvent event) {
        Piramide piramide;
        boolean error = false;
        double base = 0;
        double altura = 0;
        double apotema = 0;
        try {
            base = Double.parseDouble(campoBase.getText());
            altura = Double.parseDouble(campoAltura.getText());
            apotema = Double.parseDouble(campoApotema.getText());
            piramide = new Piramide(base, altura, apotema);
            volumen.setText("Volumen (cm3): " + String.format("%.2f", piramide.calcularVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", piramide.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        } finally {
            if (error) {
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}