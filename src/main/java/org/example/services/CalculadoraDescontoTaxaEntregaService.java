package org.example.services;

import org.example.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.Pedido;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraDescontoTaxaEntregaService {

    private List<IFormaDescontoTaxaEntrega> metodosDeDesconto;

    public CalculadoraDescontoTaxaEntregaService() {
        metodosDeDesconto = getListFormaDesconto();
    }

    public void calcularTaxaDesconto(Pedido pedido) {
        for (IFormaDescontoTaxaEntrega forma : metodosDeDesconto) {
            forma.calcularDescontoPedido(pedido);
        }
    }

    public void addMetodo(IFormaDescontoTaxaEntrega formaDesconto){
        if(formaDesconto == null){
            return;
        }

        this.metodosDeDesconto.add(formaDesconto);
    }

    private static List<IFormaDescontoTaxaEntrega> getListFormaDesconto() {
        List<IFormaDescontoTaxaEntrega> formasDesconto = new ArrayList<>();

        IFormaDescontoTaxaEntrega formaDeDescontoPorItem = new FormaDescontoPorItem();
        IFormaDescontoTaxaEntrega formaDescontoPorBairro = new FormaDescontoTaxaPorBairro();
        IFormaDescontoTaxaEntrega formaDescontoPorTipoCliente = new FormaDescontoTaxaPorTipoCliente();
        IFormaDescontoTaxaEntrega formaDescontoValorPedido = new FormaDescontoValorPedido();

        formasDesconto.add(formaDeDescontoPorItem);
        formasDesconto.add(formaDescontoPorBairro);
        formasDesconto.add(formaDescontoPorTipoCliente);
        formasDesconto.add(formaDescontoValorPedido);
        return formasDesconto;
    }

}
