package com.synergy.recupro.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "candidate")
public class Candidate extends Contact {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "candidates_generator")    
	@TableGenerator(
	  name = "candidates_generator",
	  table = "id_gen",
	  pkColumnName = "gen_name",
	  valueColumnName = "gen_val",
	  initialValue = 1000,
	  allocationSize = 10)
      private Long candidateId;
    
    @Column(columnDefinition = "text")
    @Size(max = 75)
    private String preferredLocation1;
    
    @Column(columnDefinition = "text")
    @Size(max = 75)
    private String preferredLocation2;
	
	@Column(columnDefinition = "text")
	private String sourceFrom;
	
	@Column(columnDefinition = "text")
	private String sourceInfo;

	@Column(columnDefinition = "text")
	private String sourcing;

	@Column(columnDefinition = "text")
	private String sourceBy;
	
	@Column(columnDefinition = "text")
	private String availableFrom;
	
	@Column(columnDefinition = "text")
	private String noticePeriod;

      

    @Column(columnDefinition = "text" )
    private int licenseNumber;
	
    @Column(columnDefinition = "text")
    private int passportNumber;
    
    @Column(columnDefinition = "text" )
    private int visaStatus;
    
    @Column(columnDefinition = "text" )
    private int dateOfBirth;
    
    
    
    @Column(columnDefinition = "text")
    private int gender;
    
    @Column(columnDefinition = "text")
    private String fatherName;
    
    @Column(columnDefinition = "text" )
    private String motherName;
    
    @Column(columnDefinition = "text" )
    private String nationality;
    
    @Column(columnDefinition = "text" )
    private String hobbies;
    
    @Column(columnDefinition = "text" )
    private String maritalStatus;
 
//	@ManyToMany(cascade = { CascadeType.ALL })
////	@JoinTable
//	@JsonIgnoreProperties("candidates")
//	private List<Requirements> requirements = new ArrayList<Requirements>();
    @JoinTable(name = "candidate_requirements", 
    		joinColumns={@JoinColumn(name="candidates_candidate_id")},
            inverseJoinColumns={@JoinColumn(name="requirements_id")})
    @ManyToMany(cascade = { CascadeType.ALL })
    private List<Requirements> requirements = new ArrayList<Requirements>() ;

//	@JsonManagedReference
    //@JsonManagedReference
    @OneToMany(cascade = {CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE}, mappedBy="candidate")
    @JsonIgnoreProperties("candidate")
    private List<Document> document;

	
	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	

	public String getPreferredLocation1() {
		return preferredLocation1;
	}

	public void setPreferredLocation1(String preferredLocation1) {
		this.preferredLocation1 = preferredLocation1;
	}

	public String getPreferredLocation2() {
		return preferredLocation2;
	}

	public void setPreferredLocation2(String preferredLocation2) {
		this.preferredLocation2 = preferredLocation2;
	}
	public String getSourceFrom() {
		return sourceFrom;
	}

	public void setSourceFrom(String sourceFrom) {
		this.sourceFrom = sourceFrom;
	}

	public String getSourceInfo() {
		return sourceInfo;
	}

	public void setSourceInfo(String sourceInfo) {
		this.sourceInfo = sourceInfo;
	}

	public String getSourcing() {
		return sourcing;
	}

	public void setSourcing(String sourcing) {
		this.sourcing = sourcing;
	}

	public String getSourceBy() {
		return sourceBy;
	}

	public void setSourceBy(String sourceBy) {
		this.sourceBy = sourceBy;
	}

	public String getAvailableFrom() {
		return availableFrom;
	}

	public void setAvailableFrom(String availableFrom) {
		this.availableFrom = availableFrom;
	}

	public String getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	public int getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(int licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public int getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(int passportNumber) {
		this.passportNumber = passportNumber;
	}

	public int getVisaStatus() {
		return visaStatus;
	}

	public void setVisaStatus(int visaStatus) {
		this.visaStatus = visaStatus;
	}

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
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

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public List<Requirements> getRequirements() {
		return requirements;
	}

	public void setRequirements(List<Requirements> requirements) {
		this.requirements = requirements;
	}
}
