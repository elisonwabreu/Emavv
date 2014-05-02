package org.entities.classes;

import javax.persistence.Entity;

@Entity
public class tb_usuarios extends tb_funcionarios {
   
    
     String fd_login;
     String fd_senha;

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
}
