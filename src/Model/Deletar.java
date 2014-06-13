package Model;


import Funcao.Limpar;
import Daos.DaoAluno;
import Daos.DaoCargo;
import Daos.DaoCursos;
import Daos.DaoDisciplinas;
import Daos.DaoFuncionarios;
import Daos.DaoItens;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Messages.Cmessage;
import Views.CadAluno;
import Views.CadCargos;
import Views.CadCursos;
import Views.CadDisciplinas;
import Views.CadFuncionarios;
import Views.CadItens;
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
    DaoCursos daoCurso = new DaoCursos();
    DaoItens daoItens = new DaoItens();
    DaoDisciplinas daodisc = new DaoDisciplinas();
    DaoFuncionarios daoFunc = new DaoFuncionarios();
    Limpar limpa = new Limpar();

    public void Delete(CadCargos c) throws SQLException {
        int codigo = Integer.parseInt(c.txtCodigo.getText());
            daoCargo.UpdateDelete(codigo);
            
    }
    public void Delete(CadCursos c) throws SQLException {
        int codigo = Integer.parseInt(c.txtCodigo.getText());
            daoCurso.UpdateDelete(codigo);
            
    }
    public void Delete(CadItens c) throws SQLException {
        int codigo = Integer.parseInt(c.txtCodigo.getText());
            daoItens.UpdateDelete(codigo);
            
    }
    public void Delete(CadDisciplinas c) throws SQLException {
        int codigo = Integer.parseInt(c.txtCodDisciplina.getText());
            daodisc.UpdateDelete(codigo);
            
    }
    public void Delete(CadFuncionarios c) throws SQLException {
        int codigo = Integer.parseInt(c.txtCodigo.getText());
            daoFunc.UpdateDelete(codigo);
            
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
