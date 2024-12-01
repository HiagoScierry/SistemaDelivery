package org.example.modules.descontoPedido.services;

import org.example.modules.descontoEntrega.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
import org.example.models.Pedido;
import org.example.modules.descontoPedido.interfaces.IFormaDescontoPedido;

import java.util.HashMap;

public class FormaDescontoPedidoPorCupom implements IFormaDescontoPedido {

    private HashMap<String, Double> codigosDeDesconto;

    public FormaDescontoPedidoPorCupom(){
        // Inicializa os códigos de desconto
        this.codigosDeDesconto = new HashMap<String, Double>();
        this.codigosDeDesconto.put("DESC10", 0.10); // 10%
        this.codigosDeDesconto.put("DESC20", 0.20); // 20%
        this.codigosDeDesconto.put("DESC30", 0.30); // 30%
    }

    @Override
    public void calcularDescontoPedido(Pedido pedido) {
        if(seAplica(pedido)){
            String codigoAplicado = pedido.getCodigoDeCupom();

            double valorDescontoCupom = codigosDeDesconto.getOrDefault(codigoAplicado, 0.0);

            if(valorDescontoCupom > 0){
                pedido.aplicarDesconto(new CupomDescontoEntrega(
                        "Desconto por Cupom " + codigoAplicado,
                        valorDescontoCupom
                ));
            }
        }
    }

    private Boolean seAplica(Pedido pedido) {
        return pedido.getCodigoDeCupom() != null;
    }
}
