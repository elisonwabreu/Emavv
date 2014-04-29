package Daos;

import ConnectionFactory.Conexao;
import ConnectionFactory.JPAUtil;
import Messages.Cmessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.entities.classes.tb_alunos;
import org.entities.classes.tb_itens;

public class DaoItens {
    Cmessage msg = new Cmessage();
    
    EntityManager manager = JPAUtil.getEntityManager();
    public boolean Inserir(tb_itens a) throws SQLException {
        
        if(msg.MsgConfGravacao() == true){
        manager.getTransaction().begin();
            manager.persist(a);
            manager.getTransaction().commit();
            msg.msgGravado();
        msg.msgGravado();
        return true;
        }else{
        
            return false;
            
        }
    }

    public boolean Delete(int codigo) throws SQLException {
        
                 if(msg.MsgConfExclusao() == true){
                    tb_itens itens = (tb_itens)manager.find(tb_itens.class,codigo);
                    itens.setFd_status("E");
                    manager.getTransaction().begin();
                    manager.persist(itens);
                    manager.getTransaction().commit();
                    manager.close(); 
                    return true;
                } 
                return false;
    }

    public List<tb_itens> Select(int codigo) throws SQLException {

        Connection conn = Conexao.getConexao();
        List<tb_itens> item = new ArrayList<>();
        String SQL = "SELECT * FROM tb_itens WHERE fd_item = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {

            item.add(new tb_itens(rs.getInt("fd_item"), rs.getString("fd_descricao"), rs.getDouble("fd_valor"), rs.getString("fd_status")));
        }
        pstm.close();
        conn.close();
        return item;
    }

    public void Update(tb_itens a) throws SQLException {

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
