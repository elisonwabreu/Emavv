package Daos;

import ConnectionFactory.*;
import Messages.Cmessage;
import Views.CadCargos;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
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
import org.entities.classes.tb_cargos;

public class DaoCargo {

    //private static final Cargos Cargos = null;
    //metodo que insere um cargo no banco
    Cmessage msg = new Cmessage();
    EntityManager manager;

    public DaoCargo() {
        this.manager = JPAUtil.getEntityManager();
        
    }

    public boolean Inserir(tb_cargos c) throws SQLException {

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

    public List<tb_cargos> Select(int codigo) throws SQLException {
        
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<tb_cargos> q = cb.createQuery(tb_cargos.class);
        Root<tb_cargos> c = q.from(tb_cargos.class);
        ParameterExpression<Integer> p = cb.parameter(Integer.class);
        Predicate predicate = cb.equal(c.<Integer> get("fd_cargo"), p);
        q.select(c).where(predicate);
        TypedQuery<tb_cargos> query = manager.createQuery(q);
        query.setParameter(p, codigo);
        List<tb_cargos> result = query.getResultList();
        
        return result; 
    }
     public List<tb_cargos> SelectFormBusca(int codigo) throws SQLException {

        Query q = manager.createQuery("select a from tb_cargos a where "
                + "a.fd_status <> 'E'").setMaxResults(codigo);
       
        List<tb_cargos> cargo = q.getResultList();
        return cargo;
    }
    public List<tb_cargos> SelectFormBusca() throws SQLException {

        Query q = manager.createQuery("select a from tb_cargos a where "
                + "a.fd_status <> 'E' order by a.fd_cargo").setMaxResults(3);
       
        List<tb_cargos> cargo = q.getResultList();
        return cargo;
    }
    public List<tb_cargos> Select(String descricao) throws SQLException {

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

        List<tb_cargos> cargo = q.getResultList();

        return cargo;

    }
    public List<tb_cargos> SelectC(String status) throws SQLException {

        Query q = manager.createQuery("select a from tb_cargos a "
                + "where a.fd_status = :fd_status <> 'E'");
        q.setParameter("fd_status", status);
        List<tb_cargos> cargo = q.getResultList();
        return cargo;
    } 
    public boolean Update(CadCargos ca, String status) throws SQLException {

        if (msg.MsgConfGravacao() == true) {

            tb_cargos c = (tb_cargos) manager.find(tb_cargos.class,
                    Integer.parseInt(ca.txtCodigo.getText()));
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
            
            tb_cargos c = (tb_cargos) manager.find(tb_cargos.class,codigo);
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
