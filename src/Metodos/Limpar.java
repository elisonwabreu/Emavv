/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Views.CadAluno;
import Views.CadCargos;
import Views.CadCursos;
import Views.CadDisciplinas;
import Views.CadFuncionarios;
import Views.CadItens;
import Views.CadMatriculas;
import Views.CadUsuarios;

/**
 *
 * @author Elison
 */
public class Limpar {

    public void LimpaCargo(CadCargos c) {
        c.txtCodigo.setText("");
        c.txtDescricao.setText("");
        c.cbStatus.setSelectedIndex(0);
        c.txtCodigo.setEnabled(true);

    }

    public void LimpaDisciplina(CadDisciplinas dis) {
        
        dis.txtCodDisciplina.setText("");
        dis.txtDisciplina.setText("");
        dis.comboStatus.setSelectedIndex(0);

    }

    public void LimpaCurso(CadCursos c) {
        c.txtCodigo.setText("");
        c.txtDescricao.setText("");
        c.txtValor.setText("");
        c.cbStatus.setSelectedIndex(0);
        c.txtCodigo.setEnabled(true);

    }

    public void LimpaCurso(CadItens c) {
        c.txtCodigo.setText("");
        c.txtItem.setText("");
        c.txtPreco.setText("");
        c.comboStatus.setSelectedIndex(0);
        c.txtCodigo.setEnabled(true);

    }

    public void LimpaItens(CadItens item) {
        item.txtCodigo.setText("");
        item.txtItem.setText("");
        item.txtPreco.setText("");
        item.comboStatus.setSelectedIndex(0);
    }

    public void LimpaFuncionario(CadFuncionarios fun) {
        fun.txtNome.setText("");
        fun.comboStatus.setSelectedIndex(0);
        fun.comboSexo.setSelectedIndex(0);
        fun.txtCpf.setText("");
        fun.txtRg.setText("");
        fun.txtDtNascimento.setText("");
        fun.txtEndereco.setText("");
        fun.txtNum.setText("");
        fun.comboUF.setSelectedIndex(0);
        fun.txtbairro.setText("");
        fun.txtTelefone.setText("");
        fun.txtCelular.setText("");
        fun.txtCidade.setText("");
        fun.txtCep.setText("");
        fun.txtEmail.setText("");
    }

    public void LimpaAluno(CadAluno a) {

        a.txtCodigo.setEnabled(true);
        a.txtCodigo.grabFocus();
        a.txtCodigo.setText("");
        a.txtNome.setText("");
        a.cbStatus.setSelectedIndex(0);
        a.cbSexo.setSelectedIndex(0);
        a.txtCpf.setText("");
        a.txtRg.setText("");
        a.txtDtNascimento.setText("");
        a.txtEndereco.setText("");
        a.txtNum.setText("");
        a.cbUf.setSelectedIndex(0);
        a.txtbairro.setText("");
        a.txtTelefone.setText("");
        a.txtCelular.setText("");
        a.txtCidade.setText("");
        a.txtCep.setText("");
        a.txtEmail.setText("");
        a.btnBuscar.setEnabled(true);
    }

    public void LimpaMatricula(CadMatriculas a) {

        a.txtCodigo.setEnabled(true);
        a.txtCodigo.grabFocus();
        a.txtCodigo.setText("");
        a.txtNome.setText("");
        a.btnBuscar.setEnabled(true);
    }

    public void LimpaCadUsuario(CadUsuarios user) {
        user.txtNome.setText("");
        user.txtUsuario.setText("");
        user.txtSenha.setText("");
        user.txtReSenha.setText("");
        user.cbStatus.setSelectedIndex(0);
        user.cbStatusUser.setSelectedIndex(0);
    }
}
