package org.example.interfaces;

import org.example.models.CupomDescontoEntrega;
import org.example.models.Pedido;

public interface IFormaDescontoTaxaEntrega {
    CupomDescontoEntrega calcularDescontoPedido(Pedido pedido);
    Boolean setAplica(Pedido pedido);
}
