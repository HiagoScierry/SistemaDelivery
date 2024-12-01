package org.example.modules.descontoEntrega.services;

import org.example.modules.descontoEntrega.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
import org.example.models.Pedido;

public class FormaDescontoValorPedido implements IFormaDescontoTaxaEntrega {
    @Override
    public void calcularDescontoPedido(Pedido pedido) {
        if(!seAplica(pedido))
            return;

        double valorDesconto = 0.0;

        if(pedido.getValorPedido() > 2000.0){
            valorDesconto = pedido.getValorPedido() * 0.15;
        }

        if(valorDesconto != 0.0)
            pedido.aplicarDesconto(new CupomDescontoEntrega("Desconto por valor pedido", valorDesconto));
    }

    @Override
    public Boolean seAplica(Pedido pedido) {
        return pedido.getDescontoConcedido() <= 10.0;
    }
}
