package academy.lgs.selection_committee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.lgs.selection_committee.domain.Certificate;
import academy.lgs.selection_committee.domain.Subject;

public interface CertificateRepository  extends JpaRepository<Certificate, Integer>{
	
	List<Subject> getAllSubjectByUserId(Integer id);

}
