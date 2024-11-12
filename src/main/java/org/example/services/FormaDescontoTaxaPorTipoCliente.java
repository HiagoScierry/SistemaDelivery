package org.example.services;

import org.example.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
import org.example.models.Pedido;

import java.util.Arrays;
import java.util.List;

public class FormaDescontoTaxaPorTipoCliente implements IFormaDescontoTaxaEntrega {

    private List<String> clientesValidos = Arrays.asList("Ouro", "Prata", "Bronze");

    @Override
    public void calcularDescontoPedido(Pedido pedido) {
        if(!seAplica(pedido))
            return;

        double valorDesconto = 0.0;
        String clienteTipo = pedido.getCliente().getTipo();

        switch (clienteTipo) {
            case "Ouro":
                valorDesconto = 3.0;
                break;
            case "Prata":
                valorDesconto = 2.0;
                break;
            case "Bronze":
                valorDesconto = 1.0;
                break;
        }

        if(valorDesconto != 0.0)
            pedido.aplicarDesconto(new CupomDescontoEntrega("Desconto por Tipo Cliente", valorDesconto));
    }

    @Override
    public Boolean seAplica(Pedido pedido) {
        return clientesValidos.contains(pedido.getCliente().getTipo()) && pedido.getDescontoConcedido <= 10.0;
    }
}
