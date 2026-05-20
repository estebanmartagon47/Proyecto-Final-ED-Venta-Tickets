package dao;

import modelo.ConexionBD;
import modelo.Venta;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Clase DAO encargada de registrar las ventas de tickets
 * en la tabla ventas de la base de datos.
 */
public class VentaDAO {

    /**
     * Guarda una nueva venta en la base de datos.
     *
     * @param venta objeto Venta con los datos de la compra
     * @return true si se guarda correctamente, false si ocurre un error
     */
    public boolean guardarVenta(Venta venta) {

        String sql = "INSERT INTO ventas "
                + "(evento_id, tipo_id, nombre_cliente, dni_email, cantidad, total_pagado) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection conexion = ConexionBD.conectar();
                PreparedStatement ps = conexion.prepareStatement(sql)
        ) {

            ps.setInt(1, venta.getEvento().getId());
            ps.setInt(2, venta.getTipoTicket().getId());
            ps.setString(3, venta.getNombreCliente());
            ps.setString(4, venta.getDniEmail());
            ps.setInt(5, venta.getCantidad());
            ps.setDouble(6, venta.getTotalPagado());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (Exception e) {
            System.out.println("Error al guardar la venta");
            e.printStackTrace();
            return false;
        }
    }
}