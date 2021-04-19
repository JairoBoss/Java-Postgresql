package Main;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jairo
 */
public class Connection {

    private java.sql.Connection connection;
    private Statement st;
    private ResultSet rs;

    public Connection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost/Prueba", "postgres", "123");
            this.st = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

   

    public void mostrarElementos() throws SQLException {
        try {
            rs = this.st.executeQuery("select * from Persona");
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (rs.next()) {
            System.out.println(String.format("%s %s %d", rs.getString(1), rs.getString(2), rs.getInt(3)));
        }
    }

    public void eliminar(String nombre) throws SQLException {
        String s = "delete from persona where nombre = '"+nombre+"'";        
        rs = this.st.executeQuery(s);
    }
    
    public void añadir(String nombre, String apellido, int edad) throws SQLException{
        String s = String.format("insert into Persona (Nombre, Apellido, Edad ) values ('%s', '%s',%d);", nombre, apellido, edad);
        rs = this.st.executeQuery(s);
    }
        

}
