package academy.lgs.selection_committee;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import academy.lgs.selection_committee.dao.CertificateRepository;
import academy.lgs.selection_committee.dao.FacultyRepository;
import academy.lgs.selection_committee.dao.StatmentRepository;
import academy.lgs.selection_committee.dao.SubjectsGradesRepository;
import academy.lgs.selection_committee.dao.UserRepository;
import academy.lgs.selection_committee.domain.Certificate;
import academy.lgs.selection_committee.domain.Faculty;
import academy.lgs.selection_committee.domain.Statment;
import academy.lgs.selection_committee.domain.SubjectsGrades;
import academy.lgs.selection_committee.domain.User;
import academy.lgs.selection_committee.domain.UserRole;
import academy.lgs.selection_committee.service.CertificateService;
import academy.lgs.selection_committee.service.FacultyService;
import academy.lgs.selection_committee.service.StatmentService;
import academy.lgs.selection_committee.service.SubjectsGradesService;
import academy.lgs.selection_committee.service.UserService;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@ComponentScan(basePackages = {"academy.lgs.selection_committee"})
public class ApplicationTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	SubjectsGradesRepository subjectsRepository;
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	@Autowired
	CertificateRepository certificateRepository;
	
	@Autowired
	private StatmentRepository statmentRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	SubjectsGradesService subjectsService;
	
	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	CertificateService certificateService;
	
	@Autowired
	private StatmentService statmentService;
	
	@Test
	public void testSaveUser() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setUserRole(UserRole.ROLE_CANDIDATE);

		userService.save(user);;
		
		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		User userFromDb = users.get(0);
		assertTrue(userFromDb.getEmail().equals(user.getEmail()));
		assertTrue(userFromDb.getFirstName().equals(user.getFirstName()));
		assertTrue(userFromDb.getLastName().equals(user.getLastName()));
		assertTrue(userFromDb.getUserRole().equals(user.getUserRole()));
	}
	
	@Test
	public void testGetByEmailUser() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setUserRole(UserRole.ROLE_CANDIDATE);

		userRepository.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		User getByEmail = userService.getByEmail(user.getEmail());

		assertTrue(getByEmail.getEmail().equals(user.getEmail()));
		assertTrue(getByEmail.getFirstName().equals(user.getFirstName()));
		assertTrue(getByEmail.getLastName().equals(user.getLastName()));
		assertTrue(getByEmail.getUserRole().equals(user.getUserRole()));
	}
	
	@Test
	public void testGetByIdUser() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setUserRole(UserRole.ROLE_CANDIDATE);

		userRepository.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		User getByEmail = userService.getById(user.getId());

		assertTrue(getByEmail.getEmail().equals(user.getEmail()));
		assertTrue(getByEmail.getFirstName().equals(user.getFirstName()));
		assertTrue(getByEmail.getLastName().equals(user.getLastName()));
		assertTrue(getByEmail.getUserRole().equals(user.getUserRole()));
	}
	
	@Test
	public void testFindByEmailUser() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setUserRole(UserRole.ROLE_CANDIDATE);

		userRepository.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		assertTrue(userService.findByEmail(user.getEmail()));
	}
	
	@Test
	public void testUpdateUser() throws IOException{

		
		
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setAge(1);
		user.setUserRole(UserRole.ROLE_CANDIDATE);

		userRepository.save(user);
		
		users = userRepository.findAll();
		assertThat(users, hasSize(1));
		
		User userDB = new User();
		userDB.setEmail("2@gmail.com");
		userDB.setFirstName("2");
		userDB.setLastName("2");
		userDB.setPassword("2");
		userDB.setPasswordConfirm("2");
		userDB.setAge(2);
		userDB.setUserRole(UserRole.ROLE_CANDIDATE);

		userService.update(user,userDB.getFirstName(),userDB.getLastName(), userDB.getAge());
		
		users = userRepository.findAll();
		user = users.get(0);
		
		assertTrue(user.getFirstName().equals(userDB.getFirstName()));
		assertTrue(user.getLastName().equals(userDB.getLastName()));
		assertTrue(user.getAge().equals(userDB.getAge()));
	}

	@Test
	public void testAddSubjectsGrades() {
		List<SubjectsGrades> grades = subjectsRepository.findAll();
		assertThat(grades, hasSize(0));
		
		SubjectsGrades subjectsGrades =new SubjectsGrades();
		subjectsGrades.setFirstSubject(100);
		subjectsGrades.setSecondSubject(100);
		subjectsGrades.setThirdSubject(100);
		subjectsGrades.setSumSchoolsCerticifate(100);
		subjectsGrades.setTotalGrades(400);
		
		subjectsService.add(subjectsGrades);
		
		grades = subjectsRepository.findAll();
		assertThat(grades, hasSize(1));
		
		SubjectsGrades subjectsGradesDB = grades.get(0);
		
		assertTrue(subjectsGrades.getFirstSubject().equals(subjectsGradesDB.getFirstSubject()));
		assertTrue(subjectsGrades.getSecondSubject().equals(subjectsGradesDB.getSecondSubject()));
		assertTrue(subjectsGrades.getThirdSubject().equals(subjectsGradesDB.getThirdSubject()));
		assertTrue(subjectsGrades.getSumSchoolsCerticifate().equals(subjectsGradesDB.getSumSchoolsCerticifate()));
		assertTrue(subjectsGrades.getTotalGrades().equals(subjectsGradesDB.getTotalGrades()));
	}
	
	@Test
	public void testUpdateSubjectsGrades() {
		List<SubjectsGrades> grades = subjectsRepository.findAll();
		assertThat(grades, hasSize(0));
		
		SubjectsGrades subjectsGrades =new SubjectsGrades();
		subjectsGrades.setFirstSubject(100);
		subjectsGrades.setSecondSubject(100);
		subjectsGrades.setThirdSubject(100);
		subjectsGrades.setSumSchoolsCerticifate(100);
		subjectsGrades.setTotalGrades(400);
		
		subjectsService.add(subjectsGrades);
		
		grades = subjectsRepository.findAll();
		assertThat(grades, hasSize(1));
		
		SubjectsGrades subjectsGradesDB =new SubjectsGrades();
		subjectsGradesDB.setFirstSubject(50);
		subjectsGradesDB.setSecondSubject(50);
		subjectsGradesDB.setThirdSubject(50);
		subjectsGradesDB.setSumSchoolsCerticifate(50);
		subjectsGradesDB.setTotalGrades(50);
		
		subjectsService.update(subjectsGrades, subjectsGradesDB.getFirstSubject(),
				subjectsGradesDB.getSecondSubject(), subjectsGradesDB.getThirdSubject(),
				subjectsGradesDB.getSumSchoolsCerticifate());
		
		grades = subjectsRepository.findAll();
		subjectsGrades = grades.get(0);
		
		assertTrue(subjectsGrades.getFirstSubject().equals(subjectsGradesDB.getFirstSubject()));
		assertTrue(subjectsGrades.getSecondSubject().equals(subjectsGradesDB.getSecondSubject()));
		assertTrue(subjectsGrades.getThirdSubject().equals(subjectsGradesDB.getThirdSubject()));
		assertTrue(subjectsGrades.getSumSchoolsCerticifate().equals(subjectsGradesDB.getSumSchoolsCerticifate()));
	}
	
	@Test
	public void testDeleteSubjectsGrades() {
		List<SubjectsGrades> grades = subjectsRepository.findAll();
		assertThat(grades, hasSize(0));
		
		SubjectsGrades subjectsGrades =new SubjectsGrades();
		subjectsGrades.setFirstSubject(100);
		subjectsGrades.setSecondSubject(100);
		subjectsGrades.setThirdSubject(100);
		subjectsGrades.setSumSchoolsCerticifate(100);
		subjectsGrades.setTotalGrades(400);
		
		SubjectsGrades subjectsGradesDB =new SubjectsGrades();
		subjectsGradesDB.setFirstSubject(50);
		subjectsGradesDB.setSecondSubject(50);
		subjectsGradesDB.setThirdSubject(50);
		subjectsGradesDB.setSumSchoolsCerticifate(50);
		subjectsGradesDB.setTotalGrades(50);
		
		subjectsService.add(subjectsGrades);
		subjectsService.add(subjectsGradesDB);
		
		grades = subjectsRepository.findAll();
		assertThat(grades, hasSize(2));
		
		subjectsService.delete(subjectsGrades);
		
		grades = subjectsRepository.findAll();
		assertThat(grades, hasSize(1));
		
		subjectsGrades = grades.get(0);
		
		assertTrue(subjectsGrades.getFirstSubject().equals(subjectsGradesDB.getFirstSubject()));
		assertTrue(subjectsGrades.getSecondSubject().equals(subjectsGradesDB.getSecondSubject()));
		assertTrue(subjectsGrades.getThirdSubject().equals(subjectsGradesDB.getThirdSubject()));
		assertTrue(subjectsGrades.getSumSchoolsCerticifate().equals(subjectsGradesDB.getSumSchoolsCerticifate()));
	
	}
	
	@Test
	public void testSaveFaculty() {
		List<Faculty> facultyes = facultyRepository.findAll();
		assertThat(facultyes, hasSize(0));

		Faculty faculty = new Faculty();
		faculty.setName("Finance");
		faculty.setNumberOfSeats(10);
		faculty.setMinimumPassingScore(200);

		facultyService.save(faculty);
		
		facultyes = facultyRepository.findAll();
		assertThat(facultyes, hasSize(1));

		Faculty facultyDB = facultyes.get(0);
		assertTrue(faculty.getName().equals(facultyDB.getName()));
		assertTrue(faculty.getMinimumPassingScore().equals(facultyDB.getMinimumPassingScore()));
		assertTrue(faculty.getNumberOfSeats().equals(facultyDB.getNumberOfSeats()));
	}
	
	@Test
	public void testGetFacultyByName() {
		List<Faculty> facultyes = facultyRepository.findAll();
		assertThat(facultyes, hasSize(0));

		Faculty faculty = new Faculty();
		faculty.setName("Finance");
		faculty.setNumberOfSeats(10);
		faculty.setMinimumPassingScore(200);

		facultyService.save(faculty);
		
		facultyes = facultyRepository.findAll();
		assertThat(facultyes, hasSize(1));

		Faculty facultyDB = facultyService.getFacultyByName(faculty.getName());
		assertTrue(faculty.getId().equals(facultyDB.getId()));
		assertTrue(faculty.getName().equals(facultyDB.getName()));
		assertTrue(faculty.getMinimumPassingScore().equals(facultyDB.getMinimumPassingScore()));
		assertTrue(faculty.getNumberOfSeats().equals(facultyDB.getNumberOfSeats()));
	}
	
	@Test
	public void testGetFacultyById() {
		List<Faculty> facultyes = facultyRepository.findAll();
		assertThat(facultyes, hasSize(0));

		Faculty faculty = new Faculty();
		faculty.setName("Finance");
		faculty.setNumberOfSeats(10);
		faculty.setMinimumPassingScore(200);

		facultyService.save(faculty);
		
		facultyes = facultyRepository.findAll();
		assertThat(facultyes, hasSize(1));

		Faculty facultyDB = facultyService.getFacultyById(faculty.getId());
		assertTrue(faculty.getId().equals(facultyDB.getId()));
		assertTrue(faculty.getName().equals(facultyDB.getName()));
		assertTrue(faculty.getMinimumPassingScore().equals(facultyDB.getMinimumPassingScore()));
		assertTrue(faculty.getNumberOfSeats().equals(facultyDB.getNumberOfSeats()));
	}

	@Test
	public void testAddCertificate() {
		List<Certificate> certificates = certificateRepository.findAll();
		assertThat(certificates, hasSize(0));
		
		SubjectsGrades subjectsGrades =new SubjectsGrades();
		subjectsGrades.setFirstSubject(100);
		subjectsGrades.setSecondSubject(100);
		subjectsGrades.setThirdSubject(100);
		subjectsGrades.setSumSchoolsCerticifate(100);
		subjectsGrades.setTotalGrades(400);
		
		subjectsService.add(subjectsGrades);
		
		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setUserRole(UserRole.ROLE_CANDIDATE);
		
		userService.save(user);
		
		Certificate certificate = new Certificate();
		
		certificate.setSubject(subjectsGrades);
		certificate.setUser(user);
		
		certificateService.add(certificate);
		
		certificates = certificateRepository.findAll();
		assertThat(certificates, hasSize(1));
		
		Certificate certificateDB = certificates.get(0);
		
		assertTrue(certificate.getUser().equals(certificateDB.getUser()));
		assertTrue(certificate.getSubject().equals(certificateDB.getSubject()));
	}
	
	@Test
	public void testGetByUserId() {
		List<Certificate> certificates = certificateRepository.findAll();
		assertThat(certificates, hasSize(0));
		
		SubjectsGrades subjectsGrades =new SubjectsGrades();
		subjectsGrades.setFirstSubject(100);
		subjectsGrades.setSecondSubject(100);
		subjectsGrades.setThirdSubject(100);
		subjectsGrades.setSumSchoolsCerticifate(100);
		subjectsGrades.setTotalGrades(400);
		
		subjectsService.add(subjectsGrades);
		
		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setUserRole(UserRole.ROLE_CANDIDATE);
		
		userService.save(user);
		
		Certificate certificate = new Certificate();
		
		certificate.setSubject(subjectsGrades);
		certificate.setUser(user);
		
		certificateService.add(certificate);
		
		certificates = certificateRepository.findAll();
		assertThat(certificates, hasSize(1));
		
		Certificate certificateDB = certificateService.getByUserId(user.getId());
		
		assertTrue(certificate.getUser().equals(certificateDB.getUser()));
		assertTrue(certificate.getSubject().equals(certificateDB.getSubject()));
	}
	
	@Test
	public void testDeleteCertificate() {
		List<Certificate> certificates = certificateRepository.findAll();
		assertThat(certificates, hasSize(0));
		
		SubjectsGrades subjectsGrades =new SubjectsGrades();
		subjectsGrades.setFirstSubject(100);
		subjectsGrades.setSecondSubject(100);
		subjectsGrades.setThirdSubject(100);
		subjectsGrades.setSumSchoolsCerticifate(100);
		subjectsGrades.setTotalGrades(400);
		
		SubjectsGrades subjectsGradesDB =new SubjectsGrades();
		subjectsGradesDB.setFirstSubject(50);
		subjectsGradesDB.setSecondSubject(50);
		subjectsGradesDB.setThirdSubject(50);
		subjectsGradesDB.setSumSchoolsCerticifate(50);
		subjectsGradesDB.setTotalGrades(50);
		
		subjectsService.add(subjectsGrades);
		subjectsService.add(subjectsGradesDB);
		
		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setUserRole(UserRole.ROLE_CANDIDATE);
		
		User userDB = new User();
		userDB.setEmail("2@gmail.com");
		userDB.setFirstName("2");
		userDB.setLastName("2");
		userDB.setPassword("2");
		userDB.setPasswordConfirm("2");
		userDB.setAge(2);
		userDB.setUserRole(UserRole.ROLE_CANDIDATE);
		
		userService.save(user);
		userService.save(userDB);
		
		Certificate certificate = new Certificate();
		Certificate certificateSecond = new Certificate();
		
		certificate.setSubject(subjectsGrades);
		certificate.setUser(user);
		
		certificateSecond.setSubject(subjectsGradesDB);
		certificateSecond.setUser(userDB);
		
		certificateService.add(certificate);
		certificateService.add(certificateSecond);
		
		certificates = certificateRepository.findAll();
		assertThat(certificates, hasSize(2));
		
		certificateService.delete(certificateSecond);
		
		certificates = certificateRepository.findAll();
		assertThat(certificates, hasSize(1));
		
		Certificate certificateDB = certificates.get(0);
		
		assertTrue(certificate.getUser().equals(certificateDB.getUser()));
		assertTrue(certificate.getSubject().equals(certificateDB.getSubject()));
	}

	@Test
	public void testAddStatment() {
		List<Statment> statments = statmentRepository.findAll();
		assertThat(statments, hasSize(0));
		
		Faculty faculty = new Faculty();
		faculty.setName("Finance");
		faculty.setNumberOfSeats(10);
		faculty.setMinimumPassingScore(200);

		facultyService.save(faculty);
		
		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setUserRole(UserRole.ROLE_CANDIDATE);
		
		userService.save(user);
		
		Statment statment = new Statment();
		
		statment.setFaculty(faculty);
		statment.setUser(user);
		
		statmentService.add(statment);
		
		statments = statmentRepository.findAll();
		assertThat(statments, hasSize(1));
		
		Statment statmentDB = statments.get(0);
		
		assertTrue(statment.getUser().equals(statmentDB.getUser()));
		assertTrue(statment.getFaculty().equals(statmentDB.getFaculty()));
	}
	
	@Test
	public void testGetAllByFacultyId() {
		List<Statment> statments = statmentRepository.findAll();
		assertThat(statments, hasSize(0));
		
		Faculty faculty = new Faculty();
		faculty.setName("Finance");
		faculty.setNumberOfSeats(10);
		faculty.setMinimumPassingScore(200);

		facultyService.save(faculty);
		
		Faculty facultySecond = new Faculty();
		facultySecond.setName("Mathematic");
		facultySecond.setNumberOfSeats(10);
		facultySecond.setMinimumPassingScore(300);

		facultyService.save(facultySecond);
		
		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setUserRole(UserRole.ROLE_CANDIDATE);
		
		userService.save(user);
		
		User userSecond = new User();
		userSecond.setEmail("2@gmail.com");
		userSecond.setFirstName("2");
		userSecond.setLastName("2");
		userSecond.setPassword("2");
		userSecond.setPasswordConfirm("2");
		userSecond.setAge(2);
		userSecond.setUserRole(UserRole.ROLE_CANDIDATE);
		
		userService.save(userSecond);
		
		Statment statment = new Statment();
		Statment statmentSecond = new Statment();
		
		statment.setFaculty(faculty);
		statment.setUser(user);
		
		statmentSecond.setFaculty(facultySecond);
		statmentSecond.setUser(userSecond);
		
		statmentService.add(statment);
		statmentService.add(statmentSecond);
		
		statments = statmentRepository.findAll();
		assertThat(statments, hasSize(2));
		
		statments = statmentService.getAllByFacultyId(faculty.getId());
		assertThat(statments, hasSize(1));
		
		Statment statmentDB = statments.get(0);
		
		assertTrue(statment.getUser().equals(statmentDB.getUser()));
		assertTrue(statment.getFaculty().equals(statmentDB.getFaculty()));
	}
	
	@Test
	public void testGetAllByUserId() {
		List<Statment> statments = statmentRepository.findAll();
		assertThat(statments, hasSize(0));
		
		Faculty faculty = new Faculty();
		faculty.setName("Finance");
		faculty.setNumberOfSeats(10);
		faculty.setMinimumPassingScore(200);

		facultyService.save(faculty);
		
		Faculty facultySecond = new Faculty();
		facultySecond.setName("Mathematic");
		facultySecond.setNumberOfSeats(10);
		facultySecond.setMinimumPassingScore(300);

		facultyService.save(facultySecond);
		
		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setUserRole(UserRole.ROLE_CANDIDATE);
		
		userService.save(user);
		
		User userSecond = new User();
		userSecond.setEmail("2@gmail.com");
		userSecond.setFirstName("2");
		userSecond.setLastName("2");
		userSecond.setPassword("2");
		userSecond.setPasswordConfirm("2");
		userSecond.setAge(2);
		userSecond.setUserRole(UserRole.ROLE_CANDIDATE);
		
		userService.save(userSecond);
		
		Statment statment = new Statment();
		Statment statmentSecond = new Statment();
		
		statment.setFaculty(faculty);
		statment.setUser(user);
		
		statmentSecond.setFaculty(facultySecond);
		statmentSecond.setUser(userSecond);
		
		statmentService.add(statment);
		statmentService.add(statmentSecond);
		
		statments = statmentRepository.findAll();
		assertThat(statments, hasSize(2));
		
		statments = statmentService.getAllByUserId(user.getId());
		assertThat(statments, hasSize(1));
		
		Statment statmentDB = statments.get(0);
		
		assertTrue(statment.getUser().equals(statmentDB.getUser()));
		assertTrue(statment.getFaculty().equals(statmentDB.getFaculty()));
	}
	
	@Test
	public void testDeleteByUserId() {
		List<Statment> statments = statmentRepository.findAll();
		assertThat(statments, hasSize(0));
		
		Faculty faculty = new Faculty();
		faculty.setName("Finance");
		faculty.setNumberOfSeats(10);
		faculty.setMinimumPassingScore(200);

		facultyService.save(faculty);
		
		Faculty facultySecond = new Faculty();
		facultySecond.setName("Mathematic");
		facultySecond.setNumberOfSeats(10);
		facultySecond.setMinimumPassingScore(300);

		facultyService.save(facultySecond);
		
		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setUserRole(UserRole.ROLE_CANDIDATE);
		
		userService.save(user);
		
		User userSecond = new User();
		userSecond.setEmail("2@gmail.com");
		userSecond.setFirstName("2");
		userSecond.setLastName("2");
		userSecond.setPassword("2");
		userSecond.setPasswordConfirm("2");
		userSecond.setAge(2);
		userSecond.setUserRole(UserRole.ROLE_CANDIDATE);
		
		userService.save(userSecond);
		
		Statment statment = new Statment();
		Statment statmentSecond = new Statment();
		
		statment.setFaculty(faculty);
		statment.setUser(user);
		
		statmentSecond.setFaculty(facultySecond);
		statmentSecond.setUser(userSecond);
		
		statmentService.add(statment);
		statmentService.add(statmentSecond);
		
		statments = statmentRepository.findAll();
		assertThat(statments, hasSize(2));
		
		statmentService.deleteByUserId(userSecond.getId());
		
		statments = statmentRepository.findAll();
		assertThat(statments, hasSize(1));
		
		Statment statmentDB = statments.get(0);
		
		assertTrue(statment.getUser().equals(statmentDB.getUser()));
		assertTrue(statment.getFaculty().equals(statmentDB.getFaculty()));
	}
	
	@Test
	public void testDeleteByFacultyId() {
		List<Statment> statments = statmentRepository.findAll();
		assertThat(statments, hasSize(0));
		
		Faculty faculty = new Faculty();
		faculty.setName("Finance");
		faculty.setNumberOfSeats(10);
		faculty.setMinimumPassingScore(200);

		facultyService.save(faculty);
		
		Faculty facultySecond = new Faculty();
		facultySecond.setName("Mathematic");
		facultySecond.setNumberOfSeats(10);
		facultySecond.setMinimumPassingScore(300);

		facultyService.save(facultySecond);
		
		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setUserRole(UserRole.ROLE_CANDIDATE);
		
		userService.save(user);
		
		User userSecond = new User();
		userSecond.setEmail("2@gmail.com");
		userSecond.setFirstName("2");
		userSecond.setLastName("2");
		userSecond.setPassword("2");
		userSecond.setPasswordConfirm("2");
		userSecond.setAge(2);
		userSecond.setUserRole(UserRole.ROLE_CANDIDATE);
		
		userService.save(userSecond);
		
		Statment statment = new Statment();
		Statment statmentSecond = new Statment();
		
		statment.setFaculty(faculty);
		statment.setUser(user);
		
		statmentSecond.setFaculty(facultySecond);
		statmentSecond.setUser(userSecond);
		
		statmentService.add(statment);
		statmentService.add(statmentSecond);
		
		statments = statmentRepository.findAll();
		assertThat(statments, hasSize(2));
		
		statmentService.deleteByFacultyId(facultySecond.getId());
		
		statments = statmentRepository.findAll();
		assertThat(statments, hasSize(1));
		
		Statment statmentDB = statments.get(0);
		
		assertTrue(statment.getUser().equals(statmentDB.getUser()));
		assertTrue(statment.getFaculty().equals(statmentDB.getFaculty()));
	}
	
	@Test
	public void testGetUsersByFacultyId() {
		List<Statment> statments = statmentRepository.findAll();
		List<User> users = new ArrayList<>();
		assertThat(statments, hasSize(0));
		
		Faculty faculty = new Faculty();
		faculty.setName("Finance");
		faculty.setNumberOfSeats(10);
		faculty.setMinimumPassingScore(200);

		facultyService.save(faculty);
		
		Faculty facultySecond = new Faculty();
		facultySecond.setName("Mathematic");
		facultySecond.setNumberOfSeats(10);
		facultySecond.setMinimumPassingScore(300);

		facultyService.save(facultySecond);
		
		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setUserRole(UserRole.ROLE_CANDIDATE);
		
		userService.save(user);
		
		User userSecond = new User();
		userSecond.setEmail("2@gmail.com");
		userSecond.setFirstName("2");
		userSecond.setLastName("2");
		userSecond.setPassword("2");
		userSecond.setPasswordConfirm("2");
		userSecond.setAge(2);
		userSecond.setUserRole(UserRole.ROLE_CANDIDATE);
		
		userService.save(userSecond);
		
		users.add(user);
		
		Statment statment = new Statment();
		Statment statmentSecond = new Statment();
		
		statment.setFaculty(faculty);
		statment.setUser(user);
		
		statmentSecond.setFaculty(facultySecond);
		statmentSecond.setUser(userSecond);
		
		statmentService.add(statment);
		statmentService.add(statmentSecond);
		
		statments = statmentRepository.findAll();
		assertThat(statments, hasSize(2));
		
		List<User> usersByFacultyId = statmentService.getUsersByFacultyId(faculty.getId());
		
		assertTrue(usersByFacultyId.get(0).equals(users.get(0)));
	}
	
	@Test
	public void testGetFacultyesByUserId() {
		List<Statment> statments = statmentRepository.findAll();
		List<Faculty> facultyes = new ArrayList<>();
		assertThat(statments, hasSize(0));
		
		Faculty faculty = new Faculty();
		faculty.setName("Finance");
		faculty.setNumberOfSeats(10);
		faculty.setMinimumPassingScore(200);

		facultyService.save(faculty);
		
		Faculty facultySecond = new Faculty();
		facultySecond.setName("Mathematic");
		facultySecond.setNumberOfSeats(10);
		facultySecond.setMinimumPassingScore(300);

		facultyService.save(facultySecond);
		
		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setUserRole(UserRole.ROLE_CANDIDATE);
		
		userService.save(user);
		
		User userSecond = new User();
		userSecond.setEmail("2@gmail.com");
		userSecond.setFirstName("2");
		userSecond.setLastName("2");
		userSecond.setPassword("2");
		userSecond.setPasswordConfirm("2");
		userSecond.setAge(2);
		userSecond.setUserRole(UserRole.ROLE_CANDIDATE);
		
		userService.save(userSecond);
		
		facultyes.add(faculty);
		
		Statment statment = new Statment();
		Statment statmentSecond = new Statment();
		
		statment.setFaculty(faculty);
		statment.setUser(user);
		
		statmentSecond.setFaculty(facultySecond);
		statmentSecond.setUser(userSecond);
		
		statmentService.add(statment);
		statmentService.add(statmentSecond);
		
		statments = statmentRepository.findAll();
		assertThat(statments, hasSize(2));
		
		List<Faculty> facultyesByUserId = statmentService.getFacultyesByUserId(user.getId());
		
		assertTrue(facultyesByUserId.get(0).equals(facultyes.get(0)));
	}
	
}
