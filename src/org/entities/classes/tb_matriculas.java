package org.entities.classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;


import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class tb_matriculas implements Serializable {

    @Id
    //@GeneratedValue
    //public int fd_codigo;
    public int fd_matricula;
    public int fd_aluno;
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date fd_data_matricula;
    //public int fd_usuario;
/*
    public int getFd_codigo() {
        return fd_codigo;
    }

    public void setFd_codigo(int fd_codigo) {
        this.fd_codigo = fd_codigo;
    }
*/
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

    public Date getFd_data_matricula() {
        return fd_data_matricula;
    }

    public void setFd_data_matricula(Date fd_data_matricula) {
        this.fd_data_matricula = fd_data_matricula;
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
