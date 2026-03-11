package model;

import java.util.ArrayList;

public class Taller {

    private String nombre;
    private String direccion;
    private String nit;

    private ArrayList<Cliente> listaClientes;
    private ArrayList<Mecanico> listaMecanicos;
    private ArrayList<Repuesto> listaRepuestos;
    private ArrayList<OrdenServicio> listaOrdenes;

    public Taller(String nombre, String direccion, String nit) {

        this.nombre = nombre;
        this.direccion = direccion;
        this.nit = nit;

        listaClientes = new ArrayList<>();
        listaMecanicos = new ArrayList<>();
        listaRepuestos = new ArrayList<>();
        listaOrdenes = new ArrayList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Mecanico> getListaMecanicos() {
        return listaMecanicos;
    }

    public ArrayList<Repuesto> getListaRepuestos() {
        return listaRepuestos;
    }

    public ArrayList<OrdenServicio> getListaOrdenes() {
        return listaOrdenes;
    }

    public String registrarCliente(String nombre, String cedula, String telefono){

        String mensaje;

        Cliente auxCliente = buscarCliente(cedula);

        if(auxCliente != null){

            mensaje = "Cliente ya existe";

        }else{

            Cliente clienteNuevo = new Cliente(nombre,cedula,telefono);

            listaClientes.add(clienteNuevo);

            mensaje = "Cliente registrado";

        }

        return mensaje;

    }

    public Cliente buscarCliente(String cedula){

        Cliente auxCliente = null;

        for(Cliente c : listaClientes){

            if(c.getIdentificacion().equals(cedula)){

                auxCliente = c;
                break;

            }

        }

        return auxCliente;

    }

    public String eliminarCliente(String cedula){

        String mensaje;

        Cliente auxCliente = buscarCliente(cedula);

        if(auxCliente != null){

            listaClientes.remove(auxCliente);
            mensaje = "Cliente eliminado";

        }else{

            mensaje = "Cliente no existe";

        }

        return mensaje;

    }

    public String registrarMecanico(String nombre, String telefono, String id){

        Mecanico nuevoMecanico = new Mecanico(nombre,telefono,id);

        listaMecanicos.add(nuevoMecanico);

        return "Mecanico registrado";

    }

    public Mecanico buscarMecanico(String id){

        Mecanico auxMecanico = null;

        for(Mecanico m : listaMecanicos){

            if(m.getId().equals(id)){

                auxMecanico = m;
                break;

            }

        }

        return auxMecanico;

    }

    public String registrarRepuesto(String nombre,double costo,int cantidad){

        Repuesto repNuevo = new Repuesto(nombre,costo,cantidad);

        listaRepuestos.add(repNuevo);

        return "Repuesto agregado";

    }

    public Repuesto buscarRepuesto(String nombre){

        Repuesto auxRep = null;

        for(Repuesto r : listaRepuestos){

            if(r.getNombre().equals(nombre)){

                auxRep = r;
                break;

            }

        }

        return auxRep;

    }

    public String crearOrden(String codigo,String descripcion,Bicicleta bici){

        OrdenServicio auxOrden = buscarOrden(codigo);

        if(auxOrden != null){

            return "La orden ya existe";

        }

        OrdenServicio nuevaOrden = new OrdenServicio(codigo,descripcion,bici);

        listaOrdenes.add(nuevaOrden);

        return "Orden creada";

    }

    public OrdenServicio buscarOrden(String codigo){

        OrdenServicio auxOrden = null;

        for(OrdenServicio o : listaOrdenes){

            if(o.getCodigo().equals(codigo)){

                auxOrden = o;
                break;

            }

        }

        return auxOrden;

    }

    public String eliminarOrden(String codigo){

        String mensaje;

        OrdenServicio auxOrden = buscarOrden(codigo);

        if(auxOrden != null){

            listaOrdenes.remove(auxOrden);

            mensaje = "Orden eliminada";

        }else{

            mensaje = "Orden no existe";

        }

        return mensaje;

    }

    @Override
    public String toString() {
        return "Taller{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", clientes=" + listaClientes.size() +
                ", mecanicos=" + listaMecanicos.size() +
                ", ordenes=" + listaOrdenes.size() +
                '}';
    }

}