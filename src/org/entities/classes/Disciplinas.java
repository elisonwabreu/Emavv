package org.entities.classes;

public class Disciplinas {

    public String descricao;
    public String status;

    public Disciplinas(int codigo,String descricao, String status) {

        this.descricao = descricao;
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
