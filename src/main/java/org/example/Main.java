package org.example;

import org.example.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.Cliente;
import org.example.models.Item;
import org.example.models.Pedido;
import org.example.services.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CalculadoraDescontoService calculadoraDesconto = new CalculadoraDescontoService(getListFormaDesconto());
        Cliente cliente = new Cliente("Fulano", "Ouro", "Rua sem saída", "Centro", "Alegre");
        Item item = new Item("X-Calango", 1, 19.0, "Alimentação");
        Pedido pedido = new Pedido(cliente);

        pedido.adicionarItem(item);
        
        System.out.print("------Pedido antes do calculo de desconto------\n");
        System.out.println(pedido.toString());

        calculadoraDesconto.calcularDesconto(pedido);

        System.out.print("\n\n------Pedido após do calculo de desconto------\n");
        System.out.println(pedido.toString());
    }

    private static List<IFormaDescontoTaxaEntrega> getListFormaDesconto() {
        List<IFormaDescontoTaxaEntrega> formasDesconto = new ArrayList<>();

        IFormaDescontoTaxaEntrega formaDeDescontoPorItem = new FormaDescontoPorItem();
        IFormaDescontoTaxaEntrega formaDescontoPorBairro = new FormaDescontoTaxaPorBairro();
        IFormaDescontoTaxaEntrega formaDescontoPorTipoCliente = new FormaDescontoTaxaPorTipoCliente();
        IFormaDescontoTaxaEntrega formaDescontoValorPedido = new FormaDescontoValorPedido();

        formasDesconto.add(formaDeDescontoPorItem);
        formasDesconto.add(formaDescontoPorBairro);
        formasDesconto.add(formaDescontoPorTipoCliente);
        formasDesconto.add(formaDescontoValorPedido);
        return formasDesconto;
    }

}