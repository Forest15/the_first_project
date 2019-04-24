package ru.bellintegrator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.bellintegrator.thefirstproject.controller.OfficeController;
import ru.bellintegrator.thefirstproject.model.office.OfficeBaseModel;
import ru.bellintegrator.thefirstproject.model.office.OfficeListModel;
import ru.bellintegrator.thefirstproject.model.office.OfficeRequestModel;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
public class OfficeControllerTest {
    @Mock
    OfficeController officeController;

    @InjectMocks
    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testOfficeControllerGetOfficeList(){
        //Preparing the input and output data.
        OfficeRequestModel officeRequestModel = new OfficeRequestModel.Builder().orgId(1L).name("BeelineTechOffice").isActive("1").phone("+79154351050").build();
        List<OfficeBaseModel> officeBaseModelList = new ArrayList<OfficeBaseModel>();
        officeBaseModelList.add(new OfficeBaseModel.Builder().id(1L).name("BeelineTechOffice").isActive("1").build());
        officeBaseModelList.add(new OfficeBaseModel.Builder().id(2L).name("BeelineSalesOffice").isActive("1").build());
        OfficeListModel officeListModel = new OfficeListModel();
        officeListModel.setOfficeBaseModelList(officeBaseModelList);

        //The when & then elements of the Mock test.
        Mockito
            .when(officeController.getOfficeList(officeRequestModel))
                .thenReturn(officeListModel);

        //Validation of the test's results.
        ResponseEntity<OfficeListModel> officeListModelOriginalResult = restTemplate.postForEntity("http://localhost:8585/api/office/list", officeRequestModel, OfficeListModel.class);
        Assert.assertEquals(officeListModel, officeListModelOriginalResult.getBody());
    }
}
