/*

 */
package pastaLeituraProtocolo;

import conexao.Dados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jerson e Pedro
 */
public class LeituraProtocoloDados extends Dados implements InterfaceLeituraProtocolo {

    /**
     *
     * @param lP
     * @throws Exception
     */
    @Override
    public void gerarLeituraProtocolo(LeituraProtocolo lP) throws Exception {
        //abrindo a conexão
        Connection conn = super.conectarPrepareStatment();

        //instrução sql correspondente a criação de nova Leitura Protocolo
        String sql = "insert into LeituraProtocolo (dataHoraLeitura, referenciaProtocolo, idEnvio)";
        sql += "VALUES (getdate(),?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        // preenche os valores
        stmt.setString(1, lP.getReferenciaProtocolo());
        stmt.setInt(2, lP.getProtocolo().getIdEnvio());

        // executa
        stmt.execute();
        stmt.close();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    /**
     *
     * @return @throws Exception
     */
    @Override
    public ArrayList<LeituraProtocolo> listaLeituraProtocolo() throws Exception {
        ArrayList<LeituraProtocolo> retorno = new ArrayList<LeituraProtocolo>();
        //abrindo a conexão
        Connection conn = super.conectarPrepareStatment();

        //instrução sql correspondente a listar tabela Leitura de Protocolo
        String sql = " select idAcesso, referenciaProtocolo, idEnvio, dataHoraLeitura ";
        sql += " from leituraProtocolo ";
        PreparedStatement stmt = conn.prepareStatement(sql);

        // executa
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            LeituraProtocolo lP = new LeituraProtocolo();
            lP.setIdAcesso(rs.getInt("idAcesso"));
            lP.setReferenciaProtocolo(rs.getString("referenciaProtocolo"));
            lP.getProtocolo().setIdEnvio(rs.getInt("idEnvio"));
            lP.setData(rs.getString("dataHoraLeitura"));
            lP.setHora(rs.getString("dataHoraLeitura"));

            retorno.add(lP);
        }
        stmt.close();

        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    }
}
