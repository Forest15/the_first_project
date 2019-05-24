package ru.bellintegrator.thefirstproject.domain.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CountriesDocsBaseModel implements Serializable {
    @ApiModelProperty(notes = "The id of document or country", required = true)
    private Long id;
    @ApiModelProperty(notes = "The firstName of document or country", required = true)
    private String name;
    @ApiModelProperty(notes = "The code of document or country", required = true)
    private String code;

    public CountriesDocsBaseModel() {
    }

    public CountriesDocsBaseModel(CountriesDocsBaseModel.Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setCode(builder.code);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class Builder{
        private Long id;
        private String name;
        private String code;

        public Builder(){

        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder code(String code){
            this.code = code;
            return this;
        }

        public CountriesDocsBaseModel build(){
            return new CountriesDocsBaseModel(this);
        }
    }
}
