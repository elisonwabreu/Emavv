package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.entities.classes.tb_usuarios;
import ConnectionFactory.Conexao;

public class DaoUsuarios extends tb_usuarios {

    public void Inserir(tb_usuarios user) throws SQLException {

        Connection conn = Conexao.getConexao();
        String SQL = "INSERT INTO tb_usuarios (fd_funcionario,fd_login, fd_senha, fd_status) VALUES (? , ? , ? , ?)";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setInt(1, user.getFd_funcionario());
        pstm.setString(2, user.getFd_login());
        pstm.setString(3, user.getFd_senha());
        pstm.setString(4, user.getFd_status());
        pstm.execute();
        pstm.close();
        conn.close();
    }

    public void Select(String logar) throws SQLException {
        Connection conn = Conexao.getConexao();
        String SQL = "SELECT * FROM tb_usuarios WHERE fd_login = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setString(1, logar);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {

            setFd_login(rs.getString("fd_login"));
            setFd_senha(rs.getString("fd_senha"));

        }
        pstm.close();
        conn.close();
    }

    public void Delete(int codigo) throws SQLException {

        Connection conn = Conexao.getConexao();
        String SQL = "DELETE FROM tb_usuarios WHERE fd_funcionario = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setInt(1, codigo);
        pstm.execute();
        pstm.close();
        conn.close();

    }

    public void Update(String login, String senha, int codigo) throws SQLException {
        Connection conn = Conexao.getConexao();
        String SQL = "UPDATE tb_usuarios SET fd_login = ? , fd_senha = ? WHERE fd_funcionario = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setString(1, login);
        pstm.setString(2, senha);
        pstm.setInt(3, codigo);
        pstm.execute();
        pstm.close();
        conn.close();
    }
}
