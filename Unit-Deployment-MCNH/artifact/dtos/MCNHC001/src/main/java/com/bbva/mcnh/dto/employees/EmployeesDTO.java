package com.bbva.mcnh.dto.employees;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The EmployeesDTO class...
 */
public class EmployeesDTO implements Serializable  {
	private static final long serialVersionUID = 2931699728946643245L;

	/* Attributes section for the DTO */
	private int employeeNumber;
	private String employeeName;
	private String employeeDepartament;
	private String employeeRfc;
	private String employeeEmail;
	private String employeePhone;
	private String employeeAddress;
	private Date employeeRegistrationDate;
	private int employeeStatus;
	private int salary;
	
	
	

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDepartament() {
		return employeeDepartament;
	}

	public void setEmployeeDepartament(String employeeDepartament) {
		this.employeeDepartament = employeeDepartament;
	}

	public String getEmployeeRfc() {
		return employeeRfc;
	}

	public void setEmployeeRfc(String employeeRfc) {
		this.employeeRfc = employeeRfc;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public Date getEmployeeRegistrationDate() {
		return employeeRegistrationDate;
	}

	public void setEmployeeRegistrationDate(Date employeeRegistrationDate) {
		this.employeeRegistrationDate = employeeRegistrationDate;
	}

	public int getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(int employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	

	/**
	 * Indicates whether some other object is "equal to" this one.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		final EmployeesDTO rhs = (EmployeesDTO) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj))
					.append(employeeNumber, rhs.employeeNumber)
					.append(employeeName, rhs.employeeName)
					.append(employeeDepartament, rhs.employeeDepartament)
					.append(employeeRfc, rhs.employeeRfc)
					.append(employeeEmail, rhs.employeeEmail)
					.append(employeePhone, rhs.employeePhone)
					.append(employeeAddress, rhs.employeeAddress)
					.append(employeeRegistrationDate, rhs.employeeRegistrationDate)
					.append(employeeStatus, rhs.employeeStatus)
					.append(salary, rhs.salary)
					.isEquals();
	}

	/**
	 * Returns a hash code value for the object.
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(this.employeeNumber)
			.append(this.employeeName)
			.append(this.employeeDepartament)
			.append(this.employeeRfc)
			.append(this.employeeEmail)
			.append(this.employeePhone)
			.append(this.employeeAddress)
			.append(this.employeeRegistrationDate)
			.append(this.employeeStatus)
			.append(this.salary)
			.toHashCode();
	}

	/**
	 * Returns a string representation of the object.
	 * It is important to OBFUSCATE the attributes that are sensitive to show in the representation.
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("employeeNumber", employeeNumber)
			.append("employeeName", employeeName)
			.append("employeeDepartament", employeeDepartament)
			.append("employeeRfc", employeeRfc)
			.append("employeeEmail", employeeEmail)
			.append("employeePhone", employeePhone)
			.append("employeeAddress", employeeAddress)
			.append("employeeRegistrationDate", employeeRegistrationDate)
			.append("employeeStatus", employeeStatus)
			.append("salary", salary)
			.toString();
	}
}
