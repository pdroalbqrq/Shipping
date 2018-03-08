/*
    Classe Básica Setor
 */
package pastaSetor;

import java.util.ArrayList;
import pastaFuncionario.Funcionario;

/**
 *
 * @author Jerson e Pedro
 */

public class Setor {

    private int codSetor;
    private String nomeSetor;
    private final ArrayList<Funcionario> listaFuncionarios;

    /**
     *
     */
    public Setor() {
        this.listaFuncionarios = new ArrayList<>();
        
    }

    /**
     * @return the codSetor
     */
    public int getCodSetor() {
        return codSetor;
    }

    /**
     * @param codSetor the codSetor to set
     */
    public void setCodSetor(int codSetor) {
        this.codSetor = codSetor;
    }

    /**
     * @return the nomeSetor
     */
    public String getNomeSetor() {
        return nomeSetor;
    }

    /**
     * @param nomeSetor the nomeSetor to set
     */
    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }
}
