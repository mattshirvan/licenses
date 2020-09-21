package com.relationships.models;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="licenses")
public class License {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	private Integer number;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date expires;
	
	@Size(min=2, max=100)
	private String state;
	
	@Column(updatable=false)
	private Date created;
	private Date updated;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="person_id")
	private Person person;
	
	public License() {
		
	}
	
	public String getNumberAsString() {
		int numZeros = 7 - String.valueOf(this.number).length();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < numZeros; i++)
			sb.append('0');
		return String.format("%s%d", sb, this.number);
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getExpirationDateFormatted() {
		SimpleDateFormat fm = new SimpleDateFormat("MM/dd/yyyy");
		return fm.format(this.expires);
	}
	
	public Date getExpires() {
		return expires;
	}

	public void setExpires(Date expires) {
		this.expires = expires;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@PrePersist
	protected void onCreate() {
		this.created = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updated = new Date();
	}
}
