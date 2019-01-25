package com.synergy.recupro.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.synergy.recupro.model.audit.UserDateAudit;

@Entity
@Table(name = "requirements")
public class Requirements extends UserDateAudit {
	 
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "req_generator")    
	@TableGenerator(
	  name = "req_generator",
	  table = "id_gen",
	  pkColumnName = "gen_name",
	  valueColumnName = "gen_val",
	  initialValue = 1000,
	  allocationSize = 10)
	private Long id;
    
    
	@Column(columnDefinition = "text")
    private String requirementTitle;
    
    @Column(columnDefinition = "text" )
    private String accountOwner;
    
    @Column(columnDefinition = "text" )
    private String primaryRecruiteer;
    
    @Column(columnDefinition = "text" )
    private String access;
    
    @Column(columnDefinition = "text" )
    private String endClient;
    
    @Column(columnDefinition = "text" )
    private String requiredSkills;
    
    @Column(columnDefinition = "text" )
    private String requiredExperience;

    @Column(columnDefinition = "int" )
    private int billRate;

    @Column(columnDefinition = "text" )
    private String payRate;

    @Column(columnDefinition = "text" )
    private String country;

    @Column(columnDefinition = "text" )
    private String state;

    @Column(columnDefinition = "text" )
    private String city;

    @Column(columnDefinition = "text" )
    private String zipCode;

    @Column(columnDefinition = "int" )
    private int numberOfOpenings;

    @Column(columnDefinition = "int" )
    private int maxResumesAllowed;

    @Column(columnDefinition = "text" )
    private String localIndicator;

    @Column(columnDefinition = "text" )
    private String briefDescription;
    
    @Column(columnDefinition = "text" )
    private String description;
    
    @Column(columnDefinition = "text" )
    private String duration;
    
    @Column(columnDefinition = "text" )
    private String category;
    
    @Column(columnDefinition = "text" )
    private String subCategory;
    
    @Column(columnDefinition = "text" )
    private String employementType;
    
    @Column(columnDefinition = "text" )
    private String status;
    
    @Column(columnDefinition = "text" )
    private String experienceLevel;
    
    @Column(columnDefinition = "text" )
    private String posiitonType;
    
    @Column(columnDefinition = "text" )
    private String interviewType;
    
    @Column(columnDefinition = "text" )
    private String visaType;
    
    @Column(columnDefinition ="DATE" )
    private Date projectStartDate;

    @Column(columnDefinition ="DATE" )
    private Date projectEndDate;

    @Column(columnDefinition ="text" )
    private String notes;
     
//     //Added JsonBack reference to add the referemce of requirement to account repo via spring data rest api call
//    @JsonBackReference  
//    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
//    @JoinColumn(name = "accounts_id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @NotFound(
//            action = NotFoundAction.IGNORE)
//    @JsonIgnore
//    private Accounts accounts;
    @JsonBackReference (value="accounts-requirements")
    @JoinTable(name = "accounts_requirements", 
    		joinColumns={@JoinColumn(name="requirements_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="accounts_id", referencedColumnName="id")})
    @ManyToOne(cascade = { CascadeType.ALL })
    private Accounts accounts;


    
//    @ManyToMany(mappedBy="requirements")
//    @JsonIgnoreProperties("requirements")
//    private List<Candidate> candidates ;
    @JsonBackReference
    @JoinTable(name = "candidate_requirements", 
    		joinColumns={@JoinColumn(name="requirements_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="candidates_candidate_id", referencedColumnName="candidateId")})
    @ManyToMany
    @JsonIgnoreProperties("requirements")
    private List<Candidate> candidates = new ArrayList<Candidate>();

   

    public Long getRequirementId() {
		return id;
	}

	public void setRequirementId(Long requirementId) {
		this.id = requirementId;
	}

	public String getRequirementTitle() {
		return requirementTitle;
	}

	public void setRequirementTitle(String requirementTitle) {
		this.requirementTitle = requirementTitle;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public String getPrimaryRecruiteer() {
		return primaryRecruiteer;
	}

	public void setPrimaryRecruiteer(String primaryRecruiteer) {
		this.primaryRecruiteer = primaryRecruiteer;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getEndClient() {
		return endClient;
	}

	public void setEndClient(String endClient) {
		this.endClient = endClient;
	}

	public String getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(String requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

	public String getRequiredExperience() {
		return requiredExperience;
	}

	public void setRequiredExperience(String requiredExperience) {
		this.requiredExperience = requiredExperience;
	}

	public int getBillRate() {
		return billRate;
	}

	public void setBillRate(int billRate) {
		this.billRate = billRate;
	}

	public String getPayRate() {
		return payRate;
	}

	public void setPayRate(String payRate) {
		this.payRate = payRate;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getNumberOfOpenings() {
		return numberOfOpenings;
	}

	public void setNumberOfOpenings(int numberOfOpenings) {
		this.numberOfOpenings = numberOfOpenings;
	}

	public int getMaxResumesAllowed() {
		return maxResumesAllowed;
	}

	public void setMaxResumesAllowed(int maxResumesAllowed) {
		this.maxResumesAllowed = maxResumesAllowed;
	}

	public String getLocalIndicator() {
		return localIndicator;
	}

	public void setLocalIndicator(String localIndicator) {
		this.localIndicator = localIndicator;
	}

	public String getBriefDescription() {
		return briefDescription;
	}

	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getEmployementType() {
		return employementType;
	}

	public void setEmployementType(String employementType) {
		this.employementType = employementType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExperienceLevel() {
		return experienceLevel;
	}

	public void setExperienceLevel(String experienceLevel) {
		this.experienceLevel = experienceLevel;
	}

	public String getPosiitonType() {
		return posiitonType;
	}

	public void setPosiitonType(String posiitonType) {
		this.posiitonType = posiitonType;
	}

	public String getInterviewType() {
		return interviewType;
	}

	public void setInterviewType(String interviewType) {
		this.interviewType = interviewType;
	}

	public String getVisaType() {
		return visaType;
	}

	public void setVisaType(String visaType) {
		this.visaType = visaType;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Accounts getAccounts() {
		return accounts;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}



}