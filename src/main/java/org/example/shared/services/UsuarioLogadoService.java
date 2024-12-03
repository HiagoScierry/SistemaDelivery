package org.example.shared.services;

import java.util.Random;

public class UsuarioLogadoService {

    public static final Random gerarAleatorio = new Random();

    public static String getNomeUsuario() {
        int valor = gerarAleatorio.nextInt(100);
        if (valor < 33) {
            return "BALCAO PDV 1";
        } else if (valor < 66) {
            return "Gerente";
        } else {
            return "Fulano de tal";
        }
    }

}
