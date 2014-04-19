package org.entities.classes;

public class tb_cursos {

    public int codigo;
    public String descricao;
    public double valor;
    public String status;

    public tb_cursos(int codigo, String descricao, String status) {

        this.codigo = codigo;
        this.descricao = descricao;
        this.status = status;
        
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
