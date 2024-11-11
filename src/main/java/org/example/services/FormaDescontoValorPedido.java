package org.example.services;

import org.example.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
import org.example.models.Pedido;

public class FormaDescontoValorPedido implements IFormaDescontoTaxaEntrega {
    @Override
    public CupomDescontoEntrega calcularDescontoPedido(Pedido pedido) {

        double valorDesconto = 0.0;

        double somatorioDescontosAnteriores = 0.0;

        for (CupomDescontoEntrega cupom: pedido.getCuponsDescontoEntrega())
        {
            somatorioDescontosAnteriores += cupom.getValorDesconto();
        }

        if(pedido.getValorPedido() > 200.0 && somatorioDescontosAnteriores <= 10.0){
            valorDesconto = 5.0;
        }


        return new CupomDescontoEntrega("Desconto por valor pedido", valorDesconto);
    }

    @Override
    public Boolean seAplica(Pedido pedido) {
    }
}
