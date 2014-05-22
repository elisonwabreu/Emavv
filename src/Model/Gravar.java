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
import Daos.DaoUsuarios;
import Views.CadAluno;
import Views.CadCargos;
import Views.CadCursos;
import Views.CadDisciplinas;
import Views.CadFuncionarios;
import Views.CadMatriculas;
import Views.CadUsuarios;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.entities.classes.Matriculados;
import org.entities.classes.tb_alunos;
import org.entities.classes.tb_cargos;
import org.entities.classes.tb_cursos;
import org.entities.classes.tb_disciplinas;
import org.entities.classes.tb_funcionarios;
import org.entities.classes.tb_itens;
import org.entities.classes.tb_matriculas;
import org.entities.classes.tb_usuarios;

/**
 *
 * @author suporte
 */
public class Gravar extends JFrame{
   
    Validacoes val = new Validacoes();
    tb_cargos cargo = new tb_cargos();
    DaoCargo dao = new DaoCargo(); 
    Limpar limpa = new Limpar();
    
    public void Cargo(CadCargos c) throws SQLException{
   
    if(val.ValidaGravacao(c.txtDescricao, c.cbStatus) == true){
     String codigo = c.txtCodigo.getText();
     String descricao = c.txtDescricao.getText();
     String status = "";
    if (c.cbStatus.getSelectedIndex() == 1){
       status = "A"; 
    }else{
       status = "I";     
    }
    cargo.setFd_descricao(descricao);
    cargo.setFd_status(status);
    
    if(codigo.trim().equals("")){
       
        if(dao.Inserir(cargo) == true){
        limpa.LimpaCargo(c);
        val.ButtonClick(c);
     }  
    }else{
        if(dao.Update(c,status) == true){
        limpa.LimpaCargo(c);
        val.ButtonClick(c);
    }
   } 
  }
}
   
