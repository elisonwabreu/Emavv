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
import Metodos.GerarMensalidade;
import Metodos.Limpar;
import Views.CadAluno;
import Views.CadCargos;
import Views.CadCursos;
import Views.CadDisciplinas;
import Views.CadFuncionarios;
import Views.CadItens;
import Views.CadMatriculas;
import Views.CadUsuarios;
import Views.FormGeraMensalidade;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
public class Gravar extends JFrame {

    Validacoes val = new Validacoes();
    Cargos cargo = new Cargos();
    DaoCargo dao = new DaoCargo();
    Limpar limpa = new Limpar();

    public void Cargo(CadCargos c) throws SQLException {

        if (val.ValidaGravacao(c.txtDescricao, c.cbStatus) == true) {
            String codigo = c.txtCodigo.getText();
            String descricao = c.txtDescricao.getText();
            String status = "";
            if (c.cbStatus.getSelectedIndex() == 1) {
                status = "A";
            } else {
                status = "I";
            }
            cargo.setFd_descricao(descricao);
            cargo.setFd_status(status);

            if (codigo.trim().equals("")) {

                if (dao.Inserir(cargo) == true) {
                    limpa.LimpaCargo(c);
                    val.ButtonClick(c);
                }
            } else {
                if (dao.Update(c, status) == true) {
                    limpa.LimpaCargo(c);
                    val.ButtonClick(c);
                }
            }
        }
    }

    public void Aluno(CadAluno a) throws SQLException, ParseException {

        DaoAluno al = new DaoAluno();
        Alunos aluno = new Alunos();

        //int codigo = Integer.parseInt(a.txtCodigo.getText());

        int codigo = Integer.parseInt(a.txtCodigo.getText());

        String nome = a.txtNome.getText();
        String cpf = val.AjusteCaracter(a.txtCpf.getText());
        String rg = a.txtRg.getText();
        String dtNasc = a.txtDtNascimento.getText();
        String sexo = a.cbSexo.getSelectedItem().toString();
        String endereco = a.txtEndereco.getText();
        String num;

        if (a.txtNum.getText().trim().equals("")) {
            num = null;
        } else {
            num = a.txtNum.getText();
        }

        String bairro = a.txtbairro.getText();
        String cidade = a.txtCidade.getText();
        String cep = a.txtCep.getText();
        String uf = a.cbUf.getSelectedItem().toString();
        String telefone = a.txtTelefone.getText();
        String celular = a.txtCelular.getText();
        String email = a.txtEmail.getText();
        String status = a.cbStatus.getSelectedItem().toString();

        if (a.cbSexo.getSelectedIndex() == 1) {
            sexo = "F";
        } else {
            sexo = "M";
        }
        if (a.cbStatus.getSelectedIndex() == 1) {
            status = "A";
        } else {
            status = "I";
        }
        /*
         if(codigo != 0){
         aluno.setFd_aluno(codigo);   
         }
         */
        aluno.setFd_nome(nome.toUpperCase());
        if (cpf.equals("")) {
            aluno.setFd_cpf(null);
        } else {
            aluno.setFd_cpf(cpf);
        }
        aluno.setFd_rg(rg);

        if (dtNasc.equals("  /  /    ")) {
            aluno.setFd_data_nasc(null);
        } else {
            aluno.setFd_data_nasc(val.FormataData(dtNasc));
        }

        aluno.setFd_sexo(sexo);
        aluno.setFd_endereco(endereco.toUpperCase());

        if (num != null) {
            aluno.setFd_numero(num);
        }

        aluno.setFd_bairro(bairro.toUpperCase());
        aluno.setFd_cidade(cidade.toUpperCase());
        aluno.setFd_cep(val.AjusteCaracter(cep));
        aluno.setFd_uf(uf);
        aluno.setFd_telefone(val.AjusteCaracter(telefone));
        aluno.setFd_celular(val.AjusteCaracter(celular));
        aluno.setFd_email(email.toUpperCase());
        aluno.setFd_status(status);

        if (a.txtCodigo.getText().equals("")) {

            if(al.Inserir(aluno) == true)
            limpa.LimpaAluno(a);

        } else {
            if(al.Update(a, status)==true)
            limpa.LimpaAluno(a);
        }

    }

