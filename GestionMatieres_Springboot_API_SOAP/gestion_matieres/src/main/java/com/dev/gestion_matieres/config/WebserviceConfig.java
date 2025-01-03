package com.dev.gestion_matieres.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

@EnableWs
@Configuration
@ImportResource("classpath:ws-config.xml")
public class WebserviceConfig {
    @Bean
    public MessageDispatcherServlet messageDispatcherServlet() {
        return new MessageDispatcherServlet();
    }
}
