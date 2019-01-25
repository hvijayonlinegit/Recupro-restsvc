package com.synergy.recupro.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.synergy.recupro.model.audit.UserDateAudit;

/** An entity that stores file meta data into database */
@Entity
@Table(name = "documents")
public class Document extends UserDateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "documents_generator")    
	@TableGenerator(
	  name = "documents_generator",
	  table = "id_gen",
	  pkColumnName = "gen_name",
	  valueColumnName = "gen_val",
	  initialValue = 1000,
	  allocationSize = 10)
	private Long id;
	@JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
	
	@JoinColumn(name = "candidateid", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	   @JsonIgnoreProperties("candidate")
	private Candidate candidate;
	
	@Column(name = "documentname")
	private String documentName;

	@Column(name = "documenttype")
	private String documentType;

	@Column(name = "documentsize")
	private long documentSize;
// Adding new fields for 01/23/2019
	@Column(columnDefinition ="DATE" )
    private Date issueDate;
	
	@Column(columnDefinition ="DATE" )
    private Date expiryDate;
	
	@Column(columnDefinition ="text" )
    private String notes;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public long getDocumentSize() {
		return documentSize;
	}

	public void setDocumentSize(long documentSize) {
		this.documentSize = documentSize;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", candidate=" + candidate
				+ ", documentName=" + documentName + ", documentType="
				+ documentType + ", documentSize=" + documentSize + ", docIssueDate="
						+ issueDate + ", docExpiryDate="
								+ expiryDate + ", notes="
										+ notes +"]";
	}



}
