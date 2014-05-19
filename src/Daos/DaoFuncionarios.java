package Daos;

import org.entities.classes.tb_funcionarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import Messages.Cmessage;
import ConnectionFactory.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.entities.classes.tb_alunos;


public class DaoFuncionarios {
    Cmessage msg = new Cmessage();
    EntityManager manager = JPAUtil.getEntityManager();
    
    public boolean Inserir(tb_funcionarios func) throws SQLException {
        if(msg.MsgConfGravacao() == true){
        
            
            manager.getTransaction().begin();
            manager.persist(func);
            manager.getTransaction().commit();
            manager.close();
            msg.msgGravado();
            return true;
        
        
        
        }else{
        
            return false;
        
        }
    }

    public void Delete() throws SQLException {

        Connection conn = Conexao.getConexao();

        String SQL = "DELETE FROM tb_alunos WHERE fd_aluno = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setInt(1, 1);
        pstm.execute();
        pstm.close();
        conn.close();
    }

    public void Select() throws SQLException {

        Connection conn = Conexao.getConexao();

        String SQL = "SELECT * FROM  tb_alunos";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
        }
        pstm.close();
        conn.close();
    }
    public List<tb_funcionarios> SelectCpf(String cpf){
        
        Query q = manager.createQuery("select a from tb_funcionarios a "
                                                + "where a.fd_cpf = :fd_cpf");
        q.setParameter("fd_cpf",cpf);
        List<tb_funcionarios> funcionario = q.getResultList();
        return funcionario;
    }

    public boolean Update(tb_funcionarios a, String status){
        
        if(msg.MsgConfGravacao() == true){
            
            tb_funcionarios func = (tb_funcionarios)manager.find(tb_funcionarios.class,a.getFd_funcionario());
            
            func.setFd_nome(a.getFd_nome());
            func.setFd_cpf(a.getFd_cpf());
            func.setFd_rg(a.getFd_rg());
            func.setFd_data_nasc(a.getFd_data_nasc());
            func.setFd_sexo(a.getFd_sexo());
            func.setFd_endereco(a.getFd_endereco());
            func.setFd_numero(a.getFd_numero());          
            func.setFd_bairro(a.getFd_bairro());
            func.setFd_cidade(a.getFd_cidade());
            func.setFd_cep(a.getFd_cep());
            func.setFd_uf(a.getFd_uf());  
            func.setFd_telefone(a.getFd_telefone());
            func.setFd_celular(a.getFd_celular());
            func.setFd_email(a.getFd_email());    
            func.setFd_status(a.getFd_status());
            manager.getTransaction().begin();
            manager.persist(func);
            manager.getTransaction().commit();
            manager.close();
            msg.msgGravado();
            return true;          
        }else{
            return false;
        }  
    }
    public void Delete(int codigo) throws SQLException {

      Connection conn = Conexao.getConexao(); 
            String SQL = "UPDATE tb_funcionarios SET fd_status = 'I' WHERE fd_curso = ?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
                pstm.setInt(1, codigo);
                pstm.execute();
                conn.close();
            

    
    }
}
