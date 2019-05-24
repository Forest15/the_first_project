package ru.bellintegrator.thefirstproject.domain.model.user;

import io.swagger.annotations.ApiModelProperty;
import ru.bellintegrator.thefirstproject.domain.model.userDoc.UserDocBaseModel;

import java.io.Serializable;
import java.util.List;

public class UserFullModel implements Serializable {
    @ApiModelProperty(notes = "The id of the user", required = true)
    private Long id;
    @ApiModelProperty(notes = "The first name of the user.", required = true)
    private String firstName;
    @ApiModelProperty(notes = "The last name of the user.", required = false)
    private String lastName;
    @ApiModelProperty(notes = "The middle name of the user.", required = false)
    private String middleName;
    @ApiModelProperty(notes = "The user position", required = true)
    private String position;
    @ApiModelProperty(notes = "The user's phone", required = false)
    private String phone;
    @ApiModelProperty(notes = "The user's documents list", required = false)
    private List<UserDocBaseModel> userDocBaseModelList;
    @ApiModelProperty(notes = "The user's country name", required = false)
    private String citizenshipName;
    @ApiModelProperty(notes = "The user's country code", required = false)
    private String citizenshipCode;
    @ApiModelProperty(notes = "Is user identified?", required = false)
    private Boolean isIdentified;

    public UserFullModel(UserFullModel.Builder builder){
        setId(builder.id);
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setMiddleName(builder.middleName);
        setPosition(builder.position);
        setPhone(builder.phone);
        setUserDocBaseModelList(builder.userDocBaseModelList);
        setCitizenshipName(builder.citizenshipName);
        setCitizenshipCode(builder.citizenshipCode);
        setIsIdentified(builder.isIdentified);
    }

    public UserFullModel(){

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(String citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    public Boolean getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(Boolean isIdentified) {
        this.isIdentified = isIdentified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<UserDocBaseModel> getUserDocBaseModelList() {
        return userDocBaseModelList;
    }

    public void setUserDocBaseModelList(List<UserDocBaseModel> userDocBaseModelList) {
        this.userDocBaseModelList = userDocBaseModelList;
    }

    public static class Builder{
        private Long id;
        private String firstName;
        private String lastName;
        private String middleName;
        private String position;
        private String phone;
        private List<UserDocBaseModel> userDocBaseModelList;
        private String citizenshipName;
        private String citizenshipCode;
        private Boolean isIdentified;

        public Builder(){

        }

        public Builder id(Long id){
            this.id = id;
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

        public Builder phone(String phone){
            this.phone = phone;
            return this;
        }

        public Builder isIdentified(Boolean isIdentified){
            this.isIdentified = isIdentified;
            return this;
        }

        public Builder userDocBaseModelList(List<UserDocBaseModel> userDocBaseModelList){
            this.userDocBaseModelList = userDocBaseModelList;
            return this;
        }

        public Builder citizenshipName(String citizenshipName){
            this.citizenshipName = citizenshipName;
            return this;
        }

        public Builder citizenshipCode(String citizenshipCode){
            this.citizenshipCode = citizenshipCode;
            return this;
        }

        public UserFullModel build(){
            return new UserFullModel(this);
        }
    }
}
