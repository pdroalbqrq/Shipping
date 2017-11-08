/*
    Interface responsável por implementar os métodos relacionados a classe funcionario
 */
package pastaFuncionario;

import java.util.ArrayList;

/*
 * @author Jerson e Pedro
 */

/**
 *
 * @author jerson
 */

public interface InterfaceFuncionario {

    /**
     *
     * @param fun
     * @return
     * @throws Exception
     */
    Funcionario verificarLogin(Funcionario fun) throws Exception;

    /**
     *
     * @param fun
     * @throws Exception
     */
    void cadastrarFuncionario(Funcionario fun) throws Exception;

    /**
     *
     * @param fun
     * @throws Exception
     */
    void alterarFuncionario(Funcionario fun) throws Exception;

    /**
     *
     * @param fun
     * @throws Exception
     */
    void removerFuncionario(Funcionario fun) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    ArrayList<Funcionario> listarFuncionario()throws Exception;

}
