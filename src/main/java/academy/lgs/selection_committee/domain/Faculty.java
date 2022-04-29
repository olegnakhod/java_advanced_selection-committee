package academy.lgs.selection_committee.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "facultyes")
public class Faculty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer faculty_id;
	
	@Column
	private String name;
	
	@Column(name = "number_of_seats")
	private Integer numberOfSeats;
	
	@Column(name = "minimum_passing_score")
	private Integer minimumPassingScore;
	
    @OneToMany(mappedBy = "faculty", cascade = { CascadeType.PERSIST,
            CascadeType.MERGE }, fetch = FetchType.EAGER, orphanRemoval = true)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Statment> statments = new HashSet<>();
	
	public Faculty(Integer id, String name, Integer numberOfSeats, Integer minimumPassingScore) {
		this.faculty_id = id;
		this.name = name;
		this.numberOfSeats = numberOfSeats;
		this.minimumPassingScore = minimumPassingScore;
	}

	public Faculty(String name, Integer numberOfSeats, Integer minimumPassingScore) {
		this.name = name;
		this.numberOfSeats = numberOfSeats;
		this.minimumPassingScore = minimumPassingScore;
	}

	public Faculty() {
	}

	public Integer getId() {
		return faculty_id;
	}

	public void setId(Integer id) {
		this.faculty_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Integer getMinimumPassingScore() {
		return minimumPassingScore;
	}

	public void setMinimumPassingScore(Integer minimumPassingScore) {
		this.minimumPassingScore = minimumPassingScore;
	}

	@Override
	public int hashCode() {
		return Objects.hash(faculty_id, minimumPassingScore, name, numberOfSeats);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		return Objects.equals(faculty_id, other.faculty_id) && Objects.equals(minimumPassingScore, other.minimumPassingScore)
				&& Objects.equals(name, other.name) && Objects.equals(numberOfSeats, other.numberOfSeats);
	}

	@Override
	public String toString() {
		return "Faculty [id=" + faculty_id + ", name=" + name + ", numberOfSeats=" + numberOfSeats + ", minimumPassingScore="
				+ minimumPassingScore + "]";
	}	
	
}
