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
import ru.bellintegrator.thefirstproject.controller.OrganizationController;
import ru.bellintegrator.thefirstproject.domain.model.ResponseModel;
import ru.bellintegrator.thefirstproject.domain.model.organization.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
public class OrganizationControllerTest {
    @Mock
    OrganizationController organizationController;

    @InjectMocks
    RestTemplate restTemplate = new RestTemplate();
    @InjectMocks
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testOrganizationControllerGetOrgList() throws IOException, URISyntaxException {
        //Preparing the input and output data.

        OrganizationRequestModel organizationRequestModel = new OrganizationRequestModel.
                Builder().
                orgName("Beeline").
                inn("1").
                isActive(true).
                build();

        List<OrganizationBaseModel> orgBaseCheckModelList = new ArrayList<OrganizationBaseModel>();
        orgBaseCheckModelList.add(new OrganizationBaseModel.Builder().id(1L).name("Beeline").isActive(true).build());

        //The when & then elements of the Mock test.
        Mockito
                .when(organizationController.getOrgList(organizationRequestModel))
                .thenReturn(orgBaseCheckModelList);

        //Validation of the test's results.

        HttpEntity<OrganizationRequestModel> requestEntity = new HttpEntity<>(organizationRequestModel);
        OrganizationBaseModel[] organization = restTemplate.postForObject("http://localhost:8585/api/organization/list", requestEntity, OrganizationBaseModel[].class);


        Assert.
                assertEquals(orgBaseCheckModelList.get(0), organization[0]);
    }

    @Test
    public void testOrganizationControllerGetOrgById(){
        //Preparing the input and output data.
        Long id = 1L;
        OrganizationFullModel organizationCheckFullModel = new OrganizationFullModel.Builder().fullName("Vimpelcom").inn("111111111111").kpp("111111111").address("ул. 8-го марта").phone("84959999990").id(1L).name("Beeline").isActive(true).build();


        //The when & then elements of the Mock test.
        Mockito
                .when(organizationController.getOrgById(id))
                .thenReturn(organizationCheckFullModel);

        //Validation of the test's results.
        ResponseEntity<OrganizationFullModel> organizationFullModelOriginalResult = restTemplate.getForEntity("http://localhost:8585/api/organization/" + id, OrganizationFullModel.class);
        Assert.assertEquals(organizationCheckFullModel, organizationFullModelOriginalResult.getBody());

    }

    @Test
    public void testOrganizationControllerUpdateOrganization(){
        //Preparing the input and output data.
        OrganizationFullModel organizationFullModel = new OrganizationFullModel.Builder().fullName("Vimpelcom").inn("111111111111").kpp("111111111").address("ул. 8-го марта").phone("84959999990").id(1L).name("Beeline").isActive(true).build();
        ResponseModel responseCheckModel = new ResponseModel.Builder().result("success").build();


        //The when & then elements of the Mock test.
        Mockito
                .when(organizationController.updateOrganization(organizationFullModel))
                .thenReturn(responseCheckModel);

        //Validation of the test's results.
        HttpEntity<OrganizationFullModel> entity = new HttpEntity<>(organizationFullModel);
        ResponseEntity<ResponseModel> responseModelOriginalResult = restTemplate.exchange("http://localhost:8585/api/organization/update", HttpMethod.PUT, entity, ResponseModel.class);
        Assert.assertEquals(responseCheckModel, responseModelOriginalResult.getBody());
    }

    @Test
    public void testOrganizationControllerCreateOrganization(){
        //Preparing the input and output data.
        OrganizationCreatingModel orgCreatingModel = new OrganizationCreatingModel.Builder().name("testVK").fullName("VK").inn("1111111").kpp("1111111").address("ул. 8-го марта").phone("84959999").isActive(true).build();
        ResponseModel responseModel = new ResponseModel.Builder().result("success").build();

        //The when & then elements of the Mock test.
        Mockito
                .when(organizationController.createOrganization(orgCreatingModel))
                .thenReturn(responseModel);

        //Validation of the test's results.
        ResponseEntity<ResponseModel> responseModelOriginalResult = restTemplate.postForEntity("http://localhost:8585/api/organization/save", orgCreatingModel, ResponseModel.class);
        Assert.assertEquals(responseModel, responseModelOriginalResult.getBody());
    }
}
