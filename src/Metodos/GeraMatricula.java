/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Views.CadAluno;
import Views.CadMatriculas;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author suporte
 */
public class GeraMatricula {

    public void convertMatricula(CadMatriculas a) {

        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat novaData = new SimpleDateFormat("yyyyHHmmss");

        String matricula = novaData.format(data);

        a.txtMatricula.setText(matricula);

    }
    public void convertMatricula(CadAluno a) {

        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat novaData = new SimpleDateFormat("yyyyHHmmss");

        String matricula = novaData.format(data);

        //a.txtMatricula.setText(matricula);

    }

}
