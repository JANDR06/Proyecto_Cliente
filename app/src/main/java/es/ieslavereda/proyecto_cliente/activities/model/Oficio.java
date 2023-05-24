package es.ieslavereda.proyecto_cliente.activities.model;

public class Oficio {

    private int idOficio;
    private String descripcion;
    private String urlImagen;

    public Oficio(int idOficio, String descripcion, String urlImagen) {
        this.idOficio = idOficio;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }

    public int getIdOficio() {
        return idOficio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    @Override
    public String toString() {
        return idOficio + ", " + descripcion + ", " + urlImagen;
    }
}
