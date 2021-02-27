
package Fabrica;
/**
 *
 * @author eduardo
 */
 
import java.sql.Connection;
import java.sql.SQLException;
    public class TestandoConexao {
    public static void main(String[]args) throws SQLException {

    Connection connection = new ConnectionFabrica().getConnection();
    System.out.println("Conexão aberta!");
    connection.close();

    }

    }