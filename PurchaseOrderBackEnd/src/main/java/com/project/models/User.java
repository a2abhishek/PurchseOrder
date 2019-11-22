package com.project.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue
	@Column(name="User_Id")
    private int UserId;
    
	@Column(name="User_Name")
    private String UserName;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Mobile_No")
    private long mobile;
	
	@Column(name="password")
    private String password;
	
	@Column(name="Address")
    private String address;
	
	@Column(name="Is_Active")
    private String isActive;
	
	@Column(name="created_by")
    private String createdBy;
	
	@Column(name="created_date")
    private LocalDate createdDate;
	
	@Column(name="updated_by")
    private String updatedBy;
	
	@Column(name="updated_date")
    private LocalDate updatedDate;
	
	@Column(name="role_name")
    private int roleName;

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int UserId) {
		this.UserId = UserId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getPass() {
		return password;
	}

	public void setPass(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddr(String address) {
		this.address = address;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getRoleId() {
		return roleName;
	}

	public void setRoleId(int roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", UserName=" + UserName + ", email=" + email + ", mobile=" + mobile
				+ ", pass=" + password + ", address=" + address + ", isActive=" + isActive + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", roleName=" + roleName + "]";
	} 
    
	
}
