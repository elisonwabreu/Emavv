package Daos;

import ConnectionFactory.JPAUtil;
import Messages.Cmessage;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


import org.entities.classes.tb_usuarios;

public class DaoUsuarios extends tb_usuarios {
    Cmessage msg = new Cmessage();
    
    EntityManager manager = JPAUtil.getEntityManager();

    public boolean Inserir(tb_usuarios user) throws SQLException {
        if(msg.MsgConfGravacao() == true){
            
            manager.getTransaction().begin();
            manager.persist(user);
            manager.getTransaction().commit();
            msg.msgGravado();
                       
        return true;
        }else{
        
            return false;
            
        }
       
    }

    public List<tb_usuarios> Select(String login) throws SQLException {
        Query q = manager.createQuery("select a from tb_usuarios as a "
                                              + "where a.fd_login like :fd_login and a.fd_status <> 'E'");
        q.setParameter("fd_funcionario",login);
        List<tb_usuarios> user = q.getResultList();
        return user;
        
    }
    public boolean Delete(int codigo) throws SQLException {
        if(msg.MsgConfExclusao() == true){
                    tb_usuarios user = (tb_usuarios)manager.find(tb_usuarios.class,codigo);
                    user.setFd_status("E");
                    manager.getTransaction().begin();
                    manager.persist(user);
                    manager.getTransaction().commit();
                    manager.close(); 
                    return true;
                } 
                return false;
    }
        
    public boolean Update(tb_usuarios a , String status) throws SQLException {

        if(msg.MsgConfGravacao() == true){
            
            tb_usuarios user = (tb_usuarios)manager.find(tb_usuarios.class,a.getFd_funcionario());
            
            user.setFd_login(a.getFd_login());
            user.setFd_senha(a.getFd_senha());
            manager.getTransaction().begin();
            manager.persist(user);
            manager.getTransaction().commit();
            manager.close();
            msg.msgGravado();
            return true;          
        }else{
            return false;
        }

}
}
