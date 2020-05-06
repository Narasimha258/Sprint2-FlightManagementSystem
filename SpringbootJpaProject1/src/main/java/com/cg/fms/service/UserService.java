package com.cg.fms.service;

import java.util.List;

import com.cg.fms.model.Schedule;
import com.cg.fms.model.Search;
import com.cg.fms.model.Users;

public interface UserService {
	
	public void addUserService(Users user);
	public List<Users> viewUserService();
	public Users viewByIdService(int id);

	public void deletebyIdService(int id);

	public Users updateService(int userId,Users user);
	public List<Schedule> searchScheduledFlights(Search search);
	public List<Object>userNamesService();
	public List<Object>userEmailService();
	public List<Object>userPhoneService();
	
	public int validateLogin(String userName,String password);
	
	public Users userLoginService(Users user1);
	
	public Users LoginService(String userName, String password);
	public List<Object>airportListService();
	


}
