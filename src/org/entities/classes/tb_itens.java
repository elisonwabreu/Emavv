package org.entities.classes;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author elison
 */
@Entity
public class tb_itens implements Serializable {

    @Id
    @GeneratedValue
    private int fd_item;
    private String fd_descricao;
    private double fd_valor;
    private String fd_status;

    public tb_itens() {
    }

    public tb_itens(int fd_item, String fd_descricao, double fd_valor, String fd_status) {

        this.fd_item = fd_item;
        this.fd_descricao = fd_descricao;
        this.fd_valor = fd_valor;
        this.fd_status = fd_status;
    }

    public int getFd_item() {
        return fd_item;
    }

    public void setFd_item(int fd_item) {
        this.fd_item = fd_item;
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
