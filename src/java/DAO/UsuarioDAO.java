package DAO;

import Conexion.Conexion;
import DTO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

public class UsuarioDAO {

    // CRUD
    //CREATE READ UPDATE AND DELET 
    // INSERT INTO 
    // SELECT READ
    public List<Usuario> obtenerUsuarios() throws NamingException {

        Conexion conexion = new Conexion();

        Connection cc = conexion.obtenerConexion();
        String sql = "SELECT usu_id, usu _name, usu_email "
                + "FROM USER "
                + "WHERE usu_status = 'A '";

        System.out.println(sql);

        List<Usuario> ListaUsuario = new ArrayList<>();
        try {
            //Statement
            //ResultSet
            Statement st = cc.createStatement();
            ResultSet resultado = st.executeQuery(sql);

            int contador = 0;

            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setCodigo(resultado.getInt(1));
                usuario.setNombre(resultado.getString(2));
                usuario.setCorreo(resultado.getString(3));
                ListaUsuario.add(usuario);
                contador++;

            }

            if (contador > 0) {
                return ListaUsuario;

            } else {
                return null;

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public Usuario obtenerUsuariosXLogin(String username, String password) throws NamingException {
        try {
            Conexion conexion = new Conexion();

            Connection cc = conexion.obtenerConexion();
            String sql = "SELECT usu_id, usu _name, usu_email "
                    + "FROM USER "
                    + "WHERE usu_status = 'A ' "
                    + "AND usu_email=" + username + " "
                    + "AND usu_password=" + password;

            System.out.println(sql);

            Usuario usuario = new Usuario();;

            //Statement
            //ResultSet
            Statement st = cc.createStatement();
            ResultSet resultado = st.executeQuery(sql);

            int contador = 0;
            while (resultado.next()) {

                usuario.setCodigo(resultado.getInt(1));
                usuario.setNombre(resultado.getString(2));
                usuario.setCorreo(resultado.getString(3));
                contador++;

            }

            if (contador > 0) {
                return usuario;

            } else {
                return null;

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public Usuario obtenerUsuariosXID(int Id) throws NamingException {
        try {
            Conexion conexion = new Conexion();

            Connection cc = conexion.obtenerConexion();
            String sql = "SELECT usu_id, usu _name, usu_email "
                    + "FROM USER "
                    + "WHERE usu_status = 'A ' "
                    + "AND id=" + Id;

            System.out.println(sql);

            Usuario usuario = new Usuario();

            //Statement
            //ResultSet
            Statement st = cc.createStatement();
            ResultSet resultado = st.executeQuery(sql);

            int contador = 0;
            while (resultado.next()) {

                usuario.setCodigo(resultado.getInt(1));
                usuario.setNombre(resultado.getString(2));
                usuario.setCorreo(resultado.getString(3));
                contador++;

            }

            if (contador > 0) {
                return usuario;

            } else {
                return null;

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public boolean guardarUsuario(Usuario usuario) throws NamingException {
        try {
            Conexion conexion = new Conexion();

            Connection cc = conexion.obtenerConexion();
            //INSERT, UPDATE, DELET
            String sql = "INSERT INTO USER(usu_id, usu_name, usu_email, usu_password, "
                    + "usu_status, usu_dateadd ) "
                    + "VALUES(?,?,?,?,?,?)";
            //PREPAREDSTATEMENT ENVIA VALORES A LOS PARAMETROS DEL SQL
            PreparedStatement pst = cc.prepareStatement(sql);
            pst.setInt(1, usuario.getCodigo());
            pst.setString(2, usuario.getNombre());
            pst.setString(3, usuario.getCorreo());
            pst.setString(4, usuario.getClave());
            pst.setString(5, "A");
            pst.setString(6, "2023-07-24");

            //Ejecutar Consulta
            int registrosGuardados = pst.executeUpdate();
            return registrosGuardados > 0;

        } catch (SQLException ex) {
            return false;
        }

    }

    public boolean modificarUsuario(Usuario usuario) throws NamingException {
        try {
            Conexion conexion = new Conexion();

            Connection cc = conexion.obtenerConexion();
            //INSERT, UPDATE, DELET
            String sql = "UPDATE USER INT usu_name=?, usu_email=?, usu_password=?, "
                    + "WHERE usu_id=?)";
            //PREPAREDSTATEMENT ENVIA VALORES A LOS PARAMETROS DEL SQL
            PreparedStatement pst = cc.prepareStatement(sql);
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getCorreo());
            pst.setString(3, usuario.getClave());
            pst.setInt(4, usuario.getCodigo());

            //Ejecutar Consulta
            int registrosGuardados = pst.executeUpdate();
            return registrosGuardados > 0;

        } catch (SQLException ex) {
            return false;
        }

    }

    public boolean eliminarUsuario(Usuario usuario) throws NamingException {
        try {
            Conexion conexion = new Conexion();
            Connection cc = conexion.obtenerConexion();
            //INSERT, UPDATE, DELET

            String sql = "DELET FROM USER "
                    + "WHERE usu_id=?)";

            //PREPAREDSTATEMENT ENVIA VALORES A LOS PARAMETROS DEL SQL
            PreparedStatement pst = cc.prepareStatement(sql);

            pst.setInt(1, usuario.getCodigo());

            //Ejecutar Consulta
            int registrosGuardados = pst.executeUpdate();
            return registrosGuardados > 0;

        } catch (SQLException ex) {
            return false;
        }

    }

}