    public void Funcionario(CadFuncionarios fun) throws SQLException, ParseException {
        //Instacia DaoFuncionarios
        DaoFuncionarios func = new DaoFuncionarios();
        Funcionarios funcionario = new Funcionarios();

        String nome = fun.txtNome.getText();
        String cpf = fun.txtCpf.getText();
        String rg = fun.txtRg.getText();
        String dtNasc = fun.txtDtNascimento.getText();
        String sexo = fun.comboSexo.getSelectedItem().toString();
        String endereco = fun.txtEndereco.getText();
        String num = fun.txtNum.getText();
        String uf = fun.comboUF.getSelectedItem().toString();
        String cidade = fun.txtCidade.getText();
        String celular = fun.txtCelular.getText();
        String email = fun.txtCep.getText();
        String bairro = fun.txtbairro.getText();
        String cep = fun.txtCep.getText();
        String telefone = fun.txtTelefone.getText();
        String status = fun.comboStatus.getSelectedItem().toString();

        String cargo =  fun.txtCargo.getText();


        if (fun.comboSexo.getSelectedIndex() == 1) {
            status = "F";
        } else {
            status = "M";
        }

        if (fun.comboStatus.getSelectedIndex() == 1) {
            status = "A";
        } else {
            status = "I";
        }
        funcionario.setFd_nome(nome.toUpperCase());
        funcionario.setFd_cpf((val.AjusteCaracter(cpf)));
        funcionario.setFd_rg(rg);
        funcionario.setFd_data_nasc(val.FormataData(dtNasc));
        funcionario.setFd_sexo(sexo);
        funcionario.setFd_endereco(endereco.toUpperCase());
        funcionario.setFd_numero(num);
        funcionario.setFd_bairro(bairro.toUpperCase());
        funcionario.setFd_cidade(cidade.toUpperCase());
        funcionario.setFd_cep(val.AjusteCaracter(cep));
        funcionario.setFd_uf(uf);
        funcionario.setFd_celular(val.AjusteCaracter(celular));
        funcionario.setFd_email(email.toUpperCase());
        funcionario.setFd_telefone(val.AjusteCaracter(telefone));
        funcionario.setFd_status(status);

        funcionario.setFd_cargo(cargo);


        if (fun.txtCodigo.getText().equals("")) {
            if (val.ValidaGravacaoFunc(cpf, fun) == true) {
                if (func.Inserir(funcionario) == true) {
                    limpa.LimpaFuncionario(fun);
                }
            }
        } else if (val.ValidaGravacaoFunc(cpf, fun) == true) {
            if (func.Update(funcionario, status) == true) {
                limpa.LimpaFuncionario(fun);
            }
        }
    }

    public void DisciplinaGravar(CadDisciplinas dis) throws SQLException {
        //Instacia DaoDisciplinas
        DaoDisciplinas disciplina = new DaoDisciplinas();
        Disciplinas novo = new Disciplinas(0, null, null);

        String descricao = dis.txtDisciplina.getText();
        String status = dis.comboStatus.getSelectedItem().toString();
        int codidoCurso = Integer.parseInt(dis.txtCodigo.getText());

        if (dis.comboStatus.getSelectedIndex() == 1) {
            status = "A";
        } else {
            status = "I";
        }
        novo.setFd_descricao(descricao.toUpperCase());
        novo.setFd_status(status);
        novo.setFd_curso(codidoCurso);

        disciplina.Inserir(novo);

    }

    public void Cursos(CadCursos c) throws SQLException {
        //Instacia DaoDisciplinas
        DaoCursos curso = new DaoCursos();
        Cursos novo = new Cursos();
        //int codigo = Integer.parseInt(c.txtCodigo.getText());
        String descricao = c.txtDescricao.getText();
        double valor = Double.parseDouble(c.txtValor.getText());
        String status = c.cbStatus.getSelectedItem().toString();

        if (c.cbStatus.getSelectedIndex() == 1) {
            status = "A";
        } else {
            status = "I";
        }
        // novo.setFd_curso(codigo);
        novo.setFd_descricao(descricao.toUpperCase());
        novo.setFd_status(status);
        novo.setFd_valor(valor);

        curso.Inserir(novo);

    }

    public void Itens(CadItens i) throws SQLException {
        //Instacia DaoDisciplinas
        DaoItens item = new DaoItens();
        Itens novo = new Itens(0, null, 0.0, null);

        String descricao = i.txtItem.getText();
        Double valor = Double.parseDouble(i.txtPreco.getText());
        String status = i.comboStatus.getSelectedItem().toString();

        if (i.comboStatus.getSelectedIndex() == 1) {
            status = "A";
        } else {
            status = "I";
        }
        novo.setFd_descricao(descricao.toUpperCase());
        novo.setFd_valor(valor);
        novo.setFd_status(status);

        item.Inserir(novo);

        //limpa.LimpaItens(i);
    }

