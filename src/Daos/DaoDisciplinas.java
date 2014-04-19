package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Messages.Cmessage;
import org.entities.classes.Disciplinas;
import ConnectionFactory.Conexao;

public class DaoDisciplinas {
    Cmessage msg = new Cmessage();
    public boolean Inserir(Disciplinas a) throws SQLException {
        
        if(msg.MsgConfGravacao() == true){
        Connection conn = Conexao.getConexao();

        String SQL = "INSERT INTO tb_disciplinas (fd_descricao, fd_status) VALUES (? , ? )";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setString(1, a.getDescricao());
        pstm.setString(2, a.getStatus());
        pstm.execute();
        pstm.close();
        conn.close();
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

    public List<Disciplinas> Select(int codigo) throws SQLException {

        Connection conn = Conexao.getConexao();
        List<Disciplinas> disciplina = new ArrayList<>();

        String SQL = "SELECT * FROM tb_disciplinas WHERE fd_disciplina = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {

            disciplina.add(new Disciplinas(rs.getInt("fd_disciplina"), rs.getString("fd_descricao"), rs.getString("fd_status")));
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
