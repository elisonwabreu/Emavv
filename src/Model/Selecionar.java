/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.entities.classes.tb_alunos;
import org.entities.classes.tb_cargos;
import org.entities.classes.tb_cursos;
import Daos.DaoAluno;
import Daos.DaoUsuarios;
import Daos.DaoCargo;
import Daos.DaoCursos;
import Daos.DaoDisciplinas;
import Daos.DaoFuncionarios;
import Daos.DaoItens;
import Daos.DaoMatricula;
import Messages.Cmessage;
import Views.CadAluno;
import Views.CadCargos;
import Views.CadCursos;
import Views.CadDisciplinas;
import Views.CadFuncionarios;
import Views.CadItens;
import Views.CadMatriculas;
import Views.CadUsuarios;
import Views.FormBusca;
import Views.Form_TelaLogin;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.entities.classes.tb_disciplinas;
import org.entities.classes.tb_funcionarios;
import org.entities.classes.tb_itens;
import org.entities.classes.tb_matriculas;
import org.entities.classes.tb_usuarios;

/**
 *
 * @author suporte
 */
public class Selecionar extends JFrame {

    Validacoes val = new Validacoes();
    Cmessage msg = new Cmessage();
    Limpar limpa = new Limpar();

    public void getJtableValue(int ValueJtable, JTextField txtCodigo) {

        String codigo = Integer.toString(ValueJtable);
        txtCodigo.setText(codigo);
        txtCodigo.grabFocus();
    }

    public boolean Logar(Form_TelaLogin c) throws SQLException {

        DaoUsuarios dao = new DaoUsuarios();

        String login = c.txtLogin.getText();
        if(c.txtLogin.getText().equals("") || c.txtSenha.getText().equals("")){
            msg.msgLogin();
            return false;
        }else{
        List<tb_usuarios> user = dao.Select(login);

        if (user.size() > 0) {
            for (tb_usuarios car : user) {

                if (car.getFd_login().equals(c.txtLogin.getText()) &&
                        car.getFd_senha().equals(c.txtSenha.getText())) {
                    return true;
                } else if (car.getFd_login().equals(c.txtLogin.getText()) ||
                           car.getFd_senha() != c.txtSenha.getText()) {
                    msg.msgLogin();
                    return false;
                }else if (car.getFd_login() != c.txtLogin.getText() || 
                          car.getFd_senha() != c.txtSenha.getText()) {
                    msg.msgLogin();
                    return false;
                }
            }
        }
        }
        msg.msgLogin();
        return false;

    }

    public boolean ListarCargos(CadCargos c) throws SQLException {

        DaoCargo dao = new DaoCargo();

        int codigo = Integer.parseInt(c.txtCodigo.getText());

        List<tb_cargos> cargos = dao.Select(codigo);

        if (cargos.size() > 0) {

            for (tb_cargos car : cargos) {
                c.txtDescricao.setText(car.getFd_descricao());
                if (car.getFd_status().equals("A")) {
                    c.cbStatus.setSelectedIndex(1);
                } else {
                    c.cbStatus.setSelectedIndex(2);
                }
            }
            return true;

        } else {
            msg.msgNenhumRegistro();
            limpa.LimpaCargo(c);
            return false;
        }
    }
    public boolean ListarCargos(CadFuncionarios c) throws SQLException {

        DaoCargo dao = new DaoCargo();

        String status = "A";

        List<tb_cargos> cargos = dao.SelectC(status);

        if (cargos.size() > 0) {

            for (tb_cargos car : cargos) {
                
              
                c.txtCargo.setText(car.getFd_descricao());
                
            }
            return true;

        }
        return false;
    }


