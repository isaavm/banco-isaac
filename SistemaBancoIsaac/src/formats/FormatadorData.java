/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formats;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Isaac
 */
public class FormatadorData {    
    private SimpleDateFormat formatador; 

    public FormatadorData() {
        this.formatador=new SimpleDateFormat("dd/MM/yyyy");
    }
    
    public Date convertToDate(String data) throws ParseException{
        return formatador.parse(data);
    }
    
    public String convertToString(Date data){
        return formatador.format(data);
    }
    
}
