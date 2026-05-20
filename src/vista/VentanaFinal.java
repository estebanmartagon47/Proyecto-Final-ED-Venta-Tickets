package vista;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana final que se muestra tras completar la compra.
 */
public class VentanaFinal extends JFrame {

    private static final long serialVersionUID = 1L;

    private JButton botonAceptar;

    /**
     * Constructor de la ventana final.
     */
    public VentanaFinal() {

        setTitle("Compra Finalizada");
        setSize(500, 320);
        setLocationRelativeTo(null);
        setResizable(false);

        iniciarComponentes();
    }

    /**
     * Método encargado de crear la interfaz gráfica.
     */
    private void iniciarComponentes() {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(35, 35, 35));

        // Título principal
        JLabel mensaje = new JLabel(
                "¡Gracias por su compra!",
                SwingConstants.CENTER
        );

        mensaje.setFont(new Font("Arial", Font.BOLD, 28));
        mensaje.setForeground(Color.WHITE);

        // Subtítulo
        JLabel subtitulo = new JLabel(
                "Su ticket ha sido registrado correctamente",
                SwingConstants.CENTER
        );

        subtitulo.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitulo.setForeground(new Color(220, 220, 220));

        // Panel central
        JPanel panelCentro = new JPanel();
        panelCentro.setBackground(new Color(35, 35, 35));
        panelCentro.setLayout(new GridLayout(2, 1));

        panelCentro.add(mensaje);
        panelCentro.add(subtitulo);

        // Botón aceptar
        botonAceptar = new JButton("Aceptar");

        botonAceptar.setFont(new Font("Arial", Font.BOLD, 14));
        botonAceptar.setBackground(new Color(34, 139, 34));
        botonAceptar.setForeground(Color.WHITE);
        botonAceptar.setFocusPainted(false);

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(new Color(35, 35, 35));

        panelBoton.add(botonAceptar);

        panel.add(panelCentro, BorderLayout.CENTER);
        panel.add(panelBoton, BorderLayout.SOUTH);

        add(panel);
    }

    /**
     * Getter del botón aceptar.
     */
    public JButton getBotonAceptar() {
        return botonAceptar;
    }
}