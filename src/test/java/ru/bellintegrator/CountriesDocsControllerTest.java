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
import org.springframework.web.client.RestTemplate;
import ru.bellintegrator.thefirstproject.controller.CountriesDocsController;
import ru.bellintegrator.thefirstproject.controller.UserController;
import ru.bellintegrator.thefirstproject.domain.model.CountriesDocsBaseModel;
import ru.bellintegrator.thefirstproject.domain.model.user.UserBaseModel;
import ru.bellintegrator.thefirstproject.domain.model.user.UserRequestModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CountriesDocsControllerTest {
    @Mock
    CountriesDocsController counriesDocsController;

    @InjectMocks
    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testCountriesDocsControllerGetCountriesList() throws IOException {
        //Preparing the input and output data.

        List<CountriesDocsBaseModel> countriesDocsBaseModelList = new ArrayList<>();
        countriesDocsBaseModelList.add(new CountriesDocsBaseModel.Builder().id(1L).code("643").name("Российская Федерация").build());

        //The when & then elements of the Mock test.
        Mockito
                .when(counriesDocsController.getCountriesList())
                .thenReturn(countriesDocsBaseModelList);

        //Validation of the test's results.

        CountriesDocsBaseModel[] countries = restTemplate.getForObject("http://localhost:8585/api/countries", CountriesDocsBaseModel[].class);


        Assert.assertEquals(countriesDocsBaseModelList.get(0).getId(), countries[0].getId());
        Assert.assertEquals(countriesDocsBaseModelList.get(0).getCode(), countries[0].getCode());
        Assert.assertEquals(countriesDocsBaseModelList.get(0).getName(), countries[0].getName());

    }

    @Test
    public void testCountriesDocsControllerGetDocsList() throws IOException {
        //Preparing the input and output data.

        List<CountriesDocsBaseModel> countriesDocsBaseModelList = new ArrayList<>();
        countriesDocsBaseModelList.add(new CountriesDocsBaseModel.Builder().id(1L).code("21").name("Паспорт гражданина РФ").build());

        //The when & then elements of the Mock test.
        Mockito
                .when(counriesDocsController.getCountriesList())
                .thenReturn(countriesDocsBaseModelList);

        //Validation of the test's results.

        CountriesDocsBaseModel[] docs = restTemplate.getForObject("http://localhost:8585/api/docs", CountriesDocsBaseModel[].class);


        Assert.assertEquals(countriesDocsBaseModelList.get(0).getId(), docs[0].getId());
        Assert.assertEquals(countriesDocsBaseModelList.get(0).getCode(), docs[0].getCode());
        Assert.assertEquals(countriesDocsBaseModelList.get(0).getName(), docs[0].getName());

    }

}
