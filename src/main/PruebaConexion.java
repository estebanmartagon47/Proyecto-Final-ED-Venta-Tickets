package main;

import dao.EventoDAO;
import dao.TipoTicketDAO;
import modelo.Evento;
import modelo.TipoTicket;

import java.util.List;

/**
 * Clase de prueba para comprobar la conexión con la base de datos.
 */
public class PruebaConexion {

    public static void main(String[] args) {

        EventoDAO eventoDAO = new EventoDAO();
        TipoTicketDAO tipoTicketDAO = new TipoTicketDAO();

        List<Evento> eventos = eventoDAO.obtenerEventos();
        List<TipoTicket> tipos = tipoTicketDAO.obtenerTiposTicket();

        System.out.println("=== EVENTOS DISPONIBLES ===");

        for (Evento evento : eventos) {
            System.out.println(evento.getId() + " - " + evento.getNombre()
                    + " - " + evento.getFecha()
                    + " - " + evento.getUbicacion());
        }

        System.out.println();
        System.out.println("=== TIPOS DE TICKET ===");

        for (TipoTicket tipo : tipos) {
            System.out.println(tipo.getId() + " - " + tipo.getNombre()
                    + " - " + tipo.getPrecio() + "€");
        }
    }
}