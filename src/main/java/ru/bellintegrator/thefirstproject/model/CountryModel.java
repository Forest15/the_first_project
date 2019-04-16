package ru.bellintegrator.thefirstproject.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CountryModel implements Serializable {
    @ApiModelProperty(notes = "County id", required = true)
    private Long countryId = 1l;
    @ApiModelProperty(notes = "County code", required = true)
    private Integer countryCode = 203;
    @ApiModelProperty(notes = "County name", required = true)
    private String countryName = "Russia";

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Integer getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
