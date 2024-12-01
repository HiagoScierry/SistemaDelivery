package org.example.modules.descontoPedido.interfaces;

import org.example.models.Pedido;

public interface IFormaDescontoPedido {
    void calcularDesconto(Pedido pedido);
}
