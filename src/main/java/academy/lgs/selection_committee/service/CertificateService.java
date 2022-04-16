package academy.lgs.selection_committee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lgs.selection_committee.dao.CertificateRepository;
import academy.lgs.selection_committee.dao.SubjectsGradesRepository;
import academy.lgs.selection_committee.dao.UserRepository;
import academy.lgs.selection_committee.domain.Certificate;

@Service
public class CertificateService {
	
	@Autowired
	SubjectsGradesRepository subjectsRepository;
	
	@Autowired
	CertificateRepository certificateRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	public List<Certificate> getAll(){
		return certificateRepository.findAll();
	}
	
	public Certificate getByUserId(Integer userId) {
		List<Certificate> certificates = certificateRepository.findAll();
		return  certificates.stream().filter(x->x.getUser().getId().equals(userId)).findFirst().get();
	}
	
	public Certificate add(Certificate certificate) {
		return certificateRepository.save(certificate);
	}
	
	public void delte(Certificate certificate) {
		certificateRepository.delete(certificate);
	}
	
}
