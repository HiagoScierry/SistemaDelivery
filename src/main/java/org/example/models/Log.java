package org.example.models;

import java.time.LocalDateTime;

public class Log {

    private String nomeUsuario;
    private LocalDateTime data;
    private String codigoPedido;
    private String nomeOperacao;
    private String nomeCliente;

    public Log(String nomeUsuario, String codigoPedido, String nomeOperacao, String nomeCliente) {
        this.nomeUsuario = nomeUsuario;
        this.codigoPedido = codigoPedido;
        this.nomeOperacao = nomeOperacao;
        this.nomeCliente = nomeCliente;
        this.data = LocalDateTime.now();
    }

    //getters

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public String getNomeOperacao() {
        return nomeOperacao;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public LocalDateTime getData() {
        return data;
    }

}
