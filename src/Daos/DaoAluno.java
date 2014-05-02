package Daos;

import ConnectionFactory.*;
import Messages.Cmessage;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.entities.classes.tb_alunos;

/**
 *
 * @author athalias
 */
public class DaoAluno {

    Cmessage msg = new Cmessage();
    EntityManager manager = JPAUtil.getEntityManager();
    
    public boolean Inserir(tb_alunos al) throws SQLException {
        
        if(msg.MsgConfGravacao()==true){
            
            manager.getTransaction().begin();
            manager.persist(al);
            manager.getTransaction().commit();
            msg.msgGravado();
            return true;
        }else{
            return false;
        }
    }

    public boolean Delete(int codigo) throws SQLException {
        
        if(msg.MsgConfExclusao() == true){
            tb_alunos aluno = (tb_alunos)manager.find(tb_alunos.class,codigo);
            aluno.setFd_status("E");
            manager.getTransaction().begin();
            manager.persist(aluno);
            manager.getTransaction().commit();
            manager.close(); 
            return true;
        } 
        return false;
    }
    
    public List<tb_alunos> Select(int codigo) throws SQLException {

        Query q = manager.createQuery("select a from tb_alunos a "
                                              + "where a.fd_aluno = :fd_aluno and a.fd_status <> 'E'");
        q.setParameter("fd_aluno",codigo);
        List<tb_alunos> aluno = q.getResultList();
        return aluno;  
    }
    
    public List<tb_alunos> Select(String nome) throws SQLException {

        Query q = manager.createQuery("select a from tb_alunos as a "
                                              + "where a.fd_nome like :fd_nome and a.fd_status <> 'E'");
        q.setParameter("fd_nome","%"+nome+"%");
        List<tb_alunos> aluno = q.getResultList();
        return aluno;  
    }
    
    public List<tb_alunos> SelectCpf(String cpf){
        
        Query q = manager.createQuery("select a from tb_alunos a "
                                                + "where a.fd_cpf = :fd_cpf");
        q.setParameter("fd_cpf",cpf);
        List<tb_alunos> aluno = q.getResultList();
        return aluno;
    }
    
    public boolean Update(tb_alunos a, String status){
        
        if(msg.MsgConfGravacao() == true){
            
            tb_alunos aluno = (tb_alunos)manager.find(tb_alunos.class,a.getFd_aluno());
            
            aluno.setFd_nome(a.getFd_nome());
            aluno.setFd_cpf(a.getFd_cpf());
            aluno.setFd_rg(a.getFd_rg());
            aluno.setFd_data_nasc(a.getFd_data_nasc());
            aluno.setFd_sexo(a.getFd_sexo());
            aluno.setFd_endereco(a.getFd_endereco());
            aluno.setFd_numero(a.getFd_numero());          
            aluno.setFd_bairro(a.getFd_bairro());
            aluno.setFd_cidade(a.getFd_cidade());
            aluno.setFd_cep(a.getFd_cep());
            aluno.setFd_uf(a.getFd_uf());  
            aluno.setFd_telefone(a.getFd_telefone());
            aluno.setFd_celular(a.getFd_celular());
            aluno.setFd_email(a.getFd_email());    
            aluno.setFd_status(a.getFd_status());
            manager.getTransaction().begin();
            manager.persist(aluno);
            manager.getTransaction().commit();
            manager.close();
            msg.msgGravado();
            return true;          
        }else{
            return false;
        }  
    }
}