package academy.lgs.selection_committee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lgs.selection_committee.dao.StatmentRepository;
import academy.lgs.selection_committee.domain.Statment;

@Service
public class StatmentService {
	
	@Autowired
	private StatmentRepository statmentRepository;
	
	public List<Statment> getAll(){
		return statmentRepository.findAll();
	}
	
	public List<Statment> getAllByFacultyId(Integer facultyId){
		return statmentRepository.getAllByFacultyId(facultyId);
	}
		
	public List<Statment> getAllByUserId(Integer userId){
		return statmentRepository.getAllByUserId(userId);
	}
	
	public Statment add(Statment statment) {
		return statmentRepository.save(statment);
	}
	
	
	public void deleteByUserId(Integer id) {
		Statment statment = statmentRepository.findAll().stream().filter(x-> x.getUser().getId()==id).findFirst().get();
		statmentRepository.delete(statment);
	}
	

}
