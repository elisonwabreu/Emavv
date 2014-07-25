package org.entities.classes;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "tb_disciplinas")
public class Disciplinas implements Serializable {

    @Id
    @GeneratedValue
    private int fd_disciplina;
    private String fd_descricao;
    private String fd_status;
    private int fd_curso;

    public int getFd_curso() {
        return fd_curso;
    }

    public void setFd_curso(int fd_curso) {
        this.fd_curso = fd_curso;
    }

    public Disciplinas() {
    }

    public Disciplinas(int fd_disciplina, String fd_descricao, String fd_status) {

        this.fd_disciplina = fd_disciplina;
        this.fd_descricao = fd_descricao;
        this.fd_status = fd_status;
    }

    public int getFd_disciplina() {
        return fd_disciplina;
    }

    public void setFd_disciplina(int fd_disciplina) {
        this.fd_disciplina = fd_disciplina;
    }

    public String getFd_descricao() {
        return fd_descricao;
    }

    public void setFd_descricao(String fd_descricao) {
        this.fd_descricao = fd_descricao;
    }

    public String getFd_status() {
        return fd_status;
    }

    public void setFd_status(String fd_status) {
        this.fd_status = fd_status;
    }

}
