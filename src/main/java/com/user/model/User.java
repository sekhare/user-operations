package com.user.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "userDetails")
@Table(name = "users")
public class User implements  Serializable {

	

	private String name;



	@Id
	private String email;
	private String password;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date lastLoginDate;
	public String getName() {
		return name;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password="
				+ password + ", lastLoginDate=" + lastLoginDate + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getLastLoginDate() {
		return lastLoginDate;
	}


	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}


	
	
	
}
