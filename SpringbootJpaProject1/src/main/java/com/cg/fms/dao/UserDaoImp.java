package com.cg.fms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.fms.exception.UserTypeException;
import com.cg.fms.model.Schedule;
import com.cg.fms.model.Search;
import com.cg.fms.model.Users;

@Transactional
@Repository
public class UserDaoImp implements UserDao{
	
	@PersistenceContext
	EntityManager entityManager;
   //This method will store the Userobject in DataBase
	@Override
	public void addUserDao(Users user) {
		entityManager.persist(user);
		
	}
    //This method will fetch all the User info and return a UserList from the Users_Table
	@Override
	public List<Users> viewUsersDao() {
		String Qstr="SELECT user from Users user";
		TypedQuery<Users> query=entityManager.createQuery(Qstr,Users.class);
		return query.getResultList();
	
	}
    //This method will find a UserId by using the method find(name_of_the_class,PrimaryKey)
	@Override
	public Users viewByIdDao(int id) {
		return entityManager.find(Users.class, id);
		
	}
	//This method will find a UserId by using the method find(name_of_the_class,PrimaryKey) and remove method is used to remove the object from dataBase
	@Override
	public void deletebyIdDao(int id) {
		Users user=entityManager.find(Users.class, id);
		entityManager.remove(user);
		entityManager.flush();
		
	}
	//This method will find a UserId by using the method find(name_of_the_class,PrimaryKey) and update the User with the UserObject
	@Override
	public Users updateDao(int userId,Users user) {
		Users user1=entityManager.find(Users.class, userId);
		user1.setUserName(user.getUserName());
		user1.setPassword(user.getPassword());
		user1.setEmail(user.getEmail());
		user1.setPhone(user.getPhone());
		user1.setUserId(user.getUserId());
		user1.setUserType(user.getUserType());
		entityManager.persist(user1);
		return user1;
		
	}

      //this method will find the Scheduled Flight by DeparturTime,
	//sourceAirport and destinationAirport and Return a Schedule List 
	   @Override
	    public List<Schedule> searchScheduledFlights(Search search) {

			String str = "SELECT schedule from Schedule schedule WHERE :dDate=schedule.DepartureTime OR :sAirport=schedule.sourceAirport AND :dAirport=schedule.destinationAirport";
			TypedQuery<Schedule> query = entityManager.createQuery(str, Schedule.class);
			query.setParameter("dDate", search.DeparturTime);
			query.setParameter("sAirport", search.sourceAirport);
			query.setParameter("dAirport", search.destinationAirport);
			List<Schedule> list = query.getResultList();
			return list;

	}
	   @Override
	   public List<Object>userNames()
	   {
		   String Qstr="SELECT userName FROM Users user";
		   TypedQuery<Object> query=entityManager.createQuery(Qstr,Object.class);
		   List<Object> list=query.getResultList();
		   return list;
	   }
	   @Override
	   public List<Object>userEmail()
	   {
		   String Qstr="SELECT email FROM Users user";
		   TypedQuery<Object> query=entityManager.createQuery(Qstr,Object.class);
		   List<Object> list=query.getResultList();
		   return list;
	   }
	   @Override
	   public List<Object>userPhone()
	   {
		   String Qstr="SELECT phone FROM Users user";
		   TypedQuery<Object> query=entityManager.createQuery(Qstr,Object.class);
		   List<Object> list=query.getResultList();
		   return list;
	   }
	@Override
	public int validateLogin(String userName, String password) {
		 List<Users> passList = new ArrayList();
		 String Qstr="SELECT user FROM Users user WHERE user.userName=:name ";
		 TypedQuery<Users> query = entityManager.createQuery(Qstr,Users.class);
		 query.setParameter("name",userName);
		 passList = query.getResultList();
		 if(passList.size()>0)
		 {
			 if(passList.get(0).getPassword().equals(password) && passList.get(0).getUserType().equals("Customer") )
				 return 1;
			 else if(passList.get(0).getPassword().equals(password) && passList.get(0).getUserType().equals("Admin") )
				 return 2;
			 else 
				 return 0;	 
		 }
		 else
			return 0;
	}
	@Override
	public Users userLogin(Users user1) {
		String Qstr="SELECT user from Users user WHERE :name=user.userName AND :pass=user.password";
		TypedQuery<Users> query=entityManager.createQuery(Qstr,Users.class);
		query.setParameter("name",user1.getUserName());
		query.setParameter("pass",user1.getPassword());
		try
		{
			return query.getSingleResult();
		}
		catch(Exception e)
		{
			return null;
		}
		
	}
	@Override
	public Users Login(String userName, String password) {
		String Qstr="SELECT user from Users user WHERE :name=user.userName AND :pass=user.password";
		TypedQuery<Users> query=entityManager.createQuery(Qstr,Users.class);
		query.setParameter("name",userName);
		query.setParameter("pass",password);
		try
		{
			return query.getSingleResult();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@Override
	public List<Object> airportList() {
		   String Qstr="SELECT AirportCode FROM Airport airport";
		   TypedQuery<Object> query=entityManager.createQuery(Qstr,Object.class);
		   List<Object> list=query.getResultList();
		   return list;
	}
	   
	   



}
