/*

 */
package pastaProtocolo;

import pastaFuncionario.Funcionario;

/*
 * @author Jerson e Pedro
 */
public class Protocolo {
    private int idEnvio;
    private String dataProtocolo;
    private String horaProtocolo;
    private String titulo;
    private String link;
    private Funcionario emissario;
    private Funcionario destinatario;
    
    public Protocolo() {
    this.emissario = new Funcionario();
    this.destinatario = new Funcionario();
       
    }
    
    /*
     * @return the idEnvio
     */
    public int getIdEnvio() {
        return idEnvio;
    }
    
    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }
    /*
     * @return the dataProtocolo
     */
    public String getDataProtocolo() {
        return dataProtocolo;
    }

    /*
     * @param dataProtocolo the dataProtocolo to set
     */
    public void setDataProtocolo(String dataProtocolo) {
        this.dataProtocolo = dataProtocolo;
    }

    /*
     * @return the horaProtocolo
     */
    public String getHoraProtocolo() {
        return horaProtocolo;
    }

    /*
     * @param horaProtocolo the horaProtocolo to set
     */
    public void setHoraProtocolo(String horaProtocolo) {
        this.horaProtocolo = horaProtocolo;
    }

    /*
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /*
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /*
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /*
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    /*
     * @return the emissario
     */
    public Funcionario getEmissario() {
        return emissario;
    }

    /*
     * @param emissario the emissario to set
     */
    public void setEmissario(Funcionario emissario) {
        this.emissario = emissario;
    }

    /*
     * @return the destinatario
     */
    public Funcionario getDestinatario() {
        return destinatario;
    }

    /*
     * @param destinatario the destinatario to set
     */
    public void setDestinatario(Funcionario destinatario) {
        this.destinatario = destinatario;
    }

    }
