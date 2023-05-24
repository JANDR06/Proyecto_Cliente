package es.ieslavereda.proyecto_cliente.activities.model;

public class Usuario {

    private int idUsuario;
    private String nombre;
    private String apellidos;
    private int idOficio;

    public Usuario(int idUsuario, String nombre, String apellidos, int idOficio) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.idOficio = idOficio;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getIdOficio() {
        return idOficio;
    }

    @Override
    public String toString() {
        return idUsuario + ", " + nombre + ", " + apellidos + ", " +idOficio;
    }
}
