package Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Conexion {

    private Connection dataConnection;

    public Connection obtenerConexion() throws NamingException {
        try {
            Context context = new InitialContext();
            DataSource datasource = (DataSource) context.lookup("jdbc/laboratorio");
            dataConnection = datasource.getConnection();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return dataConnection;
    }

}
