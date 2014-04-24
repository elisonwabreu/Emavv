package Daos;

import ConnectionFactory.*;
import Messages.Cmessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.entities.classes.tb_alunos;

/**
 *
 * @author athalias
 */
public class DaoAluno {
    //Metodo para inserir um registro da tabela de Aluno
    Cmessage msg = new Cmessage();
    EntityManager manager = JPAUtil.getEntityManager();
    
    public boolean Inserir(tb_alunos al) throws SQLException {
        
        if(msg.MsgConfGravacao()==true){
            
            manager.getTransaction().begin();
            manager.persist(al);
            manager.getTransaction().commit();
            msg.msgGravado();
            System.gc();
            return true;
        }else{
            return false;
        }
    }
    //Fim do metodo Inserir

    //Metodo para deletar um registro da tabela de Aluno
    public void Delete(int codigo) throws SQLException {

        Connection conn = Conexao.getConexao();

        String SQL = "DELETE FROM tb_alunos WHERE fd_aluno = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setInt(1, codigo);
        pstm.execute();
        pstm.close();
        conn.close();
    }
    //Fim do metodo Delete
    
    public List<tb_alunos> Select(int codigo) throws SQLException {

        Query q = manager.createQuery("select a from tb_alunos a "
                                              + "where a.fd_aluno = :fd_aluno");
        q.setParameter("fd_aluno",codigo);
        List<tb_alunos> aluno = q.getResultList();
        return aluno;  
    }
    
    public List<tb_alunos> SelectCpf(String cpf){
        
        Query q = manager.createQuery("select a.fd_cpf from tb_alunos a "
                                                + "where a.fd_cpf = :fd_cpf");
        q.setParameter("fd_cpf",cpf);
        List<tb_alunos> aluno = q.getResultList();
        return aluno;
    }
    
  /*
    public List<tb_alunos> Select(String nome) throws SQLException {
        
        Connection conn = Conexao.getConexao();

        List<tb_alunos> aluno = new ArrayList<>();
        
        String sql = "";
  
            sql = "select "
                + "a.fd_aluno, "
                + "a.fd_nome, 	"
                + "case when (a.fd_status = 'A') then 'Ativo' "
                + "when (a.fd_status = 'I') then 'Inativo' "
                + "else 'Excluído' end as fd_status "
                + "from "
                + "tb_alunos a "
                + "where "
                + "a.fd_status <> 'E' and "
                + "a.fd_nome like ? ";
                    
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1,"%"+nome+"%");

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {

            aluno.add(new tb_alunos(rs.getInt("fd_aluno"), 
                    rs.getString("fd_nome"), rs.getString("fd_status")));

        }
        pstm.close();
        conn.close();

        return aluno;
    }

    public boolean Update(tb_alunos al) throws SQLException {

        if(msg.MsgConfGravacao()==true){
        
            Connection conn = Conexao.getConexao();
            String SQL = "UPDATE tb_alunos SET fd_nome = ?, fd_cpf = ?, fd_rg = ?, "
                    + "fd_data_nasc = ?, fd_sexo = ?, fd_endereco = ?, fd_numero = ?, fd_bairro = ?, "
                    + "fd_cidade = ?, fd_cep = ?, fd_uf = ?, fd_telefone = ?, "
                    + "fd_celular = ?, fd_email = ?, fd_status = ? WHERE fd_aluno = ?";

            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setString(1, al.getNome() );
            pstm.setString(2, al.getCpf());
            pstm.setString(3, al.getRg());
            pstm.setString(4, al.getDataNascimento());
            pstm.setString(5, al.getSexo());
            pstm.setString(6, al.getEndereco() );
            pstm.setInt(7, al.getNumero() );
            pstm.setString(8, al.getBairro());
            pstm.setString(9, al.getCidade() );
            pstm.setString(10, al.getCep() );
            pstm.setString(11, al.getUf() );
            pstm.setString(12, al.getTelefone() );
            pstm.setString(13, al.getCelular());
            pstm.setString(14, al.getEmail());
            //pstm.setBlob(15,(Blob) al.getImagem());
            pstm.setString(15, al.getStatus());
            pstm.setInt(16, al.getCodigo());
            pstm.execute();
            pstm.close();
            conn.close();
                msg.msgGravado();
                return true;
        }else{
                return false;
        }
    }   */ 
}