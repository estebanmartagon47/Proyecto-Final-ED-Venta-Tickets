package vista;

import modelo.Evento;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Ventana que muestra la información de los eventos disponibles.
 */
public class VentanaEventos extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea areaEventos;
    private JButton botonVolver;

    public VentanaEventos(List<Evento> eventos) {

        setTitle("Información de Eventos");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setResizable(false);

        iniciarComponentes(eventos);
    }

    private void iniciarComponentes(List<Evento> eventos) {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        areaEventos = new JTextArea();
        areaEventos.setEditable(false);
        areaEventos.setFont(new Font("Arial", Font.PLAIN, 14));

        StringBuilder texto = new StringBuilder();

        for (Evento evento : eventos) {
            texto.append("Evento: ").append(evento.getNombre()).append("\n");
            texto.append("Descripción: ").append(evento.getDescripcion()).append("\n");
            texto.append("Fecha: ").append(evento.getFecha()).append("\n");
            texto.append("Horario: ").append(evento.getHorario()).append("\n");
            texto.append("Ubicación: ").append(evento.getUbicacion()).append("\n");
            texto.append("----------------------------------------\n");
        }

        areaEventos.setText(texto.toString());

        JScrollPane scroll = new JScrollPane(areaEventos);

        botonVolver = new JButton("Volver");

        panel.add(scroll, BorderLayout.CENTER);
        panel.add(botonVolver, BorderLayout.SOUTH);

        add(panel);
    }

    public JButton getBotonVolver() {
        return botonVolver;
    }
}