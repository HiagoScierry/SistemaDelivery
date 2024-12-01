package org.example.modules.descontoEntrega.services;

import org.example.modules.descontoEntrega.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
import org.example.models.Pedido;

import java.util.Arrays;
import java.util.List;

public class FormaDescontoTaxaPorBairro implements IFormaDescontoTaxaEntrega {

    private List<String> bairrosValidos = Arrays.asList("Centro", "Bela Vista", "Cidade Maravilhosa");

    @Override
    public void calcularDescontoPedido(Pedido pedido) {
        if(!seAplica(pedido))
            return;

        double valorDesconto = 0.0;
        String bairroCliente = pedido.getCliente().getBairro();

        switch (bairroCliente) {
            case "Centro":
                valorDesconto = pedido.getTaxaEntrega() * 0.20;
                break;
            case "Bela Vista":
                valorDesconto = pedido.getTaxaEntrega() * 0.30;
                break;
            case "Cidade Maravilhosa":
                valorDesconto = pedido.getTaxaEntrega() * 0.15;
                break;
        }

        if(valorDesconto != 0.0)
            pedido.aplicarDesconto(new CupomDescontoEntrega("Desconto por Bairro", valorDesconto));
    }

    @Override
    public Boolean seAplica(Pedido pedido) {
        return bairrosValidos.contains(pedido.getCliente().getBairro()) && pedido.getDescontoConcedido() <= 10.0;
    }
}
