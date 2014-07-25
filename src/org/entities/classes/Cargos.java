package org.entities.classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity(name = "tb_cargos")
public class Cargos implements Serializable {

    @Id
    @GeneratedValue
    private int fd_cargo;
    private String fd_descricao;
    private String fd_status;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fd_data_cadastro;

    public Cargos() {
    }

    public Date getFd_data_cadastro() {
        return fd_data_cadastro;
    }

    public void setFd_data_cadastro(Date fd_data_cadastro) {
        this.fd_data_cadastro = fd_data_cadastro;
    }

    public Cargos(int fd_cargo, String fd_descricao, String fd_status) {

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
