package org.example.models;

import org.example.interfaces.IFormaDescontoTaxaEntrega;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private double taxaEntrega = 10.0;
    private LocalDate dataPedido;
    private Cliente cliente;
    private List<Item> itens;
    private List<CupomDescontoEntrega> cuponsDescontoEntrega;

    public Pedido(Cliente cliente) {
        this.dataPedido = LocalDate.now();
        this.cliente = cliente;

        this.itens = new ArrayList<>();
        this.cuponsDescontoEntrega = new ArrayList<>();

    }

    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

    public double getValorPedido(){
        Double valorPedido = 0.0;
        double descontoAcumulado = 0.0;

        for (Item item : itens) {
            valorPedido += item.getValorTotal();
        }

        for(CupomDescontoEntrega cupom : cuponsDescontoEntrega){
            descontoAcumulado += cupom.getValorDesconto();
        }

        return (valorPedido + getTaxaEntrega() - descontoAcumulado);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItems() {
        return itens;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public void aplicarDesconto(CupomDescontoEntrega cupomDesconto) {
        cuponsDescontoEntrega.add(cupomDesconto);
    }

    public double getDescontoConcedido(){
        double descontoAcumulado = 0.0;

        for(CupomDescontoEntrega cupom : cuponsDescontoEntrega){
            descontoAcumulado += cupom.getValorDesconto();
        }
        
        return descontoAcumulado;
    }

    public List<CupomDescontoEntrega> getCuponsDescontoEntrega() {
        return cuponsDescontoEntrega;
    }

    public String toString(){


        String retorno = "PEDIDO: Data " + dataPedido.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", Taxa Entrega" + getTaxaEntrega() + " Valor do Pedido " + getValorPedido() +  "Desconto Aplicado" + getDescontoConcedido() +  "\n" ;
        String cliente = this.cliente.toString();
        String items = "";
        String cupomDesconto = "";

        for (Item item : itens) {
            items += item.toString() + " | ";
        }

        for (CupomDescontoEntrega cupomDescontoEntrega : cuponsDescontoEntrega) {
            cupomDesconto += cupomDescontoEntrega.toString() + " | ";
        }

        retorno += cliente + "\n" + items + "\n" + cupomDesconto;

        return retorno;
    }

}
