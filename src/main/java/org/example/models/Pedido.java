package org.example.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pedido {
    private int id;
    private double taxaEntrega;
    private LocalDate dataPedido;
    private Cliente cliente;
    private String codigoDeCupom;
    private List<Item> itens;
    private List<CupomDescontoEntrega> cuponsDescontoEntrega;
    private List<CupomDescontoPedido> cuponsDescontoPedido;


    public Pedido(double taxaEntrega, LocalDate dataPedido, Cliente cliente) {
        if (taxaEntrega < 0 || dataPedido == null || cliente == null) {
            throw new IllegalArgumentException("Valores inválidos para criar o pedido.");
        }

        this.id = new Random().nextInt(1000);
        this.taxaEntrega = taxaEntrega;
        this.dataPedido = dataPedido;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.cuponsDescontoEntrega = new ArrayList<>();
        this.cuponsDescontoPedido = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setCodigoDeCupom(String codigoDeCupom) {
        this.codigoDeCupom = codigoDeCupom;
    }

    public double getValorPedido(){
        Double valorPedido = 0.0;
        double descontoAcumuladoTaxaEntrega = 0.0;
        double descontoAcumuladoPedido = 0.0;
        double descontoTotal;

        for (Item item : itens) {
            valorPedido += item.getValorTotal();
        }

        for(CupomDescontoEntrega cupom : this.cuponsDescontoEntrega){
            descontoAcumuladoTaxaEntrega += cupom.getValorDesconto();
        }

        for(CupomDescontoPedido cupom : this.cuponsDescontoPedido){
            descontoAcumuladoPedido += cupom.getValorDesconto();
        }

        descontoTotal = descontoAcumuladoPedido + descontoAcumuladoTaxaEntrega;

        return (valorPedido + getTaxaEntrega() - descontoTotal);
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
    public List<CupomDescontoPedido> getCuponsDescontoPedido() {
        return cuponsDescontoPedido;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public String getCodigoDeCupom() {
        return codigoDeCupom;
    }

    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

    public void adicionarDescontoTaxaEntrega(CupomDescontoEntrega cupomDesconto) {
        cuponsDescontoEntrega.add(cupomDesconto);
    }

    public void adicionarDescontoPedido(CupomDescontoPedido cupomDesconto) {
        cuponsDescontoPedido.add(cupomDesconto);
    }

    public String toString(){
        String retorno = "PEDIDO: Data " + dataPedido.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " , Taxa Entrega " + getTaxaEntrega() + " , Valor do Pedido " + getValorPedido() +  " , Desconto Aplicado " + getDescontoConcedido() +  "\n" ;
        String cliente = this.cliente.toString();
        String items = "";
        String cupomDescontoTaxaEntrega = "DESCONTO NA ENTREGA =>";
        String cupomDescontoPedido = "DESCONTO NO PEDIDO =>";

        for (Item item : itens) {
            items += item.toString() + " | ";
        }

        for (CupomDescontoEntrega cupomDesconto : cuponsDescontoEntrega) {
            cupomDescontoTaxaEntrega += cupomDesconto.toString() + " | ";
        }

        for (CupomDescontoPedido cupomDesconto : cuponsDescontoPedido){
            cupomDescontoPedido += cupomDesconto.toString()  + " | ";
        }

        retorno += cliente + "\n" + items + "\n" + cupomDescontoTaxaEntrega + "\n" + cupomDescontoPedido + "\n";

        return retorno;
    }

}
