package academy.lgs.selection_committee.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column
	private Integer age;
	@Column(unique = true)
	private String email;
	@Column
	private String password;
	@Column(name = "password_confirm")
	private String passwordConfirm;
	@Lob
	private String encodeImage;

	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	public User(User user) {
		this.id = user.id;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.age = user.age;
		this.email = user.email;
		this.password = user.password;
		this.passwordConfirm = user.passwordConfirm;
		this.encodeImage = user.encodeImage;
		this.userRole = user.userRole;
	}

	public User(Integer id, String firstName, String lastName, Integer age, String email, String password,
			String passwordConfirm, String encodeImage, UserRole userRole) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.encodeImage = encodeImage;
		this.userRole = userRole;
	}

	public User(String firstName, String lastName, Integer age, String email, String password, String passwordConfirm,
			String encodeImage, UserRole userRole) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.encodeImage = encodeImage;
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

	public String getEmail() {
		return email;
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

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	public String getEncodeImage() {
		return encodeImage;
	}

	public void setEncodeImage(String encodeImage) {
		this.encodeImage = encodeImage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, email, firstName, id, lastName, password, userRole);
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
		return Objects.equals(age, other.age) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& userRole == other.userRole;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", email="
				+ email + ", userRole=" + userRole + "]";
	}

}
