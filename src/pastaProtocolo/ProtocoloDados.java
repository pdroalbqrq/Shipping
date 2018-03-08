/*
 *
 */
package pastaProtocolo;

import conexao.Dados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pastaFuncionario.Funcionario;


/*
 * @author Jerson e Pedro
 */
public class ProtocoloDados extends Dados implements InterfaceProtocolo {

    private Funcionario funcionarioLogado;

    @Override
    public void gerarProtocolo(Protocolo protoc) throws Exception {
        //abrindo a conexão
        Connection conn = super.conectarPrepareStatment();
       
        //instrução sql correspondente a criação de novo protocolo
        String sql = " INSERT INTO Protocolo (data,hora, titulo, link, matriculaEmi, matriculaDes) ";
        sql += " VALUES (cast(getdate() as date),cast(getdate() as time(0)),?,?,?,?) ";
        PreparedStatement stmt = conn.prepareStatement(sql);

        // preenche os valores
        stmt.setString(1, protoc.getTitulo());
        stmt.setString(2, protoc.getLink());
        stmt.setInt(3, protoc.getEmissario().getMatricula());
        stmt.setInt(4, protoc.getDestinatario().getMatricula());

        // executa
        stmt.execute();
        stmt.close();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    @Override
    public ArrayList<Protocolo> listarProtocoloRecebido(Funcionario f) throws Exception {
        ArrayList<Protocolo> retorno = new ArrayList<Protocolo>();
        //abrindo a conexão
        Connection conn = super.conectarPrepareStatment();
        //instrução sql correspondente a listar tabela Protocolo
        this.funcionarioLogado = f;
        String sql = " select protoc.idEnvio, protoc.matriculaEmi, protoc.data, protoc.Hora, protoc.matriculaDes, ";
        sql += " protoc.titulo, protoc.link,";
        sql += " funE.NomeFuncionario as nomefuncionario,  ";
        sql += " funD.NomeFuncionario as nomedestinatario, ";
        sql += " setr.CodSetor,setr.NomeSetor as nomesetor ";
        sql += " from Protocolo as protoc ";
        sql += " inner join Funcionario as funD ";
        sql += " on funD.Matricula = protoc.matriculaDes ";
        sql += " inner join Funcionario as funE ";
        sql += " on funE.Matricula = protoc.matriculaEmi ";
        sql += " inner join Setor as setr ";
        sql += " on setr.CodSetor = funE.CodSetor ";
        sql += " where protoc.matriculaDes = " + f.getMatricula() + ";";
        PreparedStatement stmt = conn.prepareStatement(sql);
        // executa
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Protocolo p = new Protocolo();
            p.setIdEnvio(rs.getInt("idEnvio"));
            p.getEmissario().setMatricula(rs.getInt("matriculaEmi"));
            p.setData(rs.getDate("data"));
            p.setHora(rs.getString("hora"));
            p.getDestinatario().setMatricula(rs.getInt("matriculaDes"));
            p.setTitulo(rs.getString("titulo"));
            p.setLink(rs.getString("link"));
            p.getEmissario().setNomeFuncionario(rs.getString("nomeFuncionario"));
            p.getDestinatario().setNomeFuncionario(rs.getString("nomeDestinatario"));
            p.getSetor().setCodSetor(rs.getInt("CodSetor"));
            p.getSetor().setNomeSetor(rs.getString("nomesetor"));
            p.getEmissario().setSetor(p.getSetor());
            retorno.add(p);
        }
        stmt.close();
        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    }

    @Override
    public ArrayList<Protocolo> listarProtocoloEnviados(Funcionario f) throws Exception {

        ArrayList<Protocolo> retorno = new ArrayList<Protocolo>();

        //abrindo a conexão
        Connection conn = super.conectarPrepareStatment();

        //instrução sql correspondente a listar tabela Protocolo
        this.funcionarioLogado = f;
        String sql = " select protoc.idEnvio, protoc.matriculaEmi, protoc.data, protoc.Hora, protoc.matriculaDes, ";
        sql += " protoc.titulo, protoc.link,";
        sql += " funE.NomeFuncionario as nomefuncionario,  ";
        sql += " funD.NomeFuncionario as nomedestinatario, ";
        sql += " setr.CodSetor,setr.NomeSetor as nomesetor ";
        sql += " from Protocolo as protoc ";
        sql += " inner join Funcionario as funD ";
        sql += " on funD.Matricula = protoc.matriculaDes ";
        sql += " inner join Funcionario as funE ";
        sql += " on funE.Matricula = protoc.matriculaEmi ";
        sql += " inner join Setor as setr ";
        sql += " on setr.CodSetor = funD.CodSetor ";
        sql += " where protoc.matriculaEmi = " + f.getMatricula() + ";";

        PreparedStatement stmt = conn.prepareStatement(sql);

        // executa
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
           Protocolo p = new Protocolo();
            p.setIdEnvio(rs.getInt("idEnvio"));
            p.getEmissario().setMatricula(rs.getInt("matriculaEmi"));
            p.setData(rs.getDate("data"));
            p.setHora(rs.getString("hora"));
            p.getDestinatario().setMatricula(rs.getInt("matriculaDes"));
            p.setTitulo(rs.getString("titulo"));
            p.setLink(rs.getString("link"));
            p.getEmissario().setNomeFuncionario(rs.getString("nomeFuncionario"));
            p.getDestinatario().setNomeFuncionario(rs.getString("nomeDestinatario"));
            p.getSetor().setCodSetor(rs.getInt("CodSetor"));
            p.getSetor().setNomeSetor(rs.getString("nomesetor"));
            p.getDestinatario().setSetor(p.getSetor());
            retorno.add(p);
        }
        stmt.close();

        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    }

}
