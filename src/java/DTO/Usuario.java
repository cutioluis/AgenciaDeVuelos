package DTO;

public class Usuario {

    private int codigo;
    private String Nombre;
    private String Correo;
    private String Clave;
    private Rol rol;

    public Usuario() {
        rol = new Rol();
    }
    

    public Usuario(int codigo, String Nombre, String Correo, String Clave, int CodigoRol, String descripcion) {
        this.codigo = codigo;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Clave = Clave;
        rol.setCodigo(CodigoRol);
        rol.setDescripcion(descripcion);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

}
