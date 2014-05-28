/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import ConnectionFactory.*;
import Daos.DaoAluno;
import Daos.DaoCargo;
import Daos.DaoCursos;
import Daos.DaoFuncionarios;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.entities.classes.tb_alunos;
import org.entities.classes.tb_cargos;
import org.entities.classes.tb_cursos;
import org.entities.classes.tb_funcionarios;

/**
 *
 * @author athalias
 */
public class Validacoes extends JFrame {

    Cmessage msg = new Cmessage();

    public boolean ValidaGravacao(JTextField txtDescricao, JComboBox cbStatus) {

        if (txtDescricao.getText().equals("")) {
            msg.MsgCamposObrigatorios("Descricao");
            return false;
        } else if (cbStatus.getSelectedIndex() == 0) {
            msg.MsgCamposObrigatorios("Status");
            return false;
        } else {
            return true;
        }
    }
    /*
     *Validação para os campos do cadastro de aluno.
     */

    public boolean CamposObrigatorios(CadAluno c) {

        if (c.txtNome.getText().equals("")) {
            msg.MsgCamposObrigatorios("Nome");
            c.txtNome.grabFocus();
            return false;

        } else if (c.txtEndereco.getText().equals("")) {
            msg.MsgCamposObrigatorios("Endereco");
            c.txtEndereco.grabFocus();
            return false;

        } else if (c.txtbairro.getText().equals("")) {
            msg.MsgCamposObrigatorios("Bairro");
            c.txtbairro.grabFocus();
            return false;

        } else if (c.txtCidade.getText().equals("")) {
            msg.MsgCamposObrigatorios("Cidade");
            c.txtCidade.grabFocus();
            return false;

        } else if (c.cbSexo.getSelectedIndex() == 0) {
            msg.MsgCamposObrigatorios("Sexo");
            c.cbSexo.grabFocus();
            return false;

        } else if (c.cbUf.getSelectedIndex() == 0) {
            msg.MsgCamposObrigatorios("UF");
            c.cbUf.grabFocus();
            return false;

        } else if (AjusteCaracter(c.txtCelular.getText()).equals("")) {
            msg.MsgCamposObrigatorios("Celular");
            c.txtCelular.grabFocus();
            return false;

        } else {
            return true;
        }
    }

    public boolean CamposObrigatorios(CadFuncionarios c) {

        if (c.txtNome.getText().equals("")) {
            msg.MsgCamposObrigatorios("Nome");
            c.txtNome.grabFocus();
            return false;

        } else if (c.txtEndereco.getText().equals("")) {
            msg.MsgCamposObrigatorios("Endereco");
            c.txtEndereco.grabFocus();
            return false;

        } else if (c.txtbairro.getText().equals("")) {
            msg.MsgCamposObrigatorios("Bairro");
            c.txtbairro.grabFocus();
            return false;

        } else if (c.txtCidade.getText().equals("")) {
            msg.MsgCamposObrigatorios("Cidade");
            c.txtCidade.grabFocus();
            return false;

        } else if (c.comboSexo.getSelectedIndex() == 0) {
            msg.MsgCamposObrigatorios("Sexo");
            c.comboSexo.grabFocus();
            return false;

        } else if (c.comboUF.getSelectedIndex() == 0) {
            msg.MsgCamposObrigatorios("UF");
            c.comboUF.grabFocus();
            return false;

        } else if (AjusteCaracter(c.txtCelular.getText()).equals("")) {
            msg.MsgCamposObrigatorios("Celular");
            c.txtCelular.grabFocus();
            return false;

        } else {
            return true;
        }
    }

    public boolean ValidaGravacaoDisciplina(CadDisciplinas dis) {

        if (dis.txtDisciplina.getText().equals("")) {
            msg.MsgCamposObrigatorios("Descrição");
            return false;
        } else if (dis.comboStatus.getSelectedIndex() == 0) {
            msg.MsgCamposObrigatorios("Status");
            return false;
        } else {
            return true;
        }

    }
    /*Fim da validação do preenchimento dos campos de Disciplinas -------------------------------*/

