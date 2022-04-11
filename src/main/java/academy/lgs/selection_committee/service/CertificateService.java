package academy.lgs.selection_committee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lgs.selection_committee.dao.CertificateRepository;
import academy.lgs.selection_committee.dao.SubjectsRepository;
import academy.lgs.selection_committee.dao.UserRepository;
import academy.lgs.selection_committee.domain.Certificate;
import academy.lgs.selection_committee.domain.Subject;

@Service
public class CertificateService {
	
	@Autowired
	SubjectsRepository subjectsRepository;
	
	@Autowired
	CertificateRepository certificateRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public List<Subject> getAllSubjectByUserId(Integer id){
		return certificateRepository.getAllSubjectByUserId(id);
	}
	
	public List<Certificate> getAll(){
		return certificateRepository.findAll();
	}
	
	public Certificate add(Certificate certificate) {
		return certificateRepository.save(certificate);
	}
	
	public void delte(Certificate certificate) {
		certificateRepository.delete(certificate);
	}
}
