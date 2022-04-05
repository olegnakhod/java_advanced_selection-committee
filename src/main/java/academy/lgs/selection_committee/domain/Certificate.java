package academy.lgs.selection_committee.domain;

import java.util.Map;
import java.util.Objects;

public class Certificate {
	
	private Integer id;
	private Map<Subject,Integer> certificate;
	private Integer userId;
	
	public Certificate(Integer id, Map<Subject, Integer> certificate) {
		this.id = id;
		this.certificate = certificate;
	}

	public Certificate(Map<Subject, Integer> certificate) {
		this.certificate = certificate;
	}

	public Certificate() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Map<Subject, Integer> getCertificate() {
		return certificate;
	}

	public void setCertificate(Map<Subject, Integer> certificate) {
		this.certificate = certificate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(certificate, id);
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
		return Objects.equals(certificate, other.certificate) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Certificate [id=" + id + ", certificate=" + certificate + "]";
	}
	
}
