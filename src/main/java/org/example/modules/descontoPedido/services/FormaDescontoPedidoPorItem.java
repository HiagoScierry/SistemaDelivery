package org.example.modules.descontoPedido.services;

import org.example.models.CupomDescontoEntrega;
import org.example.models.CupomDescontoPedido;
import org.example.models.Item;
import org.example.models.Pedido;
import org.example.modules.descontoPedido.interfaces.IFormaDescontoPedido;

public class FormaDescontoPedidoPorItem implements IFormaDescontoPedido {
    @Override
    public void calcularDesconto(Pedido pedido) {
        if(!seAplica(pedido))
            return;

        double valorDesconto = 0.0;

        for (Item item: pedido.getItems())
        {
            switch (item.getTipo()) {
                case "Alimentação":
                    valorDesconto += item.getValorTotal() * 0.05;
                    break;
                case "Educação":
                    valorDesconto += item.getValorTotal() * 0.20;
                    break;
                case "Lazer":
                    valorDesconto += item.getValorTotal() * 0.15;
                    break;
            }
        }

        if(valorDesconto != 0.0)
            pedido.adicionarDescontoPedido(new CupomDescontoPedido("Desconto por item", valorDesconto));
    }

    private Boolean seAplica(Pedido pedido) {
        return pedido.getDescontoConcedido() <= 10.0 && pedido.getCuponsDescontoEntrega().isEmpty();
    }
}

