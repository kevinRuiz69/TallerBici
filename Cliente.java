package model;

import java.util.ArrayList;

public class Cliente {

    private String nombre;
    private String identificacion;
    private String telefono;
    private ArrayList<Bicicleta> listaBicicletas;

    public Cliente(String nombre, String identificacion, String telefono) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.listaBicicletas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Bicicleta> getListaBicicletas() {
        return listaBicicletas;
    }

    public void agregarBicicleta(Bicicleta bici){
        listaBicicletas.add(bici);
    }

    public Bicicleta buscarBicicleta(String chasis){

        for(Bicicleta auxBici : listaBicicletas){
            if(auxBici.getNumChasis().equals(chasis)){
                return auxBici;
            }
        }

        return null;
    }

    public boolean eliminarBicicleta(String chasis){

        Bicicleta auxBici = buscarBicicleta(chasis);

        if(auxBici != null){
            listaBicicletas.remove(auxBici);
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
