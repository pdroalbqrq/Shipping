/*
 *Classe responsável por 
 */
package pastaLeituraProtocolo;

import pastaProtocolo.Protocolo;

/*
 * @author Jerson e Pedro
 */
public class LeituraProtocolo {

    private String data;
    private String hora;
    private int idAcesso;
    private String referenciaProtocolo;
    private Protocolo protocolo;
    private int qtdLeitura;

    public LeituraProtocolo() {
        this.protocolo = new Protocolo();
        
    
    }

    /*
     * @return the data
     */
    public String getData() {
        return data;
    }

    /*
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /*
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /*
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /*
     * @return the idAcesso
     */
    public int getIdAcesso() {
        return idAcesso;
    }

    /*
     * @param idAcesso the idAcesso to set
     */
    public void setIdAcesso(int idAcesso) {
        this.idAcesso = idAcesso;
    }

    /*
     * @return the referenciaProtocolo
     */
    public String getReferenciaProtocolo() {
        return referenciaProtocolo;
    }

    /*
     * @param referenciaProtocolo the referenciaProtocolo to set
     */
    public void setReferenciaProtocolo(String referenciaProtocolo) {
        this.referenciaProtocolo = referenciaProtocolo;
    }

    /**
     * @return the protocolo
     */
    public Protocolo getProtocolo() {
        return protocolo;
    }

    /**
     * @param protocolo the protocolo to set
     */
    public void setProtocolo(Protocolo protocolo) {
        this.protocolo = protocolo;
    }

    /**
     * @return the qtdLeitura
     */
    public int getQtdLeitura() {
        return qtdLeitura;
    }

    /**
     * @param qtdLeitura the qtdLeitura to set
     */
    public void setQtdLeitura(int qtdLeitura) {
        this.qtdLeitura = qtdLeitura;
    }


}
