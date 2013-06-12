/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Isaac
 */
public class FaltaPreencherCamposException extends Exception {

    public FaltaPreencherCamposException(){
        super("Preencha todos os campos!");
    }
}
