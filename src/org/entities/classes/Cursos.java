package org.entities.classes;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "tb_cursos")
public class Cursos implements Serializable {

    @Id
    @GeneratedValue
    private int fd_curso;
    private String fd_descricao;
    private double fd_valor;
    private String fd_status;

    public Cursos() {
    }

    public Cursos(int fd_curso, String fd_descricao, String fd_status) {
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
