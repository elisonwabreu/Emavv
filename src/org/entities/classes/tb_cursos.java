package org.entities.classes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class tb_cursos implements Serializable {

    @Id
    @GeneratedValue
    int fd_curso;
    String fd_descricao;
    double fd_valor;
    String fd_status;
    @ManyToMany(mappedBy = "tb_cursos",targetEntity = tb_alunos.class)
            
    List tb_alunos;

    public List getTb_alunos() {
        return tb_alunos;
    }

    public void setTb_alunos(List tb_alunos) {
        this.tb_alunos = tb_alunos;
    }


    public tb_cursos() {
    }

    public tb_cursos(int fd_curso, String fd_descricao, String fd_status) {
        this.fd_curso = fd_curso;
        this.fd_descricao = fd_descricao;
        this.fd_status = fd_status;
    }

    public int getFd_curso() {
        return fd_curso;
    }

    public void setFd_curso(int fd_curso) {
        this.fd_curso = fd_curso;
    }

    public String getFd_descricao() {
        return fd_descricao;
    }

    public void setFd_descricao(String fd_descricao) {
        this.fd_descricao = fd_descricao;
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
