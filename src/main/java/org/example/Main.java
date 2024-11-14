package org.example;

import org.example.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.Cliente;
import org.example.models.Item;
import org.example.models.Pedido;
import org.example.services.*;

public class Main {

    public static void main(String[] args) {
        CalculadoraDescontoTaxaEntregaService calculadoraDescontoTaxaEntregaService = new CalculadoraDescontoTaxaEntregaService();

        Cliente cliente = new Cliente("Fulano", "Ouro", "Rua sem saída", "Centro", "Alegre");
        Item item = new Item("X-Calango", 1, 19.0, "Alimentação");
        Pedido pedido = new Pedido(cliente);

        pedido.adicionarItem(item);
        
        System.out.print("------Pedido antes do calculo de desconto------\n");
        System.out.println(pedido.toString());

        calculadoraDescontoTaxaEntregaService.calcularTaxaDesconto(pedido);

        System.out.print("\n\n------Pedido após do calculo de desconto------\n");
        System.out.println(pedido.toString());
    }

}