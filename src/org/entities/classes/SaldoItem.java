package org.entities.classes;

import java.sql.Date;

public class SaldoItem extends tb_itens {

    public SaldoItem(int codigo, String descricao, double valor, String status) {
        super(codigo, descricao, valor, status);
        // TODO Auto-generated constructor stub
    }
    public int saldo;
    public Date dataAtualizada;

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Date getDataAtualizada() {
        return dataAtualizada;
    }

    public void setDataAtualizada(Date dataAtualizada) {
        this.dataAtualizada = dataAtualizada;
    }
}
