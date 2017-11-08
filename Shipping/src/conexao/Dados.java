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
        String local = "255.255.255.0";
        String bancoDeDados = "protocolo";
        String url = "jdbc:sqlserver://" + local + ":1433;DatabaseName=" + bancoDeDados;
        String usuario = "jerson";
        String senha = "jerson123";
        Class.forName(driver);
        conn = DriverManager.getConnection(url, usuario, senha);
        stmt = conn.createStatement();
        return stmt;
    }
}