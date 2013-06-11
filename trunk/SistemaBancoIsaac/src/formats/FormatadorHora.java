/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formats;

import java.sql.Time;
import java.text.SimpleDateFormat;

/**
 *
 * @author Isaac
 */
public class FormatadorHora {
    SimpleDateFormat formatador;

    public FormatadorHora() {
        this.formatador = new SimpleDateFormat("HH:mm:ss");
    }
    
    public String timeToHours(Time hora){
        return formatador.format(hora);
    }
    
    public Time hoursToTime(String hora){
        return Time.valueOf(hora);
    }
}
