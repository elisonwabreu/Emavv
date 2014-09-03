/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Daos.DaoAluno;
import Daos.DaoCargo;
import Daos.DaoCursos;
import Daos.DaoDisciplinas;
import Daos.DaoFuncionarios;
import Daos.DaoItens;
import Daos.DaoMatricula;
import Daos.DaoMatriculados;
import Daos.DaoMensalidade;
import Daos.DaoUsuarios;
import Messages.Cmessage;
import Metodos.Limpar;
import Views.CadAluno;
import Views.CadCargos;
import Views.CadCursos;
import Views.CadDisciplinas;
import Views.CadFuncionarios;
import Views.CadItens;
import Views.CadMatriculas;
import Views.CadMensalidades;
import Views.CadUsuarios;
import Views.FormBusca;
import Views.FormGeraMensalidade;
import Views.FormPagamentoMensalidade;
import Views.FormTelaPagamento;
import Views.FormVendas;
import Views.Form_TelaLogin;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.entities.classes.Alunos;
import org.entities.classes.Cargos;
import org.entities.classes.Cursos;
import org.entities.classes.Disciplinas;
import org.entities.classes.Funcionarios;
import org.entities.classes.Itens;
import org.entities.classes.Matriculados;
import org.entities.classes.Matriculas;
import org.entities.classes.Mensalidades;
import org.entities.classes.Usuarios;

/**
 *
 * @author suporte
 */
public class Selecionar extends JFrame {

    Validacoes val = new Validacoes();
    Cmessage msg = new Cmessage();
    Limpar limpa = new Limpar();
    EntityManager manager;

    public void getJtableValue(int ValueJtable, JTextField txtCodigo) {

        String codigo = Integer.toString(ValueJtable);
        txtCodigo.setText(codigo);
        txtCodigo.grabFocus();
    }

