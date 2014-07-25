package Daos;

import java.sql.SQLException;
import java.util.List;
import Messages.Cmessage;
import org.entities.classes.Disciplinas;
import ConnectionFactory.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoDisciplinas {

    Cmessage msg = new Cmessage();
    EntityManager manager = JPAUtil.getEntityManager();

    public boolean Inserir(Disciplinas a) throws SQLException {

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

    public List<Disciplinas> Select(int codigo) throws SQLException {
       Query q = manager.createQuery("select a from tb_disciplinas a where "
                + "a.fd_disciplina = :fd_disciplina");
        q.setParameter("fd_disciplina", codigo);
        List<Disciplinas> disc = q.getResultList();
        return disc;
    }
    public List<Disciplinas> SelectDiscCurso(int codigo) throws SQLException {
       Query q = manager.createQuery("select a from tb_disciplinas a where "
                + "a.fd_curso = :fd_curso and fd_status <> 'E'");
        q.setParameter("fd_curso", codigo);
        List<Disciplinas> disc = q.getResultList();
        return disc;

        
    }

    public List<Disciplinas> Select(String descricao) throws SQLException {
        String jpql = "";

        if (descricao.equals("")) {
            jpql = "select a from tb_disciplinas a where a.fd_status <> 'E'";
        } else {
            jpql = "select a from tb_disciplinas a where a.fd_descricao "
                    + "like :fd_descricao and a.fd_status <> 'E' ";
        }

        Query q = manager.createQuery(jpql);

        if (descricao.equals("")) {

        } else {
            q.setParameter("fd_descricao", "%" + descricao + "%");
        }

        List<Disciplinas> disc = q.getResultList();
        return disc;
    }

    public boolean UpdateDelete(int codigo) throws SQLException {

        if (msg.MsgConfExclusao()== true) {
            
            Disciplinas c = (Disciplinas) manager.find(Disciplinas.class,codigo);
            try{
            manager.getTransaction().begin();
             c.setFd_status("E");
            manager.getTransaction().commit();
           // manager.close();
            }catch(Exception e){
                manager.getTransaction().rollback();
            }
            msg.msgExcluido();
                
            return true;
            
        } else {
            return false;
        }
    }
}
