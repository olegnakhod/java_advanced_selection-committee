package academy.lgs.selection_committee.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "certificate")
public class Certificate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Subjects subject;
	private Grades grade;
	private Integer userId;

	public Certificate(Integer id, Subjects subject, Grades grade, Integer userId) {
		this.id = id;
		this.subject = subject;
		this.grade = grade;
		this.userId = userId;
	}

	public Certificate(Subjects subject, Grades grade, Integer userId) {
		super();
		this.subject = subject;
		this.grade = grade;
		this.userId = userId;
	}

	public Certificate() {
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

	public Subjects getSubject() {
		return subject;
	}

	public void setSubject(Subjects subject) {
		this.subject = subject;
	}

	public Grades getGrade() {
		return grade;
	}

	public void setGrade(Grades grade) {
		this.grade = grade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(grade, id, subject, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Certificate other = (Certificate) obj;
		return grade == other.grade && Objects.equals(id, other.id) && subject == other.subject
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Certificate [id=" + id + ", userId=" + userId + "]";
	}
	
}
