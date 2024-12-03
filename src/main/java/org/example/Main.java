package org.example;


import org.example.models.Cliente;
import org.example.models.Item;
import org.example.models.Pedido;
import org.example.modules.descontoEntrega.interfaces.IFormaDescontoTaxaEntrega;
import org.example.modules.descontoEntrega.services.CalculadoraDescontoTaxaEntregaService;
import org.example.modules.descontoPedido.services.CalculadoraDescontoPedidoService;

import java.time.LocalDate;
import org.exemple.usuarioLogado.services.UsuarioLogadoService;

public class Main {

    public static void main(String[] args) {
        
        //TAXA ENTREGA
        CalculadoraDescontoTaxaEntregaService calculadoraDescontoTaxaEntregaService = new CalculadoraDescontoTaxaEntregaService();

        Cliente cliente = new Cliente("Fulano", "Ouro", "Rua sem saída", "Centro", "Alegre");
        Item item = new Item("X-Calango", 1, 19.0, "Alimentação");
        Pedido pedidoEntrega = new Pedido(10.0, LocalDate.now(), cliente);

        pedidoEntrega.adicionarItem(item);

        System.out.print("------Pedido antes do calculo de desconto------\n");
        System.out.println(pedidoEntrega.toString());

        calculadoraDescontoTaxaEntregaService.calcularTaxaDesconto(pedidoEntrega);

        System.out.print("\n\n------Pedido após do calculo de desconto------\n");
        System.out.println(pedidoEntrega.toString());
        
        
        //PEDIDO
        
        CalculadoraDescontoPedidoService calculadoraDescontoPedidoService = new CalculadoraDescontoPedidoService();

        Cliente clientePedido = new Cliente("Fulano", "Ouro", "Rua sem saída", "Centro", "Alegre");
        Item itemPedido = new Item("X-Calango", 1, 19.0, "Alimentação");
        Pedido pedido = new Pedido(10.0, LocalDate.now(), cliente);

        pedido.adicionarItem(itemPedido);

        System.out.print("------Pedido antes do calculo de desconto------\n");
        System.out.println(pedido.toString());

        calculadoraDescontoPedidoService.calcularTaxaDesconto(pedido);

        System.out.print("\n\n------Pedido após do calculo de desconto------\n");
        System.out.println(pedido.toString());
        
       
        //LOG
        
        
        System.out.println("Cheguei aqui!");
              
        String nomeCliente = UsuarioLogadoService.getNomeUsuario();
        
        Cliente logCliente = new Cliente(nomeCliente, "Ouro", "Rua sem saída", "Centro", "Alegre");
        System.out.println(logCliente);
        
        Item itemLog = new Item("X-Calango", 1, 19.0, "Alimentação");
        Pedido pedidoLog = new Pedido(10.0, LocalDate.now(), logCliente);

        pedido.adicionarItem(itemLog);

        System.out.print("------Pedido antes do calculo de desconto------\n");
        System.out.println(pedidoLog.toString());

        calculadoraDescontoPedidoService.calcularTaxaDesconto(pedidoLog);

        System.out.print("\n\n------Pedido após do calculo de desconto------\n");
        System.out.println(pedidoLog.toString());
    }

    public void exemploDescontoTaxaEntrega(){
        
    }

    public void exemploPedido(){
        
    }
    
    public void exemploLog(){
        
    }

}