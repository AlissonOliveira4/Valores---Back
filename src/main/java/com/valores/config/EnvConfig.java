package com.valores.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {
    public static String getMongoUri() {
        Dotenv dotenv = Dotenv.load();
        return dotenv.get("BANCO_URL");
    }
}

