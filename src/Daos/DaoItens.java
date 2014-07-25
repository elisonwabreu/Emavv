package Daos;

import ConnectionFactory.JPAUtil;
import Messages.Cmessage;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.entities.classes.Itens;

public class DaoItens {

    Cmessage msg = new Cmessage();

    EntityManager manager = JPAUtil.getEntityManager();

    public boolean Inserir(Itens a) throws SQLException {

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
            Itens itens = (Itens) manager.find(Itens.class, codigo);
            itens.setFd_status("E");
            manager.getTransaction().begin();
            manager.persist(itens);
            manager.getTransaction().commit();
            manager.close();
            return true;
        }
        return false;
    }
    public boolean UpdateDelete(int codigo) throws SQLException {

        if (msg.MsgConfExclusao()== true) {
            
            Itens c = (Itens) manager.find(Itens.class,codigo);
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

    public List<Itens> Select(int codigo) throws SQLException {

        Query q = manager.createQuery("select a from tb_itens as a "
                + "where a.fd_item = :fd_item and a.fd_status <> 'E'");
        q.setParameter("fd_item", codigo);
        List<Itens> item = q.getResultList();
        return item;
    }

    public List<Itens> Select(String nome) throws SQLException {

        Query q = manager.createQuery("select a from tb_itens as a "
                + "where a.fd_descricao like :fd_descricao and a.fd_status <> 'E'");
        q.setParameter("fd_descricao", "%" + nome + "%");
        List<Itens> item = q.getResultList();
        return item;
    }

    public boolean Update(Itens a, String status) throws SQLException {

        if (msg.MsgConfGravacao() == true) {

            Itens item = (Itens) manager.find(Itens.class, a.getFd_item());

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
