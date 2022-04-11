package academy.lgs.selection_committee.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "candidates_in_faculty")
public class FacultyIncludCandidates {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "facultyr_id", referencedColumnName = "id")
	private Faculty faculty;

	public FacultyIncludCandidates(Integer id, User user, Faculty faculty) {
		this.id = id;
		this.user = user;
		this.faculty = faculty;
	}

	public FacultyIncludCandidates(User user, Faculty faculty) {
		this.user = user;
		this.faculty = faculty;
	}

	public FacultyIncludCandidates() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	@Override
	public int hashCode() {
		return Objects.hash(faculty, id, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacultyIncludCandidates other = (FacultyIncludCandidates) obj;
		return Objects.equals(faculty, other.faculty) && Objects.equals(id, other.id)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "UsersInFaculty [id=" + id + ", user=" + user + ", faculty=" + faculty + "]";
	}

}
