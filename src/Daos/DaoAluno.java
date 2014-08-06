package Daos;

import ConnectionFactory.*;
import Messages.Cmessage;
import Model.Validacoes;
import Views.CadAluno;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.entities.classes.Alunos;
import org.entities.classes.Matriculas;

/**
 *
 * @author athalias
 */
public class DaoAluno {
    Validacoes val = new Validacoes();
    Cmessage msg = new Cmessage();
    EntityManager manager = JPAUtil.getEntityManager();

    public boolean Inserir(Alunos al) throws SQLException {

        if (msg.MsgConfGravacao() == true) {

            manager.getTransaction().begin();
            manager.persist(al);
            manager.getTransaction().commit();
            manager.close();
            msg.msgGravado();
            return true;
        } else {
            return false;
        }
    }

    public boolean Delete(int codigo) throws SQLException {

        if (msg.MsgConfExclusao() == true) {
            Alunos aluno = (Alunos) manager.find(Alunos.class, codigo);
            aluno.setFd_status("E");
            manager.getTransaction().begin();
            manager.persist(aluno);
            manager.getTransaction().commit();
            manager.close();
            return true;
        }
        return false;
    }
    
    public List<Alunos> SelectGeraMensalidade(int codigo) throws SQLException {

        Query q = manager.createQuery("select a.fd_nome, c. from tb_alunos a"
                + "inner join tb_cursos c "
                + "where a.fd_aluno = :fd_aluno and a.fd_status <> 'E'");
        q.setParameter("fd_aluno", codigo);
        List<Alunos> aluno = q.getResultList();
        return aluno;
    }
    
    public List<Alunos> Select(int codigo) throws SQLException {

        Query q = manager.createQuery("select a from tb_alunos a "
                + "where a.fd_aluno = :fd_aluno and a.fd_status <> 'E'");
        q.setParameter("fd_aluno", codigo);
        List<Alunos> aluno = q.getResultList();
        return aluno;
    }
    public List<Matriculas> SelectTT(int codigo) throws SQLException {

        Query q = manager.createQuery("select m from tb_matriculas m "
                + " where m.fd_aluno = :fd_aluno ");
        
        Alunos aluno = new Alunos();
        aluno.setFd_aluno(codigo);
        
        q.setParameter("fd_aluno", aluno);
        List<Matriculas> matricula = q.getResultList();
        return matricula;
    }
    public List<Alunos> Select() throws SQLException {

        Query q = manager.createQuery("select a from tb_alunos a "
                + "order by fd_aluno desc").setMaxResults(1);
        
        List<Alunos> aluno = q.getResultList();
        return aluno;
    }
    public List<Alunos> SelectAlunoPag() throws SQLException {

        Query q = manager.createQuery("select a from tb_alunos a "
                + "inner join tb_mensalidades m on m.fd_aluno = a.fd_aluno"
                + "order by fd_aluno desc")/*.setMaxResults(1)*/;
        
        List<Alunos> aluno = q.getResultList();
        return aluno;
    }

    public List<Alunos> Select(String nome) throws SQLException {

        Query q = manager.createQuery("select a from tb_alunos as a "
                + "where a.fd_nome like :fd_nome and a.fd_status <> 'E'");
        q.setParameter("fd_nome", "%" + nome + "%");
        List<Alunos> aluno = q.getResultList();
        return aluno;
    }
    
    public List<Alunos> SelectCpf(String cpf) {

        Query q = manager.createQuery("select a from tb_alunos a "
                + "where a.fd_cpf = :fd_cpf");
        q.setParameter("fd_cpf", cpf);
        List<Alunos> aluno = q.getResultList();
        return aluno;
    }

    public boolean Update(CadAluno a, String status) throws ParseException {

        if (msg.MsgConfGravacao() == true) {

            Alunos aluno = (Alunos) manager.find(Alunos.class, Integer.parseInt(a.txtCodigo.getText()));
            manager.getTransaction().begin();
            
            aluno.setFd_nome(a.txtNome.getText());
            aluno.setFd_cpf(val.AjusteCaracter(a.txtCpf.getText()));
            aluno.setFd_rg(a.txtRg.getText());
            aluno.setFd_data_nasc(val.FormataData(a.txtDtNascimento.getText()));
            aluno.setFd_sexo(a.cbSexo.getSelectedItem().toString());
            aluno.setFd_endereco(a.txtEndereco.getText());
            aluno.setFd_numero(a.txtNum.getText());
            aluno.setFd_bairro(a.txtbairro.getText());
            aluno.setFd_cidade(a.txtCidade.getText());
            aluno.setFd_cep(val.AjusteCaracter(a.txtCep.getText()));
            aluno.setFd_uf(a.cbUf.getSelectedItem().toString());
            aluno.setFd_telefone(val.AjusteCaracter(a.txtTelefone.getText()));
            aluno.setFd_celular(val.AjusteCaracter(a.txtCelular.getText()));
            aluno.setFd_email(a.txtEmail.getText());
            aluno.setFd_status(status);
            
            manager.getTransaction().commit();
            manager.close();
            msg.msgGravado();
            return true;
        } else {
            return false;
        }
    }

    public boolean Update(Alunos a) {

        if (msg.MsgConfGravacao() == true) {
            Alunos aluno = (Alunos) manager.find(Alunos.class, a.getFd_aluno());

            manager.getTransaction().begin();
            manager.merge(aluno);
            manager.getTransaction().commit();
            manager.close();
            msg.msgGravado();
            return true;
        } else {
            return false;
        }
    }
}
