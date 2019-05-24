package ru.bellintegrator.thefirstproject.domain.model.user;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UserRequestModel implements Serializable {
    @ApiModelProperty(notes = "The id of the office", required = true)
    private Long officeId;
    @ApiModelProperty(notes = "The first name of the user.", required = false)
    private String firstName;
    @ApiModelProperty(notes = "The last name of the user.", required = false)
    private String lastName;
    @ApiModelProperty(notes = "The middle name of the user.", required = false)
    private String middleName;
    @ApiModelProperty(notes = "The user position", required = false)
    private String position;
    @ApiModelProperty(notes = "The user's country code", required = false)
    private String citizenshipCode;

    public UserRequestModel(UserRequestModel.Builder builder){
        setOfficeId(builder.officeId);
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setMiddleName(builder.middleName);
        setPosition(builder.position);
        setCitizenshipCode(builder.citizenshipCode);
    }

    public UserRequestModel(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(String citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public static class Builder{
        private Long officeId;
        private String firstName;
        private String lastName;
        private String middleName;
        private String position;
        private String citizenshipCode;

        public Builder(){

        }

        public Builder officeId(Long officeId){
            this.officeId = officeId;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder middleName(String middleName){
            this.middleName = middleName;
            return this;
        }

        public Builder position(String position){
            this.position = position;
            return this;
        }

        public Builder citizenshipCode(String citizenshipCode){
            this.citizenshipCode = citizenshipCode;
            return this;
        }

        public UserRequestModel build(){
            return new UserRequestModel(this);
        }
    }

}
