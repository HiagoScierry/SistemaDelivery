package org.example.modules.log.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.example.models.Log;
import org.example.modules.log.interfaces.ILog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JSONLog implements ILog {
    private final String filePath;
    private final ObjectMapper objectMapper;
    private final List<Log> logs;

    public JSONLog(String filePath) {
        this.filePath = filePath;

        // Configuração do ObjectMapper com suporte a LocalDateTime
        this.objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        objectMapper.registerModule(module);

        this.logs = new ArrayList<>();
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

    // Serializer personalizado para LocalDateTime
    private static class LocalDateTimeSerializer extends com.fasterxml.jackson.databind.JsonSerializer<LocalDateTime> {
        private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        @Override
        public void serialize(LocalDateTime value, com.fasterxml.jackson.core.JsonGenerator gen, com.fasterxml.jackson.databind.SerializerProvider serializers) throws IOException {
            gen.writeString(value.format(formatter));
        }
    }
}

