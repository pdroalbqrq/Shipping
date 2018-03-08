/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pastaProtocolo;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import pastaFuncionario.Funcionario;
import pastaUtil.Util;

/**
 *
 * @author aluno
 */
public class ProtocoloNegocio implements InterfaceProtocolo {

    @Override
    public void gerarProtocolo(Protocolo protoc) throws Exception {
        try {
            Util.validarTexto(protoc.getTitulo(), "Nome", 5, 50);
            ProtocoloDados pD = new ProtocoloDados();
            pD.gerarProtocolo(protoc);
            JOptionPane.showMessageDialog(null, "Protocolo enviado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

   
    @Override
    public ArrayList<Protocolo> listarProtocoloRecebido(Funcionario f) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Protocolo> listarProtocoloEnviados(Funcionario f) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
