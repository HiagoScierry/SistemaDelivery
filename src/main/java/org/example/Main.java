package org.example;

import org.example.models.Cliente;
import org.example.models.Item;
import org.example.models.Pedido;
import org.example.services.CalculadoraDescontoService;

public class Main {
    public static void main(String[] args) {
        CalculadoraDescontoService calculadoraDesconto = new CalculadoraDescontoService();
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
}