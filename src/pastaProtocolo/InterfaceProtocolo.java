/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pastaProtocolo;

import java.util.ArrayList;
import pastaFuncionario.Funcionario;

/*
 * @author Jerson e Pedro
 */
public interface InterfaceProtocolo {
    void gerarProtocolo(Protocolo protoc) throws Exception;

    ArrayList<Protocolo> listarProtocoloRecebido(Funcionario f) throws Exception;
    ArrayList<Protocolo> listarProtocoloEnviados(Funcionario f) throws Exception;
      
}

