package com.cg.fms.dao;

import java.util.List;

import com.cg.fms.model.Schedule;
import com.cg.fms.model.Search;
import com.cg.fms.model.Users;

public interface UserDao {
	
	public void addUserDao(Users user);

	public List<Users> viewUsersDao();
	
	public Users viewByIdDao(int id);

	public void deletebyIdDao(int id);

	public Users updateDao(int userId,Users user);
	public List<Schedule> searchScheduledFlights(Search search);
	public List<Object>userNames();
	public List<Object>userEmail();
	public List<Object>userPhone();
	
	public int validateLogin(String userName,String password);
	
	//public Users login(String userName, String password, int id);
	public Users userLogin(Users user1);
	
	public Users Login(String userName, String password);
	public List<Object>airportList();
	

}