    public boolean ListarAlunos(CadAluno a) throws SQLException {

        DaoAluno dao = new DaoAluno();

        tb_alunos alu = new tb_alunos(0, null, null);

        int codigo = Integer.parseInt(a.txtCodigo.getText());

        List<tb_alunos> aluno = dao.Select(codigo);

        if (aluno.size() > 0) {

            for (tb_alunos al : aluno) {

                a.txtNome.setText(al.getFd_nome());

                if (al.getFd_status().equals("A")) {
                    a.cbStatus.setSelectedIndex(1);
                } else {
                    a.cbStatus.setSelectedIndex(2);
                }

                if (al.getFd_cpf() != null) {
                    a.txtCpf.setText(val.AjusteCaracter(al.getFd_cpf()));
                }

                a.txtRg.setText(al.getFd_rg());

                if (al.getFd_data_nasc() != null) {
                    a.txtDtNascimento.setText(val.FormataDataSelec(al.getFd_data_nasc().toString()));
                }

                a.txtEndereco.setText(al.getFd_endereco());

                if (al.getFd_numero() != null) {
                    a.txtNum.setText(al.getFd_numero());
                }

                a.cbUf.setSelectedItem(al.getFd_uf());
                a.cbSexo.setSelectedItem(al.getFd_sexo());
                a.txtbairro.setText(al.getFd_bairro());
                a.txtTelefone.setText(val.AjusteCaracter(al.getFd_telefone()));
                a.txtCelular.setText(val.AjusteCaracter(al.getFd_celular()));
                a.txtCidade.setText(al.getFd_cidade());
                a.txtCep.setText(al.getFd_cep());
                a.txtEmail.setText(al.getFd_email());
            }
            return true;

        } else {
            msg.msgNenhumRegistro();
            limpa.LimpaAluno(a);
            return false;
        }
    }
     public int ListarAlunos() throws SQLException {

        DaoAluno dao = new DaoAluno();
            
        int codigo;

        List<tb_alunos> aluno = dao.Select();
        if (aluno.size() > 0) {
            for (tb_alunos al : aluno) {
                codigo = al.getFd_aluno();
            return codigo;
        }
         }
        return 0;
     }
    public boolean ListarFuncionarios(CadFuncionarios fun) throws SQLException {

        DaoFuncionarios dao = new DaoFuncionarios();

        tb_funcionarios func = new tb_funcionarios(0, null, null);

        int codigo = Integer.parseInt(fun.txtCodigo.getText());

        List<tb_funcionarios> fuincionario = dao.Select(codigo);

        if (fuincionario.size() > 0) {

            for (tb_funcionarios al : fuincionario) {

                fun.txtNome.setText(al.getFd_nome());

                if (al.getFd_status().equals("A")) {
                    fun.comboStatus.setSelectedIndex(1);
                } else {
                    fun.comboStatus.setSelectedIndex(2);
                }

                if (al.getFd_cpf() != null) {
                    fun.txtCpf.setText(val.AjusteCaracter(al.getFd_cpf()));
                }

                fun.txtRg.setText(al.getFd_rg());

                if (al.getFd_data_nasc() != null) {
                    fun.txtDtNascimento.setText(val.FormataDataSelec(al.getFd_data_nasc().toString()));
                }

                fun.txtEndereco.setText(al.getFd_endereco());
                /*
                 if(al.getFd_numero() != null){
                 fun.txtNum.setText(al.getFd_numero());
                 }
                 */
                fun.comboUF.setSelectedItem(al.getFd_uf());
                fun.comboSexo.setSelectedItem(al.getFd_sexo());
                fun.txtbairro.setText(al.getFd_bairro());
                fun.txtTelefone.setText(val.AjusteCaracter(al.getFd_telefone()));
                fun.txtCelular.setText(val.AjusteCaracter(al.getFd_celular()));
                fun.txtCidade.setText(al.getFd_cidade());
                fun.txtCep.setText(al.getFd_cep());
                fun.txtEmail.setText(al.getFd_email());
            }
            return true;

        } else {
            msg.msgNenhumRegistro();
            limpa.LimpaFuncionario(fun);
            return false;
        }
    }

    public boolean ListarCursos(CadCursos c) throws SQLException {

        DaoCursos dao = new DaoCursos();

        int codigo = Integer.parseInt(c.txtCodigo.getText());

            List<tb_cursos> curso = dao.Select(codigo);
         if (curso.size()>0) {
            for (tb_cursos cr : curso) {
                c.txtDescricao.setText(cr.getFd_descricao());
                c.txtValor.setText(String.valueOf(cr.getFd_valor()));

                if (cr.getFd_status().equals("A")) {
                    c.cbStatus.setSelectedIndex(1);
                } else {
                    c.cbStatus.setSelectedIndex(2);
                }
            }
            return true;
        } else {
            msg.msgNenhumRegistro();
            limpa.LimpaCurso(c);
            return false;
        }
    }

