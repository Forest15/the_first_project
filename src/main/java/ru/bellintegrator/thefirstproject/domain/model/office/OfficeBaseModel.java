package ru.bellintegrator.thefirstproject.domain.model.office;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OfficeBaseModel implements Serializable {
    @ApiModelProperty(notes = "The id of the office.", required = false)
    private Long id;
    @ApiModelProperty(notes = "The firstName of the office.", required = false)
    private String name;
    @ApiModelProperty(notes = "Is the office active?", required = false)
    private boolean isActive;

    public OfficeBaseModel(OfficeBaseModel.Builder builder){
        setId(builder.id);
        setName(builder.name);
        setIsActive(builder.isActive);
    }

    public OfficeBaseModel(){

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

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public static class Builder{
        private Long id;
        private String name;
        private boolean isActive;

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

        public Builder isActive(boolean isActive){
            this.isActive = isActive;
            return this;
        }

        public OfficeBaseModel build(){
            return new OfficeBaseModel(this);
        }
    }
}
