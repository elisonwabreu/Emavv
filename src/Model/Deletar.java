
package Model;

import ConnectionFactory.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Messages.Cmessage;
import Views.CadUsuarios;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * @author Elison
 */
public class Deletar extends JFrame{
    Cmessage msg = new Cmessage();
    
    public boolean Delete(JTextField txtCodigo, String Tabela, String Campo) throws SQLException{
        if(msg.MsgConfExclusao() ==  true){
            
            int codigo = Integer.parseInt(txtCodigo.getText());
            try (Connection conn = Conexao.getConexao()) {
            String SQL = "UPDATE "+Tabela+" SET fd_status='E' WHERE "+Campo+" =?" ;
            try (PreparedStatement pstm = conn.prepareStatement(SQL)) {
                pstm.setInt(1,codigo);
                pstm.execute();
            }
            
            msg.msgExcluido();
            return true;
            }
        }else{
            return false;
        }    
    }
    
    public boolean DeleteUser(CadUsuarios user, String Tabela) throws SQLException{
        if(msg.MsgConfExclusao() ==  true){
            int codigo = Integer.parseInt(user.txtCodigo.getText());
            try (Connection conn = Conexao.getConexao()) {
            String SQL = "DELETE FROM "+Tabela+" WHERE fd_funcionario = ?" ;
            try (PreparedStatement pstm = conn.prepareStatement(SQL)) {
                pstm.setInt(1,codigo);
                pstm.execute();
            }
            msg.msgExcluido();
            return true;
            }
        }else{
            return false;
        }    
    }
   
}
