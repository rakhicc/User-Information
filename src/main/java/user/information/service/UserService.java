package user.information.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import user.information.model.User;
import user.information.repository.UserRepository;

@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void setUserRepository(UserRepository userRepository){
        this.userRepository=userRepository;
    }

	public User findUserByPhoneNumber(long phoneNumber) {
		User user  = userRepository.findByPhoneNumber(phoneNumber);
		return user;
		
	}
	
	public User findUserByEmailAddress(String email) {
		User user  = userRepository.findByEmail(email);
		return user;
		
	}
	public User saveUser(User user) {
		User user1  = userRepository.saveUser(user);
		return user1;
		
	}
}
