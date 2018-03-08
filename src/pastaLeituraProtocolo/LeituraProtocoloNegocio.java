/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pastaLeituraProtocolo;

import java.util.ArrayList;
import pastaProtocolo.Protocolo;

/**
 *
 * @author aluno
 */
public class LeituraProtocoloNegocio implements InterfaceLeituraProtocolo {

    @Override
    public void gerarLeituraProtocolo(LeituraProtocolo lP) throws Exception {
        LeituraProtocoloDados lPDados = new LeituraProtocoloDados();
        lPDados.gerarLeituraProtocolo(lP);
    }

    @Override
    public ArrayList<LeituraProtocolo> listaLeituraProtocolo(Protocolo p) throws Exception {
       LeituraProtocoloDados lPDados = new LeituraProtocoloDados();
       lPDados.listaLeituraProtocolo(p);
       
        return null;
    }
    
    
}
