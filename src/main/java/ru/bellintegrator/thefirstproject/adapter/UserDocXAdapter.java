package ru.bellintegrator.thefirstproject.adapter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.bellintegrator.thefirstproject.domain.entity.UserDocEntity;
import ru.bellintegrator.thefirstproject.domain.model.userDoc.UserDocBaseModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDocXAdapter {
    UserDocXAdapter USER_DOC_ADAPTER = Mappers.getMapper(UserDocXAdapter.class);
    List<UserDocBaseModel> toUserDocBaseModelList(List<UserDocEntity> userDocEntityList);
}
