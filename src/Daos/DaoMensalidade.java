/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import ConnectionFactory.JPAUtil;
import Messages.Cmessage;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.entities.classes.Mensalidades;

/**
 *
 * @author elison
 */
public class DaoMensalidade {

    Cmessage msg = new Cmessage();
    EntityManager manager = JPAUtil.getEntityManager();
   

    public boolean Inserir(Mensalidades a) throws SQLException {
        EntityManager manager = JPAUtil.getEntityManager();
        /*if (msg.MsgConfGravacao() == true) {*/

            manager.getTransaction().begin();
            manager.persist(a);
            manager.getTransaction().commit();
            manager.close();
            //msg.msgGravado();
            
            return true;
        //} else {
       //     return false;
      //  }
    }

    public List<Mensalidades> Select(int codigoAluno , int codigoCurso ) {

        Query q = manager.createQuery("select a from tb_mensalidades as a "
                + "where a.fd_aluno = :fd_aluno and a.fd_curso = :fd_curso"
                + " and a.fd_status <> 'E'").setMaxResults(6);
        q.setParameter("fd_aluno", codigoAluno);
        q.setParameter("fd_curso",codigoCurso);

        List<Mensalidades> mensalidade = q.getResultList();
        
        return mensalidade;
    
    }

}
