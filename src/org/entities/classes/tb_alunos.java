package org.entities.classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author athalias
 */
@Entity
public class tb_alunos implements Serializable {

    @Id
    @GeneratedValue
     int fd_aluno;
     String fd_nome;
     String fd_cpf;
     String fd_rg;
   // @Temporal(javax.persistence.TemporalType.DATE)
     Date fd_data_nasc;
     String fd_sexo;
     String fd_endereco;
     Integer fd_numero;
     String fd_bairro;
     String fd_cep;
     String fd_cidade;
     String fd_uf;
     String fd_telefone;
     String fd_celular;
     String fd_email;
     String fd_status;
    //int fd_matricula;
     

    public tb_alunos() {
    }

    public tb_alunos(int fd_aluno, String fd_nome, String fd_status) {
       
        this.fd_aluno = fd_aluno;
        this.fd_nome = fd_nome;
        this.fd_status = fd_status;
    
    }

   /* public int getFd_atricula() {
        return fd_matricula;
    }

    public void setMatricula(int fd_matricula) {
        this.fd_matricula = fd_matricula;
    }
    */
    public int getFd_aluno() {
        return fd_aluno;
    }

    public void setFd_aluno(int fd_aluno) {
        this.fd_aluno = fd_aluno;
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

    public Date getFd_data_nasc() {
        return fd_data_nasc;
    }

    public void setFd_data_nasc(Date fd_data_nasc) {
        this.fd_data_nasc = fd_data_nasc;
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

    public Integer getFd_numero() {
        return fd_numero;
    }

    public void setFd_numero(int fd_numero) {
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

    public String getFd_status() {
        return fd_status;
    }

    public void setFd_status(String fd_status) {
        this.fd_status = fd_status;
    }
    
    
    
    
}
