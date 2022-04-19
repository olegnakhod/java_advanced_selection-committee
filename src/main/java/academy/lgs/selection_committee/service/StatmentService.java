package academy.lgs.selection_committee.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lgs.selection_committee.dao.StatmentRepository;
import academy.lgs.selection_committee.domain.Statment;

@Service
public class StatmentService {
	
	private Logger logger = LoggerFactory.getLogger(StatmentService.class);
	
	@Autowired
	private StatmentRepository statmentRepository;
	
	public List<Statment> getAll(){
		logger.info("Get all statment items");
		return statmentRepository.findAll();
	}
	
	public List<Statment> getAllByFacultyId(Integer facultyId){
		logger.info("Get all statment items by faculty id = " + facultyId);
		return statmentRepository.getAllByFacultyId(facultyId);
	}
		
	public List<Statment> getAllByUserId(Integer userId){
		logger.info("Get all statment items by user id = " + userId);
		return statmentRepository.getAllByUserId(userId);
	}
	
	public Statment add(Statment statment) {
		logger.info("Save statment item:" + statment);
		return statmentRepository.save(statment);
	}
	
	
	public void deleteByUserId(Integer id) {
		logger.info("Delete statment item by user id = " +id);
		Statment statment = statmentRepository.findAll().stream().filter(x-> x.getUser().getId()==id).findFirst().get();
		statmentRepository.delete(statment);
	}
	

}
