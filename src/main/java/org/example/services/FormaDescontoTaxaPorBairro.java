package org.example.services;

import org.example.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
import org.example.models.Pedido;

public class FormaDescontoTaxaPorBairro implements IFormaDescontoTaxaEntrega {
    @Override
    public CupomDescontoEntrega calcularDescontoPedido(Pedido pedido) {
        return null;
    }

    @Override
    public Boolean setAplica(Pedido pedido) {
        return null;
    }
}
