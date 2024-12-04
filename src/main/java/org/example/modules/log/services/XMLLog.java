package org.example.modules.log.services;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.models.Log;
import org.example.modules.log.interfaces.ILog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class XMLLog implements ILog {
    private final String filePath;
    private final XmlMapper xmlMapper;

    // Construtor para inicializar o caminho do arquivo e configurar o XmlMapper
    public XMLLog(String filePath) {
        this.filePath = filePath;

        // Configuração para formatar a data e hora no formato desejado
        this.xmlMapper = new XmlMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        xmlMapper.registerModule(module);
    }

    @Override
    public void escreve(Log log) {
        try (FileWriter writer = new FileWriter(new File(filePath), true)) {
            String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(log);
            writer.write(xml + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo XML: " + e.getMessage());
        }
    }

    // Serializer personalizado para formatar LocalDateTime
    private static class LocalDateTimeSerializer extends com.fasterxml.jackson.databind.JsonSerializer<LocalDateTime> {
        private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        @Override
        public void serialize(LocalDateTime value, com.fasterxml.jackson.core.JsonGenerator gen, com.fasterxml.jackson.databind.SerializerProvider serializers) throws IOException {
            gen.writeString(value.format(formatter));
        }
    }
}
