/*
    Classe responsável por alterar os dados na tabela Funcionário
 */
package pastaFuncionario;

import conexao.Dados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jerson e Pedro
 */

public class FuncionarioDados extends Dados implements InterfaceFuncionario {

    /**
     *Método de criação de novos funcionários
     *tabela: funcionarios
     *parametros: Matricula, NomeFuncionario e CodSetor
     * @param fun
     * @throws Exception
     */

    @Override
    public void cadastrarFuncionario(Funcionario fun) throws Exception {
        //abrindo a conexão
        Connection conn = super.conectarPrepareStatment();

        //instrução sql correspondente a inserção novo funcionário
        String sql = "INSERT INTO Funcionario (Matricula, NomeFuncionario,CodSetor)";
        sql += "VALUES (?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        // preenche os valores
        stmt.setInt(1, fun.getMatricula());
        stmt.setString(2, fun.getNomeFuncionario());
        stmt.setInt(3, fun.getSetor().getCodSetor());

        // executa
        stmt.execute();
        stmt.close();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    /**
     *Método para inserir na tabela Funcionario um novo funcionario
     * @param fun
     * @return
     * @throws Exception
     */

    @Override
    public Funcionario verificarLogin(Funcionario fun) throws Exception {
        Funcionario retorno = new Funcionario();
        //abrindo a conexão
        Connection conn = super.conectarPrepareStatment();

        //instrução sql correspondente a inserção do funcionário
        String sql = "INSERT INTO Funcionário (Matricula, NomeFuncionario,CodSetor)";
        sql += "VALUES (?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        // preenche os valores
        stmt.setInt(1, fun.getMatricula());
        stmt.setString(2, fun.getNomeFuncionario());
        stmt.setInt(3, fun.getSetor().getCodSetor());

        // executa
        stmt.execute();
        stmt.close();

        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<Funcionario> listarFuncionario() throws Exception {
        ArrayList<Funcionario> retorno = new ArrayList<Funcionario>();
        //abrindo a conexão
        Connection conn = super.conectarPrepareStatment();

        //instrução sql correspondente a listar tabela funcionario
        String sql = "select Matricula, NomeFuncionario, funcionario.CodSetor, NomeSetor ";
        sql += " from Funcionario inner join setor ";
        sql += " on setor.codsetor = funcionario.codsetor ";
        PreparedStatement stmt = conn.prepareStatement(sql);

        // executa
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Funcionario f = new Funcionario();
            f.setMatricula(rs.getInt("Matricula"));
            f.setNomeFuncionario(rs.getString("NomeFuncionario"));
            f.getSetor().setCodSetor(rs.getInt("CodSetor"));
            f.getSetor().setNomeSetor(rs.getString("NomeSetor"));
            retorno.add(f);
        }
        stmt.close();

        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    }

    /**
     *
     * @param fun
     * @throws Exception
     */
    @Override
    public void alterarFuncionario(Funcionario fun) throws Exception {
        //abrindo a conexão
        Connection conn = super.conectarPrepareStatment();

        //instrução sql correspondente a inserção do aluno
        String sql = "UPDATE Funcionario SET NomeFuncionario = ?,CodSetor = ? where Matricula = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);

        // preenche os valores
        stmt.setString(1, fun.getNomeFuncionario());
        stmt.setInt(2, fun.getSetor().getCodSetor());
        stmt.setInt(3, fun.getMatricula());

        // executa
        stmt.execute();
        stmt.close();

        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    /**
     *
     * @param fun
     * @throws Exception
     */
    @Override
    public void removerFuncionario(Funcionario fun) throws Exception {
        //abrindo a conexão
        Connection conn = super.conectarPrepareStatment();

        //instrução sql correspondente a remover funcionário
        String sql = "delete from funcionario where matricula = ? ";
        PreparedStatement stmt = conn.prepareStatement(sql);

        // preenche os valores
        stmt.setInt(1, fun.getMatricula());

        // executa
        stmt.execute();
        stmt.close();

        //fechando a conexão com o banco de dados
        super.desconectar();
    }

}