    public boolean Logar(Form_TelaLogin c) throws SQLException {

        DaoUsuarios dao = new DaoUsuarios();

        String login = c.txtLogin.getText();
        if (c.txtLogin.getText().equals("") || c.txtSenha.getText().equals("")) {
            msg.msgLogin();
            return false;
        } else {
            List<Usuarios> user = dao.Select(login);

            if (user.size() > 0) {
                for (Usuarios car : user) {

                    if (car.getFd_login().equals(c.txtLogin.getText())
                            && car.getFd_senha().equals(c.txtSenha.getText())) {
                        return true;
                    } else if (car.getFd_login().equals(c.txtLogin.getText())
                            || car.getFd_senha() != c.txtSenha.getText()) {
                        msg.msgLogin();
                        return false;
                    } else if (car.getFd_login() != c.txtLogin.getText()
                            || car.getFd_senha() != c.txtSenha.getText()) {
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

        List<Cargos> cargos = dao.Select(codigo);

        if (cargos.size() > 0) {

            for (Cargos car : cargos) {
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

        int codigo = Integer.parseInt(c.txtCodigoCargo.getText());

        List<Cargos> cargos = dao.Select(codigo);

        if (cargos.size() > 0) {

            for (Cargos car : cargos) {

                c.txtCargo.setText(car.getFd_descricao());

            }
            return true;

        }
        return false;
    }

    public boolean ListarAlunos(CadAluno a) throws SQLException {

        DaoAluno dao = new DaoAluno();

        Alunos alu = new Alunos(0, null, null);

        int codigo = Integer.parseInt(a.txtCodigo.getText());

        List<Alunos> aluno = dao.Select(codigo);

        if (aluno.size() > 0) {

            for (Alunos al : aluno) {

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

    public boolean ListarAlunos(FormGeraMensalidade a) throws SQLException {

        DaoAluno dao = new DaoAluno();

        Alunos alu = new Alunos(0, null, null);

        int codigo = Integer.parseInt(a.txtCodigo.getText());

        List<Alunos> aluno = dao.Select(codigo);

        if (aluno.size() > 0) {

            for (Alunos al : aluno) {

                a.txtNomeAluno.setText(al.getFd_nome());

            }
            return true;

        } else {
            msg.msgNenhumRegistro();

            return false;
        }
    }

    public boolean ListarAlunos(FormPagamentoMensalidade a) throws SQLException {

        DaoAluno dao = new DaoAluno();
        Alunos alu = new Alunos(0, null, null);

        int codigo = Integer.parseInt(a.txtAluno.getText());

        List<Alunos> aluno = dao.Select(codigo);

        if (aluno.size() > 0) {

            for (Alunos al : aluno) {

                a.txtNomeAluno.setText(al.getFd_nome());

            }
            return true;

        } else {
            msg.msgNenhumRegistro();

            return false;
        }
    }

    public boolean ListarAlunos(FormTelaPagamento a) throws SQLException {

        DaoAluno dao = new DaoAluno();

        Alunos alu = new Alunos(0, null, null);

        int codigo = Integer.parseInt(a.txtCodigo.getText());

        List<Alunos> aluno = dao.Select(codigo);

        if (aluno.size() > 0) {

            for (Alunos al : aluno) {

                a.txtNome.setText(al.getFd_nome());
            }
            return true;

        } else {
            msg.msgNenhumRegistro();
            // limpa.LimpaAluno(a);
            return false;
        }
    }

    public boolean ListarAlunos(CadMensalidades a) throws SQLException {

        DaoAluno dao = new DaoAluno();

        Alunos alu = new Alunos(0, null, null);

        int codigo = Integer.parseInt(a.txtCodigo.getText());

        List<Alunos> aluno = dao.Select(codigo);

        if (aluno.size() > 0) {

            for (Alunos al : aluno) {

                a.txtNomeAluno.setText(al.getFd_nome());
            }
            return true;

        } else {
            msg.msgNenhumRegistro();
            // limpa.LimpaAluno(a);
            return false;
        }
    }

    public int ListarAlunos() throws SQLException {

        DaoAluno dao = new DaoAluno();

        int codigo;

        List<Alunos> aluno = dao.Select();
        if (aluno.size() > 0) {
            for (Alunos al : aluno) {
                codigo = al.getFd_aluno();
                return codigo;
            }
        }
        return 0;
    }

    public boolean ListarFuncionarios(CadFuncionarios fun) throws SQLException {

        DaoFuncionarios dao = new DaoFuncionarios();

        Funcionarios func = new Funcionarios(0, null, null);

        int codigo = Integer.parseInt(fun.txtCodigo.getText());

        List<Funcionarios> fuincionario = dao.Select(codigo);

        if (fuincionario.size() > 0) {

            for (Funcionarios al : fuincionario) {

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
                fun.txtCargo.setText(al.getFd_cago());
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

        List<Cursos> curso = dao.Select(codigo);
        if (curso.size() > 0) {
            for (Cursos cr : curso) {
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

    public boolean ListarCursos(FormPagamentoMensalidade c) throws SQLException {

        DaoCursos dao = new DaoCursos();

        int codigo = Integer.parseInt(c.txtCurso.getText());

        List<Cursos> curso = dao.Select(codigo);
        if (curso.size() > 0) {
            for (Cursos cr : curso) {
                c.txtNomeCurso.setText(cr.getFd_descricao());
                c.txtValorCurso.setText(String.valueOf(cr.getFd_valor()));

                /*if (cr.getFd_status().equals("A")) {
                 c.cbStatus.setSelectedIndex(1);
                 } else {
                 c.cbStatus.setSelectedIndex(2);
                 }*/
            }
            return true;
        } else {
            msg.msgNenhumRegistro();
            /* limpa.LimpaCurso(c);*/
            return false;
        }
    }

    public boolean ListarCursos(FormGeraMensalidade c) throws SQLException {

        DaoCursos dao = new DaoCursos();

        int codigo = Integer.parseInt(c.txtCodigoCurso.getText());

        List<Cursos> curso = dao.Select(codigo);
        if (curso.size() > 0) {
            for (Cursos cr : curso) {
                c.txtDescricao.setText(cr.getFd_descricao());

            }
            return true;
        } else {
            msg.msgNenhumRegistro();

            return false;
        }
    }

    public boolean ListarCursos(CadMensalidades c) throws SQLException {

        DaoCursos dao = new DaoCursos();

        int codigo = Integer.parseInt(c.txtCodigo1.getText());

        List<Cursos> curso = dao.Select(codigo);
        if (curso.size() > 0) {
            for (Cursos cr : curso) {
                c.txtNomeAluno1.setText(cr.getFd_descricao());

            }
            return true;
        } else {
            msg.msgNenhumRegistro();

            return false;
        }
    }

    public boolean ListarMensalidades(CadMensalidades c) throws SQLException {

        DaoMensalidade dao = new DaoMensalidade();

        int codigoCurso = Integer.parseInt(c.txtCodigo1.getText());
        int codigoAluno = Integer.parseInt(c.txtCodigo.getText());

        List<Mensalidades> mensalidade = dao.Select(codigoAluno, codigoCurso);
        if (mensalidade.size() > 0) {
            int i = 0;
            List<JFormattedTextField> fData = Arrays.asList(
                    c.txtData1, c.txtData2, c.txtData3, c.txtData4, c.txtData5, c.txtData6
            );
            List<JTextField> fTitulo = Arrays.asList(
                    c.txtTitulo1, c.txtTitulo2, c.txtTitulo3, c.txtTitulo4, c.txtTitulo5, c.txtTitulo6
            );
            for (Mensalidades cr : mensalidade) {
                fData.get(i).setText(cr.getFd_vencimento());
                fTitulo.get(i).setText(String.valueOf(cr.getFd_mensalidade()));
                i++;
            }
            return true;
        } else {
            msg.msgNenhumRegistro();
            return false;
        }
    }

    public boolean ListarMensalidades(FormPagamentoMensalidade c) throws SQLException {

        DaoMensalidade dao = new DaoMensalidade();

        int codigo = Integer.parseInt(c.txtTitulo.getText());

        List<Mensalidades> mensalidade = dao.Select(codigo);
        if (mensalidade.size() > 0) {
            for (Mensalidades cr : mensalidade) {
                
                c.txtAluno.setText(String.valueOf(cr.getFd_aluno()));
                c.txtCurso.setText(String.valueOf(cr.getFd_curso()));
                c.txtMatricula.setText(String.valueOf(cr.getFd_matricula()));
                c.txtDataVencimento.setText(cr.getFd_vencimento());
                
                if (cr.getFd_status().equals("A")) {
                    c.cbStatus.setSelectedIndex(1);
                }else if(cr.getFd_status().equals("F")){
                    c.cbStatus.setSelectedIndex(2);
                }else if(cr.getFd_status().equals("I")){
                    c.cbStatus.setSelectedIndex(3);
                }else if(cr.getFd_status().equals("E")){
                    c.cbStatus.setSelectedIndex(4);
                }    
            return true;
            }
            }else {
            msg.msgNenhumRegistro();
        }
        return false;
    }
    
    public boolean ListarCursos(CadDisciplinas c) throws SQLException {

        DaoCursos dao = new DaoCursos();

        int codigo = Integer.parseInt(c.txtCodigo.getText());

        List<Cursos> curso = dao.Select(codigo);
        if (curso.size() > 0) {
            for (Cursos cr : curso) {
                c.txtDescricao.setText(cr.getFd_descricao());
                // c.txtValor.setText(String.valueOf(cr.getFd_valor()));

                if (cr.getFd_status().equals("A")) {
                    c.cbStatus.setSelectedIndex(1);
                } else {
                    c.cbStatus.setSelectedIndex(2);
                }
            }
            return true;
        } else {
            msg.msgNenhumRegistro();

            return false;
        }
    }

    public boolean ListarCursos(CadMatriculas c) throws SQLException {

        DaoCursos dao = new DaoCursos();
        DaoDisciplinas disc = new DaoDisciplinas();

        int codigo = Integer.parseInt(c.txtCodCurso.getText());
        List<Cursos> curso = dao.Select(codigo);
        List<Disciplinas> disciplina = disc.SelectDiscCurso(codigo);
        if (curso.size() > 0) {
            for (Cursos cr : curso) {
                c.txtDescricaoCurso.setText(cr.getFd_descricao());
            }
            return true;
        } else {
            msg.msgNenhumRegistro();
            return false;
        }
    }

    public boolean ListarDisciplinas(CadMatriculas c) throws SQLException {

        DaoDisciplinas disc = new DaoDisciplinas();
        int codigo = Integer.parseInt(c.txtCodCurso.getText());
        List<Disciplinas> disciplina = disc.SelectDiscCurso(codigo);
        DefaultTableModel model = (DefaultTableModel) c.jGridMatricula.getModel();
        model.setNumRows(disciplina.size());
        if (disciplina.size() > 0) {
            for (Disciplinas cr : disciplina) {
                for (int i = 0; i < disciplina.size(); i++) {
                    c.jGridMatricula.setValueAt(disciplina.get(i).getFd_disciplina(), i, 0);
                    c.jGridMatricula.setValueAt(disciplina.get(i).getFd_descricao(), i, 1);
                }
            }
            return true;
        } else {
            msg.msgNenhumRegistroDisc();
            c.jGridMatricula.setName("");
            return false;
        }
    }

    public boolean ListarItens(CadItens c) throws SQLException {

        DaoItens dao = new DaoItens();

        int codigo = Integer.parseInt(c.txtCodigo.getText());

        List<Itens> item = dao.Select(codigo);
        if (c.txtCodigo.getText() != "") {
            if (item.size() > 0) {
                for (Itens cr : item) {
                    c.txtItem.setText(cr.getFd_descricao());
                    c.txtPreco.setText(String.valueOf(cr.getFd_valor()));

                    if (cr.getFd_status().equals("A")) {
                        c.comboStatus.setSelectedIndex(1);
                    } else {
                        c.comboStatus.setSelectedIndex(2);
                    }
                }
            }
            return true;
        } else {
            msg.msgNenhumRegistro();
            limpa.LimpaItens(c);
            return false;
        }
    }

    public boolean ListarItens(FormVendas c) throws SQLException {

        DaoItens dao = new DaoItens();

        int codigo = Integer.parseInt(c.txtCodigo.getText());

        List<Itens> item = dao.Select(codigo);
        if (c.txtCodigo.getText() != "") {
            if (item.size() > 0) {
                for (Itens cr : item) {
                    c.txtValorUnitario.setText(String.valueOf(cr.getFd_valor()));
                    c.lblProdutos.setText(cr.getFd_descricao());

                }
            }
            return true;
        } else {
            msg.msgNenhumRegistro();
            // limpa.LimpaItens(c);
            return false;
        }
    }

    public boolean ListarDisciplinas(CadDisciplinas c) throws SQLException {

        DaoDisciplinas dao = new DaoDisciplinas();

        int codigo = Integer.parseInt(c.txtCodDisciplina.getText());

        List<Disciplinas> disc = dao.Select(codigo);
        if (disc.size() > 0) {
            for (Disciplinas cr : disc) {
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
        List<Funcionarios> fuincionario = daoufun.Select(codigo);
        List<Usuarios> user = dao.Select(codigo);

        for (Usuarios cr : user) {
            c.txtUsuario.setText(cr.getFd_login());
            c.txtSenha.setText(cr.getFd_senha());
            if (cr.getFd_status().equals("A")) {
                c.cbStatusUser.setSelectedIndex(1);
            } else {
                c.cbStatusUser.setSelectedIndex(2);
            }
            if (fuincionario.size() > 0) {

                for (Funcionarios al : fuincionario) {

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

    public void ListarMAtricula(CadMatriculas c) throws SQLException {

        DaoAluno dao = new DaoAluno();
        DaoMatriculados matr = new DaoMatriculados();
        int codigo = Integer.parseInt(c.txtCodigo.getText());
        List<Alunos> aluno = dao.Select(codigo);
        
        if (aluno.size() > 0) {
            for (Alunos al : aluno) {
                c.txtNome.setText(al.getFd_nome());
            }
            
            List<Matriculados> matricula = matr.Select(codigo);
        
            if (matricula.size() > 0) {
                for (Matriculados ma : matricula) {
                    c.txtMatricula.setText(String.valueOf(ma.getFd_matricula()
                                                           .getFd_matricula()));
                    c.txtCodCurso.setText(String.valueOf(ma.getFd_curso()
                                                               .getFd_curso()));
                    c.txtDescricaoCurso.setText(ma.getFd_curso().getFd_descricao());
                    c.txtDtCadastro.setText(val.FormataDataSelec
                      (ma.getFd_matricula().getFd_data_matricula().toString()));    
                }
            }else{
                msg.msgNenhumaMatricula();   
            }
        }      
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

                List<Cargos> cargo = dao.Select(f.txtCampoBusca.getText().toUpperCase());
                DefaultTableModel model = (DefaultTableModel) f.jGridBusca.getModel();
                model.setNumRows(cargo.size());
                if (cargo.size() > 0) {
                    for (Cargos ca : cargo) {
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
                List<Alunos> aluno = daoalu.Select(f.txtCampoBusca.getText().toUpperCase());
                DefaultTableModel model2 = (DefaultTableModel) f.jGridBusca.getModel();
                model2.setNumRows(aluno.size());
                if (aluno.size() > 0) {
                    for (Alunos al : aluno) {
                        for (int i = 0; i < aluno.size(); i++) {
                            f.jGridBusca.setValueAt(aluno.get(i).getFd_aluno(), i, 0);
                            f.jGridBusca.setValueAt(aluno.get(i).getFd_nome(), i, 1);
                            f.jGridBusca.setValueAt(aluno.get(i).getFd_status(), i, 2);

                        }
                    }
                } else {
                    msg.msgNenhumRegistro();
                }
                break;

            case 3:
                DaoFuncionarios daofunc = new DaoFuncionarios();
                List<Funcionarios> func = daofunc.Select(f.txtCampoBusca.getText().toUpperCase());
                DefaultTableModel model3 = (DefaultTableModel) f.jGridBusca.getModel();
                model3.setNumRows(func.size());
                if (func.size() > 0) {
                    for (Funcionarios al : func) {
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
                List<Cursos> curso = daocurso.Select(f.txtCampoBusca.getText().toUpperCase());
                DefaultTableModel model4 = (DefaultTableModel) f.jGridBusca.getModel();
                model4.setNumRows(curso.size());
                if (curso.size() > 0) {
                    for (Cursos c : curso) {
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
                List<Disciplinas> disc = daodisc.Select(f.txtCampoBusca.getText().toUpperCase());
                DefaultTableModel model5 = (DefaultTableModel) f.jGridBusca.getModel();
                model5.setNumRows(disc.size());
                if (disc.size() > 0) {
                    for (Disciplinas c : disc) {
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
                List<Itens> item = daoitem.Select(f.txtCampoBusca.getText().toUpperCase());
                DefaultTableModel model6 = (DefaultTableModel) f.jGridBusca.getModel();
                model6.setNumRows(item.size());
                if (item.size() > 0) {
                    for (Itens c : item) {
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
            case 7:
                DaoAluno daoalu2 = new DaoAluno();
                Mensalidades mens = new Mensalidades();
                List<Alunos> aluno2 = daoalu2.Select(f.txtCampoBusca.getText().toUpperCase());
                DefaultTableModel model7 = (DefaultTableModel) f.jGridBusca.getModel();
                model7.setNumRows(aluno2.size());
                if (aluno2.size() > 0) {
                    for (Alunos al : aluno2) {
                        for (int i = 0; i < aluno2.size(); i++) {
                            f.jGridBusca.setValueAt(aluno2.get(i).getFd_aluno(), i, 0);
                            f.jGridBusca.setValueAt(aluno2.get(i).getFd_nome(), i, 1);
                            f.jGridBusca.setValueAt(aluno2.get(i).getFd_status(), i, 2);

                        }
                    }
                } else {
                    msg.msgNenhumRegistro();
                }
                break;
        }

    }

}
