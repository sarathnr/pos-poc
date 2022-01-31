package com.zooplus.pospoc.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class POSConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}