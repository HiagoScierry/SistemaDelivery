package org.example.modules.descontoPedido.services;

import org.example.models.CupomDescontoEntrega;
import org.example.models.CupomDescontoPedido;
import org.example.models.Pedido;
import org.example.modules.descontoPedido.interfaces.IFormaDescontoPedido;

import java.util.Arrays;
import java.util.List;

public class FormaDescontoPedidoPorTipoCliente implements IFormaDescontoPedido {
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
            pedido.adicionarDescontoPedido(new CupomDescontoPedido("Desconto por Tipo Cliente", valorDesconto));
    }

    private Boolean seAplica(Pedido pedido) {
        return clientesValidos.contains(pedido.getCliente().getTipo()) && pedido.getCuponsDescontoPedido().isEmpty();
    }
}
