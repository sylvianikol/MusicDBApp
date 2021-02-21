package com.softuni.exam.config;

import com.softuni.exam.init.CareerInfoContainer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public CareerInfoContainer careerInfoContainer() {
        return new CareerInfoContainer();
    }
}
