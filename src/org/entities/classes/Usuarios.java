package org.entities.classes;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tb_usuarios")
public class Usuarios implements Serializable {

    @Id
    private int fd_funcionario;
    private String fd_login;
    private String fd_senha;
    private String fd_status;

    public String getFd_status() {
        return fd_status;
    }

    public void setFd_status(String fd_status) {
        this.fd_status = fd_status;
    }

    public String getFd_login() {
        return fd_login;
    }

    public void setFd_login(String fd_login) {
        this.fd_login = fd_login;
    }

    public String getFd_senha() {
        return fd_senha;
    }

    public void setFd_senha(String fd_senha) {
        this.fd_senha = fd_senha;
    }

    public int getFd_funcionario() {
        return fd_funcionario;
    }

    public void setFd_funcionario(int fd_funcionario) {
        this.fd_funcionario = fd_funcionario;
    }

}
