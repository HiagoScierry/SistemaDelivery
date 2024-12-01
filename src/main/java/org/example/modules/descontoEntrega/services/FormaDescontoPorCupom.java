package org.example.modules.descontoEntrega.services;

import org.example.modules.descontoEntrega.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
import org.example.models.Pedido;

import java.util.HashMap;

public class FormaDescontoPorCupom implements IFormaDescontoTaxaEntrega {

    private HashMap<String, Double> codigosDeDesconto;

    public FormaDescontoPorCupom(){
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

    @Override
    public Boolean seAplica(Pedido pedido) {
        return pedido.getCodigoDeCupom() != null;
    }
}
