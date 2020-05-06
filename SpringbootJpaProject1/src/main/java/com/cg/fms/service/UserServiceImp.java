package com.cg.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.UserDao;
import com.cg.fms.model.Schedule;
import com.cg.fms.model.Search;
import com.cg.fms.model.Users;
//This Service Method will send the Object from Rest-Controller to Dao and there a Methods like addUser,viewUser,updateUser,deleteUser
@Transactional
@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	UserDao userDao;
	

	@Override
	public void addUserService(Users user) {
		userDao.addUserDao(user);
		
	}

	@Override
	public List<Users> viewUserService() {
		List<Users> list=userDao.viewUsersDao();
		return list;
	}

	@Override
	public Users viewByIdService(int id) {
		Users user=userDao.viewByIdDao(id);
		return user;

	}

	@Override
	public void deletebyIdService(int id) {
		userDao.deletebyIdDao(id);
		
	}

	@Override
	public Users updateService(int userId,Users user) {
		Users user1=userDao.updateDao(userId, user);
		return user1;
	}

	@Override
	public List<Schedule> searchScheduledFlights(Search search) {
		// TODO Auto-generated method stub
		return userDao.searchScheduledFlights(search);
	}
	@Override
	public List<Object>userNamesService()
	{
		List<Object> list=userDao.userNames();
		return list;
	}

	@Override
	public List<Object> userEmailService() {
		List<Object> list=userDao.userEmail();
		return list;
	}

	@Override
	public List<Object> userPhoneService() {
		List<Object> list=userDao.userPhone();
		return list;
	}

	@Override
	public int validateLogin(String userName, String password) {
		return userDao.validateLogin(userName, password);
	}

	@Override
	public Users userLoginService(Users user1) {
		return userDao.userLogin(user1);
	}

	@Override
	public Users LoginService(String userName, String password) {
		
		return userDao.Login(userName, password);
		
	}

	@Override
	public List<Object> airportListService() {
		
		return userDao.airportList();
	}

}