    public boolean ValidaGravacaoCusrsos(CadCursos cur) {

        if (cur.txtDescricao.getText().equals("")) {
            msg.MsgCamposObrigatorios("Descrição");
            return false;
        } else if (cur.cbStatus.getSelectedIndex() == 0) {
            msg.MsgCamposObrigatorios("Status");
            return false;
        } else {
            return true;
        }

    }
    /*
     *Validação para os campos do cadastro de Disciplinas.
     */

    public boolean ValidaGravacaoItem(CadItens item) {

        if (item.txtItem.getText().equals("")) {
            msg.MsgCamposObrigatorios("Descrição");
            return false;
        } else if (item.txtPreco.getText().equals("")) {
            msg.MsgCamposObrigatorios("Valor");
            return false;
        } else if (item.comboStatus.getSelectedIndex() == 0) {
            msg.MsgCamposObrigatorios("Status");
            return false;
        } else {
            return true;
        }

    }
    /*Fim da validação do preenchimento dos campos de Disciplinas -------------------------------*/

    //KeyPressed Event from JTextField

    public boolean KeyPressedText(CadMatriculas c) {

        if (c.txtCodigo.getText().equals("")) {

            c.btnSalvar.setEnabled(true);
            c.txtCodigo.setEnabled(false);

            return true;
        } else {
            c.btnSalvar.setEnabled(true);
            c.txtCodigo.setEnabled(false);
            return false;
        }
    }

    public boolean KeyPressedText(CadItens c) {

        if (c.txtCodigo.getText().equals("")) {

            c.btnSalvar.setEnabled(true);
            c.txtCodigo.setEnabled(false);

            return true;
        } else {
            c.btnSalvar.setEnabled(true);
            c.txtCodigo.setEnabled(false);
            return false;
        }
    }

    public boolean KeyPressedText(CadDisciplinas c) {

        if (c.txtCodigo.getText().equals("")) {

            c.btnSalvar.setEnabled(true);
            c.txtCodigo.setEnabled(false);

            return true;
        } else {
            c.btnSalvar.setEnabled(true);
            c.txtCodigo.setEnabled(false);
            return false;
        }
    }

    //-------------------------------------------------------------------
    public boolean KeyPressedText(CadCargos c) {

        if (c.txtCodigo.getText().equals("")) {

            c.btnSalvar.setEnabled(true);
            c.btnLimpar.setEnabled(true);
            c.txtDescricao.grabFocus();
            c.txtCodigo.setEnabled(false);
            c.btnPesquisa.setEnabled(false);
            c.cbStatus.setSelectedIndex(1);
            return true;
        } else {
            c.btnExcluir.setEnabled(true);
            c.btnLimpar.setEnabled(true);
            c.btnSalvar.setEnabled(true);
            c.txtCodigo.setEnabled(false);
            c.btnPesquisa.setEnabled(true);
            c.btnPesquisa.setEnabled(true);
            return false;
        }
    }

    public boolean KeyPressedText(CadAluno a) {

        if (a.txtCodigo.getText().equals("")) {

            a.btnSalvar.setEnabled(true);
            a.btnLimpar.setEnabled(true);
            a.txtNome.grabFocus();
            a.txtCodigo.setEnabled(false);
            a.btnBuscar.setEnabled(false);
            a.btnAtualizar.setEnabled(false);
            a.cbStatus.setSelectedIndex(1);
            return true;
        } else {
            a.btnExcluir.setEnabled(true);
            a.btnLimpar.setEnabled(true);
            a.btnSalvar.setEnabled(true);
            a.txtCodigo.setEnabled(false);
            a.btnBuscar.setEnabled(true);
            a.btnAtualizar.setEnabled(true);
            return false;
        }
    }

    public boolean KeyPressedText(CadFuncionarios a) {

        if (a.txtCodigo.getText().equals("")) {

            a.btnSalvar.setEnabled(true);
            a.btnLimpar.setEnabled(true);
            a.txtNome.grabFocus();
            a.txtCodigo.setEnabled(false);
            a.btnBuscar.setEnabled(false);
            // a.btnAtualizar.setEnabled(false);
            a.comboStatus.setSelectedIndex(1);
            return true;
        } else {
            a.btnExcluir.setEnabled(true);
            a.btnLimpar.setEnabled(true);
            a.btnSalvar.setEnabled(true);
            a.txtCodigo.setEnabled(false);
            a.btnBuscar.setEnabled(true);
            //a.btnAtualizar.setEnabled(true);
            return false;
        }
    }

