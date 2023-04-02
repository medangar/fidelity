package com.arabsoft.fidelity.config;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public Jackson2ObjectMapperBuilderCustomizer addJavaTimeModule() {
    return builder -> builder.modulesToInstall(new JavaTimeModule());
  }

}
