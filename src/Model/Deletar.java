package Model;


import Daos.DaoAluno;
import Daos.DaoCargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Messages.Cmessage;
import Views.CadAluno;
import Views.CadCargos;
import Views.CadUsuarios;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * @author Elison
 */
public class Deletar extends JFrame {

    Cmessage msg = new Cmessage();
    DaoAluno daoAluno = new DaoAluno();
    DaoCargo daoCargo = new DaoCargo();
    Limpar limpa = new Limpar();

    public void Delete(CadCargos c) throws SQLException {
        int codigo = Integer.parseInt(c.txtCodigo.getText());
            daoCargo.UpdateDelete(codigo);
            
    }

    public boolean DeleteUser(CadUsuarios user, String Tabela) throws SQLException {
        if (msg.MsgConfExclusao() == true) {
            int codigo = Integer.parseInt(user.txtCodigo.getText());
        }
            return false;
    }

    public void Alunos(CadAluno ca) throws SQLException {

        int codigo = Integer.parseInt(ca.txtCodigo.getText());
        if (daoAluno.Delete(codigo) == true) {
            limpa.LimpaAluno(ca);
        }
    }

}
