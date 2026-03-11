package model;

public class Bicicleta {

    private String marca;
    private String color;
    private String numChasis;
    private String tipo;

    public Bicicleta(String marca, String color, String numChasis, String tipo) {
        this.marca = marca;
        this.color = color;
        this.numChasis = numChasis;
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumChasis() {
        return numChasis;
    }

    public void setNumChasis(String numChasis) {
        this.numChasis = numChasis;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", numChasis='" + numChasis + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
