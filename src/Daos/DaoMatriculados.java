package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnectionFactory.Conexao;

public class DaoMatriculados {

    public void Inserir() throws SQLException {

        Connection conn = Conexao.getConexao();
        String SQL = "INSERT INTO tb_matriculados (fd_curso , fd_aluno) VALUES (? , ?)";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setInt(1, 0);
        pstm.setInt(2, 0);
        pstm.execute();
        pstm.close();
        conn.close();
    }

    public void Delete() throws SQLException {

        Connection conn = Conexao.getConexao();
        String SQL = "DELETE FROM tb_matriculados WHERE fd_matriculado = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setInt(1, 0);
        pstm.execute();
        pstm.close();
        conn.close();
    }

    public void Select() throws SQLException {

        Connection conn = Conexao.getConexao();
        String SQL = "SELECT * FROM tb_matriculados";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
        }
        pstm.execute();
        pstm.close();
        conn.close();
    }

    public void Update() throws SQLException {

        Connection conn = Conexao.getConexao();
        String SQL = "UPDATE tb_matriculados SET fd_curso = ? , fd_aluno = ? WHERE fd_matriculado = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setString(1, "");
        pstm.setString(2, "");
        pstm.setInt(3, 0);
        pstm.execute();
        pstm.close();
        conn.close();
    }
}
