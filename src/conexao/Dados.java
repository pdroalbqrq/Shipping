/*

 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jerson e Pedro
 */

public class Dados {
    private Statement stmt;
    private Connection conn;

    /**
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Statement conectar() throws ClassNotFoundException, SQLException {
        return this.conectarSqlServer();
    }

    /**
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection conectarPrepareStatment() throws ClassNotFoundException, SQLException {
        this.conectarSqlServer();
        return conn;
    }

    /**
     *
     * @throws SQLException
     */
    public void desconectar() throws SQLException {
        conn.close();
    }

    private Statement conectarSqlServer() throws ClassNotFoundException, SQLException {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String local = "localhost";
        String local = "172.16.1.24";
        //String local = "192.168.0.12";
        String bancoDeDados = "Shipping";
        String url = "jdbc:sqlserver://" + local + ":1433;DatabaseName=" + bancoDeDados;
        String usuario = "Shipping";
        String senha = "12345";
        Class.forName(driver);
        conn = DriverManager.getConnection(url, usuario, senha);
        stmt = conn.createStatement();
        return stmt;
    }
}