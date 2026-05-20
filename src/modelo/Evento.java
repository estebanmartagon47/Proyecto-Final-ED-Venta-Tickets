package modelo;
//Clase que representa un evento o atracción disponible en el parque.
public class Evento {

    private int id;
    private String nombre;
    private String descripcion;
    private String fecha;
    private String horario;
    private String ubicacion;
    // Constructor vacío.
    public Evento() {
    }
     // Constructor completo de la clase Evento.
    public Evento(int id, String nombre, String descripcion, String fecha, String horario, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.horario = horario;
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getFecha() {
        return fecha;
    }
    public String getHorario() {
        return horario;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    @Override
    public String toString() {
        return nombre;
    }
}