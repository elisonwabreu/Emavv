package Daos;

import ConnectionFactory.JPAUtil;
import Messages.Cmessage;
import Views.CadMatriculas;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.entities.classes.tb_alunos;
import org.entities.classes.tb_matriculas;

public class DaoMatricula {

    Cmessage msg = new Cmessage();
    EntityManager manager = JPAUtil.getEntityManager();

    public boolean Inserir(tb_matriculas a) throws SQLException {
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

    public List<tb_matriculas> Select(int codigo) throws SQLException {

        Query q = manager.createQuery("select a from tb_matriculas a "
                + "where a.fd_aluno = :fd_aluno");
        q.setParameter("fd_aluno", codigo);
        List<tb_matriculas> matricula = q.getResultList();
        return matricula;
    }
    
    public List<tb_matriculas> SelectMatricula(int matriculaexit) throws SQLException {

        Query q = manager.createQuery("select a from tb_matriculas a "
                + "where a.fd_matricula = :fd_matricula");
         q.setParameter("fd_matricula", matriculaexit);
        List<tb_matriculas> matricula = q.getResultList();
        return matricula;
    }
}
