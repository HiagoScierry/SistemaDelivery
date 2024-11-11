package org.example.models;

public class CupomDescontoEntrega {

    private String nomeMetodo;
    private double valorDesconto;

    public CupomDescontoEntrega(String nome, double valorDesconto) {
        this.nomeMetodo = nome;
        this.valorDesconto = valorDesconto;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public String getNomeMetodo(){
        return nomeMetodo;
    }

    @Override
    public String toString() {
        return getNomeMetodo() + " " + getValorDesconto();
    }
}
