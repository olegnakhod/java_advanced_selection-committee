package academy.lgs.selection_committee.domain;

import java.util.Objects;
import java.util.Set;

public class Statment {
	
	private Integer id;
	private Set<User> users;
	private Integer facultyId;
	
	public Statment(Integer id, Set<User> users, Integer facultyId) {
		this.id = id;
		this.users = users;
		this.facultyId = facultyId;
	}

	public Statment(Set<User> users, Integer facultyId) {
		this.users = users;
		this.facultyId = facultyId;
	}

	public Statment() {
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Integer getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(facultyId, id, users);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Statment other = (Statment) obj;
		return Objects.equals(facultyId, other.facultyId) && Objects.equals(id, other.id)
				&& Objects.equals(users, other.users);
	}

	@Override
	public String toString() {
		return "Statment [id=" + id + ", users=" + users + ", facultyId=" + facultyId + "]";
	}	
	
}
