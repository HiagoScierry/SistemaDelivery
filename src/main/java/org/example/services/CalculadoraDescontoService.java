package org.example.services;

import org.example.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
import org.example.models.Pedido;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraDescontoService {

    private List<IFormaDescontoTaxaEntrega> metodosDeDesconto;

    public CalculadoraDescontoService(List<IFormaDescontoTaxaEntrega> metodosDeDesconto) {
        this.metodosDeDesconto = metodosDeDesconto;
    }

    public void calcularDesconto(Pedido pedido) {
        for (IFormaDescontoTaxaEntrega forma : metodosDeDesconto) {
            forma.calcularDescontoPedido(pedido);
        }
    }

}
