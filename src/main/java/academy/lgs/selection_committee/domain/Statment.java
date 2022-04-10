package academy.lgs.selection_committee.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "statmens")
public class Statment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToMany(mappedBy = "statments", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Faculty> facultyes = new HashSet<>();

	public Statment(Integer id, Set<Faculty> facultyes) {
		this.id = id;
		this.facultyes = facultyes;
	}
	
	public Statment() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Faculty> getFacultyes() {
		return facultyes;
	}

	public void setFacultyes(Set<Faculty> facultyes) {
		this.facultyes = facultyes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(facultyes, id);
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
		return Objects.equals(facultyes, other.facultyes) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Statment [id=" + id + ", facultyes=" + facultyes + "]";
	}
	
}
