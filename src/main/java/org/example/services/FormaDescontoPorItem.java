package org.example.services;

import org.example.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
import org.example.models.Item;
import org.example.models.Pedido;

import java.util.Arrays;
import java.util.List;

public class FormaDescontoPorItem implements IFormaDescontoTaxaEntrega {
    @Override
    public void calcularDescontoPedido(Pedido pedido) {
        if(!seAplica(pedido))
            return;

        double valorDesconto = 0.0;

        for (Item item: pedido.getItems())
        {
            switch (item.getTipo()) {
                case "Alimentação":
                    valorDesconto += 5.0;
                    break;
                case "Educação":
                    valorDesconto += 2.0;
                    break;
                case "Lazer":
                    valorDesconto += 1.5;
                    break;
            }
        }

        if(valorDesconto != 0.0)
            pedido.aplicarDesconto(new CupomDescontoEntrega("Desconto por item", valorDesconto));
    }

    @Override
    public Boolean seAplica(Pedido pedido) {
        return pedido.getDescontoConcedido() <= 10.0;
    }}
