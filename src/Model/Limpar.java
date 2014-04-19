/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Views.CadAluno;
import Views.CadCargos;
import Views.CadCursos;
import Views.CadFuncionarios;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author Elison
 */
public class Limpar {
    
       
    public void LimpaCargo(CadCargos c){
        c.txtCodigo.setText("");
        c.txtDescricao.setText("");
        c.cbStatus.setSelectedIndex(0);
        c.txtCodigo.setEnabled(true);
    
    }
        
    public void LimpaDisciplina(JTextField txtdescricao, JComboBox comboStatus){
                
        txtdescricao.setText("");
        comboStatus.setSelectedIndex(0);
        
    
    }
     public void LimpaCurso(CadCursos c){
        c.txtCodigo.setText("");
        c.txtDescricao.setText("");
        c.cbStatus.setSelectedIndex(0);
        c.txtCodigo.setEnabled(true);
    
    }
    
    public void LimpaItens(JTextField txtdescricao,JTextField txtValor, JComboBox comboStatus){
                
        txtdescricao.setText("");
        txtValor.setText("");
        comboStatus.setSelectedIndex(0);
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
    
    public void LimpaCadUsuario(JTextField txtNome, JTextField txtUsuario, JTextField txtSenha, JTextField txtReSenha, JComboBox cbStatus, JComboBox cbStatusUser) {
        txtNome.setText("");
        txtUsuario.setText("");
        txtSenha.setText("");
        txtReSenha.setText("");
        cbStatus.setSelectedIndex(0);
        cbStatusUser.setSelectedIndex(0);
    }
}
