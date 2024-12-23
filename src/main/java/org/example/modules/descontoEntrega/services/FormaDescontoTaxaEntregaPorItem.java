package org.example.modules.descontoEntrega.services;

import org.example.modules.descontoEntrega.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
import org.example.models.Item;
import org.example.models.Pedido;

public class FormaDescontoTaxaEntregaPorItem implements IFormaDescontoTaxaEntrega {
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
            pedido.adicionarDescontoTaxaEntrega(new CupomDescontoEntrega("Desconto por item", valorDesconto));
    }

    private Boolean seAplica(Pedido pedido) {
        return pedido.getDescontoConcedido() <= 10.0 && pedido.getCuponsDescontoEntrega().isEmpty();
    }
}
