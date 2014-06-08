package org.entities.classes;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class tb_mensalidades {
    
  @Id  
  private int fd_matricula;
  private int fd_curso;
  private int fd_aluno;
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date fd_vencimento;
  private double fd_valor;
  private String fd_status;
  /*@ManyToMany
  @Fetch(FetchMode.JOIN)
  private tb_alunos alunos;*/

  /*  public tb_alunos getAlunos() {
  return alunos;
  }
  
  public void setAlunos(tb_alunos alunos) {
  this.alunos = alunos;
  }*/

    public tb_mensalidades(int fd_matricula, int fd_curso, int fd_aluno, Date fd_vencimento,
                        double fd_valor, String fd_status)
    {
        this.fd_matricula = fd_matricula;
        this.fd_curso = fd_curso;
        this.fd_aluno = fd_aluno;
        this.fd_vencimento = fd_vencimento;
        this.fd_valor = fd_valor;
        this.fd_status = fd_status;
    }

    public tb_mensalidades() {
        
    }

    public int getFd_matricula() {
        return fd_matricula;
    }

    public void setFd_matricula(int fd_matricula) {
        this.fd_matricula = fd_matricula;
    }

    public int getFd_curso() {
        return fd_curso;
    }

    public void setFd_curso(int fd_curso) {
        this.fd_curso = fd_curso;
    }

    public int getFd_aluno() {
        return fd_aluno;
    }

    public void setFd_aluno(int fd_aluno) {
        this.fd_aluno = fd_aluno;
    }

    public Date getFd_vencimento() {
        return fd_vencimento;
    }

    public void setFd_vencimento(Date fd_vencimento) {
        this.fd_vencimento = fd_vencimento;
    }

    public double getFd_valor() {
        return fd_valor;
    }

    public void setFd_valor(double fd_valor) {
        this.fd_valor = fd_valor;
    }

    public String getFd_status() {
        return fd_status;
    }

    public void setFd_status(String fd_status) {
        this.fd_status = fd_status;
    }
  
}
