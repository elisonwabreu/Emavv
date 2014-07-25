package Daos;

import ConnectionFactory.JPAUtil;
import Messages.Cmessage;
import java.sql.SQLException;
import javax.persistence.EntityManager;
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

    public void Select() throws SQLException {

       
    }

    public void Update() throws SQLException {

        
    }
}
