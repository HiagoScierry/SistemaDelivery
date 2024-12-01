package org.example.modules.descontoEntrega.services;

import org.example.models.CupomDescontoEntrega;
import org.example.models.Pedido;
import org.example.modules.descontoEntrega.interfaces.IFormaDescontoTaxaEntrega;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class FormaDescontoTaxaEntregaPorDataPedido implements IFormaDescontoTaxaEntrega {
    private final Map<LocalDate,Double> descontosPorData;

    public FormaDescontoTaxaEntregaPorDataPedido(){
        this.descontosPorData = new HashMap<>();
        descontosPorData.put(LocalDate.of(2025, Month.JANUARY, 1), 0.10);
        descontosPorData.put(LocalDate.of(2024, Month.OCTOBER, 12), 0.15);
        descontosPorData.put(LocalDate.of(2024, Month.DECEMBER, 25), 0.20);
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        if(seAplica(pedido)){
            pedido.adicionarDescontoTaxaEntrega(new CupomDescontoEntrega("Desconto por data", descontosPorData.get(pedido.getDataPedido())));
        }
    }

    private Boolean seAplica(Pedido pedido) {
        return descontosPorData.containsKey(pedido.getDataPedido());
    }
}