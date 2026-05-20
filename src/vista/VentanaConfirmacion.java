package vista;

import modelo.Venta;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana encargada de mostrar el resumen final de la compra
 * antes de guardar la venta en la base de datos.
 */
public class VentanaConfirmacion extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea areaResumen;
    private JButton botonConfirmar;
    private JButton botonCancelar;

    public VentanaConfirmacion(Venta venta) {

        setTitle("Confirmación de Compra");
        setSize(560, 470);
        setLocationRelativeTo(null);
        setResizable(false);

        iniciarComponentes(venta);
    }

    private void iniciarComponentes(Venta venta) {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(35, 35, 35));

        JLabel titulo = new JLabel("CONFIRMACIÓN DE COMPRA", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setForeground(Color.WHITE);
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 15, 0));

        areaResumen = new JTextArea();
        areaResumen.setEditable(false);
        areaResumen.setFont(new Font("Arial", Font.PLAIN, 15));
        areaResumen.setBackground(new Color(245, 245, 245));
        areaResumen.setForeground(Color.BLACK);
        areaResumen.setMargin(new Insets(15, 20, 15, 20));

        String resumen = "";

        resumen += "===== RESUMEN DE COMPRA =====\n\n";
        resumen += "Evento: " + venta.getEvento().getNombre() + "\n";
        resumen += "Fecha: " + venta.getEvento().getFecha() + "\n";
        resumen += "Tipo Ticket: " + venta.getTipoTicket().getNombre() + "\n";
        resumen += "Precio Unitario: " + venta.getTipoTicket().getPrecio() + " €\n";
        resumen += "Cantidad: " + venta.getCantidad() + "\n";
        resumen += "Cliente: " + venta.getNombreCliente() + "\n";
        resumen += "DNI / Email: " + venta.getDniEmail() + "\n\n";
        resumen += "TOTAL A PAGAR: " + venta.getTotalPagado() + " €";

        areaResumen.setText(resumen);

        JScrollPane scroll = new JScrollPane(areaResumen);
        scroll.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(35, 35, 35));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

        botonConfirmar = new JButton("Confirmar y Pagar");
        botonConfirmar.setFont(new Font("Arial", Font.BOLD, 14));
        botonConfirmar.setBackground(new Color(34, 139, 34));
        botonConfirmar.setForeground(Color.WHITE);
        botonConfirmar.setFocusPainted(false);

        botonCancelar = new JButton("Cancelar");
        botonCancelar.setFont(new Font("Arial", Font.BOLD, 14));
        botonCancelar.setBackground(new Color(178, 34, 34));
        botonCancelar.setForeground(Color.WHITE);
        botonCancelar.setFocusPainted(false);

        panelBotones.add(botonConfirmar);
        panelBotones.add(botonCancelar);

        panel.add(titulo, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        add(panel);
    }

    public JButton getBotonConfirmar() {
        return botonConfirmar;
    }

    public JButton getBotonCancelar() {
        return botonCancelar;
    }
}