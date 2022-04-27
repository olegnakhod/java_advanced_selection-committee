package academy.lgs.selection_committee.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "statments")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Statment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer statment_id;
	
	@ManyToOne
	@JoinColumn(name = "user_fk_id",nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "faculty_fk_id",nullable = false)
	private Faculty faculty;

	public Statment(Integer id, User user, Faculty faculty) {
		this.statment_id = id;
		this.user = user;
		this.faculty = faculty;
	}

	public Statment(User user, Faculty faculty) {
		this.user = user;
		this.faculty = faculty;
	}

	public Statment() {
	}

	public Integer getId() {
		return statment_id;
	}

	public void setId(Integer id) {
		this.statment_id = id;
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
		return Objects.hash(faculty, statment_id, user);
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
		return Objects.equals(faculty, other.faculty) && Objects.equals(statment_id, other.statment_id)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "UsersInFaculty [id=" + statment_id + ", user=" + user + ", faculty=" + faculty + "]";
	}

}
