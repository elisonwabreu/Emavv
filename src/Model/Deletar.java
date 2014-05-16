
package Model;

import ConnectionFactory.Conexao;
import Daos.DaoAluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Messages.Cmessage;
import Views.CadAluno;
import Views.CadUsuarios;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * @author Elison
 */
public class Deletar extends JFrame{
    Cmessage msg = new Cmessage();
    DaoAluno daoAluno = new DaoAluno();
    Limpar limpa = new Limpar();
    
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
    
    public void Alunos(CadAluno ca) throws SQLException{
        
        int codigo = Integer.parseInt(ca.txtCodigo.getText());
        if(daoAluno.Delete(codigo) == true){
            limpa.LimpaAluno(ca);  
        }    
    }
   
}
