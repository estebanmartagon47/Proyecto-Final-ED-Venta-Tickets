package vista;

import modelo.Evento;
import modelo.TipoTicket;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

/**
 * Ventana donde el usuario introduce los datos necesarios
 * para comprar tickets.
 */
public class VentanaCompra extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<Evento> comboEventos;
    private JComboBox<TipoTicket> comboTipos;
    private JTextField campoNombre;
    private JTextField campoDniEmail;
    private JSpinner spinnerCantidad;
    private JButton botonContinuar;
    private JButton botonCancelar;

    /**
     * Constructor de la ventana de compra.
     *
     * @param eventos lista de eventos disponibles
     * @param tipos lista de tipos de ticket disponibles
     */
    public VentanaCompra(List<Evento> eventos, List<TipoTicket> tipos) {

        setTitle("Sacar Ticket");
        setSize(560, 480);
        setLocationRelativeTo(null);
        setResizable(false);

        iniciarComponentes(eventos, tipos);
    }

    /**
     * Crea y coloca los componentes gráficos.
     */
    private void iniciarComponentes(List<Evento> eventos, List<TipoTicket> tipos) {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(35, 35, 35));

        JLabel titulo = new JLabel("COMPRA DE TICKETS");
        titulo.setBounds(145, 25, 300, 35);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        panel.add(titulo);

        JLabel labelEvento = crearLabel("Evento:", 60, 85);
        panel.add(labelEvento);

        comboEventos = new JComboBox<>();
        comboEventos.setBounds(210, 85, 270, 28);

        for (Evento evento : eventos) {
            comboEventos.addItem(evento);
        }

        panel.add(comboEventos);

        JLabel labelNombre = crearLabel("Nombre:", 60, 135);
        panel.add(labelNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(210, 135, 270, 28);
        panel.add(campoNombre);

        JLabel labelDniEmail = crearLabel("DNI / Email:", 60, 185);
        panel.add(labelDniEmail);

        campoDniEmail = new JTextField();
        campoDniEmail.setBounds(210, 185, 270, 28);
        panel.add(campoDniEmail);

        JLabel labelTipo = crearLabel("Tipo de ticket:", 60, 235);
        panel.add(labelTipo);

        comboTipos = new JComboBox<>();
        comboTipos.setBounds(210, 235, 270, 28);

        for (TipoTicket tipo : tipos) {
            comboTipos.addItem(tipo);
        }

        panel.add(comboTipos);

        JLabel labelCantidad = crearLabel("Cantidad:", 60, 285);
        panel.add(labelCantidad);

        spinnerCantidad = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        spinnerCantidad.setBounds(210, 285, 80, 28);
        panel.add(spinnerCantidad);

        botonContinuar = new JButton("Continuar");
        botonContinuar.setBounds(115, 365, 140, 38);
        botonContinuar.setFont(new Font("Arial", Font.BOLD, 14));
        botonContinuar.setBackground(new Color(34, 139, 34));
        botonContinuar.setForeground(Color.WHITE);
        botonContinuar.setFocusPainted(false);
        panel.add(botonContinuar);

        botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(300, 365, 140, 38);
        botonCancelar.setFont(new Font("Arial", Font.BOLD, 14));
        botonCancelar.setBackground(new Color(178, 34, 34));
        botonCancelar.setForeground(Color.WHITE);
        botonCancelar.setFocusPainted(false);
        panel.add(botonCancelar);

        add(panel);
    }

    /**
     * Método auxiliar para crear etiquetas con el mismo estilo.
     */
    private JLabel crearLabel(String texto, int x, int y) {

        JLabel label = new JLabel(texto);
        label.setBounds(x, y, 130, 25);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.WHITE);

        return label;
    }

    public JComboBox<Evento> getComboEventos() {
        return comboEventos;
    }

    public JComboBox<TipoTicket> getComboTipos() {
        return comboTipos;
    }

    public JTextField getCampoNombre() {
        return campoNombre;
    }

    public JTextField getCampoDniEmail() {
        return campoDniEmail;
    }

    public JSpinner getSpinnerCantidad() {
        return spinnerCantidad;
    }

    public JButton getBotonContinuar() {
        return botonContinuar;
    }

    public JButton getBotonCancelar() {
        return botonCancelar;
    }
}