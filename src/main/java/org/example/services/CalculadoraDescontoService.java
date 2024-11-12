package org.example.services;

import org.example.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
import org.example.models.Pedido;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraDescontoService {
    
    public void calcularDesconto(Pedido pedido) {
        List<IFormaDescontoTaxaEntrega> formasDesconto = getFormaDescontoTaxaEntregas();

        for (IFormaDescontoTaxaEntrega forma : formasDesconto) {
            forma.calcularDescontoPedido(pedido);
        }
    }

    private static List<IFormaDescontoTaxaEntrega> getFormaDescontoTaxaEntregas() {
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
