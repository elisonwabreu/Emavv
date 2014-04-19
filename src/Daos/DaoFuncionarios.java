package Daos;

import org.entities.classes.tb_funcionarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import Messages.Cmessage;
import ConnectionFactory.*;
import javax.persistence.EntityManager;


public class DaoFuncionarios {
    Cmessage msg = new Cmessage();
    public boolean Inserir(tb_funcionarios func) throws SQLException {
        if(msg.MsgConfGravacao() == true){
        
            EntityManager manager = JPAUtil.getEntityManager();
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

    public void Update() throws SQLException {

        Connection conn = Conexao.getConexao();
        String SQL = "UPDATE tb_alunos SET fd_nome = ?, fd_cpf = ?, fd_rg = ?, fd_data_nasc = ?, fd_endereco = ?, fd_numero = ?, fd_bairro = ?, fd_cidade = ?, fd_cep = ?, fd_uf = ?, fd_telefone = ?, fd_celular = ?, fd_email = ?, fd_status = ? WHERE fd_aluno = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);

        pstm.setString(1, "Athalias");
        pstm.setString(2, "11111111111");
        pstm.setString(3, "1111111");
        pstm.setByte(4, (byte) (0000 - 00 - 00));
        pstm.setString(5, "Rua 315");
        pstm.setInt(6, 168);
        pstm.setString(7, "Jangurussu");
        pstm.setString(8, "Fortaleza");
        pstm.setString(9, "60866280");
        pstm.setString(10, "ce");
        pstm.setString(11, "8532508425");
        pstm.setString(12, "8585487735");
        pstm.setString(13, "elisonwabreu@gmail.com");
        pstm.setString(14, "A");
        pstm.setInt(15, 2);
        pstm.execute();
        pstm.close();
        conn.close();
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
