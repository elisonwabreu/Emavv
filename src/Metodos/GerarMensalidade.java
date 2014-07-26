/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author elison
 */
public class GerarMensalidade {
/**
 * Classe destinada a gerar 6 meses de mensalidades, com intervalos de 30 dias
 */
    public Calendar data;
    private int dias = 30 ;
   
    public List<String> Gerar() {
 
        for (int i = 0; i < 6; i++) {
                
            List<String> sDate = new ArrayList<>();
            
            Calendar c = Calendar.getInstance();

            c.add(Calendar.DAY_OF_MONTH, dias);
            dias =( dias + 30 );
            Date data = c.getTime();

            DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            String sData = fmt.format(data);
            
            //Date mtr = java.sql.Date.valueOf(sData);

            sDate.add(sData);
   
            return sDate;    
        }
        return null;      
    }

}
