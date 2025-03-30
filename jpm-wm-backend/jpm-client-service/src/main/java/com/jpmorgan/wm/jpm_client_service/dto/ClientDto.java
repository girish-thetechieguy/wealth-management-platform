package com.jpmorgan.wm.jpm_client_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

public class ClientDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String country;
    private String phone;
    private String username;
    private String password;
    private String company;
    private Boolean isVarified;
    private Boolean requestRetirement;
    private Boolean grantRetirementAccess;
    private Boolean requestEducation;
    private Boolean grantEducationAccess;
    private Boolean requestWealthMgmt;
    private Boolean grantWealthMgmt;
    private String wealthInverstType;
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public @NotNull String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName) {
        this.lastName = lastName;
    }

    public @NotNull String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public @NotNull String getCountry() {
        return country;
    }

    public void setCountry( String country) {
        this.country = country;
    }

    public @NotNull String getPhone() {
        return phone;
    }

    public void setPhone( String phone) {
        this.phone = phone;
    }

    public @NotNull String getUsername() {
        return username;
    }

    public void setUsername( String username) {
        this.username = username;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword( String password) {
        this.password = password;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Boolean getVarified() {
        return isVarified;
    }

    public void setVarified(Boolean varified) {
        isVarified = varified;
    }

    public Boolean getRequestRetirement() {
        return requestRetirement;
    }

    public void setRequestRetirement(Boolean requestRetirement) {
        this.requestRetirement = requestRetirement;
    }

    public Boolean getGrantRetirementAccess() {
        return grantRetirementAccess;
    }

    public void setGrantRetirementAccess(Boolean grantRetirementAccess) {
        this.grantRetirementAccess = grantRetirementAccess;
    }

    public Boolean getRequestEducation() {
        return requestEducation;
    }

    public void setRequestEducation(Boolean requestEducation) {
        this.requestEducation = requestEducation;
    }

    public Boolean getGrantEducationAccess() {
        return grantEducationAccess;
    }

    public void setGrantEducationAccess(Boolean grantEducationAccess) {
        this.grantEducationAccess = grantEducationAccess;
    }

    public Boolean getRequestWealthMgmt() {
        return requestWealthMgmt;
    }

    public void setRequestWealthMgmt(Boolean requestWealthMgmt) {
        this.requestWealthMgmt = requestWealthMgmt;
    }

    public Boolean getGrantWealthMgmt() {
        return grantWealthMgmt;
    }

    public void setGrantWealthMgmt(Boolean grantWealthMgmt) {
        this.grantWealthMgmt = grantWealthMgmt;
    }

    public String getWealthInverstType() {
        return wealthInverstType;
    }

    public void setWealthInverstType(String wealthInverstType) {
        this.wealthInverstType = wealthInverstType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
