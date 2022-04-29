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
@Table(name = "certificates")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Certificate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer certificate_id;
	
	@ManyToOne
	@JoinColumn(name = "user_fk_id",nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "subject_fk_id",nullable = false)
	private SubjectsGrades subject;

	public Certificate(Integer id, User user, SubjectsGrades subject) {
		this.certificate_id = id;
		this.user = user;
		this.subject = subject;
	}

	public Certificate(User user, SubjectsGrades subject) {
		this.user = user;
		this.subject = subject;
	}

	public Certificate() {
	}

	public Integer getId() {
		return certificate_id;
	}

	public void setId(Integer id) {
		this.certificate_id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SubjectsGrades getSubject() {
		return subject;
	}

	public void setSubject(SubjectsGrades subject) {
		this.subject = subject;
	}

	@Override
	public int hashCode() {
		return Objects.hash(certificate_id, subject, user);
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
		return Objects.equals(certificate_id, other.certificate_id) && Objects.equals(subject, other.subject)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Certificate [id=" + certificate_id + ", user=" + user + ", subject=" + subject + "]";
	}
}
