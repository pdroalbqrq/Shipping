/*
 Classe responsável por alterar a tabela setor no banco de dados 
 */
package pastaSetor;

import conexao.Dados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pastaFuncionario.Funcionario;

/**
 *
 * @author Jerson e Pedro
 */
public class SetorDados extends Dados implements InterfaceSetor {

    /**
     * Método de criação de novos setores tabela: Setor
     *
     * @param setor
     * @throws Exception
     */
    @Override
    public void cadastrarSetor(Setor setor) throws Exception {
        //abrindo a conexão
        Connection conn = super.conectarPrepareStatment();
        //analisando se setor já existe
        //setar uma variavel string 

        //comparar variavel string com conteudo localizado no banco
        //buscar no banco 
        //Cria um novo Setor
        String sql = "INSERT INTO Setor (NomeSetor)";
        sql += "VALUES (?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        // preenche os valores
        stmt.setString(1, setor.getNomeSetor());

        // executa
        stmt.execute();
        stmt.close();

        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    /**
     * Método para editar o campo NomeSetor da tabela Setor
     *
     * @param setor
     * @throws Exception
     */
    @Override
    public void alterarSetor(Setor setor) throws Exception {
        //abrindo a conexão
        Connection conn = super.conectarPrepareStatment();

        //altera campo nome na tabela setor
        String sql = "UPDATE Setor SET  NomeSetor = ? where CodSetor = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);

        // preenche os valores
        stmt.setString(1, setor.getNomeSetor());
        stmt.setInt(2, setor.getCodSetor());

        // executa
        stmt.execute();
        stmt.close();

        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    /**
     * Método para remover setor Funcionamento restrito a não utilização do
     * campo codSetor como chave estrangeira
     *
     * @param setor
     * @throws Exception
     */
    @Override
    public void removerSetor(Setor setor) throws Exception {
        //abrindo a conexão
        Connection conn = super.conectarPrepareStatment();

        //Remove setor caso não possua ligação por chave estrangeira
        String sql = "delete from setor where CodSetor = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        // preenche os valores
        stmt.setInt(1, setor.getCodSetor());

        // executa
        stmt.execute();
        stmt.close();

        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    /**
     * Método para selecionar e listar os setores
     *
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<Setor> listarSetor() throws Exception {
        ArrayList<Setor> retorno = new ArrayList<Setor>();
        //abrindo a conexão
        Connection conn = super.conectarPrepareStatment();
        //instrução sql correspondente selecionar as dados da tabela Setor
        String sql = " select codSetor, nomeSetor from setor ";
        sql += " ORDER BY nomeSetor ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        // executa
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Setor s = new Setor();
            s.setCodSetor(rs.getInt("codSetor"));
            s.setNomeSetor(rs.getString("nomeSetor"));
            retorno.add(s);
        }
        stmt.close();
        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    }

public boolean verificarDuplicidadeNome (Setor s) throws Exception {
        boolean retorno = false;
        //abrindo a conexão
        Connection conn = super.conectarPrepareStatment();
        //instrução sql correspondente selecionar as dados da tabela Setor
        String sql = " select codSetor, nomeSetor ";
        sql += " from setor ";
        sql += " where nomeSetor = ? ";
        PreparedStatement stmt = conn.prepareStatement(sql); 
        // preenche os valores
        stmt.setString(1, s.getNomeSetor());
        // executa
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            retorno = true;
            break;
        }
        stmt.close();
        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    }
}
