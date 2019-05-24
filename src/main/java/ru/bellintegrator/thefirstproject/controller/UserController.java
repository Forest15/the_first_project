package ru.bellintegrator.thefirstproject.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.thefirstproject.domain.model.ResponseModel;
import ru.bellintegrator.thefirstproject.domain.model.user.*;
import ru.bellintegrator.thefirstproject.domain.model.userDoc.UserDocFullModel;
import ru.bellintegrator.thefirstproject.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "api/user", produces = "application/json")
public class UserController {
    private final UserService userService;

    @Autowired
    public  UserController( UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/list")
    @ApiOperation(value = "Request the user list with filter", tags = "User")
    public List<UserBaseModel> getUserList(@RequestBody UserRequestModel userRequestModel){
        return  userService.getUserList(userRequestModel);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get user card by id", tags = "User")
    public UserFullModel getUserById(@PathVariable("id") Long id) {
        return  userService.getUserById(id);
    }

    @PutMapping(value = "/update")
    @ApiOperation(value = "The update of the user details", tags = "User")
    public ResponseModel updateUser(@RequestBody UserUpdateModel userUpdateModel){
        return  userService.updateUser(userUpdateModel);
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "The creation of the user", tags = "User")
    public ResponseModel createUser(@RequestBody UserCreatingModel userCreatingModel){
        return  userService.createUser(userCreatingModel);
    }

    @PutMapping(value = "/userdocs/update")
    @ApiOperation(value = "The update of the user document.", tags = "User")
    public ResponseModel updateUserDoc(@RequestBody UserDocFullModel userDocFullModel){
        return userService.updateUserDoc(userDocFullModel);
    }

    @PostMapping(value = "/userdocs/save")
    @ApiOperation(value = "The creation of the user document.", tags = "User")
    public ResponseModel createUserDoc(@RequestBody UserDocFullModel userDocFullModel){
        return userService.createUserDoc(userDocFullModel);
    }
}
