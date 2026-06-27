package InvestingApplication.servicesImpl;

import java.util.HashMap;
import java.util.Map;

import InvestingApplication.exceptions.UserNotFoundException;
import InvestingApplication.models.User;
import InvestingApplication.services.UserService;

public class UserServiceImpl implements UserService {
	Map<String, User> userData = new HashMap<>();
	
	public void addUser(User user) {
		if(userData.containsKey(user.getName())) {
			System.out.println("User already existed with the given name");
		}
		else {
		userData.put(user.getName(), user);
		System.out.println("User added successfully!!!");
		}
	}
	
	public User getUser(String name) {
		if(!userData.containsKey(name)) {
			throw new UserNotFoundException("Error: User not found");
		}
		return userData.get(name);
	}
}
/*
Find User : O(n)
Since users are stored in ArrayList, but using Maps we can reduce the time and get O(1)

Add User -> O(1)
Find User -> O(1)
Find Stock -> O(1)
Buy -> O(1)
Sell -> O(1)
*/