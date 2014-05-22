package Daos;

import ConnectionFactory.JPAUtil;
import Messages.Cmessage;
import Views.CadMatriculas;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import org.entities.classes.tb_matriculas;

public class DaoMatricula {
    Cmessage msg = new Cmessage();
     EntityManager manager = JPAUtil.getEntityManager();
     
    public boolean Inserir(tb_matriculas a) throws SQLException {
        if(msg.MsgConfGravacao()==true){
            
            manager.getTransaction().begin();
            manager.persist(a);
            manager.getTransaction().commit();
            msg.msgGravado();
            return true;
        }else{
            return false;
        }
    }
}
