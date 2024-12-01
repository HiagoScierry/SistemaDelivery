package org.example.models;

public class CupomDescontoPedido {
    private String nomeMetodo;
    private double valorDesconto;

    public CupomDescontoPedido(String nome, double valorDesconto) {
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
        return "CUPOM DESCONTO ENTREGA: " + "Nome metodo " + this.getNomeMetodo() + ", Valor desconto " + this.getValorDesconto();
    }
}
