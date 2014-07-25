package org.entities.classes;

import java.sql.SQLException;
import java.util.ArrayList;

import Daos.DaoCargo;

public class Consultas {

    @SuppressWarnings("rawtypes")
    public ArrayList ConsultaCargo(int codigo, String descricao, String status) throws SQLException {

        DaoCargo c = new DaoCargo();

        ArrayList retorno = new ArrayList();

        //retorno = (ArrayList<Cargos>) c.Select(codigo, descricao, status);
        return retorno;
    }
}
