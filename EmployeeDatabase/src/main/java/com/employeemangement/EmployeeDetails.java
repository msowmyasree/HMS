package com.employeemangement;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class EmployeeDetails {
	   
		@Id
	    @GeneratedValue
		private long id;
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		private String name;
		private String department;
		private double salary;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public EmployeeDetails(long id, String name, String department,double salary) {
			super();
			this.id = id;
			this.name = name;
			this.department = department;
			this.salary=salary;
		}
		public EmployeeDetails() {
			super();
		}
		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", department=" + department + ",salary="+ salary+ "]";
		}
		
		 @Override
			public int hashCode() {
				return Objects.hash(department, id, name,salary);
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				EmployeeDetails other = (EmployeeDetails) obj;
				return Objects.equals(department, other.department) && id == other.id && Objects.equals(name, other.name);
			}
			
			
			
		
		

	}



