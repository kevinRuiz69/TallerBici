package model;

import java.util.ArrayList;

public class OrdenServicio {

    private String codigo;
    private String descripcion;
    private EstadoOrden estado;
    private Bicicleta bicicleta;
    private Mecanico mecanico;
    private ArrayList<Tarea> listaTareas;
    private ArrayList<Repuesto> listaRepuestos;

    public OrdenServicio(String codigo, String descripcion, Bicicleta bicicleta) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.bicicleta = bicicleta;
        this.estado = EstadoOrden.RECIBIDA;
        this.listaTareas = new ArrayList<>();
        this.listaRepuestos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public void asignarMecanico(Mecanico mecanico){
        this.mecanico = mecanico;
    }

    public void agregarTarea(Tarea tarea){
        listaTareas.add(tarea);
    }

    public void agregarRepuesto(Repuesto repuesto){
        listaRepuestos.add(repuesto);
    }

    public double calcularTotal(){

        double total = 0;

        for(Tarea auxTarea : listaTareas){
            total += auxTarea.getCosto();
        }

        for(Repuesto auxRepuesto : listaRepuestos){
            total += auxRepuesto.calcularCosto();
        }

        return total;
    }

    @Override
    public String toString() {
        return "OrdenServicio{" +
                "codigo='" + codigo + '\'' +
                ", estado=" + estado +
                ", total=" + calcularTotal() +
                '}';
    }
}
