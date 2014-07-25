package org.entities.classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity(name = "tb_funcionarios")
public class Funcionarios implements Serializable {

    @Id
    @GeneratedValue
    private int fd_funcionario;
    private String fd_nome;
    private String fd_cpf;
    private String fd_rg;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fd_data_nasc;
    private String fd_sexo;
    private String fd_endereco;
    private String fd_numero;
    private String fd_bairro;
    private String fd_cep;
    private String fd_cidade;
    private String fd_uf;
    private String fd_telefone;
    private String fd_celular;
    private String fd_email;
    private String fd_status;
//    Blob fd_imagem;

    public Funcionarios() {
    }

    public Funcionarios(int fd_funcionario, String fd_nome, String fd_status) {

        this.fd_funcionario = fd_funcionario;
        this.fd_nome = fd_nome;
        this.fd_status = fd_status;
    }

    public int getFd_funcionario() {
        return fd_funcionario;
    }

    public void setFd_funcionario(int fd_funcionario) {
        this.fd_funcionario = fd_funcionario;
    }

    public String getFd_nome() {
        return fd_nome;
    }

    public void setFd_nome(String fd_nome) {
        this.fd_nome = fd_nome;
    }

    public String getFd_cpf() {
        return fd_cpf;
    }

    public void setFd_cpf(String fd_cpf) {
        this.fd_cpf = fd_cpf;
    }

    public String getFd_rg() {
        return fd_rg;
    }

    public void setFd_rg(String fd_rg) {
        this.fd_rg = fd_rg;
    }

    public String getFd_sexo() {
        return fd_sexo;
    }

    public void setFd_sexo(String fd_sexo) {
        this.fd_sexo = fd_sexo;
    }

    public String getFd_endereco() {
        return fd_endereco;
    }

    public void setFd_endereco(String fd_endereco) {
        this.fd_endereco = fd_endereco;
    }

    public String getFd_numero() {
        return fd_numero;
    }

    public void setFd_numero(String fd_numero) {
        this.fd_numero = fd_numero;
    }

    public String getFd_bairro() {
        return fd_bairro;
    }

    public void setFd_bairro(String fd_bairro) {
        this.fd_bairro = fd_bairro;
    }

    public String getFd_cep() {
        return fd_cep;
    }

    public void setFd_cep(String fd_cep) {
        this.fd_cep = fd_cep;
    }

    public String getFd_cidade() {
        return fd_cidade;
    }

    public void setFd_cidade(String fd_cidade) {
        this.fd_cidade = fd_cidade;
    }

    public String getFd_uf() {
        return fd_uf;
    }

    public void setFd_uf(String fd_uf) {
        this.fd_uf = fd_uf;
    }

    public String getFd_telefone() {
        return fd_telefone;
    }

    public void setFd_telefone(String fd_telefone) {
        this.fd_telefone = fd_telefone;
    }

    public String getFd_celular() {
        return fd_celular;
    }

    public void setFd_celular(String fd_celular) {
        this.fd_celular = fd_celular;
    }

    public String getFd_email() {
        return fd_email;
    }

    public void setFd_email(String fd_email) {
        this.fd_email = fd_email;
    }

    public Date getFd_data_nasc() {
        return fd_data_nasc;
    }

    public void setFd_data_nasc(Date fd_data_nasc) {
        this.fd_data_nasc = fd_data_nasc;
    }

    public String getFd_status() {
        return fd_status;
    }

    public void setFd_status(String fd_status) {
        this.fd_status = fd_status;
    }

}
