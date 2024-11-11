package org.example.models;

import org.example.interfaces.IFormaDescontoTaxaEntrega;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

    private double taxaEntrega = 5.0;
    private LocalDateTime dataPedido;
    private Cliente cliente;
    private List<Item> itens;
    private List<CupomDescontoEntrega> cuponsDescontoEntrega;

    public Pedido(LocalDateTime data, Cliente cliente) {
        this.dataPedido = data;
        this.cliente = cliente;
    }

    public void adicionarItem(Item item) {}

    public double getValorPedido(){
        return 0.0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItems() {
        return null;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public void aplicarDesconto(IFormaDescontoTaxaEntrega desconto) {}

    public double getDescontoConcedido(){
        return 0.0;
    }

    public List<CupomDescontoEntrega> getCupomDescontoEntrega() {
        return null;
    }

    public String toString(){
        return "";
    }

}
