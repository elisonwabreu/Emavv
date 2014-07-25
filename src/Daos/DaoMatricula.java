package Daos;

import ConnectionFactory.JPAUtil;
import Messages.Cmessage;
import Views.CadMatriculas;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.entities.classes.Alunos;
import org.entities.classes.Cursos;
import org.entities.classes.Matriculados;
import org.entities.classes.Matriculas;

public class DaoMatricula {

    Cmessage msg = new Cmessage();
    EntityManager manager = JPAUtil.getEntityManager();

    public boolean Inserir(Matriculas a) throws SQLException {
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

    public List<Matriculas> Select(int codigo) throws SQLException {

        Query q = manager.createQuery("select m from tb_matriculas m "
                + " where m.fd_aluno = :fd_aluno ");
        
        Alunos aluno = new Alunos();
        aluno.setFd_aluno(codigo);
        
        q.setParameter("fd_aluno", aluno);
        List<Matriculas> matricula = q.getResultList();
        return matricula;
    }
    
    public List<Matriculas> SelectMatricula(int matriculaexit) throws SQLException {

        Query q = manager.createQuery("select a from tb_matriculas a "
                + "where a.fd_matricula = :fd_matricula");
         q.setParameter("fd_matricula", matriculaexit);
        List<Matriculas> matricula = q.getResultList();
        return matricula;
    }
}
