package org.example.modules.descontoPedido.services;

import org.example.models.Pedido;
import org.example.modules.descontoPedido.interfaces.IFormaDescontoPedido;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraDescontoPedidoService {
        private List<IFormaDescontoPedido> metodosDeDesconto;

        public CalculadoraDescontoPedidoService() {
            this.metodosDeDesconto = getListFormaDesconto();
        }

        public void calcularTaxaDesconto(Pedido pedido) {
            for (IFormaDescontoPedido forma : metodosDeDesconto) {
                forma.calcularDesconto(pedido);
            }
        }

        public void addMetodo(IFormaDescontoPedido formaDesconto){
            if(formaDesconto == null){
                return;
            }

            this.metodosDeDesconto.add(formaDesconto);
        }

        private static List<IFormaDescontoPedido> getListFormaDesconto() {
            List<IFormaDescontoPedido> formasDesconto = new ArrayList<>();

            IFormaDescontoPedido formaDescontoPedidoPorTipoCliente = new FormaDescontoPedidoPorTipoCliente();
            IFormaDescontoPedido formaDescontoPedidoPorItem = new FormaDescontoPedidoPorItem();
            IFormaDescontoPedido formaDescontoPedidoPorCupom = new FormaDescontoPedidoPorCupom();

            formasDesconto.add(formaDescontoPedidoPorTipoCliente);
            formasDesconto.add(formaDescontoPedidoPorItem);
            formasDesconto.add(formaDescontoPedidoPorCupom);

            return formasDesconto;
        }



}

