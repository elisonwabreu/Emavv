package org.entities.classes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class tb_matriculados implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "fd_matricula")
    private  Matriculas  fd_matricula;
    
    @OneToMany
    @JoinColumn(name = "fd_aluno")
    private List<tb_alunos> fd_aluno;
    
    @OneToMany
    @JoinColumn(name = "fd_curso")
    private List<tb_cursos> fd_curso;
    
   
    public tb_cursos getFd_curso() {
        return (tb_cursos) fd_curso;
    }

    public Matriculas getFd_matricula() {
        return fd_matricula;
    }

    public void setFd_matricula(Matriculas fd_matricula) {
        this.fd_matricula = fd_matricula;
    }

    public tb_alunos getFd_aluno() {
        return (tb_alunos) fd_aluno;
    }

    public void setFd_aluno(List<tb_alunos> fd_aluno) {
        this.fd_aluno = fd_aluno;
    }

    public void setFd_curso(List<tb_cursos> fd_curso) {
        this.fd_curso = fd_curso;
    }
}
