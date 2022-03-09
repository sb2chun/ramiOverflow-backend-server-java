package com.miracom.backendramioverflow.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class FileUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T readJsonFile(Class<T> clazz, String fileName) {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try (InputStream inputStream = new ClassPathResource(fileName).getInputStream()) {

            return objectMapper.readValue(inputStream, clazz);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
