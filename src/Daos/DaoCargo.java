package Daos;


import ConnectionFactory.*;
import Messages.Cmessage;
import Views.CadCargos;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.entities.classes.Cargos;

public class DaoCargo {

    //private static final Cargos Cargos = null;
    //metodo que insere um cargo no banco
    Cmessage msg = new Cmessage();
    EntityManager manager;

    public DaoCargo() {
        this.manager = JPAUtil.getEntityManager();
        
    }

    public boolean Inserir(Cargos c) throws SQLException {

        if (msg.MsgConfGravacao() == true) {
            manager.getTransaction().begin();
            manager.persist(c);
            manager.getTransaction().commit();
            manager.close();
            msg.msgGravado();
            return true;

        } else {
            return false;
        }
    }


    public List<Cargos> Select(int codigo) throws SQLException {

        Query q = manager.createQuery("select a from tb_cargos a where "
                + " a.fd_cargo = :fd_cargo and a.fd_status <> 'E'");
        q.setParameter("fd_cargo", codigo);
        List<Cargos> cargo = q.getResultList();
        return cargo;
    }
    public List<Cargos> SelectCri(int codigo) throws SQLException {
        
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Cargos> q = cb.createQuery(Cargos.class);
        Root<Cargos> c = q.from(Cargos.class);
        ParameterExpression<Integer> p = cb.parameter(Integer.class);
        Predicate predicate = cb.equal(c.<Integer> get("fd_cargo"), p);
        q.select(c).where(predicate);
        TypedQuery<Cargos> query = manager.createQuery(q);
        query.setParameter(p, codigo);
        List<Cargos> result = query.getResultList();
        
        return result; 

    }
     public List<Cargos> SelectFormBusca(int codigo) throws SQLException {

        Query q = manager.createQuery("select a from tb_cargos a where "
                + "a.fd_status <> 'E'").setMaxResults(codigo);
       
        List<Cargos> cargo = q.getResultList();
        return cargo;
    }
    public List<Cargos> SelectFormBusca() throws SQLException {

        Query q = manager.createQuery("select a from tb_cargos a where "
                + "a.fd_status <> 'E' order by a.fd_cargo").setMaxResults(3);
       
        List<Cargos> cargo = q.getResultList();
        return cargo;
    }
    public List<Cargos> Select(String descricao) throws SQLException {

        String jpql = "";

        if (descricao.equals("")) {
            jpql = "select a from tb_cargos a where a.fd_status <>'E'";
        } else {
            jpql = "select a from tb_cargos a where a.fd_descricao "
                    + "like :fd_descricao and a.fd_status <> 'E'";
        }

        Query q = manager.createQuery(jpql);

        if (descricao.equals("")) {

        } else {
            q.setParameter("fd_descricao", "%" + descricao + "%");
        }

        List<Cargos> cargo = q.getResultList();

        return cargo;

    }
    public List<Cargos> SelectC(String status) throws SQLException {

        Query q = manager.createQuery("select a from tb_cargos a "
                + "where a.fd_status = :fd_status <> 'E'");
        q.setParameter("fd_status", status);
        List<Cargos> cargo = q.getResultList();
        return cargo;
    } 
    public boolean Update(CadCargos ca, String status) throws SQLException {

        if (msg.MsgConfGravacao() == true) {

            Cargos c = (Cargos) manager.find(Cargos.class,Integer.parseInt(ca.txtCodigo.getText()));
            manager.getTransaction().begin();
            c.setFd_descricao(ca.txtDescricao.getText());
            c.setFd_status(status);
            manager.getTransaction().commit();
            manager.close();
            msg.msgGravado();

            return true;
        } else {
            return false;
        }
    }
    public boolean Deletar(int codigo) throws SQLException {

        if (msg.MsgConfExclusao() == true) {
            Query query = manager.createQuery("UPDATE tb_cargos a SET a.fd_status = 'E'"
                    + "where a.fd_curso = :fd_curso");
            manager.getTransaction().begin();
            query.setParameter("fd_curso", codigo);
            query.executeUpdate();
            manager.getTransaction().commit();
            manager.close();
            return true;

        } else {
            return false;
        }
    }
    
     public boolean UpdateDelete(int codigo) throws SQLException {

        if (msg.MsgConfExclusao()== true) {
            
            Cargos c = (Cargos) manager.find(Cargos.class,codigo);
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
