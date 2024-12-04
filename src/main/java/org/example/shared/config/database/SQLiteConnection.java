package org.example.shared.config.database;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {
    private static String url;

    public static Connection getConexao() throws Exception {
        Dotenv dotenv = Dotenv.load();
        url = dotenv.get("CAMINHO_BANCO_DADOS");
        if(url == null){
            url = ("CAMINHO_BANCO_DADOS");
        }

        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new Exception("Problema ao abrir banco de dados SQLite");
        }
    }
}