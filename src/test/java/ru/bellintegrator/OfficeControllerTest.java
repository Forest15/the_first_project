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
import ru.bellintegrator.thefirstproject.controller.OfficeController;
import ru.bellintegrator.thefirstproject.domain.model.ResponseModel;
import ru.bellintegrator.thefirstproject.domain.model.office.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
public class OfficeControllerTest {
    @Mock
    OfficeController officeController;

    @InjectMocks
    RestTemplate restTemplate = new RestTemplate();
    @InjectMocks
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testOfficeControllerGetOfficeList() throws IOException {
        //Preparing the input and output data.

        OfficeRequestModel officeRequestModel = new OfficeRequestModel.
                Builder().
                orgId(1L).
                name("BeelineTechOffice").
                phone("84959999991").
                isActive(true).
                build();

        List<OfficeBaseModel> officeBaseCheckModelList = new ArrayList<>();
        officeBaseCheckModelList.add(new OfficeBaseModel.Builder().id(1L).name("BeelineTechOffice").isActive(true).build());

        //The when & then elements of the Mock test.
        Mockito
                .when(officeController.getOfficeList(officeRequestModel))
                .thenReturn(officeBaseCheckModelList);

        //Validation of the test's results.

        HttpEntity<OfficeRequestModel> requestEntity = new HttpEntity<>(officeRequestModel);
        OfficeBaseModel[] office = restTemplate.postForObject("http://localhost:8585/api/office/list", requestEntity, OfficeBaseModel[].class);


        Assert.assertEquals(officeBaseCheckModelList.get(0).getId(), office[0].getId());
        Assert.assertEquals(officeBaseCheckModelList.get(0).getName(), office[0].getName());
        Assert.assertEquals(officeBaseCheckModelList.get(0).getIsActive(), office[0].getIsActive());
    }

    @Test
    public void testOfficeControllerGetOfficeById(){
        //Preparing the input and output data.
        Long id = 1L;
        OfficeFullModel officeCheckFullModel = new OfficeFullModel.Builder().id(1L).name("BeelineTechOffice").address("ул. Станции Билайн").phone("84959999991").isActive(true).build();


        //The when & then elements of the Mock test.
        Mockito
                .when(officeController.getOfficeById(id))
                .thenReturn(officeCheckFullModel);

        //Validation of the test's results.
        ResponseEntity<OfficeFullModel> officeFullModelOriginalResult = restTemplate.getForEntity("http://localhost:8585/api/office/" + id, OfficeFullModel.class);
        Assert.assertEquals(officeCheckFullModel.getId(), officeFullModelOriginalResult.getBody().getId());
        Assert.assertEquals(officeCheckFullModel.getName(), officeFullModelOriginalResult.getBody().getName());
        Assert.assertEquals(officeCheckFullModel.getAddress(), officeFullModelOriginalResult.getBody().getAddress());
        Assert.assertEquals(officeCheckFullModel.getPhone(), officeFullModelOriginalResult.getBody().getPhone());
        Assert.assertEquals(officeCheckFullModel.getIsActive(), officeFullModelOriginalResult.getBody().getIsActive());
    }

    @Test
    public void testOfficeControllerUpdateOffice(){
        //Preparing the input and output data.
        OfficeFullModel officeCheckFullModel = new OfficeFullModel.Builder().id(1L).name("BeelineTechOffice").address("ул. Станции Билайн").phone("84959999991").isActive(true).build();
        ResponseModel responseCheckModel = new ResponseModel.Builder().result("success").build();


        //The when & then elements of the Mock test.
        Mockito
                .when(officeController.updateOffice(officeCheckFullModel))
                .thenReturn(responseCheckModel);

        //Validation of the test's results.
        HttpEntity<OfficeFullModel> entity = new HttpEntity<>(officeCheckFullModel);
        ResponseEntity<ResponseModel> responseModelOriginalResult = restTemplate.exchange("http://localhost:8585/api/office/update", HttpMethod.PUT, entity, ResponseModel.class);
        Assert.assertEquals(responseCheckModel, responseModelOriginalResult.getBody());
    }

    @Test
    public void testOfficeControllerCreateOffice(){
        //Preparing the input and output data.
        OfficeCreatingModel officeCreatingModel = new OfficeCreatingModel.Builder().orgId(1L).name("VK").address("1111111").phone("1111111").isActive(true).build();
        ResponseModel responseModel = new ResponseModel.Builder().result("success").build();

        //The when & then elements of the Mock test.
        Mockito
                .when(officeController.createOffice(officeCreatingModel))
                .thenReturn(responseModel);

        //Validation of the test's results.
        ResponseEntity<ResponseModel> responseModelOriginalResult = restTemplate.postForEntity("http://localhost:8585/api/office/save", officeCreatingModel, ResponseModel.class);
        Assert.assertEquals(responseModel, responseModelOriginalResult.getBody());
    }
}
