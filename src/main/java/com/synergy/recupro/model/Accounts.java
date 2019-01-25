package com.synergy.recupro.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.synergy.recupro.model.audit.UserDateAudit;


@Entity
@Table(name="accounts")
public class Accounts extends UserDateAudit {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "accounts_generator")    
	@TableGenerator(
	  name = "accounts_generator",
	  table = "id_gen",
	  pkColumnName = "gen_name",
	  valueColumnName = "gen_val",
	  initialValue = 1000,
	  allocationSize = 10)
	private Long id;
   
	//Client Information
    @Column(columnDefinition = "text")
    @Size(min = 3, max = 25)
    private String name;

    @Column(columnDefinition = "text")
    @Size(min = 3, max = 15)
    private String access;
    
    @Column(columnDefinition = "text")
    @Size(min = 3, max = 35)
    private String accountOwner;
    
    @Column(columnDefinition = "text")
    @Size(max = 25)
    private String category;
    
    @Column(columnDefinition = "text")
    @Size(max=25)
    private String websiteAddress;
    
    @Column(columnDefinition = "text")
    @Size(max=25)
    private String status; 
    
    @Column(columnDefinition = "text")
    @Size(max=25)
    private String accountCode; 
    
    
    //Address Information
    @Column(columnDefinition = "text")
    @Size(max=10)
    private String phoneNumber1;
    
    @Column(columnDefinition = "text")
    @Size(max=10)
    private String phoneNumber2;
    
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
    private String street;
    
    @Column(columnDefinition = "int")
    private int zipCode;
    
    @Column(columnDefinition = "int")
    private int fax;
    
    @Email
    @Column(columnDefinition = "text")
    private String email1;

    @Email
    @Column(columnDefinition = "text")
    private String email2;
    
    @Column(columnDefinition = "text")
    @Size(min = 10, max = 1000)
    private String description;
    
    @JoinTable(name = "accounts_requirements", 
    		joinColumns={@JoinColumn(name="accounts_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="requirements_id", referencedColumnName="id")})
    @OneToMany(cascade = { CascadeType.ALL })
    @JsonIgnoreProperties("requirements")
    private List<Requirements> requirements;


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

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getWebsiteAddress() {
		return websiteAddress;
	}

	public void setWebsiteAddress(String websiteAddress) {
		this.websiteAddress = websiteAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getFax() {
		return fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Requirements> getRequirements() {
		return requirements;
	}

	public void setRequirements(List<Requirements> requirements) {
		this.requirements = requirements;
	}
}