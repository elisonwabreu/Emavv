package Daos;

import java.sql.SQLException;
import java.util.List;
import Messages.Cmessage;
import org.entities.classes.tb_disciplinas;
import ConnectionFactory.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
       Query q = manager.createQuery("select a from tb_disciplinas a where "
                + "a.fd_disciplina = :fd_disciplina");
        q.setParameter("fd_disciplina", codigo);
        List<tb_disciplinas> disc = q.getResultList();
        return disc;

        
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

    public boolean UpdateDelete(int codigo) throws SQLException {

        if (msg.MsgConfExclusao()== true) {
            
            tb_disciplinas c = (tb_disciplinas) manager.find(tb_disciplinas.class,codigo);
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
