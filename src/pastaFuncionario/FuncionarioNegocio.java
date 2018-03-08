/*

 */
package pastaFuncionario;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import pastaUtil.Util;

/**
 *
 * @author aluno
 */
public class FuncionarioNegocio implements InterfaceFuncionario {

    @Override
    public void cadastrarFuncionario(Funcionario funcionario) throws Exception {
        Util.validarTexto(funcionario.getNomeFuncionario(), "Nome", 5, 50);
        FuncionarioDados sd = new FuncionarioDados();
        if (Util.apenasTexto(funcionario.getNomeFuncionario()) == true) {
            sd.cadastrarFuncionario(funcionario);
            JOptionPane.showMessageDialog(null, "Funcionário Cadastrado");
        } else {
        JOptionPane.showMessageDialog(null, "Nome inválido");
        }
    }

    @Override
    public void alterarFuncionario(Funcionario funcionario) throws Exception {
        Util.validarTexto(funcionario.getNomeFuncionario(), "Nome", 5, 50);
        FuncionarioDados sd = new FuncionarioDados();
         if (Util.apenasTexto(funcionario.getNomeFuncionario()) == true) {
        sd.alterarFuncionario(funcionario);
        JOptionPane.showMessageDialog(null, "Funcionário Alterado");
         } else {
        JOptionPane.showMessageDialog(null, "Nome inválido");
        }
    }

    @Override
    public Funcionario verificarLogin(Funcionario fun) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerFuncionario(Funcionario fun) throws Exception {
         FuncionarioDados fD = new FuncionarioDados();
         fD.removerFuncionario(fun);
         
    }

    @Override
    public ArrayList<Funcionario> listarFuncionario() throws Exception {
        return listarFuncionario();
    }

}
