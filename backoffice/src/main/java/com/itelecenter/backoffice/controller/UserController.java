package com.itelecenter.backoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itelecenter.backoffice.entity.User;
import com.itelecenter.backoffice.service.TracingUserInfor;
import com.itelecenter.backoffice.service.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {

@Autowired
private UserServiceImpl userServiceImpl;

@Autowired
private TracingUserInfor tracingUserInfor;
	
	@PostMapping("/UserSave")
	public User saveUserData(@RequestBody User user, HttpSession session)
	{
		tracingUserInfor.addPageVisit(session, "UserSave");
		return userServiceImpl.saveUser(user);
	}
	@PostMapping("update")
	public User updateUserData( @RequestBody User user, HttpSession session)
	{
		tracingUserInfor.addPageVisit(session, "update");
		     User user2 = userServiceImpl.findById(user.getId());
		     user2.setEmail(user.getEmail());
		     user2.setUserName(user.getUserName());
		     user2.setMobile(user.getMobile());
		     user2.setPincode(user.getPincode());
		     
		return userServiceImpl.updatePatient(user2);
	}
	@GetMapping("/{id}")
	public String deleteUser(@PathVariable Long id, HttpSession session)
	{
		tracingUserInfor.addPageVisit(session, "id");
		User user = userServiceImpl.findById(id);
		userServiceImpl.deleteConsultation(user);
		return "User is successfully deleted";
	}
	@GetMapping("getAllUsers")
	public List<User> getAllUserData(HttpSession session)
	{
		tracingUserInfor.addPageVisit(session, "getAllUsers");
		return userServiceImpl.findByAll();
	}
	@GetMapping("get/{id}")
	public User getUserDataByid(@PathVariable Long id,HttpSession session)
	{
		tracingUserInfor.addPageVisit(session, "get");
		return userServiceImpl.findById(id);
	}
	
	  @GetMapping("/history")
	    public String history(HttpSession session) {
	     //model.addAttribute("pageVisits", tracingUserInfor.getPageVisits(session));
		  List<String> pageVisitedByUser  =	  tracingUserInfor.getPageVisits(session);
	        return  pageVisitedByUser.toString(); // 
	    }
	
	
}
