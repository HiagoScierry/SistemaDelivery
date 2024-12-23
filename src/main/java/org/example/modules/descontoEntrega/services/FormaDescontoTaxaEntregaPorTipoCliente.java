package org.example.modules.descontoEntrega.services;

import org.example.modules.descontoEntrega.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
import org.example.models.Pedido;

import java.util.Arrays;
import java.util.List;

public class FormaDescontoTaxaEntregaPorTipoCliente implements IFormaDescontoTaxaEntrega {

    private List<String> clientesValidos = Arrays.asList("Ouro", "Prata", "Bronze");

    @Override
    public void calcularDesconto(Pedido pedido) {
        if(!seAplica(pedido))
            return;

        double valorDesconto = 0.0;
        String clienteTipo = pedido.getCliente().getTipo();

        switch (clienteTipo) {
            case "Ouro":
                valorDesconto = pedido.getTaxaEntrega() * 0.30;
                break;
            case "Prata":
                valorDesconto = pedido.getTaxaEntrega() * 0.20;
                break;
            case "Bronze":
                valorDesconto = pedido.getTaxaEntrega() * 0.10;
                break;
        }

        if(valorDesconto != 0.0)
            pedido.adicionarDescontoTaxaEntrega(new CupomDescontoEntrega("Desconto por Tipo Cliente", valorDesconto));
    }

    private Boolean seAplica(Pedido pedido) {
        return clientesValidos.contains(pedido.getCliente().getTipo()) && pedido.getDescontoConcedido() <= 10.0;
    }
}
