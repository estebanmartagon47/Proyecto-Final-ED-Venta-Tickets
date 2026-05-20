package dao;

import modelo.ConexionBD;
import modelo.TipoTicket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO encargada de acceder a los datos de la tabla tipos.
 *
 * Obtiene los distintos tipos de tickets disponibles en la base de datos.
 */
public class TipoTicketDAO {

    /**
     * Obtiene todos los tipos de ticket almacenados en la base de datos.
     *
     * @return lista de tipos de ticket disponibles
     */
    public List<TipoTicket> obtenerTiposTicket() {

        List<TipoTicket> listaTipos = new ArrayList<>();

        String sql = "SELECT id, nombre, descripcion, precio FROM tipos";

        try (
                Connection conexion = ConexionBD.conectar();
                PreparedStatement ps = conexion.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                TipoTicket tipo = new TipoTicket();

                tipo.setId(rs.getInt("id"));
                tipo.setNombre(rs.getString("nombre"));
                tipo.setDescripcion(rs.getString("descripcion"));
                tipo.setPrecio(rs.getDouble("precio"));

                listaTipos.add(tipo);
            }

        } catch (Exception e) {
            System.out.println("Error al obtener los tipos de ticket");
            e.printStackTrace();
        }

        return listaTipos;
    }
}