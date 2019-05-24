package ru.bellintegrator.thefirstproject.repository;

import ru.bellintegrator.thefirstproject.domain.entity.UserEntity;
import ru.bellintegrator.thefirstproject.domain.model.user.UserRequestModel;
import ru.bellintegrator.thefirstproject.domain.model.user.UserUpdateModel;

import java.util.List;

public interface UserRepository {

    /**
     * Get all the UserEntity objects;
     *
     * @return List<UserEntity>
     */
    List<UserEntity> all(UserRequestModel userRequestModel);

    /**
     * Get the UserEntity object by id;
     *
     * @param id
     * @return UserEntity
     */
    UserEntity loadById(Long id);

    /**
     * Update the UserUpdateModel object;
     * @param userUpdateModel
     */
    Integer update(UserUpdateModel userUpdateModel);

    /**
     * Save the UserEntity object;
     *
     * @param userEntity
     */
    void save(UserEntity userEntity);
}
