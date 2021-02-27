package Fabrica;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class ConnectionFabrica {

    public Connection getConnection( ) { //Classe getConnection que faz a conexão com o banco

    try {

    return DriverManager.getConnection("jdbc:mysql://localhost:3306/CadUsuario","root","1234");

    }

    catch(SQLException excecao) {

    throw new RuntimeException("ERRO!!",excecao);

    }

    }}