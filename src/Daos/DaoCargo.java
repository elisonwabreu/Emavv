package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.entities.classes.tb_cargos;
import ConnectionFactory.*;
import Messages.Cmessage;
import Views.CadCargos;
import javax.naming.ldap.ManageReferralControl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DaoCargo {

    //private static final Cargos Cargos = null;
    //metodo que insere um cargo no banco
    Cmessage msg = new Cmessage();
    EntityManager manager = JPAUtil.getEntityManager();
    
    public boolean Inserir(tb_cargos c) throws SQLException {

        if(msg.MsgConfGravacao() == true){
            manager.getTransaction().begin();
            manager.persist(c);
            manager.getTransaction().commit();
            manager.close();
            msg.msgGravado();
        return true;
        
        }else{
            return false;
        }
    }

    public List<tb_cargos> Select(int codigo) throws SQLException {
     
        Query q = manager.createQuery("select a from tb_cargos a where "
                                                    + "a.fd_cargo = :fd_cargo");
        q.setParameter("fd_cargo",codigo);
        List<tb_cargos> cargo = q.getResultList();
        return cargo;
    }

    public List<tb_cargos> Select(String descricao) throws SQLException {
        
        String jpql = "";
        
        if (descricao.equals("")){
            jpql = "select a from tb_cargos a";
        }else{
            jpql = "select a from tb_cargos a where a.fd_descricao "
                                            + "like :fd_descricao"; 
        }
        
        Query q = manager.createQuery(jpql);
        
        if (descricao.equals("")){
            
        }else{
            q.setParameter("fd_descricao","%"+ descricao+"%");
        }    
        
        List<tb_cargos> cargo = q.getResultList();
        
        return cargo;
        
    }

    public boolean Update(CadCargos ca,String status) throws SQLException {
        
         if(msg.MsgConfGravacao() == true){
           
             tb_cargos c =(tb_cargos)manager.find(tb_cargos.class,
                                      Integer.parseInt(ca.txtCodigo.getText()));
             manager.getTransaction().begin();
             c.setFd_descricao(ca.txtDescricao.getText());
             c.setFd_status(status);
             manager.getTransaction().commit();
             manager.close();
             msg.msgGravado();
             
            return true; 
        }else{
            return false; 
         }     
    }
}
