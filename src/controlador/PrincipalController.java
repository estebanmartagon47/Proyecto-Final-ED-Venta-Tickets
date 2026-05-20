package controlador;

// IMPORTS DAO
import dao.EventoDAO;
import dao.TipoTicketDAO;
import dao.VentaDAO;

// IMPORTS MODELO
import modelo.Evento;
import modelo.TipoTicket;
import modelo.Venta;

// IMPORTS VISTAS
import vista.VentanaCompra;
import vista.VentanaConfirmacion;
import vista.VentanaEventos;
import vista.VentanaFinal;
import vista.VentanaPrincipal;

// IMPORTS JAVA
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Controlador principal de la aplicación.
 *
 * Se encarga de conectar las vistas con los DAO
 * y gestionar los eventos de los botones.
 */
public class PrincipalController {

    private VentanaPrincipal ventanaPrincipal;

    /**
     * Constructor del controlador principal.
     */
    public PrincipalController() {

        ventanaPrincipal = new VentanaPrincipal();
        iniciarEventos();
        ventanaPrincipal.setVisible(true);
    }

    /**
     * Método encargado de asignar acciones a los botones.
     */
    private void iniciarEventos() {

        // =====================================================
        // BOTÓN INFORMACIÓN DE EVENTOS
        // =====================================================
        ventanaPrincipal.getBotonEventos().addActionListener(e -> {

            EventoDAO eventoDAO = new EventoDAO();

            List<Evento> eventos = eventoDAO.obtenerEventos();

            if (eventos.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "No se han podido cargar los eventos de la base de datos"
                );
                return;
            }

            VentanaEventos ventanaEventos =
                    new VentanaEventos(eventos);

            ventanaEventos.getBotonVolver().addActionListener(evVolver -> {
                ventanaEventos.dispose();
            });

            ventanaEventos.setVisible(true);
        });

        // =====================================================
        // BOTÓN SACAR TICKET
        // =====================================================
        ventanaPrincipal.getBotonComprar().addActionListener(e -> {

            EventoDAO eventoDAO = new EventoDAO();
            TipoTicketDAO tipoTicketDAO = new TipoTicketDAO();

            List<Evento> eventos = eventoDAO.obtenerEventos();
            List<TipoTicket> tipos = tipoTicketDAO.obtenerTiposTicket();

            if (eventos.isEmpty() || tipos.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "No se han podido cargar los datos de la base de datos"
                );
                return;
            }

            VentanaCompra ventanaCompra =
                    new VentanaCompra(eventos, tipos);

            // =================================================
            // BOTÓN CONTINUAR
            // =================================================
            ventanaCompra.getBotonContinuar().addActionListener(ev -> {

                Evento evento =
                        (Evento) ventanaCompra
                                .getComboEventos()
                                .getSelectedItem();

                TipoTicket tipoTicket =
                        (TipoTicket) ventanaCompra
                                .getComboTipos()
                                .getSelectedItem();

                String nombre =
                        ventanaCompra.getCampoNombre().getText().trim();

                String dniEmail =
                        ventanaCompra.getCampoDniEmail().getText().trim();

                int cantidad =
                        (int) ventanaCompra
                                .getSpinnerCantidad()
                                .getValue();

                // Validar campos vacíos
                if (nombre.isEmpty() || dniEmail.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Debe completar todos los campos"
                    );
                    return;
                }

                // Validar longitud mínima del nombre
                if (nombre.length() < 3) {
                    JOptionPane.showMessageDialog(
                            null,
                            "El nombre debe tener al menos 3 caracteres"
                    );
                    return;
                }

                // Validar DNI o email
                if (dniEmail.length() < 5) {
                    JOptionPane.showMessageDialog(
                            null,
                            "El DNI o email introducido no es válido"
                    );
                    return;
                }

                // Crear objeto venta
                Venta venta = new Venta();

                venta.setEvento(evento);
                venta.setTipoTicket(tipoTicket);
                venta.setNombreCliente(nombre);
                venta.setDniEmail(dniEmail);
                venta.setCantidad(cantidad);
                venta.setFechaCompra(LocalDateTime.now());

                double total = cantidad * tipoTicket.getPrecio();
                venta.setTotalPagado(total);

                VentanaConfirmacion ventanaConfirmacion =
                        new VentanaConfirmacion(venta);

                // BOTÓN CANCELAR CONFIRMACIÓN
                ventanaConfirmacion
                        .getBotonCancelar()
                        .addActionListener(eventoCancelar -> {
                            ventanaConfirmacion.dispose();
                        });

                // BOTÓN CONFIRMAR Y PAGAR
                ventanaConfirmacion
                        .getBotonConfirmar()
                        .addActionListener(eventoConfirmar -> {

                            VentaDAO ventaDAO = new VentaDAO();

                            boolean guardado =
                                    ventaDAO.guardarVenta(venta);

                            if (guardado) {

                                VentanaFinal ventanaFinal =
                                        new VentanaFinal();

                                ventanaFinal
                                        .getBotonAceptar()
                                        .addActionListener(evFinal -> {
                                            ventanaFinal.dispose();
                                        });

                                ventanaFinal.setVisible(true);

                                ventanaConfirmacion.dispose();
                                ventanaCompra.dispose();

                            } else {

                                JOptionPane.showMessageDialog(
                                        null,
                                        "Error al guardar la compra"
                                );
                            }
                        });

                ventanaConfirmacion.setVisible(true);
            });

            // BOTÓN CANCELAR COMPRA
            ventanaCompra.getBotonCancelar().addActionListener(evCancelarCompra -> {
                ventanaCompra.dispose();
            });

            ventanaCompra.setVisible(true);
        });
    }
}