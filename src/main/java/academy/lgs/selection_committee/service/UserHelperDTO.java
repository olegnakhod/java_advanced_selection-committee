package academy.lgs.selection_committee.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import academy.lgs.selection_committee.domain.User;
import academy.lgs.selection_committee.domain.UserRole;

public class UserHelperDTO {
	
	public static User createUser( String firstName, String lastName, Integer age, String email, String password, String passwordConfirm, MultipartFile image) throws IOException {
		User user = new User();
		PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAge(age);
		user.setEmail(email);
		user.setPassword(bCryptPasswordEncoder.encode(password));
		user.setPassword(bCryptPasswordEncoder.encode(passwordConfirm));
		user.setEncodeImage(Base64.getEncoder().encodeToString(image.getBytes()));
		user.setUserRole(UserRole.ROLE_CANDIDATE);
		return user;
	}
	
	public static User updateFoto(MultipartFile image) throws IOException {
		User user = new User();
		user.setEncodeImage(Base64.getEncoder().encodeToString(image.getBytes()));
		return user;
	}

}
