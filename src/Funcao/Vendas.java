/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Funcao;

import Views.FormVendas;

/*
 * @author elisonwilson
 */
public class Vendas {
    
    public void CalcVenda(FormVendas c, double x){
    //variaveis
        int     quantidade;
        double  ValorTotal;
        double  ValorUnid;
        double  ValorGeral = x;
    //recuperação de valores
        quantidade = Integer.parseInt(c.txtQtdItem.getText());
        ValorUnid = Double.parseDouble(c.txtValorUnitario.getText());
    //calculo
        ValorTotal = (quantidade * ValorUnid);
        ValorGeral =  ValorTotal + ValorGeral;
        
        c.txtValorTotal.setText(String.valueOf(ValorTotal));
        c.txtTotalGeral.setText(String.valueOf(ValorGeral));
       
        //return ValorTotal;
    }
    
}
