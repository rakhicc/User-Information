package user.information.repository;

import org.springframework.stereotype.Repository;

import user.information.model.User;

@Repository
public interface UserRepository{
	
	User findByPhoneNumber(long phoneNumber);

    User findByEmail(String email);
    
    User saveUser(User user);

}
