package org.entities.classes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "tb_matriculados")
public class Matriculados implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "fd_matricula")
    private  Matriculas  fd_matricula;
    
    @OneToOne
    @JoinColumn(name = "fd_aluno")
    private Alunos fd_aluno;
    
    @OneToOne
    @JoinColumn(name = "fd_curso")
    private Cursos fd_curso;
    
   
    public Cursos getFd_curso() {
        return (Cursos) fd_curso;
    }

    public Matriculas getFd_matricula() {
        return fd_matricula;
    }

    public void setFd_matricula(Matriculas fd_matricula) {
        this.fd_matricula = fd_matricula;
    }

    public Alunos getFd_aluno() {
        return (Alunos) fd_aluno;
    }

    public void setFd_aluno(Alunos fd_aluno) {
        this.fd_aluno = fd_aluno;
    }

    public void setFd_curso(Cursos fd_curso) {
        this.fd_curso = fd_curso;
    }
}
