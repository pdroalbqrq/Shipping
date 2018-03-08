/*
 
 */
package pastaLeituraProtocolo;

import java.util.ArrayList;
import pastaProtocolo.Protocolo;

/*
 * @author Jerson e Pedro
 */

/**
 *
 * @author jerson
 */

public interface InterfaceLeituraProtocolo {

    /**
     *
     * @param lP
     * @throws Exception
     */
    void gerarLeituraProtocolo(LeituraProtocolo lP) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    ArrayList<LeituraProtocolo> listaLeituraProtocolo(Protocolo p) throws Exception;
}
