package org.example.models;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Log {

    private String nomeUsuario;
    private LocalDateTime data;
    private int codigoPedido;
    private String nomeOperacao;
    private String nomeCliente;

    public Log(String nomeUsuario, int codigoPedido, String nomeOperacao, String nomeCliente) {
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

    public int getCodigoPedido() {
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
