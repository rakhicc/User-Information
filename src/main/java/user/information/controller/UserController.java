package user.information.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import user.information.exception.InvalidInputException;
import user.information.model.User;
import user.information.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public void setUserService(UserService userService){
        this.userService=userService;
    }
	

	@GetMapping(value = "/{phoneNumber}")
    public ResponseEntity < User > getStudentByStudentNumber(@PathVariable("phoneNumber") String phoneNumber) {
		long phnNumber = 0;
		try {
		phnNumber  = Long.valueOf(phoneNumber).longValue();
		} catch(Exception e) {
			throw new InvalidInputException("Invalid format for phone number");
		}
		
		User user  = userService.findUserByPhoneNumber(phnNumber);
		return new ResponseEntity<User>(user, HttpStatus.OK);    
		}

    @GetMapping(value = "/email/{email}")
    public ResponseEntity < User > getStudentByEmail(@PathVariable("email") String email) {
    	User user  = userService.findUserByEmailAddress(email);
    	return new ResponseEntity<User>(user, HttpStatus.OK); 
    }
    
    @PostMapping(value = "/")   
    public ResponseEntity < String > createUser(@RequestBody @Valid User user) {
    	User user1  = userService.saveUser(user);
    	return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
