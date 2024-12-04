package org.example.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Log {

    private String nomeUsuario;
    private LocalDate data;
    private LocalTime hora;
    private String codigoPedido;
    private String nomeOperacao;
    private String nomeCliente;

    public Log(String nomeUsuario, String codigoPedido, String nomeOperacao, String nomeCliente) {
        this.nomeUsuario = nomeUsuario;
        this.codigoPedido = codigoPedido;
        this.nomeOperacao = nomeOperacao;
        this.nomeCliente = nomeCliente;
        this.data = LocalDate.now();
        this.hora = LocalTime.now();
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

    public LocalDate getData() {
        return data;
    }

    public String getHora() {
        return hora.toString();
    }

}
