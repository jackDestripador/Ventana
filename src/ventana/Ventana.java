import javax.swing.*;
import java.awt.event.*;

public class Ventana extends JFrame {

    private JPanel panel;
    private JLabel lblTitulo;
    private JTextField txtBase, txtExponente, txtResultado;
    private JButton btnCalcular, btnLimpiar, btnSalir;

    public Ventana() {
        this.setTitle("Potencia");
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        iniciarComponentes();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);

        lblTitulo = new JLabel();
        lblTitulo.setText("BASE:");
        lblTitulo.setBounds(98, 30, 300, 40);
        lblTitulo.setOpaque(true);
        panel.add(lblTitulo);

        txtBase = new JTextField();
        txtBase.setText("");
        txtBase.setBounds(180, 40, 260, 20);
        panel.add(txtBase);

        JLabel exponente = new JLabel();
        exponente.setText("EXPONENTE:");
        exponente.setBounds(60, 80, 300, 40);
        exponente.setOpaque(true);
        panel.add(exponente);

        txtExponente = new JTextField();
        txtExponente.setText("");
        txtExponente.setBounds(180, 90, 260, 20);
        panel.add(txtExponente);

        JLabel resultado = new JLabel();
        resultado.setText("RESULTADO:");
        resultado.setBounds(60, 130, 300, 40);
        resultado.setOpaque(true);
        panel.add(resultado);

        txtResultado = new JTextField();
        txtResultado.setText("");
        txtResultado.setBounds(179, 140, 260, 20);
        txtResultado.setEditable(false);
        panel.add(txtResultado);

        btnCalcular = new JButton();
        btnCalcular.setText("CALCULAR");
        btnCalcular.setBounds(200, 200, 100, 25);
        panel.add(btnCalcular);
        btnCalcular.addActionListener((ActionEvent evt) -> {
            accionCalcular();
        });

        btnSalir = new JButton();
        btnSalir.setText("SALIR");
        btnSalir.setBounds(340, 200, 100, 25);
        panel.add(btnSalir);
        btnSalir.addActionListener((ActionEvent evt) -> {
            System.exit(0);
        });

        btnLimpiar = new JButton();
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.setBounds(60, 200, 100, 25);
        panel.add(btnLimpiar);
        btnLimpiar.addActionListener((ActionEvent evt) -> {
            accionLimpiar();
        });

    }

    private void accionCalcular() {
        try {
            double base = Double.parseDouble(txtBase.getText());
            double exponente = Double.parseDouble(txtExponente.getText());
            double resultado = Math.pow(base, exponente);
            txtResultado.setText(Double.toString(resultado));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese números válidos en las cajas de texto.");
        }
    }

    private void accionLimpiar() {
        txtBase.setText("");
        txtExponente.setText("");
        txtResultado.setText("");
    }

}