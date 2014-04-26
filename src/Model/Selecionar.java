/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.entities.classes.tb_alunos;
import org.entities.classes.tb_cargos;
import org.entities.classes.tb_cursos;
import Daos.DaoAluno;
import Daos.DaoCargo;
import Daos.DaoCursos;
import Messages.Cmessage;
import Views.CadAluno;
import Views.CadCargos;
import Views.CadCursos;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author suporte
 */
public class Selecionar extends JFrame {
    
    Validacoes val = new Validacoes();
    Cmessage msg = new Cmessage();
    Limpar limpa = new Limpar();
    
     public void getJtableValue(int ValueJtable, JTextField txtCodigo ){
        
        String codigo = Integer.toString(ValueJtable);
        txtCodigo.setText(codigo);
        txtCodigo.grabFocus();
   }
     
    public boolean ListarCargos(CadCargos c) throws SQLException{
    
        DaoCargo dao = new DaoCargo();
    
        int codigo = Integer.parseInt(c.txtCodigo.getText());
            
            List<tb_cargos> cargos = dao.Select(codigo);
            
            if(cargos.size() > 0) {

            for(tb_cargos car : cargos ){
               c.txtDescricao.setText(car.getFd_descricao());
            if(car.getFd_status().equals("A")){
               c.cbStatus.setSelectedIndex(1);    
            }else{
               c.cbStatus.setSelectedIndex(2);
               }     
           }
            return true;
           
        }else{
               msg.msgNenhumRegistro();
               limpa.LimpaCargo(c);
               return false;
            }     
      }
    
    public boolean ListarAlunos(CadAluno a) throws SQLException{
    
        DaoAluno dao = new DaoAluno();
        
        tb_alunos alu = new tb_alunos(0,null,null);
    
        int codigo = Integer.parseInt(a.txtCodigo.getText());
    
        List<tb_alunos> aluno = dao.Select(codigo);
        
        if(aluno.size() > 0 ){
            
            for(tb_alunos al : aluno){

            a.txtNome.setText(al.getFd_nome());
            
            if(al.getFd_status().equals("A")){
               a.cbStatus.setSelectedIndex(1);    
            }else{
               a.cbStatus.setSelectedIndex(2);
               }   
            
            if(al.getFd_cpf() != null) {
                 a.txtCpf.setText(val.AjusteCaracter(al.getFd_cpf()));
            }
           
            a.txtRg.setText(al.getFd_rg());
            
            if(al.getFd_data_nasc() != null) {
                a.txtDtNascimento.setText(val.FormataDataSelec(al.getFd_data_nasc().toString()));
            }

            a.txtEndereco.setText(al.getFd_endereco());
            
            if(al.getFd_numero() != null){
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
           
        }else{
               msg.msgNenhumRegistro();
               limpa.LimpaAluno(a);
               return false;
           }     
      }
    
    public boolean ListarCursos(CadCursos c) throws SQLException{
    
        DaoCursos dao = new DaoCursos();
    
        int codigo = Integer.parseInt(c.txtCodigo.getText());
    
        if(val.SelectReturn(codigo,"curso","cursos") == true){
      
            List<tb_cursos> curso = dao.Select(codigo);

            for(tb_cursos cr : curso ){
               c.txtDescricao.setText(cr.getDescricao());
            if(cr.getStatus().equals("A")){
               c.cbStatus.setSelectedIndex(1);    
            }else{
               c.cbStatus.setSelectedIndex(2);
               }     
           }
            return true;
           }else{
               msg.msgNenhumRegistro();
               limpa.LimpaCurso(c);
               return false;
           }     
      }
}
