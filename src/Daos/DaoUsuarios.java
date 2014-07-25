package Daos;

import ConnectionFactory.JPAUtil;
import Messages.Cmessage;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.entities.classes.Usuarios;

public class DaoUsuarios extends Usuarios {

    Cmessage msg = new Cmessage();

    EntityManager manager = JPAUtil.getEntityManager();

    public boolean Inserir(Usuarios user) throws SQLException {
        if (msg.MsgConfGravacao() == true) {

            manager.getTransaction().begin();
            manager.persist(user);
            manager.getTransaction().commit();
            msg.msgGravado();

            return true;
        } else {

            return false;

        }

    }

    public List<Usuarios> Select(String login) throws SQLException {
        Query q = manager.createQuery("select a from tb_usuarios as a "
                + "where a.fd_login = :fd_login and a.fd_status <> 'E'");
        q.setParameter("fd_login", login);
        List<Usuarios> user = q.getResultList();
        return user;

    }

    public List<Usuarios> Select(int codigo) throws SQLException {
        Query q = manager.createQuery("select a from tb_usuarios as a "
                + "where a.fd_funcionario = :fd_funcionario and a.fd_status <> 'E'");
        q.setParameter("fd_funcionario", codigo);
        List<Usuarios> user = q.getResultList();
        return user;

    }

    public boolean Delete(int codigo) throws SQLException {
        if (msg.MsgConfExclusao() == true) {
            Usuarios user = (Usuarios) manager.find(Usuarios.class, codigo);
            user.setFd_status("E");
            manager.getTransaction().begin();
            manager.persist(user);
            manager.getTransaction().commit();
            manager.close();
            return true;
        }
        return false;
    }

    public boolean Update(Usuarios a, String status) throws SQLException {

        if (msg.MsgConfGravacao() == true) {

            Usuarios user = (Usuarios) manager.find(Usuarios.class, a.getFd_funcionario());

            user.setFd_login(a.getFd_login());
            user.setFd_senha(a.getFd_senha());
            manager.getTransaction().begin();
            manager.persist(user);
            manager.getTransaction().commit();
            manager.close();
            msg.msgGravado();
            return true;
        } else {
            return false;
        }

    }
}
