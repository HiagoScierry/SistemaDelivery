package org.example;

import org.example.interfaces.IFormaDescontoTaxaEntrega;
import org.example.models.Cliente;
import org.example.models.Item;
import org.example.models.Pedido;
import org.example.services.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        CalculadoraDescontoTaxaEntregaService calculadoraDescontoTaxaEntregaService = new CalculadoraDescontoTaxaEntregaService();

        Cliente cliente = new Cliente("Fulano", "Ouro", "Rua sem saída", "Centro", "Alegre");
        Item item = new Item("X-Calango", 1, 19.0, "Alimentação");
        Pedido pedido = new Pedido(
                10.0,
                LocalDate.now(),
                cliente
        );

        pedido.adicionarItem(item);

        IFormaDescontoTaxaEntrega formaDescontoPorCupom = new FormaDescontoPorCupom();
        IFormaDescontoTaxaEntrega formaDescontoPorTipoCliente = new FormaDescontoTaxaPorTipoCliente();
        IFormaDescontoTaxaEntrega formaDescontoPorItem = new FormaDescontoPorItem();



        calculadoraDescontoTaxaEntregaService.addMetodo(formaDescontoPorCupom);
        calculadoraDescontoTaxaEntregaService.addMetodo(formaDescontoPorTipoCliente);
        calculadoraDescontoTaxaEntregaService.addMetodo(formaDescontoPorItem);

        System.out.print("------Pedido antes do calculo de desconto------\n");
        System.out.println(pedido.toString());

        calculadoraDescontoTaxaEntregaService.calcularTaxaDesconto(pedido);

        System.out.print("\n\n------Pedido após do calculo de desconto------\n");
        System.out.println(pedido.toString());
    }

}