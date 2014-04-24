package org.entities.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class tb_cargos {

    @Id
    @GeneratedValue
    int fd_cargo;
    String fd_descricao;
    String fd_status;

    public tb_cargos() {
    }

    public tb_cargos(int fd_cargo, String fd_descricao, String fd_status) {

        this.fd_cargo = fd_cargo;
        this.fd_descricao = fd_descricao;
        this.fd_status = fd_status;
    }

    public int getFd_cargo() {
        return fd_cargo;
    }

    public void setFd_cargo(int fd_cargo) {
        this.fd_cargo = fd_cargo;
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
