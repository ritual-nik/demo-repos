package com.poc.exception_handling.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
public class TranslationsConfig {

    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderResolver localeResolver = new AcceptHeaderResolver();
        return localeResolver;
    }
}
