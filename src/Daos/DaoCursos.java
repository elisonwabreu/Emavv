package Daos;

import java.util.List;
import java.sql.SQLException;
import Messages.Cmessage;
import org.entities.classes.tb_cursos;
import ConnectionFactory.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoCursos {

    //Metodo para inserir um curso
    Cmessage msg = new Cmessage();
    EntityManager manager = JPAUtil.getEntityManager();

    public boolean Inserir(tb_cursos a) throws SQLException {
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
    //Metodo para deletar um curso

    public boolean Delete(int codigo) throws SQLException {

        if (msg.MsgConfExclusao() == true) {
            tb_cursos curso = (tb_cursos) manager.find(tb_cursos.class, codigo);
            curso.setFd_status("E");
            manager.getTransaction().begin();
            manager.persist(curso);
            manager.getTransaction().commit();
            manager.close();
            return true;
        }
        return false;

    }
    //Metodo para sele��o de um curso

    public List<tb_cursos> Select(int codigo) throws SQLException {

        Query q = manager.createQuery("select a from tb_cursos a where "
                + "a.td_curso = :td_curso");
        q.setParameter("td_curso", codigo);
        List<tb_cursos> curso = q.getResultList();
        return curso;
    }

    public List<tb_cursos> Select(String descricao) throws SQLException {
        String jpql = "";

        if (descricao.equals("")) {
            jpql = "select a from tb_cursos a";
        } else {
            jpql = "select a from tb_cursos a where a.fd_descricao "
                    + "like :fd_descricao";
        }

        Query q = manager.createQuery(jpql);

        if (descricao.equals("")) {

        } else {
            q.setParameter("fd_descricao", "%" + descricao + "%");
        }

        List<tb_cursos> curso = q.getResultList();
        return curso;
    }

    public boolean Update(tb_cursos a, String status) throws SQLException {
        if (msg.MsgConfGravacao() == true) {

            tb_cursos curso = (tb_cursos) manager.find(tb_cursos.class, a.getFd_curso());

            curso.setFd_descricao(a.getFd_descricao());
            curso.setFd_valor(a.getFd_valor());
            curso.setFd_status(a.getFd_status());
            manager.getTransaction().begin();
            manager.persist(curso);
            manager.getTransaction().commit();
            manager.close();
            msg.msgGravado();
            return true;
        } else {
            return false;
        }
    }
}
