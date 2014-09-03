package Daos;

import ConnectionFactory.JPAUtil;
import Messages.Cmessage;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.entities.classes.Alunos;
import org.entities.classes.Matriculados;



public class DaoMatriculados {
Cmessage msg = new Cmessage();
    EntityManager manager = JPAUtil.getEntityManager();

    public boolean Inserir(Matriculados a) throws SQLException {
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

    public List<Matriculados> Select(int codigo) throws SQLException {
        
        Alunos aluno = new Alunos();
        aluno.setFd_aluno(codigo);
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Matriculados> q = cb.createQuery(Matriculados.class);
        Root<Matriculados> m = q.from(Matriculados.class);
        ParameterExpression<Alunos> p = cb.parameter(Alunos.class);
        Predicate predicate = cb.equal(m.<Alunos> get("fd_aluno"), p);
        q.select(m).where(predicate);
        TypedQuery<Matriculados> query = manager.createQuery(q);
        query.setParameter(p, aluno);
        List<Matriculados> ListMatri = query.getResultList();
        return ListMatri;
    }

    public void Update() throws SQLException {

        
    }
}
