package ru.bellintegrator.thefirstproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.thefirstproject.adapter.UserAdapterImpl;
import ru.bellintegrator.thefirstproject.adapter.UserDocAdapter;
import ru.bellintegrator.thefirstproject.adapter.UserDocXAdapter;
import ru.bellintegrator.thefirstproject.domain.entity.UserDocEntity;
import ru.bellintegrator.thefirstproject.domain.entity.UserDocIdEntity;
import ru.bellintegrator.thefirstproject.domain.entity.UserEntity;
import ru.bellintegrator.thefirstproject.domain.model.ResponseModel;
import ru.bellintegrator.thefirstproject.domain.model.user.*;
import ru.bellintegrator.thefirstproject.domain.model.userDoc.UserDocBaseModel;
import ru.bellintegrator.thefirstproject.domain.model.userDoc.UserDocFullModel;
import ru.bellintegrator.thefirstproject.repository.*;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final OfficeRepository officeRepository;
    private final UserRepositoryImpl userRepository;
/*
    private final UserDocXRepository userDocXRepository;
*/
    private final UserAdapterImpl userAdapter;
    private final UserDocAdapter userDocAdapter;
    private final CountriesDocsRepositoryImpl countryDocsRepository;
    private final UserDocRepositoryImpl userDocRepository;

    @Autowired
    public UserServiceImpl(OfficeRepository officeRepository, UserRepositoryImpl userRepository/*, UserDocXRepository userDocXRepository*/, UserAdapterImpl userAdapter, UserDocAdapter userDocAdapter, CountriesDocsRepositoryImpl countryDocsRepository, UserDocRepositoryImpl userDocRepository) {
        this.officeRepository = officeRepository;
        this.userRepository = userRepository;
/*
        this.userDocXRepository = userDocXRepository;
*/
        this.userAdapter = userAdapter;
        this.userDocAdapter = userDocAdapter;
        this.countryDocsRepository = countryDocsRepository;
        this.userDocRepository = userDocRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserBaseModel> getUserList(UserRequestModel userRequestModel){
        List<UserEntity> userBaseModelsList = userRepository.all(userRequestModel);
        return userAdapter.mapAsList(userBaseModelsList, UserBaseModel.class);
    }

    @Override
    @Transactional(readOnly = true)
    public UserFullModel getUserById(Long id){
        UserEntity userEntity = userRepository.loadById(id);
        return new UserFullModel.Builder().
                id(userEntity.getId()).
                firstName(userEntity.getFirstName()).
                lastName(userEntity.getLastName()).
                middleName(userEntity.getMiddleName()).
                position(userEntity.getPosition()).
                phone(userEntity.getUserPhone()).
                userDocBaseModelList(userDocAdapter.
                        userDocEntityListToUserDocBaseModelList(userDocRepository.all(id))).
                citizenshipName(userEntity.getCountry().getName()).
                citizenshipCode(userEntity.getCountry().getCode()).
                isIdentified(userEntity.getIsIdentified()).
                build();
    }

    @Override
    @Transactional
    public ResponseModel updateUser(UserUpdateModel userUpdateModel){
        userRepository.update(userUpdateModel);
        return new ResponseModel.Builder().result("success").build();
    }

    @Override
    @Transactional
    public ResponseModel createUser(@Valid UserCreatingModel userCreatingModel){
        UserEntity userEntity = new UserEntity(
                countryDocsRepository.loadCountryById(userCreatingModel.getCitizenshipId()),
                officeRepository.loadById(userCreatingModel.getOfficeId()),
                userCreatingModel.getFirstName(),
                userCreatingModel.getLastName(),
                userCreatingModel.getMiddleName(),
                userCreatingModel.getPosition(),
                userCreatingModel.getPhone(),
                userCreatingModel.getIsIdentified()
                );
        userRepository.save(userEntity);
        return new ResponseModel.Builder().result("success").build();
    }

    @Override
    @Transactional
    public ResponseModel updateUserDoc(UserDocFullModel userDocFullModel){
        userDocRepository.update(userDocFullModel);
        return new ResponseModel.Builder().result("success").build();
    }

    @Override
    @Transactional
    public ResponseModel createUserDoc(@Valid UserDocFullModel userDocFullModel){
        UserDocEntity userDocEntity = new UserDocEntity(
                new UserDocIdEntity(userRepository.loadById(userDocFullModel.getUserId()),
                        countryDocsRepository.loadDocById(userDocFullModel.getDocTypeId())),
                /*userRepository.loadById(userDocFullModel.getUserId()),
                countryDocsRepository.loadDocById(userDocFullModel.getDocTypeId()),*/
                userDocFullModel.getSerNum(),
                userDocFullModel.getWhoIssued(),
                userDocFullModel.getDepCode(),
                userDocFullModel.getDocDate(),
                userDocFullModel.getIsGeneral()
        );
        userDocRepository.save(userDocEntity);
        return new ResponseModel.Builder().result("success").build();
    }
}
