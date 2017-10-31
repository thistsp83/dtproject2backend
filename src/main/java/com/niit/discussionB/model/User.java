package com.niit.discussionB.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class User extends BaseDomain
{
	@Id
	private String username;
	private String f_name;
	private String l_name;
	private char gender;
	private String password;
	private char status;
	private char isOnline;
	private String mail;
	private String role;
	private String last_seen;
	public User(String username, String f_name, String l_name, char gender, String password, char status,
			char isOnline, String mail, String role, String last_seen) {
		super();
		this.username = username;
		this.f_name = f_name;
		this.l_name = l_name;
		this.gender = gender;
		this.password = password;
		this.status = status;
		this.isOnline = isOnline;
		this.mail = mail;
		this.role = role;
		this.last_seen = last_seen;
	}
	public User() {
		super();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public char getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(char isOnline) {
		this.isOnline = isOnline;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLast_seen() {
		return last_seen;
	}
	public void setLast_seen(String last_seen) {
		this.last_seen = last_seen;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", f_name=" + f_name + ", l_name=" + l_name + ", gender="
				+ gender + ", password=" + password + ", status=" + status + ", isOnline=" + isOnline + ", mail=" + mail
				+ ", role=" + role + ", last_seen=" + last_seen + "]";
	}
	
	
	
	
	
	

}
