package academy.lgs.selection_committee.service;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import academy.lgs.selection_committee.dao.UserRepository;
import academy.lgs.selection_committee.domain.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
    public void save(User user) {
        userRepository.save(user);
    }
    
    public boolean findByEmail(String email) {
    	return userRepository.findByEmail(email).isPresent();
    }
    
    public User getByEmail(String email) {
    	User user = null;
    	Optional<User> findByEmail = userRepository.findByEmail(email);
    	if(findByEmail.isPresent()) {
    		user = findByEmail.get();
    	}
    	return user;
    }
    
    public void updateFoto(User user,MultipartFile image) throws IOException {
    	User userDB = userRepository.getById(user.getId());
    	userDB.setEncodeImage(Base64.getEncoder().encodeToString(image.getBytes()));
    	userRepository.save(userDB);
    }
    
    public void update(User user,String firstName, String lastName, Integer age) throws IOException {
    	User userDB = userRepository.getById(user.getId());
    	userDB.setFirstName(firstName);
    	userDB.setLastName(lastName);
    	userRepository.save(userDB);
    }
    
    public void updatePassword(User user,String password, String passwordConfirm) throws IOException {
    	PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    	User userDB = userRepository.getById(user.getId());
    	userDB.setPassword(bCryptPasswordEncoder.encode(password));
		userDB.setPassword(bCryptPasswordEncoder.encode(passwordConfirm));
    	userRepository.save(userDB);
    }
    
}