    public boolean ListarItens(CadItens c) throws SQLException {

        DaoItens dao = new DaoItens();

        int codigo = Integer.parseInt(c.txtCodigo.getText());

            List<tb_itens> item = dao.Select(codigo);
         if (item.size()>0) {
            for (tb_itens cr : item) {
                c.txtItem.setText(cr.getFd_descricao());
                c.txtPreco.setText(String.valueOf(cr.getFd_valor()));

                if (cr.getFd_status().equals("A")) {
                    c.comboStatus.setSelectedIndex(1);
                } else {
                    c.comboStatus.setSelectedIndex(2);
                }
            }
            return true;
        } else {
            msg.msgNenhumRegistro();
            limpa.LimpaCurso(c);
            return false;
        }
    }

    public boolean ListarDisciplinas(CadDisciplinas c) throws SQLException {

        DaoDisciplinas dao = new DaoDisciplinas();

        int codigo = Integer.parseInt(c.txtCodigo.getText());

            List<tb_disciplinas> disc = dao.Select(codigo);
        if (disc.size()>0) {
            for (tb_disciplinas cr : disc) {
                c.txtDisciplina.setText(cr.getFd_descricao());
                if (cr.getFd_status().equals("A")) {
                    c.comboStatus.setSelectedIndex(1);
                } else {
                    c.comboStatus.setSelectedIndex(2);
                }
            }
            return true;
        } else {
            msg.msgNenhumRegistro();
            limpa.LimpaDisciplina(c);
            return false;
        }
    }

    public boolean ListarUsuarios(CadUsuarios c) throws SQLException {
        DaoFuncionarios daoufun = new DaoFuncionarios();
        DaoUsuarios dao = new DaoUsuarios();

        int codigo = Integer.parseInt(c.txtCodigo.getText());
        List<tb_funcionarios> fuincionario = daoufun.Select(codigo);
        List<tb_usuarios> user = dao.Select(codigo);

        for (tb_usuarios cr : user) {
            c.txtUsuario.setText(cr.getFd_login());
            c.txtSenha.setText(cr.getFd_senha());
            if (cr.getFd_status().equals("A")) {
                c.cbStatusUser.setSelectedIndex(1);
            } else {
                c.cbStatusUser.setSelectedIndex(2);
            }
            if (fuincionario.size() > 0) {

                for (tb_funcionarios al : fuincionario) {

                    c.txtNome.setText(al.getFd_nome());

                    if (al.getFd_status().equals("A")) {
                        c.cbStatus.setSelectedIndex(1);
                    } else {
                        c.cbStatus.setSelectedIndex(2);
                    }
                    return true;
                }
            } else {
                msg.msgNenhumRegistro();

                return false;
            }

        }
        return false;
    }

    public boolean ListarMAtricula(CadMatriculas c) throws SQLException {

        DaoAluno dao = new DaoAluno();
        DaoMatricula matr = new DaoMatricula();
        tb_matriculas mat = new tb_matriculas();
        tb_alunos alu = new tb_alunos(0, null, null);
        int codigo = Integer.parseInt(c.txtCodigo.getText());
        List<tb_alunos> aluno = dao.Select(codigo);
        List<tb_matriculas> matricula = matr.Select(codigo);
        if (aluno.size() > 0) {

            for (tb_alunos al : aluno) {

                c.txtNome.setText(al.getFd_nome());

            }
            if (matricula.size() > 0) {

                for (tb_matriculas al : matricula) {

                    c.txtMatricula.setText(String.valueOf(al.getFd_matricula()));
                    c.txtDtCadastro.setText(val.FormataDataSelec(al.getFd_data_matricula().toString()));
                }
                return true;

            } else {
                msg.msgNenhumRegistro();
                limpa.LimpaMatricula(c);
                return false;
            }
        }
        return false;
    }

