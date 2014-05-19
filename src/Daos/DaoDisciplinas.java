package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Messages.Cmessage;
import org.entities.classes.tb_disciplinas;
import ConnectionFactory.Conexao;
import ConnectionFactory.JPAUtil;
import javax.persistence.EntityManager;

public class DaoDisciplinas {
    Cmessage msg = new Cmessage();
    EntityManager manager = JPAUtil.getEntityManager();
    public boolean Inserir(tb_disciplinas a) throws SQLException {
        
      if(msg.MsgConfGravacao() == true){
            manager.getTransaction().begin();
            manager.persist(a);
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

        String SQL = "DELETE FROM tb_disciplinas WHERE fd_disciplinas = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setInt(1, 1);
        pstm.execute();
        pstm.close();
        conn.close();
    }

    public List<tb_disciplinas> Select(int codigo) throws SQLException {

        Connection conn = Conexao.getConexao();
        List<tb_disciplinas> disciplina = new ArrayList<>();

        String SQL = "SELECT * FROM tb_disciplinas WHERE fd_disciplina = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {

            disciplina.add(new tb_disciplinas(rs.getInt("fd_disciplina"), rs.getString("fd_descricao"), rs.getString("fd_status")));
        }
        pstm.close();
        conn.close();

        return disciplina;
    }

    public void Update() throws SQLException {

        Connection conn = Conexao.getConexao();

        String SQL = "UPDATE tb_disciplinas SET fd_descricao = ? and fd_status = ? WHERE fd_disciplina = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setString(1, "");
        pstm.setString(2, "");
        pstm.setInt(3, 0);
        pstm.execute();
        pstm.close();
        conn.close();
    }
}
