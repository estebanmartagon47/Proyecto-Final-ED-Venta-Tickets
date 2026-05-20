package modelo;

import java.time.LocalDateTime;

/**
 * Clase que representa una venta de tickets.
 */
public class Venta {

    private int id;
    private Evento evento;
    private TipoTicket tipoTicket;
    private String nombreCliente;
    private String dniEmail;
    private LocalDateTime fechaCompra;
    private int cantidad;
    private double totalPagado;

    /**
     * Constructor vacío.
     */
    public Venta() {
    }

    /**
     * Constructor completo.
     */
    public Venta(int id, Evento evento, TipoTicket tipoTicket,
                 String nombreCliente, String dniEmail,
                 LocalDateTime fechaCompra,
                 int cantidad, double totalPagado) {

        this.id = id;
        this.evento = evento;
        this.tipoTicket = tipoTicket;
        this.nombreCliente = nombreCliente;
        this.dniEmail = dniEmail;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.totalPagado = totalPagado;
    }

    public int getId() {
        return id;
    }

    public Evento getEvento() {
        return evento;
    }

    public TipoTicket getTipoTicket() {
        return tipoTicket;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getDniEmail() {
        return dniEmail;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotalPagado() {
        return totalPagado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setTipoTicket(TipoTicket tipoTicket) {
        this.tipoTicket = tipoTicket;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setDniEmail(String dniEmail) {
        this.dniEmail = dniEmail;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setTotalPagado(double totalPagado) {
        this.totalPagado = totalPagado;
    }
}