    public void Aluno(CadAluno a) throws SQLException, ParseException{

        DaoAluno al = new DaoAluno();
        tb_alunos aluno = new tb_alunos();
        //int codigo = Integer.parseInt(a.txtCodigo.getText()); 
        String nome = a.txtNome.getText();
        String cpf = val.AjusteCaracter(a.txtCpf.getText());
        String rg = a.txtRg.getText();
        String dtNasc = a.txtDtNascimento.getText();
        String sexo = a.cbSexo.getSelectedItem().toString();
        String endereco = a.txtEndereco.getText();
        String  num;
        
        if(a.txtNum.getText().trim().equals("")){
           num = null; 
        }else{
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

       if (a.cbSexo.getSelectedIndex() == 1){
           sexo = "F"; 
       }else{
           sexo = "M";     
       }  
       if (a.cbStatus.getSelectedIndex() == 1){
           status = "A"; 
       }else{
           status = "I";     
       }
       /*
       if(codigo != 0){
           aluno.setFd_aluno(codigo);   
       }
       */
       aluno.setFd_nome(nome.toUpperCase());
       if(cpf.equals("")){
         aluno.setFd_cpf(null);  
       }else{
           aluno.setFd_cpf(cpf);
       }
       aluno.setFd_rg(rg);
       
       if(dtNasc.equals("  /  /    ")){
         aluno.setFd_data_nasc(null);  
       }else{
         aluno.setFd_data_nasc(val.FormataData(dtNasc));
       }
       
       aluno.setFd_sexo(sexo);
       aluno.setFd_endereco(endereco.toUpperCase());
       
       if(num != null){
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

       if(a.txtCodigo.getText().equals("")){
            if(val.ValidaGravacaoAlunos(cpf,a) == true){
                 if(al.Inserir(aluno) == true){
                   limpa.LimpaAluno(a);  
               }  
            }
          }else if(val.ValidaGravacaoAlunos(cpf,a) == true){
              if(al.Update(aluno,status) == true){
                limpa.LimpaAluno(a);  
            }        
        }
    } 
    
  public void Funcionario(CadFuncionarios fun) throws SQLException, ParseException{
     //Instacia DaoFuncionarios
        DaoFuncionarios func = new DaoFuncionarios();
         tb_funcionarios funcionario = new tb_funcionarios();
    
     String nome = fun.txtNome.getText();
     String cpf = fun.txtCpf.getText();
     String rg = fun.txtRg.getText();
     String dtNasc = fun.txtDtNascimento.getText();
     String sexo = fun.comboSexo.getSelectedItem().toString();
     String endereco = fun.txtEndereco.getText();
     int  num = Integer.parseInt(fun.txtNum.getText());
     String uf = fun.comboUF.getSelectedItem().toString();
     String cidade = fun.txtCidade.getText();
     String celular = fun.txtCelular.getText();
     String email = fun.txtCep.getText();
     String bairro = fun.txtbairro.getText();
     String cep = fun.txtCep.getText();
     String telefone = fun.txtTelefone.getText();
     String status = fun.comboStatus.getSelectedItem().toString();
     
    if (fun.comboSexo.getSelectedIndex() == 1){
        status = "F"; 
    }else{
        status = "M";     
    }
    
    if (fun.comboStatus.getSelectedIndex() == 1){
        status = "A"; 
    }else{
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
    
    
    if(fun.txtCodigo.getText().equals("")){
            if(val.ValidaGravacaoFunc(cpf,fun) == true){
                 if(func.Inserir(funcionario) == true){
                   limpa.LimpaFuncionario(fun);  
               }  
            }
          }else if(val.ValidaGravacaoFunc(cpf,fun) == true){
              if(func.Update(funcionario,status) == true){
                limpa.LimpaFuncionario(fun);  
            }  
          }
    } 
  
    public void DisciplinaGravar(CadDisciplinas dis) throws SQLException{
     //Instacia DaoDisciplinas
        DaoDisciplinas disciplina = new DaoDisciplinas();
        tb_disciplinas novo = new tb_disciplinas(0, null, null);
    
     String descricao = dis.txtDisciplina.getText();
     String status = dis.comboStatus.getSelectedItem().toString();
     
       
    if (dis.comboStatus.getSelectedIndex() == 1){
        status = "A"; 
    }else{
        status = "I";     
    }
    novo.setFd_descricao(descricao.toUpperCase());
    novo.setFd_status(status);
    
    disciplina.Inserir(novo);
     
    

    }    
    
    public void Cursos(CadCursos c) throws SQLException{
     //Instacia DaoDisciplinas
        DaoCursos curso = new DaoCursos();
        tb_cursos novo = new tb_cursos();
     //int codigo = Integer.parseInt(c.txtCodigo.getText());
     String descricao = c.txtDescricao.getText();
     double valor  = Double.parseDouble(c.txtValor.getText());
     String status = c.cbStatus.getSelectedItem().toString();
     
       
    if (c.cbStatus.getSelectedIndex() == 1){
        status = "A"; 
    }else{
        status = "I";     
    }
   // novo.setFd_curso(codigo);
    novo.setFd_descricao(descricao.toUpperCase());
    novo.setFd_status(status);
    novo.setFd_valor(valor);
    
    
    curso.Inserir(novo);
     
    

    }    
   public void Itens(JTextField txtDescricao,JTextField txtValor,JComboBox comboStatus) throws SQLException{
     //Instacia DaoDisciplinas
        DaoItens item = new DaoItens();
        tb_itens novo = new tb_itens(0,null,0.0,null);
    
     String descricao = txtDescricao.getText();
     Double valor = Double.parseDouble(txtValor.getText());
     String status = comboStatus.getSelectedItem().toString();
     
       
    if (comboStatus.getSelectedIndex() == 1){
        status = "A"; 
    }else{
        status = "I";     
    }
    novo.setFd_descricao(descricao.toUpperCase());
    novo.setFd_valor(valor);
    novo.setFd_status(status);
    
    item.Inserir(novo);
     
    limpa.LimpaItens(txtDescricao, txtValor, comboStatus);

    } 
   
   public void insertUsuario(CadUsuarios u) throws SQLException{
           
           DaoUsuarios user = new  DaoUsuarios();
           tb_usuarios usuario = new tb_usuarios();
           
           int cod = Integer.parseInt(u.txtCodigo.getText());
           String nomeUser = u.txtUsuario.getText();
           String senha1 = u.txtSenha.getText();
           String senha2 = u.txtReSenha.getText();
           String status = u.cbStatusUser.getSelectedItem().toString();
           
           if (u.cbStatusUser.getSelectedIndex() == 0){
            status = "A"; 
            }else{
            status = "I";     
            }
          
           if(val.senhaValida(senha1, senha2)== true) {
               usuario.setFd_funcionario(cod);
               usuario.setFd_login(nomeUser);
               usuario.setFd_senha(senha1);
               usuario.setFd_status(status);
               if(senha1.length() >= 6 && senha1.length() <=12){
               user.Inserir(usuario);
               }else{
                 JOptionPane.showMessageDialog(null, "Total de Caracteres para senha invalido.\r\n"
                         + "Sua senha deve conter no min. 6 e no máx. 12");  
               }
        } else {
               JOptionPane.showMessageDialog(null, "Ação não executada");
                   
        }
   
   }
   
   public void GravaMatricula(CadMatriculas a) throws ParseException, SQLException{
       DaoMatricula matr = new DaoMatricula();
       tb_matriculas novoMatr = new tb_matriculas();
       
       int codAluno = Integer.parseInt(a.txtCodigo.getText());
       int matricula = Integer.parseInt(a.txtMatricula.getText());
       String data = a.txtDtCadastro.getText();
       
      
      novoMatr.setFd_matricula(matricula);
      novoMatr.setFd_aluno(codAluno);
      novoMatr.setFd_data_matricula(val.FormataData(data));
       
      matr.Inserir(novoMatr);
   }
}
