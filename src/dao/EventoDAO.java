package dao;

import modelo.ConexionBD;
import modelo.Evento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO significa Data Access Object.
 *
 * Esta clase se encarga de acceder a los datos de la tabla eventos.
 * Separa las consultas SQL del resto de la aplicación siguiendo MVC.
 */
public class EventoDAO {

    /**
     * Obtiene todos los eventos almacenados en la base de datos.
     *
     * @return lista de eventos disponibles
     */
    public List<Evento> obtenerEventos() {

        List<Evento> listaEventos = new ArrayList<>();

        String sql = "SELECT id, nombre, descripcion, fecha, horario, ubicacion FROM eventos";

        try (
                Connection conexion = ConexionBD.conectar();
                PreparedStatement ps = conexion.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Evento evento = new Evento();

                evento.setId(rs.getInt("id"));
                evento.setNombre(rs.getString("nombre"));
                evento.setDescripcion(rs.getString("descripcion"));
                evento.setFecha(rs.getString("fecha"));
                evento.setHorario(rs.getString("horario"));
                evento.setUbicacion(rs.getString("ubicacion"));

                listaEventos.add(evento);
            }

        } catch (Exception e) {
            System.out.println("Error al obtener eventos");
            e.printStackTrace();
        }

        return listaEventos;
    }
}