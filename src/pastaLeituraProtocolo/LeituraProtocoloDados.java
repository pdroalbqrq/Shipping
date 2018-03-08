/*

 */
package pastaLeituraProtocolo;

import conexao.Dados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pastaProtocolo.Protocolo;

/**
 *
 * @author Jerson e Pedro
 */
public class LeituraProtocoloDados extends Dados implements InterfaceLeituraProtocolo {

    private Protocolo protocSelect;

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
        String sql = " insert into LeituraProtocolo (dataLeitura,HoraLeitura,referenciaProtocolo,idEnvio) ";
        sql += " values ( cast(getdate() as date),cast(getdate() as time(0)),?,?) ";
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
    public ArrayList<LeituraProtocolo> listaLeituraProtocolo(Protocolo p) throws Exception {
        ArrayList<LeituraProtocolo> retorno = new ArrayList<LeituraProtocolo>();
        protocSelect = p;
        int idEnvio = p.getIdEnvio();
        //abrindo a conexão
        Connection conn = super.conectarPrepareStatment();

        //instrução sql correspondente a listar tabela Leitura de Protocolo
        String sql = " SELECT COUNT(idAcesso) AS 'qntAcessos' FROM LeituraProtocolo ";
        sql += " WHERE idEnvio =" + idEnvio + ";";
        PreparedStatement stmt = conn.prepareStatement(sql);

        // executa
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            LeituraProtocolo lP = new LeituraProtocolo();
            lP.setQtdLeitura(rs.getInt("qntAcessos"));
            retorno.add(lP);
        }
        stmt.close();

        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    }
}
