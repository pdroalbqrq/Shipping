/*
 *
 */
package pastaProtocolo;

import conexao.Dados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 * @author Jerson e Pedro
 */
public class ProtocoloDados extends Dados implements InterfaceProtocolo {

    @Override
    public void gerarProtocolo(Protocolo protoc) throws Exception {
        //abrindo a conexão
        Connection conn = super.conectarPrepareStatment();

        //instrução sql correspondente a criação de novo protocolo
        String sql = "INSERT INTO Protocolo (dataHoraProtocolo, titulo, link, matriculaEmi, matriculaDes)";
        sql += "VALUES (getdate(),?,?,?,?)";
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
    public ArrayList<Protocolo> listarProtocolo() throws Exception {
        ArrayList<Protocolo> retorno = new ArrayList<Protocolo>();
        //abrindo a conexão
        Connection conn = super.conectarPrepareStatment();

        //instrução sql correspondente a listar tabela Protocolo
        String sql = " select protoc.idEnvio, protoc.matriculaEmi, funE.NomeFuncionario, protoc.dataHoraProtocolo, protoc.matriculaDes, funD.NomeFuncionario, titulo, link ";
        sql += "from Protocolo as protoc ";
        sql += "inner join Funcionario as funD ";
        sql += "on funD.Matricula = protoc.matriculaDes ";
        sql += "inner join  Funcionario as funE ";
        sql += "on funE.Matricula = protoc.matriculaEmi ";
        PreparedStatement stmt = conn.prepareStatement(sql);

        // executa
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Protocolo p = new Protocolo();
            p.setIdEnvio(rs.getInt("idEnvio"));
            p.getEmissario().setMatricula(rs.getInt("matriculaEmi"));
            p.getEmissario().setNomeFuncionario(rs.getString("nomeFuncionario"));
            p.getDestinatario().setMatricula(rs.getInt("matriculaDes"));
            p.getDestinatario().setNomeFuncionario(rs.getString("nomeFuncionario"));
            p.setDataProtocolo(rs.getString("dataHoraProtocolo"));
            p.setHoraProtocolo(rs.getString("dataHoraProtocolo"));
            p.setTitulo(rs.getString("titulo"));
            p.setLink(rs.getString("link"));
            retorno.add(p);
        }
        stmt.close();

        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    }

}
