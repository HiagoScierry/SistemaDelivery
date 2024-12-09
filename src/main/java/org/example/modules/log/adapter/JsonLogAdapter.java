package org.example.modules.log.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.cdimascio.dotenv.Dotenv;
import org.example.models.Log;
import org.example.modules.log.interfaces.ILogAdapter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JsonLogAdapter implements ILogAdapter {
    private final String filePath;
    private ObjectMapper objectMapper;
    private final List<Log> logs;

    public JsonLogAdapter() {

        this.logs = new ArrayList<>();
        Dotenv dotenv = Dotenv.load();

        this.filePath = dotenv.get("LOG_FILE_PATH") + "log.json";
        System.out.println(this.filePath);

        // Configuração do ObjectMapper com suporte a LocalDateTime
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


    }

    @Override
    public void escreve(Log log) {
        logs.add(log); // Adiciona o novo log à lista

        try (FileWriter writer = new FileWriter(new File(filePath))) {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(logs);
            writer.write(json);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo JSON: " + e.getMessage());
        }
    }

}

