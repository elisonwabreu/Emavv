package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Messages.Cmessage;
import org.entities.classes.Itens;
import ConnectionFactory.Conexao;

public class DaoItens {
    Cmessage msg = new Cmessage();
    public boolean Inserir(Itens a) throws SQLException {
        
        if(msg.MsgConfGravacao() == true){
        Connection conn = Conexao.getConexao();
        String SQL = "INSERT INTO tb_itens (fd_descricao, fd_valor, fd_status) 	VALUES (?, ?, ?)";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setString(1, a.getDescricao());
        pstm.setDouble(2, a.getValor());
        pstm.setString(3, a.getStatus());
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
        String SQL = "DELETE FROM tb_itens WHERE fd_item = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setInt(1, 1);
        pstm.execute();
        pstm.close();
        conn.close();
    }

    public List<Itens> Select(int codigo) throws SQLException {

        Connection conn = Conexao.getConexao();
        List<Itens> item = new ArrayList<>();
        String SQL = "SELECT * FROM tb_itens WHERE fd_item = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {

            item.add(new Itens(rs.getInt("fd_item"), rs.getString("fd_descricao"), rs.getDouble("fd_valor"), rs.getString("fd_status")));
        }
        pstm.close();
        conn.close();
        return item;
    }

    public void Update(Itens a) throws SQLException {

        Connection conn = Conexao.getConexao();
        String SQL = "UPDATE tb_itens SET fd_descricao = ?, fd_valor = ?, fd_status = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setString(1, a.descricao);
        pstm.setDouble(1, a.valor);
        pstm.setString(3, a.status);
        pstm.execute();
        pstm.close();
        conn.close();
    }
}
