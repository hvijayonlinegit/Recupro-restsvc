package com.synergy.recupro.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employee")
public class Employee extends Contact {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "employees_generator")    
	@TableGenerator(
	  name = "employees_generator",
	  table = "id_gen",
	  pkColumnName = "gen_name",
	  valueColumnName = "gen_val",
	  initialValue = 1000,
	  allocationSize = 10)
      private Long employeeId;
    
   @Column(columnDefinition ="DATE" )
    private Date dateOfJoining;
   @Column(columnDefinition ="DATE" )
    private Date dateOfResign;
    @Column(columnDefinition = "text" )
    private String licenseNumber;
	
    @Column(columnDefinition = "text")
    private String passportNumber;
    
    @Column(columnDefinition = "text" )
    private String visaStatus;
    
    @Column(columnDefinition = "text" )
    private int dateOfBirth;
    
    
    
    @Column(columnDefinition = "text")
    private String gender;
    
    @Column(columnDefinition = "text")
    private String fatherName;
    
    @Column(columnDefinition = "text" )
    private String motherName;
    
    @Column(columnDefinition = "text" )
    private String nationality;
    
    
 
//    @OneToMany(cascade = {CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE}, mappedBy="employee")
//    @JsonIgnoreProperties("employee")
//    private List<Document> document;

		
	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getVisaStatus() {
		return visaStatus;
	}

	public void setVisaStatus(String visaStatus) {
		this.visaStatus = visaStatus;
	}

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Date getDateOfJoineing() {
		return dateOfJoining;
	}

	public void setDateOfJoineing(Date dateOfJoineing) {
		this.dateOfJoining = dateOfJoineing;
	}

	public Date getDateOfResign() {
		return dateOfResign;
	}

	public void setDateOfResign(Date dateOfResign) {
		this.dateOfResign = dateOfResign;
	}

	
}
