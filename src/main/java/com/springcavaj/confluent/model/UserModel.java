/**
 * 
 */
package com.springcavaj.confluent.model;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author springcavaj
 *
 */
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
	private String firstName;
	private String middleName;
	private String lastName;
	private String mobileNo;
	private String email;
	private String panNo;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, lastName, middleName, mobileNo, panNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		UserModel other = (UserModel) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(middleName, other.middleName)
				&& Objects.equals(mobileNo, other.mobileNo) && Objects.equals(panNo, other.panNo);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserModel [firstName=");
		builder.append(firstName);
		builder.append(", middleName=");
		builder.append(middleName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", mobileNo=");
		builder.append(mobileNo);
		builder.append(", email=");
		builder.append(email);
		builder.append(", panNo=");
		builder.append(panNo);
		builder.append("]");
		return builder.toString();
	}
}
