package org.example.modules.descontoEntrega.services;

import org.example.modules.descontoEntrega.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.Pedido;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraDescontoTaxaEntregaService {

    private List<IFormaDescontoTaxaEntrega> metodosDeDesconto;

    public CalculadoraDescontoTaxaEntregaService() {
//        metodosDeDesconto = new ArrayList<IFormaDescontoTaxaEntrega>();
        this.metodosDeDesconto = getListFormaDesconto();
    }

    public void calcularTaxaDesconto(Pedido pedido) {
        for (IFormaDescontoTaxaEntrega forma : metodosDeDesconto) {
            forma.calcularDesconto(pedido);
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

        IFormaDescontoTaxaEntrega formaDescontoTaxaEntregaPorItem = new FormaDescontoTaxaEntregaPorItem();
        IFormaDescontoTaxaEntrega formaDescontoTaxaEntregaPorBairro = new FormaDescontoTaxaEntregaPorBairro();
        IFormaDescontoTaxaEntrega formaDescontoTaxaEntregaPorTipoCliente = new FormaDescontoTaxaEntregaPorTipoCliente();
        IFormaDescontoTaxaEntrega formaDescontoTaxaEntregaValorPedido = new FormaDescontoTaxaEntregaValorPedido();
        IFormaDescontoTaxaEntrega formaDescontoTaxaEntregaPorDataPedido = new FormaDescontoTaxaEntregaPorDataPedido();

        formasDesconto.add(formaDescontoTaxaEntregaPorItem);
        formasDesconto.add(formaDescontoTaxaEntregaPorBairro);
        formasDesconto.add(formaDescontoTaxaEntregaPorTipoCliente);
        formasDesconto.add(formaDescontoTaxaEntregaValorPedido);
        formasDesconto.add(formaDescontoTaxaEntregaPorDataPedido);

        return formasDesconto;
    }

}
