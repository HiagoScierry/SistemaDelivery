package org.example.services;

import org.example.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
import org.example.models.Pedido;

public class FormaDescontoValorPedido implements IFormaDescontoTaxaEntrega {
    @Override
    public void calcularDescontoPedido(Pedido pedido) {
        if(!seAplica(pedido))
            return;

        double valorDesconto = 0.0;

        if(pedido.getValorPedido() > 200.0){
            valorDesconto = 5.0;
        }

        if(valorDesconto != 0.0)
            pedido.aplicarDesconto(new CupomDescontoEntrega("Desconto por valor pedido", valorDesconto));
    }

    @Override
    public Boolean seAplica(Pedido pedido) {
        return pedido.getDescontoConcedido() <= 10.0;
    }
}
