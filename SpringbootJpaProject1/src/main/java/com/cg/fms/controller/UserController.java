package com.cg.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.exception.SearchNotFoundException;
import com.cg.fms.exception.UserTypeException;
import com.cg.fms.model.Search;
import com.cg.fms.model.Users;
import com.cg.fms.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/addUser") //post mapping requestmethod is used to add the data from the Requesting body
	public ResponseEntity<String> saveBook(@RequestBody Users user) {
		userService.addUserService(user);
        
		return new ResponseEntity<String>("User Added",HttpStatus.OK);
	}
	@GetMapping("/getUser") //This method is used to display all the list of users from the dataBase
    public ResponseEntity<List<Users>> getUserslist() {
			List<Users> list =userService.viewUserService();
			return new ResponseEntity<List<Users>>(list,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser/{id}")//This Method is used to delete a User object with its corresponding useeId
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id)
	{
		userService.deletebyIdService(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}
	@GetMapping("/viewbyid/{id}")//This Method is used to View the User by userId
	public ResponseEntity<Users> viewUser(@PathVariable("id") int id)
	{
		Users user=userService.viewByIdService(id);
		return new ResponseEntity<Users>(user,HttpStatus.OK);
	}
	@PutMapping("/updateuser/{id}")//This Method is used to Update the User by userId if User present then it updated otherwise UserNot found message will be displayed
	public ResponseEntity<String> updateUser(@PathVariable("id") int id,@RequestBody Users user)throws UserTypeException
	{
	
		Users user1=userService.updateService(id, user);
		try
		{
			if(user1==null)
			{
				throw new UserTypeException("User Not Found");
			}
			else
				return new ResponseEntity<String>("User Updated",HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
		
	}

    @PostMapping("/search")//This method is used to display the all the Avilable flights from the Schedule Table based on Users request(Source,destination and DepatureTime)
    public ResponseEntity<Object> search(@RequestBody Search search) throws SearchNotFoundException{
    	try {
    	
    	    if(userService.searchScheduledFlights(search).isEmpty())
    	    	 throw new SearchNotFoundException("No Search Results!");
    	    else
    	       return new ResponseEntity<>(userService.searchScheduledFlights(search),HttpStatus.OK);
    	}
    	catch(Exception e)
    	{
    		return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
    	}
    	    
    }
    @GetMapping("/userNames")
    public ResponseEntity<List<Object>> userNames()
    {
    	List<Object> list=userService.userNamesService();
    	return new ResponseEntity<List<Object>>(list,HttpStatus.OK);
    }
    @GetMapping("/userEmail")
    public ResponseEntity<List<Object>> userEmail()
    {
    	List<Object> list=userService.userEmailService();
    	return new ResponseEntity<List<Object>>(list,HttpStatus.OK);
    }
    @GetMapping("/userPhone")
    public ResponseEntity<List<Object>> userPhone()
    {
    	List<Object> list=userService.userPhoneService();
    	return new ResponseEntity<List<Object>>(list,HttpStatus.OK);
    }
    @GetMapping("/airport")
    public ResponseEntity<List<Object>> airportList()
    {
    	List<Object> list=userService.airportListService();
    	return new ResponseEntity<List<Object>>(list,HttpStatus.OK);
    }
    
	@GetMapping("/User/validate/{name}/{password}")
	public int validateLogin(@PathVariable String name,@PathVariable String password)
	{
		return userService.validateLogin(name, password);
	}
	@PostMapping("/userLogin")
	public ResponseEntity<Object> userLogin(@RequestBody Users user1)
	{
		Users user=userService.userLoginService(user1);
		try {
			if(user==null)
			{
				throw new UserTypeException("Please enter Corrrect-Details");
			}
			else
				return new ResponseEntity<Object>(user,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND); 
		}
	}
	@PostMapping("/login/{userName}/{password}")
	public ResponseEntity<Users> logIn(@PathVariable String userName,@PathVariable String password)
	{
		Users user=userService.LoginService(userName, password);
		try {
			if(user==null)
			{
				throw new UserTypeException("Please enter Corrrect-Details");
			}
			else
				return new ResponseEntity<Users>(user,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}

	 }
	
}
    
	
	