    public boolean KeyPressedText(CadCursos c) {

        if (c.txtCodigo.getText().equals("")) {

            c.btnSalvar.setEnabled(true);
            c.btnLimpar.setEnabled(true);
            c.txtDescricao.grabFocus();
            c.txtCodigo.setEnabled(false);
            c.btPesquisa.setEnabled(false);
            c.cbStatus.setSelectedIndex(1);
            return true;
        } else {
            c.btnExcluir.setEnabled(true);
            c.btnLimpar.setEnabled(true);
            c.btnSalvar.setEnabled(true);
            c.txtCodigo.setEnabled(false);
            c.btPesquisa.setEnabled(true);
            return false;
        }
    }

    public boolean KeyPressedText(CadUsuarios u) {

        if (u.txtCodigo.getText().equals("")) {

            u.btnSalvar.setEnabled(true);
            u.btnLimpar.setEnabled(true);
            u.txtNome.grabFocus();
            u.txtCodigo.setEnabled(false);
            u.btPesquisa.setEnabled(false);
            u.cbStatus.setSelectedIndex(1);
            return true;
        } else {
            u.btnExcluir.setEnabled(true);
            u.btnLimpar.setEnabled(true);
            u.btnSalvar.setEnabled(true);
            u.txtCodigo.setEnabled(false);
            u.btPesquisa.setEnabled(true);
            return false;
        }
    }

    public void ButtonClick(CadUsuarios c) {

        c.btnExcluir.setEnabled(false);
        c.btnLimpar.setEnabled(false);
        c.bntRelatorio.setEnabled(false);
        c.btnSalvar.setEnabled(false);
        c.txtCodigo.setEnabled(true);
        c.txtCodigo.grabFocus();
    }

    public void ButtonClick(CadCargos c) {

        c.btnExcluir.setEnabled(false);
        c.btnLimpar.setEnabled(false);
        c.bntRelatorio.setEnabled(false);
        c.btnSalvar.setEnabled(false);
        c.btnPesquisa.setEnabled(true);
        c.txtCodigo.setEnabled(true);
        c.txtCodigo.grabFocus();
    }

    public void ButtonClick(CadItens c) {

        c.btnExcluir.setEnabled(false);
        c.btnLimpar.setEnabled(false);
        c.bntRelatorio.setEnabled(false);
        c.btnSalvar.setEnabled(false);
        c.btnBuscar.setEnabled(true);
        c.txtCodigo.setEnabled(true);
        c.txtCodigo.grabFocus();
    }

    public void ButtonClick(CadDisciplinas c) {
        if(c.txtCodigo.getText().equals("")){
            c.btnExcluir.setEnabled(false);
            c.btnLimpar.setEnabled(false);
            c.bntRelatorio.setEnabled(false);
            c.btnSalvar.setEnabled(false);
            c.btnBuscar.setEnabled(true);
            c.txtCodigo.setEnabled(true);
            c.txtCodigo.grabFocus();
        }else{
            c.btnExcluir.setEnabled(true);
            c.btnLimpar.setEnabled(true);
            c.bntRelatorio.setEnabled(true);
            c.btnSalvar.setEnabled(false);
            c.btnBuscar.setEnabled(true);
            c.txtCodigo.setEnabled(true);
            c.txtCodigo.grabFocus();
        }
    }

    public void ButtonClick(CadMatriculas c) {

        c.btnSalvar.setEnabled(false);
        c.txtCodigo.setEnabled(true);
        c.txtCodigo.grabFocus();
    }

    public void ButtonClick(CadAluno a) {

        a.btnExcluir.setEnabled(false);
        a.btnLimpar.setEnabled(false);
        a.bntRelatorio.setEnabled(false);
        a.btnSalvar.setEnabled(false);
        a.btnAtualizar.setEnabled(false);
        a.btnBuscar.setEnabled(true);
        a.txtCodigo.setEnabled(true);
        a.txtCodigo.grabFocus();
    }

