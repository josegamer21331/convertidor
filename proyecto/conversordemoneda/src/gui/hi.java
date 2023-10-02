package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.border.EmptyBorder;

public class hi extends JFrame {
    private JPanel contentPane;
    private JTextField cantidadTextField;
    private JComboBox<String> monedaDestinoComboBox;
    private JLabel resultadoLabel;

    // Tasas de conversión (tasas reales deben ser actualizadas).
    private static final double COP_TO_USD = 0.00026; // 1 COP = 0.00026 USD
    private static final double COP_TO_EUR = 0.00022; // 1 COP = 0.00022 EUR
    private static final double COP_TO_GBP = 0.00019; // 1 COP = 0.00019 GBP
    private static final double COP_TO_JPY = 0.028;   // 1 COP = 0.028 JPY
    private static final double COP_TO_KRW = 0.31;    // 1 COP = 0.31 KRW

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    hi frame = new hi();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public hi() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        setTitle("Convertidor de Moneda");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 2, 10, 10)); // Diseño de la cuadrícula

        JLabel lblCantidad = new JLabel("Cantidad en Pesos Colombianos:");
        contentPane.add(lblCantidad);

        cantidadTextField = new JTextField();
        contentPane.add(cantidadTextField);

        JLabel lblMonedaDestino = new JLabel("Moneda de Destino:");
        contentPane.add(lblMonedaDestino);

        monedaDestinoComboBox = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "JPY", "KRW"});
        contentPane.add(monedaDestinoComboBox);

        JButton btnConvertir = new JButton("Convertir");
        contentPane.add(btnConvertir);
        btnConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertirMoneda();
            }
        });

        resultadoLabel = new JLabel("Resultado: ");
        contentPane.add(resultadoLabel);
    }

    private void convertirMoneda() {
        try {
            double cantidad = Double.parseDouble(cantidadTextField.getText());
            String monedaDestino = (String) monedaDestinoComboBox.getSelectedItem();

            double resultado = convertir(cantidad, monedaDestino);
            DecimalFormat df = new DecimalFormat("#.##"); // Formatea el resultado a dos decimales.
            resultadoLabel.setText("Resultado: " + df.format(resultado) + " " + monedaDestino);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double convertir(double cantidad, String monedaDestino) {
        // Implementa la lógica real de conversión aquí con las tasas de conversión reales.
        double tasa = 0.0;

        if (monedaDestino.equals("USD")) {
            tasa = COP_TO_USD;
        } else if (monedaDestino.equals("EUR")) {
            tasa = COP_TO_EUR;
        } else if (monedaDestino.equals("GBP")) {
            tasa = COP_TO_GBP;
        } else if (monedaDestino.equals("JPY")) {
            tasa = COP_TO_JPY;
        } else if (monedaDestino.equals("KRW")) {
            tasa = COP_TO_KRW;
        }

        // Si no se encuentra una tasa de conversión válida, devuelve 0.
        return cantidad * tasa;
    }
}