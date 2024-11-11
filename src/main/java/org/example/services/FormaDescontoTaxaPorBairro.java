package org.example.services;

import org.example.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
import org.example.models.Pedido;

import java.util.Arrays;
import java.util.List;

public class FormaDescontoTaxaPorBairro implements IFormaDescontoTaxaEntrega {

    private List<String> bairrosValidos = Arrays.asList("Centro", "Bela Vista", "Cidade Maravilhosa");

    @Override
    public CupomDescontoEntrega calcularDescontoPedido(Pedido pedido) {

        double valorDesconto = 0.0;
        String bairroCliente = pedido.getCliente().getBairro();

        switch (bairroCliente) {
            case "Centro":
                valorDesconto = 2.0;
                break;
            case "Bela Vista":
                valorDesconto = 3.0;
                break;
            case "Cidade Maravilhosa":
                valorDesconto = 1.5;
                break;
        }

        return new CupomDescontoEntrega("Desconto por Bairro", valorDesconto);
    }

    @Override
    public Boolean seAplica(Pedido pedido) {
        return bairrosValidos.contains(pedido.getCliente().getBairro());
    }
}
