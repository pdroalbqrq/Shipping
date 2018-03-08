/*
Classe Principal
Contem Testes Comentados
 */


import javax.swing.JOptionPane;

/**
 *
 * @author Jerson e Pedro
 */
public class ShippingTeste {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        try {
            /*teste*/
//            Protocolo p = new Protocolo();
//            p.setIdEnvio(100001);
//            LeituraProtocolo leituraP = new LeituraProtocolo();//instancia Leitura de Protocolo
//            LeituraProtocoloDados dadosL = new LeituraProtocoloDados();//instancia Dados de Leitura de Protocolo         
//            {
//                //cria Leitura Protocolo
//                leituraP.setReferenciaProtocolo("teste2");
//                leituraP.getProtocolo().setIdEnvio(100001);
//                dadosL.gerarLeituraProtocolo(leituraP);
//            }
//            {//lista Leitura de Protocolos
//                ArrayList<LeituraProtocolo> listaLeituraProtocolo = dadosL.listaLeituraProtocolo(p);
//                for (LeituraProtocolo listaP : listaLeituraProtocolo) {
//                    String mensagem = "";
//                    mensagem += " Acessos " + listaP.getQtdLeitura();
//                    System.out.println(mensagem);
//                }
//            }
//            /*Protocolo*/
//            Protocolo protoc = new Protocolo();//instancia Protocolo
//            ProtocoloDados dadosP = new ProtocoloDados();//instancia Dados de Funcionário
//            /*teste*/ {
//                protoc.getEmissario().setMatricula(201030);
//                protoc.getDestinatario().setMatricula(301020);
//                protoc.setTitulo("Redes Sociais");
//                protoc.setLink("facebook.com");
//            }
//            dadosP.gerarProtocolo(protoc);//cria protocolo
//            {//lista protocolos
//                ArrayList<Protocolo> listaProtoc = dadosP.listarProtocolo();
//                for (Protocolo lP : listaProtoc) {
//                    String mensagem = "";
//                    mensagem += " ID: " + lP.getIdEnvio();
//                    mensagem += " Matricula Emitente: " + lP.getEmissario().getMatricula();
//                    mensagem += " Nome Emitente: " + lP.getEmissario().getNomeFuncionario();
//                    mensagem += " Matricula Destinatário: " + lP.getDestinatario().getMatricula();
//                    mensagem += " Nome Destinatário: " + lP.getDestinatario().getNomeFuncionario();
//                    mensagem += " Data: " + lP.getDataProtocolo();
//                    mensagem += " Hora: " + lP.getHoraProtocolo();
//                    mensagem += " Título: " + lP.getTitulo();
//                    mensagem += " Conetúdo: " + lP.getLink();
//                    System.out.println(mensagem);
//                }
//            }
//            /*funcionario*/
//            Funcionario fun = new Funcionario();//instancia Funcionário
//            FuncionarioDados dadosF = new FuncionarioDados();//instancia Dados de Funcionário
//            /*teste*/ {
//                fun.getSetor().setCodSetor(2);
//                fun.setMatricula(123226);
//                fun.setNomeFuncionario("Melo Semi Deus");
//            }
//            dadosF.cadastrarFuncionario(fun);//cadastra funcionário
//            dadosF.alterarFuncionario(fun);//altera funcionário
//            {//lista funcionários
//                ArrayList<Funcionario> listaFunc = dadosF.listarFuncionario();
//                for (Funcionario f1 : listaFunc) {
//                    String mensagem = "";
//                    mensagem += " Matricula: " + f1.getMatricula();
//                    mensagem += " Nome: " + f1.getNomeFuncionario();
//                    mensagem += " Cod Setor: " + f1.getSetor().getCodSetor();
//                    mensagem += " Setor: " + f1.getSetor().getNomeSetor();
//                    System.out.println(mensagem);
//                }
//            }
//            /*setor*/
//            SetorDados dadosS = new SetorDados();//instancia Dados de Setor
//            Setor setor = new Setor();//instancia Setor
//            /*teste*/ {
//                setor.setCodSetor(3);
//                setor.setNomeSetor("Informática");
//            }
//            dadosS.cadastrarSetor(setor);//cria setor
//            dadosS.alterarSetor(setor);//altera setor
//            dadosS.removerSetor(setor);//remove setor
//            {//lista setor
//                ArrayList<Setor> lista = dadosS.listarSetor();
//                for (Setor s1 : lista) {
//                    String mensagem = "";
//                    mensagem += "Código: " + s1.getCodSetor();
//                    mensagem += " Nome: " + s1.getNomeSetor();
//                    System.out.println(mensagem);
//               }

            /*Mensagem de sucesso*/
            JOptionPane.showMessageDialog(null, "Cadastrado");

        } catch (Exception ex) {
            /*Mensagem de erro*/
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
