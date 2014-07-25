package org.entities.classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity(name = "tb_matriculas")
public class Matriculas implements Serializable {

    @Id
    private int fd_matricula;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fd_data_matricula;

    @OneToOne
    @JoinColumn(name = "fd_aluno")
    private Alunos fd_aluno;

    @OneToOne
    @JoinColumn(name = "fd_curso")
    private Cursos fd_curso;

    public int getFd_matricula() {
        return fd_matricula;
    }

    public void setFd_matricula(int fd_matricula) {
        this.fd_matricula = fd_matricula;
    }

    public Alunos getFd_aluno() {
        return fd_aluno;
    }

    public void setFd_aluno(Alunos fd_aluno) {
        this.fd_aluno = (Alunos) fd_aluno;
    }

    public Date getFd_data_matricula() {
        return fd_data_matricula;
    }

    public void setFd_data_matricula(Date fd_data_matricula) {
        this.fd_data_matricula = fd_data_matricula;
    }

    public Cursos getFd_curso() {
        return fd_curso;
    }

    public void setFd_curso(Cursos fd_curso) {
        this.fd_curso = fd_curso;
    }


    /*
     public int getFd_usuario() {
     return fd_usuario;
     }

     public void setFd_usuario(int fd_usuario) {
     this.fd_usuario = fd_usuario;
     }
     */
}
