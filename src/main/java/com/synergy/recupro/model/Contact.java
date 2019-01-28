package com.synergy.recupro.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.synergy.recupro.model.audit.UserDateAudit;


@MappedSuperclass
@JsonIgnoreProperties(
        value = {"createdBy", "updatedBy"},
        allowGetters = true
)
public abstract class Contact extends UserDateAudit {

	@Column(columnDefinition = "text")
	private String firstName;

	@Column(columnDefinition = "text")
	private String middleName;
	
	@Column(columnDefinition = "text")
	private String lastName;
	
	@Column(columnDefinition = "text")
	private String emailAddress;
	
	@Column(columnDefinition = "text")
	private String mobileNumber;

	@Column(columnDefinition = "text")
	private String phoneNumber;
	
	@Column(columnDefinition = "text")
    @Size(max = 75)
    private String country;
    
    @Column(columnDefinition = "text")
    @Size(max = 75)
    private String state;
    
    @Column(columnDefinition = "text")
    @Size(max = 75)
    private String city;
   
    @Column(columnDefinition = "text")
    @Size(max = 75)
    private String address;
    
    @Column(columnDefinition = "int")
    private int zipCode;
    
    @Column(columnDefinition = "text")
    @Size(max = 75)
    private String skypeId;
    
    @Column(columnDefinition = "text")
    @Size(max = 75)
    private String twitterId;
    
    @Column(columnDefinition = "text")
	private String linkedinUrl;
    
    @Column(columnDefinition = "text")
    @Size(max = 75)
    private String status;
    
    @Column(columnDefinition = "text")
    @Size(max = 75)
    private String access;
    
    @Column(columnDefinition = "text")
    @Size(max = 75)
    private String role;
    
    @Column(columnDefinition = "int" )
    private int fax;	 
    
    @Column(columnDefinition = "text" )
    private String clientName;
    
    
    @Column(columnDefinition = "text" )
    private String notes;
    
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public String getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}

	public String getLinkedinUrl() {
		return linkedinUrl;
	}

	public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getFax() {
		return fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}	 
    
    
}
// class Contact