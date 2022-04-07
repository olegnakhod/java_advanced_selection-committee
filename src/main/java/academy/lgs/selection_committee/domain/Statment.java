package academy.lgs.selection_committee.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statmens")
public class Statment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer userId;
	private Integer facultyId;
	
	public Statment(Integer id, Integer userId, Integer facultyId) {
		this.id = id;
		this.userId = userId;
		this.facultyId = facultyId;
	}

	public Statment(Integer userId, Integer facultyId) {
		this.userId = userId;
		this.facultyId = facultyId;
	}

	public Statment() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(facultyId, id, userId);
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
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Statment [id=" + id + ", userId=" + userId + ", facultyId=" + facultyId + "]";
	}
	
	
	
}
