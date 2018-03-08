/*

 */
package pastaProtocolo;

import java.sql.Date;
import pastaFuncionario.Funcionario;
import pastaSetor.Setor;

/*
 * @author Jerson e Pedro
 */
public class Protocolo {

    private int idEnvio;
    private String dataProtocolo;
    private Date data;
    private String hora;
    private String titulo;
    private String link;
    private Funcionario emissario;
    private Funcionario destinatario;
    private Setor setor;

    public Protocolo() {
        this.emissario = new Funcionario();
        this.destinatario = new Funcionario();
        this.setor = new Setor();

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

    /**
     * @return the setor
     */
    public Setor getSetor() {
        return setor;
    }

    /**
     * @param setor the setor to set
     */
    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
}
