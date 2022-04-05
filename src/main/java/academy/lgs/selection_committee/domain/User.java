package academy.lgs.selection_committee.domain;

import java.util.Objects;

public class User {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	private UserRole userRole;
	private Integer certificateId;
	
	public User(Integer id, String firstName, String lastName, Integer age, UserRole userRole) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.userRole = userRole;
	}

	public User(String firstName, String lastName, Integer age, UserRole userRole) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.userRole = userRole;
	}

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public Integer getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(Integer certificateId) {
		this.certificateId = certificateId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, firstName, id, lastName, userRole);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(age, other.age) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& userRole == other.userRole;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", userRole="
				+ userRole + "]";
	}	

}
