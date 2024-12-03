package org.example;


import org.example.models.Cliente;
import org.example.models.Item;
import org.example.models.Pedido;
import org.example.modules.descontoEntrega.interfaces.IFormaDescontoTaxaEntrega;
import org.example.modules.descontoEntrega.services.CalculadoraDescontoTaxaEntregaService;
import org.example.modules.descontoPedido.services.CalculadoraDescontoPedidoService;

import java.time.LocalDate;
import org.exemple.usuarioLogado.services.UsuarioLogadoService;

public class Main1 {

    public void main(String[] args) {
        exemploDescontoTaxaEntrega();
        exemploPedido();
        exemploLog();
    }

    public void exemploDescontoTaxaEntrega(){
        CalculadoraDescontoTaxaEntregaService calculadoraDescontoTaxaEntregaService = new CalculadoraDescontoTaxaEntregaService();

        Cliente cliente = new Cliente("Fulano", "Ouro", "Rua sem saída", "Centro", "Alegre");
        Item item = new Item("X-Calango", 1, 19.0, "Alimentação");
        Pedido pedido = new Pedido(10.0, LocalDate.now(), cliente);

        pedido.adicionarItem(item);

        System.out.print("------Pedido antes do calculo de desconto------\n");
        System.out.println(pedido.toString());

        calculadoraDescontoTaxaEntregaService.calcularTaxaDesconto(pedido);

        System.out.print("\n\n------Pedido após do calculo de desconto------\n");
        System.out.println(pedido.toString());
    }

    public void exemploPedido(){
        CalculadoraDescontoPedidoService calculadoraDescontoPedidoService = new CalculadoraDescontoPedidoService();

        Cliente cliente = new Cliente("Fulano", "Ouro", "Rua sem saída", "Centro", "Alegre");
        Item item = new Item("X-Calango", 1, 19.0, "Alimentação");
        Pedido pedido = new Pedido(10.0, LocalDate.now(), cliente);

        pedido.adicionarItem(item);

        System.out.print("------Pedido antes do calculo de desconto------\n");
        System.out.println(pedido.toString());

        calculadoraDescontoPedidoService.calcularTaxaDesconto(pedido);

        System.out.print("\n\n------Pedido após do calculo de desconto------\n");
        System.out.println(pedido.toString());
    }
    
    public void exemploLog(){
        System.out.println("Cheguei aqui!");
        CalculadoraDescontoPedidoService calculadoraDescontoPedidoService = new CalculadoraDescontoPedidoService();
              
        String nomeCliente = UsuarioLogadoService.getNomeUsuario();
        
        Cliente logCliente = new Cliente(nomeCliente, "Ouro", "Rua sem saída", "Centro", "Alegre");
        System.out.println(logCliente);
        
        Item item = new Item("X-Calango", 1, 19.0, "Alimentação");
        Pedido pedido = new Pedido(10.0, LocalDate.now(), logCliente);

        pedido.adicionarItem(item);

        System.out.print("------Pedido antes do calculo de desconto------\n");
        System.out.println(pedido.toString());

        calculadoraDescontoPedidoService.calcularTaxaDesconto(pedido);

        System.out.print("\n\n------Pedido após do calculo de desconto------\n");
        System.out.println(pedido.toString());
    }

}