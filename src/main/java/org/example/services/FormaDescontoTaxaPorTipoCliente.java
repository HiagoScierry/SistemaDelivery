package org.example.services;

import org.example.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
import org.example.models.Pedido;

import java.util.Arrays;
import java.util.List;

public class FormaDescontoTaxaPorTipoCliente implements IFormaDescontoTaxaEntrega {

    private List<String> clientesValidos = Arrays.asList("Ouro", "Prata", "Bronze");

    @Override
    public CupomDescontoEntrega calcularDescontoPedido(Pedido pedido) {

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

        return new CupomDescontoEntrega("Desconto por Tipo Cliente", valorDesconto);
    }

    @Override
    public Boolean seAplica(Pedido pedido) {
        return clientesValidos.contains(pedido.getCliente().getBairro());
    }
}
