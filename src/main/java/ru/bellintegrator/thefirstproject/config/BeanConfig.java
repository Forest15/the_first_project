package ru.bellintegrator.thefirstproject.config;

import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.bellintegrator.thefirstproject.service.OfficeService;

@Configuration
public class BeanConfig {

    @Bean
    public MapperFactory mapper() {
        return new DefaultMapperFactory.Builder().build();
    }

}
