package org.entities.classes;

public class Itens {

    //public int codigo;
    public String descricao;
    public double valor;
    public String status;

    public Itens(int codigo, String descricao, double valor, String status) {

        this.descricao = descricao;
        this.valor = valor;
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
