package academy.lgs.selection_committee;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import academy.lgs.selection_committee.dao.UserRepository;
import academy.lgs.selection_committee.domain.User;
import academy.lgs.selection_committee.domain.UserRole;
import academy.lgs.selection_committee.service.UserService;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ApplicationTests {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
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

		userService.save(user);
		
		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		User userFromDb = users.get(0);
		assertTrue(userFromDb.getEmail().equals(user.getEmail()));
		assertTrue(userFromDb.getFirstName().equals(user.getFirstName()));
		assertTrue(userFromDb.getLastName().equals(user.getLastName()));
		assertTrue(userFromDb.getUserRole().equals(user.getUserRole()));
	}
	
	@Test
	public void testFindByEmail() {
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
}
