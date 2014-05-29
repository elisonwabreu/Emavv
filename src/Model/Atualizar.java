/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Funcao.Limpar;
import Daos.DaoAluno;
import Views.CadAluno;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JFrame;
import org.entities.classes.tb_alunos;

/**
 *
 * @author suporte
 */
public class Atualizar extends JFrame {

    Validacoes val = new Validacoes();
    Limpar limpa = new Limpar();

    public void AtualizarAluno(CadAluno a) throws ParseException, SQLException {

        DaoAluno al = new DaoAluno();
        tb_alunos aluno = new tb_alunos();
        //int codigo = Integer.parseInt(a.txtCodigo.getText()); 
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
            if (val.ValidaGravacaoAlunos(cpf, a) == true) {
                if (al.Update(aluno) == true) {
                    limpa.LimpaAluno(a);
                }
            }
        } else if (val.ValidaGravacaoAlunos(cpf, a) == true) {
            if (al.Update(aluno, status) == true) {
                limpa.LimpaAluno(a);
            }
        }

    }

}