    public void ButtonClick(CadFuncionarios a) {

        a.btnExcluir.setEnabled(false);
        a.btnLimpar.setEnabled(false);
        a.bntRelatorio.setEnabled(false);
        a.btnSalvar.setEnabled(false);
        //a.btnAtualizar.setEnabled(false);
        a.btnBuscar.setEnabled(true);
        a.txtCodigo.setEnabled(true);
        a.txtCodigo.grabFocus();
    }

    public void ButtonClick(CadCursos c) {

        c.btnExcluir.setEnabled(false);
        c.btnLimpar.setEnabled(true);
        c.bntRelatorio.setEnabled(true);
        c.btnSalvar.setEnabled(true);
        c.btPesquisa.setEnabled(true);
        c.txtCodigo.setEnabled(true);
        c.txtCodigo.grabFocus();
    }

    public String AjusteCaracter(String carac) {

        String[] caracEspecial = {".", "-", "(", ")"};
        String str = carac;

        for (int i = 0; i < caracEspecial.length; i++) {

            str = str.replace(caracEspecial[i], "");
        }
        return str.trim();
    }

    public Date FormataData(String data) throws ParseException {

        Date date = new Date(data);

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date dataUtil = new java.util.Date();
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

        return date;
    }

    public String FormataDataSelec(String data) {

        String date = data;
        //1997/11/02
        date = date.substring(8, 10) + "/" + date.substring(5, 7) + "/" + date.substring(0, 4);

        return date;
    }

