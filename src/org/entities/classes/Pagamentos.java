package org.entities.classes;

import javax.xml.crypto.Data;

public class Pagamentos {

    private double valor;
    private int despesa;
    private String observacao;
    private Data dataPagamento;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getDespesa() {
        return despesa;
    }

    public void setDespesa(int despesa) {
        this.despesa = despesa;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Data getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Data dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
