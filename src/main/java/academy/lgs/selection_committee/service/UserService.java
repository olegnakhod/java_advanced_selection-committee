package academy.lgs.selection_committee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import academy.lgs.selection_committee.dao.UserRepository;
import academy.lgs.selection_committee.domain.User;
import academy.lgs.selection_committee.domain.UserRole;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
	
    public void save(User user) {
    	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
        user.setUserRole(UserRole.ROLE_CANDIDATE);
        userRepository.save(user);
    }
    
    
    
    public User findByEmail(String email) {
    	User user = null;
    	Optional<User> findByEmail = userRepository.findByEmail(email);
    	if(findByEmail.isPresent()) {
    		user = findByEmail.get();
    	}
    	return user;
    }
}
