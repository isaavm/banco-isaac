/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formats;

import java.text.DecimalFormat;

/**
 *
 * @author Isaac
 */
public class FormatadorMoeda {
    private DecimalFormat formatador;

    public FormatadorMoeda() {
        formatador = new DecimalFormat("R$ ###,###,##0.00");
    }
    
    public double currencyToDouble(String moeda){
        String valor = moeda.substring(3);
        if(moeda.contains(".")){
            valor = valor.replace(".", "");
        }
        if(moeda.contains(",")){
            valor = valor.replace(",", ".");
        }
        return Double.parseDouble(valor);
    }
    
    public String doubleToCurrency(double valor){
        return formatador.format(valor);
    }
    
    
}
