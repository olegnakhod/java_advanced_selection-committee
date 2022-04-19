package academy.lgs.selection_committee.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lgs.selection_committee.dao.CertificateRepository;
import academy.lgs.selection_committee.dao.SubjectsGradesRepository;
import academy.lgs.selection_committee.dao.UserRepository;
import academy.lgs.selection_committee.domain.Certificate;

@Service
public class CertificateService {
	
	private Logger logger = LoggerFactory.getLogger(CertificateService.class);
	
	@Autowired
	SubjectsGradesRepository subjectsRepository;
	
	@Autowired
	CertificateRepository certificateRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	public List<Certificate> getAll(){
		logger.info("Get all certificates items");
		return certificateRepository.findAll();
	}
	
	public Certificate getByUserId(Integer userId) {
		logger.info("Get certificate by user id = " +  userId);
		List<Certificate> certificates = certificateRepository.findAll();
		return  certificates.stream().filter(x->x.getUser().getId().equals(userId)).findFirst().get();
	}
	
	public Certificate add(Certificate certificate) {
		logger.info("Save certificate:" + certificate);
		return certificateRepository.save(certificate);
	}
	
	public void delte(Certificate certificate) {
		logger.info("Delete certificate:" + certificate);
		certificateRepository.delete(certificate);
	}
	
}
