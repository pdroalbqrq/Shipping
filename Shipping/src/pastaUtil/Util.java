/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pastaUtil;

/**
 *
 * @author aluno
 */
public class Util {

    public static boolean apenasTexto(String texto) {
        return texto.matches("[^\\d]+");

    }

    public static void validarTexto(String texto, String msg, int tamanhoMin, int tamanhoMax) throws Exception {
        if (texto == null) {
            throw new Exception("Informar o(a) " + msg);
        }
        if (texto.trim().equals("")) {
            throw new Exception("Informar o(a) " + msg);
        }
        
    }
}
