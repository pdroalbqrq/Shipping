/*

 */
package pastaSetor;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import pastaUtil.Util;

/**
 *
 * @author Jerson e Pedro
 */
public class SetorNegocio implements InterfaceSetor {

    @Override
    public void cadastrarSetor(Setor setor) throws Exception {
        Util.validarTexto(setor.getNomeSetor(), "Nome", 5, 50);
        SetorDados sd = new SetorDados();
        
        if (sd.verificarDuplicidadeNome(setor) == true) {
            throw new Exception("Este Setor já existe");
        } else {JOptionPane.showMessageDialog(null, "Setor Cadastrado");}
        sd.cadastrarSetor(setor);

    }

    @Override
    public void alterarSetor(Setor setor) throws Exception {
        Util.validarTexto(setor.getNomeSetor(), "Nome", 5, 50);
        SetorDados sd = new SetorDados();
        if (sd.verificarDuplicidadeNome(setor) == true) {
            throw new Exception("Este Setor já existe");
        }
        sd.cadastrarSetor(setor);
    }

    @Override
    public void removerSetor(Setor setor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Setor> listarSetor() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
