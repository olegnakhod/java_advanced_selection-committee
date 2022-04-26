package academy.lgs.selection_committee.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "facultyes")
public class Faculty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String name;
	
	@Column(name = "number_of_seats")
	private Integer numberOfSeats;
	
	@Column(name = "minimum_passing_score")
	private Integer minimumPassingScore;
	
	public Faculty(Integer id, String name, Integer numberOfSeats, Integer minimumPassingScore) {
		this.id = id;
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
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return Objects.hash(id, minimumPassingScore, name, numberOfSeats);
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
		return Objects.equals(id, other.id) && Objects.equals(minimumPassingScore, other.minimumPassingScore)
				&& Objects.equals(name, other.name) && Objects.equals(numberOfSeats, other.numberOfSeats);
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", numberOfSeats=" + numberOfSeats + ", minimumPassingScore="
				+ minimumPassingScore + "]";
	}	
	
}
