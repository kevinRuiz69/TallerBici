package model;

public class Mecanico {

    private String nombre;
    private String telefono;
    private String id;

    public Mecanico(String nombre, String telefono, String id) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Mecanico{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
