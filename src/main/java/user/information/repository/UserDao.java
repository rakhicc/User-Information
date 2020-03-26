package user.information.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import user.information.exception.RecordNotFoundException;
import user.information.model.User;

@Repository
public class UserDao implements UserRepository {
	
	private final MongoTemplate mongoTemplate;

	UserDao(MongoTemplate mongoTemplate) {
	this.mongoTemplate= mongoTemplate;
	}
	@Override
	public User findByPhoneNumber(long phoneNumber) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("phoneNumber").is(phoneNumber));
		User user = mongoTemplate.findOne(query, User.class);
		if (user == null) {
			throw new RecordNotFoundException("User not Found");
		}
		return user;
	}

	@Override
	public User findByEmail(String email) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		
		User user = mongoTemplate.findOne(query, User.class);
		if (user == null) {
			throw new RecordNotFoundException("User not Found");
		}
		return user;
	}

	@Override
	public User saveUser(User user) {
		mongoTemplate.save(user);
		return user;
	}

}
