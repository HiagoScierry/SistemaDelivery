package org.example.modules.log.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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

public class XMLLogAdapter implements ILogAdapter {
    private final String filePath;
    private final XmlMapper xmlMapper;
    private final List<Log> logs;

    // Construtor para inicializar o caminho do arquivo e configurar o XmlMapper
    public XMLLogAdapter() {
        this.logs = new ArrayList<>();
        Dotenv dotenv = Dotenv.load();

        this.filePath = dotenv.get("LOG_FILE_PATH") + "log.xml";
        System.out.println(this.filePath);

        // Configuração do ObjectMapper com suporte a LocalDateTime
        this.xmlMapper = new XmlMapper();
        this.xmlMapper.registerModule(new JavaTimeModule());
        this.xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


    }

    @Override
    public void escreve(Log log) {
        String xmlStart = "<logs>";
        String xmlEnd = "</logs>";

        try (FileWriter writer = new FileWriter(new File(filePath), true)) {
            String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(log);
            writer.write(xml + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo XML: " + e.getMessage());
        }
    }
}
