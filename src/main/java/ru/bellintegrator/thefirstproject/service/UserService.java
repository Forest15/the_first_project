package ru.bellintegrator.thefirstproject.service;

import ru.bellintegrator.thefirstproject.domain.model.ResponseModel;
import ru.bellintegrator.thefirstproject.domain.model.user.*;
import ru.bellintegrator.thefirstproject.domain.model.userDoc.UserDocFullModel;

import javax.validation.Valid;
import java.util.List;

public interface UserService {
    /**
     * Get the user list
     *
     * @return {List<UserBaseModel>}
     */
    List<UserBaseModel> getUserList(UserRequestModel officeRequestModel);

    /**
     *
     * Get the user by id;
     *
     * @param id
     *
     * @return UserFullModel
     */
    public UserFullModel getUserById(Long id);

    /**
     *
     * Update the user;
     *
     * @param uesrUpdateModel
     *
     * @return ResponseModel
     *
     */
    public ResponseModel updateUser(UserUpdateModel uesrUpdateModel);

    /**
     * Add new user into DB
     *
     * @param userCreatingModel
     */
    ResponseModel createUser
    (@Valid UserCreatingModel userCreatingModel);

    /**
     *
     * Update the user doc;
     *
     * @param userDocFullModel
     *
     * @return ResponseModel
     *
     */
    public ResponseModel updateUserDoc(UserDocFullModel userDocFullModel);

    /**
     * Add new user doc into DB
     *
     * @param userDocFullModel
     */
    ResponseModel createUserDoc
    (@Valid UserDocFullModel userDocFullModel);
}
