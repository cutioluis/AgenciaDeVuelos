package DTO;

public class Rol {

    private int Codigo;
    private String descripcion;

    public Rol(int Codigo, String descripcion) {
        this.Codigo = Codigo;
        this.descripcion = descripcion;
    }

    public Rol() {
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
