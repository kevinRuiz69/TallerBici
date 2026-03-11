package app;

import model.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        Taller taller = new Taller("Taller Kevin Bikes", "Armenia", "10923442");

        int opcion = 0;

        while (opcion != 8) {

            String menu =
                    "=== MENU TALLER ===\n" +
                            "1. Registrar cliente\n" +
                            "2. Registrar mecanico\n" +
                            "3. Registrar bicicleta\n" +
                            "4. Registrar repuesto\n" +
                            "5. Crear orden servicio\n" +
                            "6. Ver ordenes\n" +
                            "7. Estado taller\n" +
                            "8. Salir\n\n" +
                            "Opcion:";

            String input = JOptionPane.showInputDialog(menu);

            if (input == null) break;

            try {
                opcion = Integer.parseInt(input);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Ingrese un numero");
                continue;
            }

            switch (opcion) {

                case 1:

                    String nombre = JOptionPane.showInputDialog("Nombre cliente:");
                    String cedula = JOptionPane.showInputDialog("Cedula:");
                    String telefono = JOptionPane.showInputDialog("Telefono:");

                    String r = taller.registrarCliente(nombre,cedula,telefono);

                    JOptionPane.showMessageDialog(null,r);

                    break;

                case 2:

                    String nomM = JOptionPane.showInputDialog("Nombre mecanico:");
                    String telM = JOptionPane.showInputDialog("Telefono:");
                    String idM = JOptionPane.showInputDialog("ID mecanico:");

                    JOptionPane.showMessageDialog(null,
                            taller.registrarMecanico(nomM,telM,idM));

                    break;

                case 3:

                    String cedCliente = JOptionPane.showInputDialog("Cedula cliente:");

                    Cliente auxCliente = taller.buscarCliente(cedCliente);

                    if(auxCliente == null){
                        JOptionPane.showMessageDialog(null,"Cliente no existe");
                        break;
                    }

                    String marca = JOptionPane.showInputDialog("Marca bicicleta:");
                    String color = JOptionPane.showInputDialog("Color:");
                    String chasis = JOptionPane.showInputDialog("Numero chasis:");
                    String tipo = JOptionPane.showInputDialog("Tipo bicicleta:");

                    Bicicleta bici = new Bicicleta(marca,color,chasis,tipo);

                    auxCliente.agregarBicicleta(bici);

                    JOptionPane.showMessageDialog(null,"Bicicleta registrada");

                    break;

                case 4:

                    String nombreR = JOptionPane.showInputDialog("Nombre repuesto:");
                    double costo = Double.parseDouble(JOptionPane.showInputDialog("Costo:"));
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));

                    Repuesto rep = new Repuesto(nombreR,costo,cantidad);

                    taller.getListaRepuestos().add(rep);

                    JOptionPane.showMessageDialog(null,"Repuesto agregado");

                    break;

                case 5:

                    String cod = JOptionPane.showInputDialog("Codigo orden:");
                    String desc = JOptionPane.showInputDialog("Descripcion:");

                    String chasisB = JOptionPane.showInputDialog("Chasis bicicleta:");

                    Bicicleta auxBici = null;

                    for(Cliente c : taller.getListaClientes()){
                        auxBici = c.buscarBicicleta(chasisB);
                        if(auxBici != null) break;
                    }

                    if(auxBici == null){
                        JOptionPane.showMessageDialog(null,"Bicicleta no encontrada");
                        break;
                    }

                    String res = taller.crearOrden(cod,desc,auxBici);

                    JOptionPane.showMessageDialog(null,res);

                    break;

                case 6:

                    String lista = "=== ORDENES ===\n";

                    for(OrdenServicio o : taller.getListaOrdenes()){
                        lista += o.toString() + "\n";
                    }

                    JOptionPane.showMessageDialog(null,lista);

                    break;

                case 7:

                    JOptionPane.showMessageDialog(null,taller.toString());

                    break;

                case 8:

                    JOptionPane.showMessageDialog(null,"Saliendo");

                    break;

                default:

                    JOptionPane.showMessageDialog(null,"Opcion invalida");

            }

        }

    }

}