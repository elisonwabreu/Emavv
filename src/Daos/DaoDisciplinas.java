package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Messages.Cmessage;
import org.entities.classes.tb_disciplinas;
import ConnectionFactory.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.entities.classes.tb_cursos;

public class DaoDisciplinas {

    Cmessage msg = new Cmessage();
    EntityManager manager = JPAUtil.getEntityManager();

    public boolean Inserir(tb_disciplinas a) throws SQLException {

        if (msg.MsgConfGravacao() == true) {
            manager.getTransaction().begin();
            manager.persist(a);
            manager.getTransaction().commit();
            manager.close();
            msg.msgGravado();
            return true;
        } else {

            return false;

        }
    }

    public void Delete() throws SQLException {

       
    }

    public List<tb_disciplinas> Select(int codigo) throws SQLException {
        return null;

        
    }

    public List<tb_disciplinas> Select(String descricao) throws SQLException {
        String jpql = "";

        if (descricao.equals("")) {
            jpql = "select a from tb_disciplinas a";
        } else {
            jpql = "select a from tb_disciplinas a where a.fd_descricao "
                    + "like :fd_descricao";
        }

        Query q = manager.createQuery(jpql);

        if (descricao.equals("")) {

        } else {
            q.setParameter("fd_descricao", "%" + descricao + "%");
        }

        List<tb_disciplinas> disc = q.getResultList();
        return disc;
    }

    public void Update() throws SQLException {

        
    }
}