    public void insertUsuario(CadUsuarios u) throws SQLException {

        DaoUsuarios user = new DaoUsuarios();
        Usuarios usuario = new Usuarios();

        int cod = Integer.parseInt(u.txtCodigo.getText());
        String nomeUser = u.txtUsuario.getText();
        String senha1 = u.txtSenha.getText();
        String senha2 = u.txtReSenha.getText();
        String status = u.cbStatusUser.getSelectedItem().toString();

        if (u.cbStatusUser.getSelectedIndex() == 0) {
            status = "A";
        } else {
            status = "I";
        }

        if (val.senhaValida(senha1, senha2) == true) {
            usuario.setFd_funcionario(cod);
            usuario.setFd_login(nomeUser);
            usuario.setFd_senha(senha1);
            usuario.setFd_status(status);
            if (senha1.length() >= 6 && senha1.length() <= 12) {
                user.Inserir(usuario);
            } else {
                JOptionPane.showMessageDialog(null, "Total de Caracteres para senha invalido.\r\n"
                        + "Sua senha deve conter no min. 6 e no máx. 12");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ação não executada");

        }

    }

    public void GravaMatricula(CadMatriculas a) throws ParseException, SQLException {

        
        DaoMatriculados daomatr = new DaoMatriculados();
        DaoMatricula daoMat = new DaoMatricula();
        Matriculados matlds = new Matriculados();
        Matriculas matr = new Matriculas();
        Alunos al = new Alunos();
        Cursos c = new Cursos();
        
        matr.setFd_matricula(Integer.parseInt(a.txtMatricula.getText()));
        matr.setFd_data_matricula(val.FormataData(a.txtDtCadastro.getText()));
        matr.setFd_aluno(al);
        al.setFd_aluno(Integer.parseInt(a.txtCodigo.getText()));
        c.setFd_curso(Integer.parseInt(a.txtCodCurso.getText()));
 
        matlds.setFd_matricula(matr);
        matlds.setFd_aluno(al);
        matlds.setFd_curso(c);
        
        
        daoMat.Inserir(matr);
        daomatr.Inserir(matlds);
        
        /*List lsAluno = new ArrayList();
=======
        DaoMatricula matr = new DaoMatricula();
        Matriculas novoMatr = new Matriculas();

        List lsAluno = new ArrayList();
>>>>>>> 0b71c35422682b591808690d2e051e1d4e01398a
        List lsCurso = new ArrayList();
        lsAluno.add(Integer.parseInt(a.txtCodigo.getText()));
        lsCurso.add(Integer.parseInt(a.txtCodCurso.getText()));
        Alunos alu = new Alunos();
        alu.setFd_aluno(Integer.parseInt(a.txtCodigo.getText()));

        int matricula = Integer.parseInt(a.txtMatricula.getText());

        List<Matriculas> matricad = matr.SelectMatricula(matricula);

        if (matricad.size() > 0) {
            for (Matriculas cr : matricad) {
                if (matricula == cr.getFd_matricula()) {

                    DaoMatriculados matr2 = new DaoMatriculados();
                    Matriculados novomatr2 = new Matriculados();

                    novomatr2.setFd_matricula(novoMatr);
                    novomatr2.setFd_curso(lsCurso);
                    novomatr2.setFd_aluno(lsAluno);
                    matr2.Inserir(novomatr2);

                } else {
                    String data = a.txtDtCadastro.getText();

                    novoMatr.setFd_matricula(matricula);
                    novoMatr.setFd_aluno(alu);
                    novoMatr.setFd_data_matricula(val.FormataData(data));

                    matr.Inserir(novoMatr);

                    DaoMatriculados matr2 = new DaoMatriculados();
                    Matriculados novomatr2 = new Matriculados();

                    novomatr2.setFd_matricula(novoMatr);
                    novomatr2.setFd_curso(lsCurso);
                    novomatr2.setFd_aluno(lsAluno);
                    matr2.Inserir(novomatr2);

                }
            }
        } else {
            System.out.print("ooooooooooooooooo");

        }*/

       

    }

    public void GravaMatricula(int codigo) throws ParseException, SQLException {
        DaoMatricula matr = new DaoMatricula();
        Matriculas novoMatr = new Matriculas();
        Alunos al = new Alunos();
        al.setFd_aluno(codigo);

        java.util.Date date = new java.util.Date(System.currentTimeMillis());
        SimpleDateFormat novaData = new SimpleDateFormat("yyyyHHmmss");
        SimpleDateFormat novaDataMtr = new SimpleDateFormat("yyyymmdd");
        String matricula = novaData.format(date);

        novoMatr.setFd_matricula(Integer.parseInt(matricula));
        novoMatr.setFd_aluno(al);
        novoMatr.setFd_data_matricula(date);
        JOptionPane.showMessageDialog(null, "A matricula gerada  \r\n é: " + matricula + ".");
        matr.Inserir(novoMatr);
    }

    public void MensalidadeDDD(FormGeraMensalidade m) throws ParseException, SQLException {
        DaoMatricula mtr = new DaoMatricula();
        DaoMensalidade mens = new DaoMensalidade();
        DaoCursos curso = new DaoCursos();
        GerarMensalidade gera = new GerarMensalidade();
        Mensalidades novo = new Mensalidades();

        int idAluno = Integer.parseInt(m.txtCodigo.getText());
        int idCurso = Integer.parseInt(m.txtCodigoCurso.getText());

        int matricula;
        List<Matriculas> matriculas = mtr.Select(idAluno);
        List<Cursos> cursos = curso.Select(idCurso);
        for (Matriculas al : matriculas) {
            matricula = al.getFd_matricula();
            for (int i = 0; i < 6; i++) {

                novo.setFd_matricula(matricula);
                novo.setFd_curso(idCurso);
                novo.setFd_aluno(idAluno);
                novo.setFd_vencimento(val.AjusteCaracter(String.valueOf(gera.Gerar())));
                for (Cursos cr : cursos) {
                    novo.setFd_valor(cr.getFd_valor());
                }
                novo.setFd_status("A");
                mens.Inserir(novo);
            }

        }

    }
}
