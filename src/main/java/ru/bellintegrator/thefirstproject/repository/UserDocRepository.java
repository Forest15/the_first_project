package ru.bellintegrator.thefirstproject.repository;

import ru.bellintegrator.thefirstproject.domain.entity.UserDocEntity;
import ru.bellintegrator.thefirstproject.domain.model.userDoc.UserDocFullModel;

import java.util.List;

public interface UserDocRepository {

    /**
     * Get all the UserDocEntity objects;
     *
     * @return List<UserDocEntity>
     */
    List<UserDocEntity> all();

    /**
     * Get the UserDocEntity object by id;
     *
     * @param id
     * @return UserDocEntity
     */
    UserDocEntity loadById(Long id);

    /**
     * Update the UserDocFullModel object;
     * @param userDocFullModel
     */
    Integer update(UserDocFullModel userDocFullModel);

    /**
     * Save the UserDocEntity object;
     *
     * @param userDocEntity
     */
    void save(UserDocEntity userDocEntity);
}
