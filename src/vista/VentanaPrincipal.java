package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

/**
 * Ventana principal de la aplicación.
 * Desde aquí el usuario puede consultar eventos o iniciar la compra de tickets.
 */
public class VentanaPrincipal extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
    private JLabel titulo;
    private JLabel subtitulo;
    private JLabel logo;
    private JButton botonEventos;
    private JButton botonComprar;
    

    /**
     * Constructor de la ventana principal.
     */
    public VentanaPrincipal() {

        setTitle("Sistema de Venta de Tickets");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        iniciarComponentes();
    }

    /**
     * Crea y configura los componentes visuales de la ventana.
     */
    private void iniciarComponentes() {

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(30, 30, 30));

        titulo = new JLabel("PARQUE DE ATRACCIONES");
        titulo.setBounds(95, 140, 400, 40);
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        titulo.setForeground(Color.WHITE);

        subtitulo = new JLabel("Sistema de venta de tickets");
        subtitulo.setBounds(165, 180, 300, 30);
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitulo.setForeground(new Color(220, 220, 220));

        botonEventos = new JButton("Información de Eventos");
        botonEventos.setBounds(155, 240, 240, 45);
        botonEventos.setFont(new Font("Arial", Font.BOLD, 14));
        botonEventos.setBackground(new Color(70, 130, 180));
        botonEventos.setForeground(Color.WHITE);
        botonEventos.setFocusPainted(false);

        botonComprar = new JButton("Sacar Ticket");
        botonComprar.setBounds(155, 305, 240, 45);
        botonComprar.setFont(new Font("Arial", Font.BOLD, 14));
        botonComprar.setBackground(new Color(34, 139, 34));
        botonComprar.setForeground(Color.WHITE);
        botonComprar.setFocusPainted(false);
        logo = new JLabel();

        ImageIcon icono = new ImageIcon(
                getClass().getResource("/imagenes/logo.png")
        );
        logo.setIcon(icono);
        logo.setBounds(210, 15, 128, 128);

        panel.add(logo);
        panel.add(titulo);
        panel.add(subtitulo);
        panel.add(botonEventos);
        panel.add(botonComprar);

        add(panel);
    }

    public JButton getBotonEventos() {
        return botonEventos;
    }

    public JButton getBotonComprar() {
        return botonComprar;
    }
}