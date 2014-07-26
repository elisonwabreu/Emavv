/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import ConnectionFactory.JPAUtil;
import Messages.Cmessage;
import Metodos.GerarMensalidade;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import org.entities.classes.Matriculas;
import org.entities.classes.Mensalidades;

/**
 *
 * @author elison
 */
public class DaoMensalidade {

    Cmessage msg = new Cmessage();
    EntityManager manager = JPAUtil.getEntityManager();

    public boolean Inserir(Mensalidades a) throws SQLException {
        if (msg.MsgConfGravacao() == true) {

            manager.getTransaction().begin();
            manager.persist(a);
            manager.getTransaction().commit();
            msg.msgGravado();
            return true;
        } else {
            return false;
        }
    }

}
