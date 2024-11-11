package org.example.services;

import org.example.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
import org.example.models.Item;
import org.example.models.Pedido;

import java.util.Arrays;
import java.util.List;

public class FormaDescontoPorItem implements IFormaDescontoTaxaEntrega {
    private List<String> tipoItemValido = Arrays.asList("Alimentação", "Educação", "Lazer");

    @Override
    public CupomDescontoEntrega calcularDescontoPedido(Pedido pedido) {

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


        return new CupomDescontoEntrega("Desconto por item", valorDesconto);
    }

    @Override
    public Boolean seAplica(Pedido pedido) {
        return tipoItemValido.contains(pedido.getCliente().getBairro());
    }}
