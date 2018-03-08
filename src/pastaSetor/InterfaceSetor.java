/*
    Interface responsável por implementar os métodos das classes relacionadas a Setor
 */
package pastaSetor;

import java.util.ArrayList;

/**
 *
 * @author Jerson e Pedro
 */
public interface InterfaceSetor {

   

    void cadastrarSetor(Setor setor) throws Exception;

    void alterarSetor(Setor setor) throws Exception;

    void removerSetor(Setor setor) throws Exception;

    ArrayList<Setor> listarSetor() throws Exception;
}
