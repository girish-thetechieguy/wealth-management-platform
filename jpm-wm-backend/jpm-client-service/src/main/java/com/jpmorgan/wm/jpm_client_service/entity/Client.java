package com.jpmorgan.wm.jpm_client_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq_generator")
    @SequenceGenerator(name = "client_seq_generator", sequenceName = "client_schema.client_id_seq", allocationSize = 1)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String city;


    @Column
    private String country;

    @Column
    private String phone;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String company;

    @Column
    private Boolean isVarified;

    @Column
    private Boolean requestRetirement;

    @Column
    private Boolean grantRetirementAccess;

    @Column
    private Boolean requestEducation;

    @Column
    private Boolean grantEducationAccess;

    @Column
    private Boolean requestWealthMgmt;

    @Column
    private Boolean grantWealthMgmt;

    @Column
    private String wealthInverstType;

    @Column
    private Date createdAt;

    @Column
    private String createdBy;

    @Column
    private Date updatedAt;

    @Column
    private String updatedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
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
