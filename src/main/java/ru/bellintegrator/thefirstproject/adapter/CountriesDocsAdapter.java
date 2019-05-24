package ru.bellintegrator.thefirstproject.adapter;

import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class CountriesDocsAdapter {
    private final MapperFactory mapperFactory;

    @Autowired
    public CountriesDocsAdapter(MapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
    }

    public <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass) {
        return mapperFactory.getMapperFacade().mapAsList(source, destinationClass);
    }

}
