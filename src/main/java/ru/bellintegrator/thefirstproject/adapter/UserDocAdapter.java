package ru.bellintegrator.thefirstproject.adapter;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.thefirstproject.domain.entity.UserDocEntity;
import ru.bellintegrator.thefirstproject.domain.model.user.UserBaseModel;
import ru.bellintegrator.thefirstproject.domain.model.userDoc.UserDocBaseModel;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserDocAdapter implements Adapter{
    private final MapperFactory mapperFactory;
    /*
    private final CustomMapperFactory customMapperFactory;
*/

    @Autowired
    public UserDocAdapter(MapperFactory mapperFactory/*, CustomMapperFactory customMapperFactory*/) {
        this.mapperFactory = mapperFactory;
/*
        this.customMapperFactory = customMapperFactory;
*/
    }

    @Override
    public <S, D> D map(S sourceObject, Class<D> destinationClass) {
        return mapperFactory.getMapperFacade().map(sourceObject, destinationClass);
    }

    @Override
    public <S, D> void map(S sourceObject, D destinationObject) {
        mapperFactory.getMapperFacade().map(sourceObject, destinationObject);
    }

    @Override
    public <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass) {
/*
        MapperFactory mapperFactory = customMapperFactory.getObject();
*/

        MapperFactory mapperFactoryX = new DefaultMapperFactory.Builder().build();
        mapperFactoryX.classMap(UserDocEntity.class, UserDocBaseModel.class).
                field("docDate", "docDate").byDefault().register();
        MapperFacade mapperFacade = mapperFactoryX.getMapperFacade();
        return mapperFacade.mapAsList(source, destinationClass);

    }
    public List<UserDocBaseModel> userDocEntityListToUserDocBaseModelList(List<UserDocEntity> userDocEntityList){

    if(userDocEntityList == null){

        return null;

    }

    List<UserDocBaseModel> userDocBaseModels = new ArrayList<UserDocBaseModel>();
        for(UserDocEntity userDoc: userDocEntityList){

            userDocBaseModels.add(
                    new UserDocBaseModel.Builder().
                            docTypeId(userDoc.getUserDocIdEntity().getDocType().getId()).
                            docName(userDoc.getUserDocIdEntity().getDocType().getName()).
                            serNum(userDoc.getSerNum()).
                            whoIssued(userDoc.getWhoIssued()).
                            depCode(userDoc.getDepCode()).
                            docDate(userDoc.getDocDate()).
                            isGeneral(userDoc.getIsGeneral()).
                            build());
            }

        return userDocBaseModels;

    }
}
