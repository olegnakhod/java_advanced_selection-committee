package academy.lgs.selection_committee.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subjects_grades")
public class SubjectsGrades {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "first_subject")
	private Integer firstSubject;
	
	@Column(name = "second_subject")
	private Integer secondSubject;
	
	@Column(name = "third_subject")
	private Integer thirdSubject;
	
	@Column(name = "sum_certicifate")
	private Integer sumSchoolsCerticifate;
	
	@Column(name = "total_grades")
	private Integer totalGrades;
	
	public SubjectsGrades(Integer id, Integer firstSubject, Integer secondSubject, Integer thirdSubject,
			Integer sumSchoolsCerticifate, Integer totalGrades) {
		this.id = id;
		this.firstSubject = firstSubject;
		this.secondSubject = secondSubject;
		this.thirdSubject = thirdSubject;
		this.sumSchoolsCerticifate = sumSchoolsCerticifate;
		this.totalGrades = totalGrades;
	}
	
	

	public SubjectsGrades(Integer firstSubject, Integer secondSubject, Integer thirdSubject, Integer sumSchoolsCerticifate,
			Integer totalGrades) {
		this.firstSubject = firstSubject;
		this.secondSubject = secondSubject;
		this.thirdSubject = thirdSubject;
		this.sumSchoolsCerticifate = sumSchoolsCerticifate;
		this.totalGrades = totalGrades;
	}

	public SubjectsGrades() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFirstSubject() {
		return firstSubject;
	}

	public void setFirstSubject(Integer firstSubject) {
		this.firstSubject = firstSubject;
	}

	public Integer getSecondSubject() {
		return secondSubject;
	}

	public void setSecondSubject(Integer secondSubject) {
		this.secondSubject = secondSubject;
	}

	public Integer getThirdSubject() {
		return thirdSubject;
	}

	public void setThirdSubject(Integer thirdSubject) {
		this.thirdSubject = thirdSubject;
	}

	public Integer getSumSchoolsCerticifate() {
		return sumSchoolsCerticifate;
	}

	public void setSumSchoolsCerticifate(Integer sumSchoolsCerticifate) {
		this.sumSchoolsCerticifate = sumSchoolsCerticifate;
	}

	public Integer getTotalGrades() {
		return totalGrades;
	}



	public void setTotalGrades(Integer totalGrades) {
		this.totalGrades = totalGrades;
	}



	@Override
	public int hashCode() {
		return Objects.hash(firstSubject, id, secondSubject, sumSchoolsCerticifate, thirdSubject);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubjectsGrades other = (SubjectsGrades) obj;
		return Objects.equals(firstSubject, other.firstSubject) && Objects.equals(id, other.id)
				&& Objects.equals(secondSubject, other.secondSubject)
				&& Objects.equals(sumSchoolsCerticifate, other.sumSchoolsCerticifate)
				&& Objects.equals(thirdSubject, other.thirdSubject);
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", firstSubject=" + firstSubject + ", secondSubject=" + secondSubject
				+ ", thirdSubject=" + thirdSubject + ", sumSchoolsCerticifate=" + sumSchoolsCerticifate + "]";
	}
}