    public void setSelectOnJTable(FormBusca f, String tabela, int TableIndex) throws SQLException {
        /*
         Valores correspondentes TableIndex
         1 = cargos
         2 = alunos
         3 = funcionarios
         4 = cursos 
         5 = disciplinas 
         6 = itens
         */
        switch (TableIndex) {
            case 1:
                DaoCargo dao = new DaoCargo();
                
                List<tb_cargos> cargo = dao.Select(f.txtCampoBusca.getText().toUpperCase());
                DefaultTableModel model = (DefaultTableModel) f.jGridBusca.getModel();
                model.setNumRows(cargo.size());
                if (cargo.size() > 0) {
                    for (tb_cargos ca : cargo) {
                        for (int i = 0; i < cargo.size(); i++) {
                            f.jGridBusca.setValueAt(cargo.get(i).getFd_cargo(), i, 0);
                            f.jGridBusca.setValueAt(cargo.get(i).getFd_descricao(), i, 1);
                            f.jGridBusca.setValueAt(cargo.get(i).getFd_status(), i, 2);

                        }
                    }
                } else {
                    msg.msgNenhumRegistro();
                }
                break;

            case 2:
                DaoAluno daoalu = new DaoAluno();
                List<tb_alunos> aluno = daoalu.Select(f.txtCampoBusca.getText().toUpperCase());
                DefaultTableModel model2 = (DefaultTableModel) f.jGridBusca.getModel();
                model2.setNumRows(aluno.size());
                if (aluno.size() > 0) {
                    for (tb_alunos al : aluno) {
                        for (int i = 0; i < aluno.size(); i++) {
                            f.jGridBusca.setValueAt(aluno.get(i).getFd_aluno(), i, 0);
                            f.jGridBusca.setValueAt(aluno.get(i).getFd_nome(), i, 1);
                            f.jGridBusca.setValueAt(aluno.get(i).getFd_cpf(), i, 2);

                        }
                    }
                } else {
                    msg.msgNenhumRegistro();
                }
                break;

            case 3:
                DaoFuncionarios daofunc = new DaoFuncionarios();
                List<tb_funcionarios> func = daofunc.Select(f.txtCampoBusca.getText().toUpperCase());
                DefaultTableModel model3 = (DefaultTableModel) f.jGridBusca.getModel();
                model3.setNumRows(func.size());
                if (func.size() > 0) {
                    for (tb_funcionarios al : func) {
                        for (int i = 0; i < func.size(); i++) {
                            f.jGridBusca.setValueAt(func.get(i).getFd_funcionario(), i, 0);
                            f.jGridBusca.setValueAt(func.get(i).getFd_nome(), i, 1);
                            f.jGridBusca.setValueAt(func.get(i).getFd_cpf(), i, 2);

                        }
                    }
                } else {
                    msg.msgNenhumRegistro();
                }
                break;

            case 4:
                DaoCursos daocurso = new DaoCursos();
                List<tb_cursos> curso = daocurso.Select(f.txtCampoBusca.getText().toUpperCase());
                DefaultTableModel model4 = (DefaultTableModel) f.jGridBusca.getModel();
                model4.setNumRows(curso.size());
                if (curso.size() > 0) {
                    for (tb_cursos c : curso) {
                        for (int i = 0; i < curso.size(); i++) {
                            f.jGridBusca.setValueAt(curso.get(i).getFd_curso(), i, 0);
                            f.jGridBusca.setValueAt(curso.get(i).getFd_descricao(), i, 1);
                            f.jGridBusca.setValueAt(curso.get(i).getFd_status(), i, 2);

                        }
                    }
                } else {
                    msg.msgNenhumRegistro();
                }
                break;

            case 5:
                DaoDisciplinas daodisc = new DaoDisciplinas();
                List<tb_disciplinas> disc = daodisc.Select(f.txtCampoBusca.getText().toUpperCase());
                DefaultTableModel model5 = (DefaultTableModel) f.jGridBusca.getModel();
                model5.setNumRows(disc.size());
                if (disc.size() > 0) {
                    for (tb_disciplinas c : disc) {
                        for (int i = 0; i < disc.size(); i++) {
                            f.jGridBusca.setValueAt(disc.get(i).getFd_disciplina(), i, 0);
                            f.jGridBusca.setValueAt(disc.get(i).getFd_descricao(), i, 1);
                            f.jGridBusca.setValueAt(disc.get(i).getFd_status(), i, 2);

                        }
                    }
                } else {
                    msg.msgNenhumRegistro();
                }
                break;
            case 6:
                DaoItens daoitem = new DaoItens();
                List<tb_itens> item = daoitem.Select(f.txtCampoBusca.getText().toUpperCase());
                DefaultTableModel model6 = (DefaultTableModel) f.jGridBusca.getModel();
                model6.setNumRows(item.size());
                if (item.size() > 0) {
                    for (tb_itens c : item) {
                        for (int i = 0; i < item.size(); i++) {
                            f.jGridBusca.setValueAt(item.get(i).getFd_item(), i, 0);
                            f.jGridBusca.setValueAt(item.get(i).getFd_descricao(), i, 1);
                            f.jGridBusca.setValueAt(item.get(i).getFd_valor(), i, 2);

                        }
                    }
                } else {
                    msg.msgNenhumRegistro();
                }
                break;
        }

    }

}
