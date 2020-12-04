package com.bookapp.model.entities;

import java.util.*;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_table")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer uid;
	private String uname;
	private String password;
	
	@Column(name="role")
	@CollectionTable(name="roles")
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> roles = new ArrayList<>();
	private String phoneno;
	private String address;
	private String email;
	
	public User() {}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(Integer uid, String uname, String password, List<String> roles, String phoneno, String address,
			String email) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.roles = roles;
		this.phoneno = phoneno;
		this.address = address;
		this.email = email;
	}
	public User(String uname, String password, List<String> roles, String phoneno, String address, String email) {
		super();
		this.uname = uname;
		this.password = password;
		this.roles = roles;
		this.phoneno = phoneno;
		this.address = address;
		this.email = email;
	}

}
