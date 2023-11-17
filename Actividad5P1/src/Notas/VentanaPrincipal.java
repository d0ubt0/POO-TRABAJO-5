package Notas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel nota1, nota2, nota3, nota4, nota5, promedio, desviacion, mayor, menor;
    private JTextField campoNota1, campoNota2, campoNota3, campoNota4, campoNota5;
    private JButton calcular, limpiar;

    public VentanaPrincipal() {
        inicio();
        setTitle("Notas");
        setSize(250, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        contenedor.setBackground(Color.black);
        nota1 = new JLabel();
        nota1.setText("Nota 1:");
        nota1.setBounds(20, 20, 135, 23);
        nota1.setForeground(Color.white);
        campoNota1 = new JTextField();
        campoNota1.setBounds(90, 20, 130, 23);

        nota2 = new JLabel();
        nota2.setText("Nota 2:");
        nota2.setBounds(20, 50, 135, 23);
        nota2.setForeground(Color.white);
        campoNota2 = new JTextField();
        campoNota2.setBounds(90, 50, 130, 23);

        nota3 = new JLabel();
        nota3.setText("Nota 3:");
        nota3.setBounds(20, 80, 135, 23);
        nota3.setForeground(Color.white);
        campoNota3 = new JTextField();
        campoNota3.setBounds(90, 80, 130, 23);
        

        nota4 = new JLabel();
        nota4.setText("Nota 4:");
        nota4.setBounds(20, 110, 135, 23);
        nota4.setForeground(Color.white);
        campoNota4 = new JTextField();
        campoNota4.setBounds(90, 110, 130, 23);

        nota5 = new JLabel();
        nota5.setText("Nota 5:");
        nota5.setBounds(20, 140, 135, 23);
        nota5.setForeground(Color.white);
        campoNota5 = new JTextField();
        campoNota5.setBounds(90, 140, 130, 23);

        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(20, 170, 100, 23);
        calcular.setBackground(Color.white);
        calcular.setForeground(Color.black);
        calcular.addActionListener(this);

        limpiar = new JButton();
        limpiar.setText("Limpiar");
        limpiar.setBounds(125, 170, 80, 23);
        limpiar.setBackground(Color.white);
        limpiar.setForeground(Color.black);
        limpiar.addActionListener(this);

        promedio = new JLabel();
        promedio.setText("Promedio = ");
        promedio.setBounds(20, 210, 135, 23);
        promedio.setForeground(Color.white);

        desviacion = new JLabel();
        desviacion.setText("Desviacion = ");
        desviacion.setBounds(20, 240, 200, 23);
        desviacion.setForeground(Color.white);
        

        mayor = new JLabel();
        mayor.setText("Nota mayor = ");
        mayor.setBounds(20, 270, 120, 23);
        mayor.setForeground(Color.white);

        menor = new JLabel();
        menor.setText("Nota menor = ");
        menor.setBounds(20, 300, 120, 23);
        menor.setForeground(Color.white);

        contenedor.add(nota1);
        contenedor.add(campoNota1);
        contenedor.add(nota2);
        contenedor.add(campoNota2);
        contenedor.add(nota3);
        contenedor.add(campoNota3);
        contenedor.add(nota4);
        contenedor.add(campoNota4);
        contenedor.add(nota5);
        contenedor.add(campoNota5);
        contenedor.add(calcular);
        contenedor.add(limpiar);
        contenedor.add(promedio);
        contenedor.add(desviacion);
        contenedor.add(mayor);
        contenedor.add(menor);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            Notas notas = new Notas();
            notas.listaNotas[0] = Double.parseDouble(campoNota1.getText());
            notas.listaNotas[1] = Double.parseDouble(campoNota2.getText());
            notas.listaNotas[2] = Double.parseDouble(campoNota3.getText());
            notas.listaNotas[3] = Double.parseDouble(campoNota4.getText());
            notas.listaNotas[4] = Double.parseDouble(campoNota5.getText());
            notas.calcularPromedio();
            notas.calcularDesviación();
            promedio.setText("Promedio = " + String.format("%.2f", notas.calcularPromedio()));
            double desv = notas.calcularDesviación();
            desviacion.setText("Desviación estándar = " + String.format("%.2f", desv));
            mayor.setText("Valor mayor = " + String.valueOf(notas.calcularMayor()));
            menor.setText("Valor menor = " + String.valueOf(notas.calcularMenor()));
        }

        if (evento.getSource() == limpiar) {
            campoNota1.setText("");
            campoNota2.setText("");
            campoNota3.setText("");
            campoNota4.setText("");
            campoNota5.setText("");
        }
    }
}
