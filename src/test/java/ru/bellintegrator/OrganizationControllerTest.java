package ru.bellintegrator;

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

import java.util.ArrayList;
import java.util.List;

//@RunWith(MockitoJUnitRunner.Silent.class)
public class OrganizationControllerTest {
    @Mock
    OrganizationController organizationController;

    @InjectMocks
    RestTemplate restTemplate = new RestTemplate();

   /* @Test
    public void testOrganizationControllerGetOrgList(){
        //Preparing the input and output data.
        OrganizationRequestModel organizationRequestModel = new OrganizationRequestModel.Builder().orgName("Beeline").inn("111111111111").isActive("1").build();
        List<OrganizationBaseModel> orgBaseModelList = new ArrayList<OrganizationBaseModel>();
        orgBaseModelList.add(new OrganizationBaseModel.Builder().id(1L).name("Beeline").isActive("1").build());
        orgBaseModelList.add(new OrganizationBaseModel.Builder().id(2L).name("MTS").isActive("1").build());
        orgBaseModelList.add(new OrganizationBaseModel.Builder().id(3L).name("Megafon").isActive("1").build());
       *//* OrganizationListModel orgListModel = new OrganizationListModel();
        orgListModel.setOrgListModel(orgBaseModelList);*//*

        //The when & then elements of the Mock test.
        Mockito
                .when(organizationController.getOrgList(organizationRequestModel))
                .thenReturn(orgBaseModelList);

        //Validation of the test's results.
        ResponseEntity<OrganizationListModel> organizationListModelOriginalResult = restTemplate.postForEntity("http://localhost:8585/api/organization/list", organizationRequestModel, OrganizationListModel.class);
        Assert.assertEquals(orgBaseModelList, organizationListModelOriginalResult.getBody());
    }

    @Test
    public void testOrganizationControllerGetOrgById(){
        //Preparing the input and output data.
        Long id = 1L;
        OrganizationFullModel organizationFullModel = new OrganizationFullModel.Builder().fullName("Vimpelcom").inn("111111111111").kpp("111111111").address("ул. 8-го марта").phone("84959999990").id(1L).name("Beeline").isActive("1").build();


        //The when & then elements of the Mock test.
        Mockito
                .when(organizationController.getOrgById(id))
                .thenReturn(organizationFullModel);

        //Validation of the test's results.
        ResponseEntity<OrganizationFullModel> organizationFullModelOriginalResult = restTemplate.getForEntity("http://localhost:8585/api/organization/" + id, OrganizationFullModel.class);
        Assert.assertEquals(organizationFullModel, organizationFullModelOriginalResult.getBody());

    }

    @Test
    public void testOrganizationControllerUpdateOrganization(){
        //Preparing the input and output data.
        OrganizationFullModel organizationFullModel = new OrganizationFullModel.Builder().fullName("Vimpelcom").inn("111111111111").kpp("111111111").address("ул. 8-го марта").phone("84959999990").id(1L).name("Beeline").isActive("1").build();
        ResponseModel responseModel = new ResponseModel.Builder().result("success").build();

        //The when & then elements of the Mock test.
        Mockito
                .when(organizationController.updateOrganization(organizationFullModel))
                .thenReturn(responseModel);

        //Validation of the test's results.
        HttpEntity<OrganizationFullModel> entity = new HttpEntity<>(organizationFullModel);
        ResponseEntity<ResponseModel> responseModelOriginalResult = restTemplate.exchange("http://localhost:8585/api/organization/update", HttpMethod.PUT, entity, ResponseModel.class);
        Assert.assertEquals(responseModel, responseModelOriginalResult.getBody());
    }

    @Test
    public void testOrganizationControllerCreateOrganization(){
        //Preparing the input and output data.
        OrganizationCreatingModel orgCreatingModel = new OrganizationCreatingModel.Builder().fullName("Vimpelcom").inn("111111111111").kpp("111111111").address("ул. 8-го марта").phone("84959999990").isActive("1").build();
        ResponseModel responseModel = new ResponseModel.Builder().result("success").build();

        //The when & then elements of the Mock test.
        Mockito
                .when(organizationController.createOrganization(orgCreatingModel))
                .thenReturn(responseModel);

        //Validation of the test's results.
        ResponseEntity<ResponseModel> responseModelOriginalResult = restTemplate.postForEntity("http://localhost:8585/api/organization/save", orgCreatingModel, ResponseModel.class);
        Assert.assertEquals(responseModel, responseModelOriginalResult.getBody());
    }*/
}
