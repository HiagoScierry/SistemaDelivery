package org.example.modules.descontoEntrega.interfaces;

import org.example.models.Pedido;

public interface IFormaDescontoTaxaEntrega {
    void calcularDesconto(Pedido pedido);
}
