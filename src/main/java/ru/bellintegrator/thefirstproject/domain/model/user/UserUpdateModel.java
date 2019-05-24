package ru.bellintegrator.thefirstproject.domain.model.user;

import io.swagger.annotations.ApiModelProperty;

public class UserUpdateModel {

        @ApiModelProperty(notes = "The id of the user", required = true)
        private Long id;
        @ApiModelProperty(notes = "The id of the office", required = false)
        private Long officeId;
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
        @ApiModelProperty(notes = "The user's country Id", required = false)
        private Long citizenshipId;
        @ApiModelProperty(notes = "Is user identified?", required = false)
        private Boolean isIdentified;

        public UserUpdateModel(UserUpdateModel.Builder builder){
            setId(builder.id);
            setOfficeId(builder.officeId);
            setFirstName(builder.firstName);
            setLastName(builder.lastName);
            setMiddleName(builder.middleName);
            setPosition(builder.position);
            setPhone(builder.phone);
            setCitizenshipId(builder.citizenshipId);
            setIsIdentified(builder.isIdentified);
        }

        public UserUpdateModel(){

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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Long getCitizenshipId() {
            return citizenshipId;
        }

        public void setCitizenshipId(Long citizenshipId) {
            this.citizenshipId = citizenshipId;
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

        public static class Builder{
            private Long id;
            private Long officeId;
            private String firstName;
            private String lastName;
            private String middleName;
            private String position;
            private String phone;
            private Long citizenshipId;
            private Boolean isIdentified;

            public Builder(){

            }

            public Builder id(Long id){
                this.id = id;
                return this;
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

            public Builder phone(String phone){
                this.phone = phone;
                return this;
            }

            public Builder isIdentified(Boolean isIdentified){
                this.isIdentified = isIdentified;
                return this;
            }

            public Builder citizenshipId(Long citizenshipId){
                this.citizenshipId = citizenshipId;
                return this;
            }

            public UserUpdateModel build(){
                return new UserUpdateModel(this);
            }
        }
    }
