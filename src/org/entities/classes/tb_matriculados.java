package org.entities.classes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class tb_matriculados implements Serializable {
    @Id
    private  int  fd_matricula;
    private  int  fd_curso;
    private  int  fd_aluno;
    @ManyToMany(mappedBy = "tb_matriculados",targetEntity = tb_alunos.class)
    List tb_alunos;

    public List getTb_alunos() {
        return tb_alunos;
    }

    public void setTb_alunos(List tb_alunos) {
        this.tb_alunos = tb_alunos;
    }
    
    public int getFd_curso() {
        return fd_curso;
    }

    public int getFd_matricula() {
        return fd_matricula;
    }

    public void setFd_matricula(int fd_matricula) {
        this.fd_matricula = fd_matricula;
    }

    public int getFd_aluno() {
        return fd_aluno;
    }

    public void setFd_aluno(int fd_aluno) {
        this.fd_aluno = fd_aluno;
    }

    public void setFd_curso(int fd_curso) {
        this.fd_curso = fd_curso;
    }

    
}
