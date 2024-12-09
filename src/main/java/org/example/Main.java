package org.example;


import org.example.models.Cliente;
import org.example.models.Item;
import org.example.models.Log;
import org.example.models.Pedido;
import org.example.modules.descontoEntrega.services.CalculadoraDescontoTaxaEntregaService;
import org.example.modules.descontoPedido.services.CalculadoraDescontoPedidoService;
import org.example.modules.log.adapter.DBLogAdapter;
import org.example.modules.log.adapter.JsonLogAdapter;
import org.example.modules.log.adapter.XMLLogAdapter;
import org.example.modules.log.interfaces.ILogAdapter;
import org.example.shared.services.LogServiceSingleton;
import org.example.shared.services.UsuarioLogadoService;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
//        exemploDescontoTaxaEntrega();
//        exemploPedido();
        exemploLog();
    }

    public static void exemploDescontoTaxaEntrega(){
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

    public static void exemploPedido(){
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

    public static void exemploLog(){
        LogServiceSingleton logServiceSingleton = LogServiceSingleton.getInstance();
        ILogAdapter logAdapter = new DBLogAdapter();

        Cliente cliente = new Cliente("Fulano", "Ouro", "Rua sem saída", "Centro", "Alegre");
        Item item = new Item("X-Calango", 1, 19.0, "Alimentação");
        Pedido pedido = new Pedido(10.0, LocalDate.now(), cliente);


        Log log = new Log(
                UsuarioLogadoService.getNomeUsuario(),
                pedido.getId(),
                "Realiza pedido",
                pedido.getCliente().getNome()
        );

        logAdapter.escreve(log);
        logAdapter.escreve(log);
        logAdapter.escreve(log);

    }
}