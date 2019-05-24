package ru.bellintegrator.thefirstproject.domain.model.userDoc;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.deser.DateTimeDeserializer;
import com.fasterxml.jackson.datatype.joda.ser.DateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

public class UserDocBaseModel implements Serializable {
    @ApiModelProperty(notes = "The id of the document's type.", required = false)
    private Long docTypeId;
    @ApiModelProperty(notes = "The id of the document's name.", required = false)
    private String docName;
    @ApiModelProperty(notes = "The serial number of the user's ducument.", required = false)
    private String serNum;
    @ApiModelProperty(notes = "The department who issued the user's ducument.", required = false)
    private String whoIssued;
    @ApiModelProperty(notes = "The code of the department who issued the user's ducument.", required = false)
    private String depCode;
    @ApiModelProperty(notes = "The date when the user's ducument have been receipted.", required = false)
/*    @JsonSerialize(using = DateTimeSerializer.class)
    @JsonDeserialize(using = DateTimeDeserializer.class)*/
    private Date docDate;
    @ApiModelProperty(notes = "Is the user's ducument general.", required = false)
    private Boolean isGeneral;

    public UserDocBaseModel(UserDocBaseModel.Builder builder){
        setDocTypeId(builder.docTypeId);
        setDocName(builder.docName);
        setSerNum(builder.serNum);
        setWhoIssued(builder.whoIssued);
        setDepCode(builder.depCode);
        setDocDate(builder.docDate);
        setIsGeneral(builder.isGeneral);
    }

    public UserDocBaseModel(){

    }

    public Long getDocTypeId() {
        return docTypeId;
    }

    public void setDocTypeId(Long docTypeId) {
        this.docTypeId = docTypeId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getSerNum() {
        return serNum;
    }

    public void setSerNum(String serNum) {
        this.serNum = serNum;
    }

    public String getWhoIssued() {
        return whoIssued;
    }

    public void setWhoIssued(String whoIssued) {
        this.whoIssued = whoIssued;
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public Boolean getIsGeneral() {
        return isGeneral;
    }

    public void setIsGeneral(Boolean isGeneral) {
        this.isGeneral = isGeneral;
    }

    public static class Builder{
        private Long docTypeId;
        private String docName;
        private String serNum;
        private String whoIssued;
        private String depCode;
        private Date docDate;
        private Boolean isGeneral;

        public Builder(){

        }

        public Builder docTypeId(Long docTypeId){
            this.docTypeId = docTypeId;
            return this;
        }

        public Builder docName(String docName){
            this.docName = docName;
            return this;
        }

        public Builder serNum(String serNum){
            this.serNum = serNum;
            return this;
        }

        public Builder whoIssued(String whoIssued){
            this.whoIssued = whoIssued;
            return this;
        }

        public Builder depCode(String depCode){
            this.depCode = depCode;
            return this;
        }

        public Builder docDate(Date docDate){
            this.docDate = docDate;
            return this;
        }

        public Builder isGeneral(Boolean isGeneral){
            this.isGeneral = isGeneral;
            return this;
        }

        public UserDocBaseModel build(){
            return new UserDocBaseModel(this);
        }
    }
}