    public boolean validaCPF(String strCpf) {
        int iDigito1Aux = 0, iDigito2Aux = 0, iDigitoCPF;
        int iDigito1 = 0, iDigito2 = 0, iRestoDivisao = 0;
        String strDigitoVerificador, strDigitoResultado;

        if (!strCpf.substring(0, 1).equals("")) {
            try {
                strCpf = strCpf.replace('.', ' ');
                strCpf = strCpf.replace('-', ' ');
                strCpf = strCpf.replaceAll(" ", "");
                for (int iCont = 1; iCont < strCpf.length() - 1; iCont++) {
                    iDigitoCPF = Integer.parseInt(strCpf.substring(iCont - 1, iCont));
                    iDigito1Aux = iDigito1Aux + (11 - iCont) * iDigitoCPF;
                    iDigito2Aux = iDigito2Aux + (12 - iCont) * iDigitoCPF;
                }
                iRestoDivisao = (iDigito1Aux % 11);
                if (iRestoDivisao < 2) {
                    iDigito1 = 0;
                } else {
                    iDigito1 = 11 - iRestoDivisao;
                }
                iDigito2Aux += 2 * iDigito1;
                iRestoDivisao = (iDigito2Aux % 11);
                if (iRestoDivisao < 2) {
                    iDigito2 = 0;
                } else {
                    iDigito2 = 11 - iRestoDivisao;
                }
                strDigitoVerificador = strCpf.substring(strCpf.length() - 2, strCpf.length());
                strDigitoResultado = String.valueOf(iDigito1) + String.valueOf(iDigito2);
                return strDigitoVerificador.equals(strDigitoResultado);
            } catch (NumberFormatException e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public void clickBtPesquisa(int tableIndex, JTextField txtCodigo, String tabela) {

        FormBusca busca = new FormBusca();
        busca.setVisible(true);
        busca.tableIndex = tableIndex;
        busca.setTxtCodigo(txtCodigo);
        busca.tabela = tabela;

    }

    public void setTextUp(CadCargos c) {

        String nome = c.txtDescricao.getText().toUpperCase();
        c.txtDescricao.setText(nome);
    }
    public void setTextUp(CadUsuarios c) {

        String nome = c.txtUsuario.getText().toUpperCase();
        c.txtUsuario.setText(nome);
    }
    public void setTextUp(Form_TelaLogin c) {

        String nome = c.txtLogin.getText().toUpperCase();
        c.txtLogin.setText(nome);
    }
    public void setTextUp(CadItens c) {

        String nome = c.txtItem.getText().toUpperCase();
        c.txtItem.setText(nome);
    }
    public void setTextUp(CadDisciplinas c) {

        String nome = c.txtDisciplina.getText().toUpperCase();
        c.txtDisciplina.setText(nome);
    }
    public void setTextUp(CadCursos c) {

        String nome = c.txtDescricao.getText().toUpperCase();
        c.txtDescricao.setText(nome);
    }

    public void setTextUp(CadAluno a) {

        String nome = a.txtNome.getText().toUpperCase();
        String endereco = a.txtEndereco.getText().toUpperCase();
        String bairro = a.txtbairro.getText().toUpperCase();
        String cidade = a.txtCidade.getText().toUpperCase();

        a.txtNome.setText(nome);
        a.txtEndereco.setText(endereco);
        a.txtbairro.setText(bairro);
        a.txtCidade.setText(cidade);

    }
    public void setTextUp(CadFuncionarios a) {

        String nome = a.txtNome.getText().toUpperCase();
        String endereco = a.txtEndereco.getText().toUpperCase();
        String bairro = a.txtbairro.getText().toUpperCase();
        String cidade = a.txtCidade.getText().toUpperCase();

        a.txtNome.setText(nome);
        a.txtEndereco.setText(endereco);
        a.txtbairro.setText(bairro);
        a.txtCidade.setText(cidade);

    }

    public boolean senhaValida(String senha1, String senha2) {

        if (senha1.equals(senha2)) {
            return true;
        } else {

            JOptionPane.showMessageDialog(null, "Senhas não conferem. Verifique!", "Senhas", JOptionPane.WARNING_MESSAGE);

            return false;
        }
    }

    public boolean CpfJaExiste(String cpf) {

        boolean podeGravar = false;
        int getCodigoAluno = 0;
        DaoAluno dao = new DaoAluno();
        List<tb_alunos> aluno = dao.SelectCpf(cpf);

        if (aluno.size() == 0) {
            podeGravar = true;
        } else {
            return false;
        }

        return podeGravar;
    }

    public boolean CpfJaExisteFunc(String cpf) {

        boolean podeGravar = false;
        int getCodigoFunc = 0;
        DaoFuncionarios dao = new DaoFuncionarios();
        List<tb_funcionarios> func = dao.SelectCpf(cpf);

        if (func.isEmpty()) {
            podeGravar = true;
        } else {
            return false;
        }

        return podeGravar;
    }

    public boolean ValidaGravacaoFunc(String cpf, CadFuncionarios c) {

        boolean grava = true;

        if (cpf.equals("")) {

        } else {
            if (validaCPF(cpf) == false) {

                JOptionPane.showMessageDialog(null, "CPF: " + cpf + " "
                        + "Não é válido.", "Grava Aluno", JOptionPane.WARNING_MESSAGE);
                grava = false;
            }
            if (CpfJaExiste(cpf) == false) {

                JOptionPane.showMessageDialog(null, "CPF: " + cpf + " "
                        + "Já cadastrado.", "Grava Aluno", JOptionPane.WARNING_MESSAGE);
                grava = false;
            }

        }

        if (CamposObrigatorios(c) == false) {
            return false;
        }

        return grava;
    }

    public boolean ValidaGravacaoAlunos(String cpf, CadAluno c) {

        boolean grava = true;

        if (cpf.equals("")) {

        } else {
            if (validaCPF(cpf) == false) {

                JOptionPane.showMessageDialog(null, "CPF: " + cpf + " "
                        + "Não é válido.", "Grava Aluno", JOptionPane.WARNING_MESSAGE);
                grava = false;
            }

            if (CpfJaExiste(cpf) == false) {

                JOptionPane.showMessageDialog(null, "CPF: " + cpf + " "
                        + "Já cadastrado.", "Grava Aluno", JOptionPane.WARNING_MESSAGE);
                grava = false;
            }

        }

        if (CamposObrigatorios(c) == false) {
            return false;
        }

        return grava;
    }

    public boolean CamposLogin(Form_TelaLogin c) {

        if (c.txtLogin.getText().equals("")) {
            msg.MsgCamposObrigatorios("Login");

            return false;

        } else if (c.txtSenha.getText().equals("")) {
            msg.MsgCamposObrigatorios("Senha");

            return false;
        }
        return true;
    }

}
