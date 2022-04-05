package academy.lgs.selection_committee.domain;

import java.util.Objects;

public class Faculty {
	
	private Integer id;
	private String name;
	private Integer numberOfSeats;
	
	public Faculty(Integer id, String name, Integer numberOfSeats) {
		this.id = id;
		this.name = name;
		this.numberOfSeats = numberOfSeats;
	}

	public Faculty(String name, Integer numberOfSeats) {
		this.name = name;
		this.numberOfSeats = numberOfSeats;
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

	@Override
	public int hashCode() {
		return Objects.hash(id, name, numberOfSeats);
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
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(numberOfSeats, other.numberOfSeats);
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", numberOfSeats=" + numberOfSeats + "]";
	}

}
