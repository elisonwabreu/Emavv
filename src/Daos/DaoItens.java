package Daos;

import ConnectionFactory.JPAUtil;
import Messages.Cmessage;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.entities.classes.tb_itens;

public class DaoItens {

    Cmessage msg = new Cmessage();

    EntityManager manager = JPAUtil.getEntityManager();

    public boolean Inserir(tb_itens a) throws SQLException {

        if (msg.MsgConfGravacao() == true) {
            manager.getTransaction().begin();
            manager.persist(a);
            manager.getTransaction().commit();
            msg.msgGravado();
            msg.msgGravado();
            return true;
        } else {

            return false;

        }
    }

    public boolean Delete(int codigo) throws SQLException {

        if (msg.MsgConfExclusao() == true) {
            tb_itens itens = (tb_itens) manager.find(tb_itens.class, codigo);
            itens.setFd_status("E");
            manager.getTransaction().begin();
            manager.persist(itens);
            manager.getTransaction().commit();
            manager.close();
            return true;
        }
        return false;
    }

    public List<tb_itens> Select(int codigo) throws SQLException {

        Query q = manager.createQuery("select a from tb_itens as a "
                + "where a.fd_nome like :fd_nome and a.fd_status <> 'E'");
        q.setParameter("fd_item", codigo);
        List<tb_itens> item = q.getResultList();
        return item;
    }

    public List<tb_itens> Select(String nome) throws SQLException {

        Query q = manager.createQuery("select a from tb_itens as a "
                + "where a.fd_descricao like :fd_descricao and a.fd_status <> 'E'");
        q.setParameter("fd_descricao", "%" + nome + "%");
        List<tb_itens> item = q.getResultList();
        return item;
    }

    public boolean Update(tb_itens a, String status) throws SQLException {

        if (msg.MsgConfGravacao() == true) {

            tb_itens item = (tb_itens) manager.find(tb_itens.class, a.getFd_item());

            item.setFd_descricao(a.getFd_descricao());
            item.setFd_valor(a.getFd_valor());
            item.setFd_status(a.getFd_status());
            manager.getTransaction().begin();
            manager.persist(item);
            manager.getTransaction().commit();
            manager.close();
            msg.msgGravado();
            return true;
        } else {
            return false;
        }
    }
}
