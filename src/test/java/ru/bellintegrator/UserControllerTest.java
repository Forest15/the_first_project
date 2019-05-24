package ru.bellintegrator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.bellintegrator.thefirstproject.controller.UserController;
import ru.bellintegrator.thefirstproject.domain.model.ResponseModel;
import ru.bellintegrator.thefirstproject.domain.model.user.*;
import ru.bellintegrator.thefirstproject.domain.model.userDoc.UserDocFullModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {
    @Mock
    UserController userController;

    @InjectMocks
    RestTemplate restTemplate = new RestTemplate();
    @InjectMocks
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testUserControllerGetUserList() throws IOException {
        //Preparing the input and output data.

        UserRequestModel userRequestModel = new UserRequestModel.
                Builder().
                officeId(1L).
                firstName("Vladimir").
                lastName("Cherevko").
                middleName("Igorevich").
                position("admin").
                citizenshipCode("643").
                build();

        List<UserBaseModel> userBaseCheckModelList = new ArrayList<>();
        userBaseCheckModelList.add(new UserBaseModel.Builder().id(1L).firstName("Vladimir").lastName("Cherevko").middleName("Igorevich").position("admin").build());

        //The when & then elements of the Mock test.
        Mockito
                .when(userController.getUserList(userRequestModel))
                .thenReturn(userBaseCheckModelList);

        //Validation of the test's results.

        HttpEntity<UserRequestModel> requestEntity = new HttpEntity<>(userRequestModel);
        UserBaseModel[] user = restTemplate.postForObject("http://localhost:8585/api/user/list", requestEntity, UserBaseModel[].class);


        Assert.assertEquals(userBaseCheckModelList.get(0).getId(), user[0].getId());
        Assert.assertEquals(userBaseCheckModelList.get(0).getFirstName(), user[0].getFirstName());
        Assert.assertEquals(userBaseCheckModelList.get(0).getMiddleName(), user[0].getMiddleName());
        Assert.assertEquals(userBaseCheckModelList.get(0).getLastName(), user[0].getLastName());
        Assert.assertEquals(userBaseCheckModelList.get(0).getPosition(), user[0].getPosition());
    }

    @Test
    public void testUserControllerGetUserById(){
        //Preparing the input and output data.
        Long id = 1L;
        UserFullModel userCheckFullModel = new UserFullModel.Builder().id(1L).firstName("Vladimir").lastName("Cherevko").middleName("Igorevich").position("admin").phone("*1").citizenshipCode("643").citizenshipName("Российская Федерация").isIdentified(true).build();


        //The when & then elements of the Mock test.
        Mockito
                .when(userController.getUserById(id))
                .thenReturn(userCheckFullModel);

        //Validation of the test's results.
        ResponseEntity<UserFullModel> userFullModelOriginalResult = restTemplate.getForEntity("http://localhost:8585/api/user/" + id, UserFullModel.class);
        Assert.assertEquals(userCheckFullModel.getId(), userFullModelOriginalResult.getBody().getId());
        Assert.assertEquals(userCheckFullModel.getFirstName(), userFullModelOriginalResult.getBody().getFirstName());
        Assert.assertEquals(userCheckFullModel.getMiddleName(), userFullModelOriginalResult.getBody().getMiddleName());
        Assert.assertEquals(userCheckFullModel.getLastName(), userFullModelOriginalResult.getBody().getLastName());
        Assert.assertEquals(userCheckFullModel.getPosition(), userFullModelOriginalResult.getBody().getPosition());
        Assert.assertEquals(userCheckFullModel.getPhone(), userFullModelOriginalResult.getBody().getPhone());
        Assert.assertEquals(userCheckFullModel.getCitizenshipCode(), userFullModelOriginalResult.getBody().getCitizenshipCode());
        Assert.assertEquals(userCheckFullModel.getCitizenshipName(), userFullModelOriginalResult.getBody().getCitizenshipName());
    }

    @Test
    public void testUserControllerUpdateUser(){
        //Preparing the input and output data.
        UserUpdateModel UserUpdateModel = new UserUpdateModel.Builder().id(1L).officeId(1L).firstName("Vladimir").lastName("Cherevko").middleName("Igorevich").position("admin").phone("*1").citizenshipId(1L).isIdentified(true).build();
        ResponseModel responseCheckModel = new ResponseModel.Builder().result("success").build();


        //The when & then elements of the Mock test.
        Mockito
                .when(userController.updateUser(UserUpdateModel))
                .thenReturn(responseCheckModel);

        //Validation of the test's results.
        HttpEntity<UserUpdateModel> entity = new HttpEntity<>(UserUpdateModel);
        ResponseEntity<ResponseModel> responseModelOriginalResult = restTemplate.exchange("http://localhost:8585/api/user/update", HttpMethod.PUT, entity, ResponseModel.class);
        Assert.assertEquals(responseCheckModel, responseModelOriginalResult.getBody());
    }

    @Test
    public void testUserControllerCreateUser(){
        //Preparing the input and output data.
        UserCreatingModel userCreatingModel = new UserCreatingModel.Builder().officeId(1L).firstName("SVladimir").lastName("Cherevko").middleName("Igorevich").position("admin").phone("*1").citizenshipId(1L).isIdentified(true).build();
        ResponseModel responseModel = new ResponseModel.Builder().result("success").build();

        //The when & then elements of the Mock test.
        Mockito
                .when(userController.createUser(userCreatingModel))
                .thenReturn(responseModel);

        //Validation of the test's results.
        ResponseEntity<ResponseModel> responseModelOriginalResult = restTemplate.postForEntity("http://localhost:8585/api/user/save", userCreatingModel, ResponseModel.class);
        Assert.assertEquals(responseModel, responseModelOriginalResult.getBody());
    }

    @Test
    public void testUserControllerUpdateUserDoc(){
        //Preparing the input and output data.
        UserDocFullModel userDocFullModel = new UserDocFullModel.Builder().userId(1L).docTypeId(1L).serNum("9009908991").whoIssued("State Department #1").depCode("115-551").docDate(new Date()).isIsGeneral(true).build();
        ResponseModel responseCheckModel = new ResponseModel.Builder().result("success").build();


        //The when & then elements of the Mock test.
        Mockito
                .when(userController.updateUserDoc(userDocFullModel))
                .thenReturn(responseCheckModel);

        //Validation of the test's results.
        HttpEntity<UserDocFullModel> entity = new HttpEntity<>(userDocFullModel);
        ResponseEntity<ResponseModel> responseModelOriginalResult = restTemplate.exchange("http://localhost:8585/api/user/userdocs/update", HttpMethod.PUT, entity, ResponseModel.class);
        Assert.
                assertEquals(responseCheckModel, responseModelOriginalResult.getBody());
    }

    @Test
    public void testUserControllerCreateUserDoc(){
        //Preparing the input and output data.
        UserDocFullModel userDocFullModel = new UserDocFullModel.Builder().userId(8L).docTypeId(1L).serNum("9009908991").whoIssued("State Department #1").depCode("115-551").docDate(new Date()).isIsGeneral(true).build();
        ResponseModel responseModel = new ResponseModel.Builder().result("success").build();

        //The when & then elements of the Mock test.
        Mockito
                .when(userController.createUserDoc(userDocFullModel))
                .thenReturn(responseModel);

        //Validation of the test's results.
        ResponseEntity<ResponseModel> responseModelOriginalResult = restTemplate.postForEntity("http://localhost:8585/api/user/userdocs/save", userDocFullModel, ResponseModel.class);
        Assert.assertEquals(responseModel, responseModelOriginalResult.getBody());
    }
}
