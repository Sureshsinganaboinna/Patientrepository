package com.itc.restclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itc.restclient.entities.UserEntr;
import com.itc.restclient.service.TracingUserInfor;
import com.itc.restclient.service.UserServiceImplll;


import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {

@Autowired
private UserServiceImplll userServiceImpl;

@Autowired
private TracingUserInfor tracingUserInfor;
	
	@PostMapping("/UserSave")
	public UserEntr saveUserData(@RequestBody UserEntr user, HttpSession session)
	{
		System.out.println(user.getEmail());
		tracingUserInfor.addPageVisit(session, "UserSave");
		return userServiceImpl.saveUser(user);
	}
	@PostMapping("update")
	public UserEntr updateUserData( @RequestBody UserEntr user, HttpSession session)
	{
		tracingUserInfor.addPageVisit(session, "update");
		     UserEntr user2 = userServiceImpl.findById(user.getId());
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
		UserEntr user = userServiceImpl.findById(id);
		userServiceImpl.deleteConsultation(user);
		return "User is successfully deleted";
	}
	@GetMapping("getAllUsers")
	public List<UserEntr> getAllUserData(HttpSession session)
	{
		tracingUserInfor.addPageVisit(session, "getAllUsers");
		return userServiceImpl.findByAll();
	}
	@GetMapping("get/{id}")
	public UserEntr getUserDataByid(@PathVariable Long id,HttpSession session)
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
