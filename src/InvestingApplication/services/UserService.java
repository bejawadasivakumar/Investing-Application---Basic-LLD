package InvestingApplication.services;

import InvestingApplication.models.User;

public interface UserService {
	
	void addUser(User user);
	User getUser(String name);

}
