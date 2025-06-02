package com.itc.restclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.itc.restclient.entities.Entry;
import com.itc.restclient.entities.User;
import com.itc.restclient.repository.UserRepository;
import com.itc.restclient.service.EntryService;
import com.itc.restclient.service.EntryServiceImpl;
import com.itc.restclient.service.UserService;
import com.itc.restclient.service.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	HttpSession session;

	@Autowired
	private EntryService entryService;

	@GetMapping("home")
	public String homepage() {

		String model = new String("loginpage");

		return model;
	}

	@GetMapping("register")
	public String registrationpage() {

		String model = new String("registrationpage");

		return model;
	}

	@PostMapping(value = "saveuser")
	public String saveuser(@ModelAttribute("user") User user) {
		// code to save the user details in the database

		String model = new String("registersuccess");

		//userService.saveUser(user);

		return model;

	}

	@PostMapping(value = "/authenticate")
	public String authenticateuser(@ModelAttribute("user") User user, Model model) {
		String viewname = "loginpage";

	//	User user1 = userService.findByUsername(user.getUsername());

	/*	if (user1 != null && user.getPassword().equals(user1.getPassword())) {
			viewname = "userhomepage";
			model.addAttribute("user", user1);

			session.setAttribute("user", user1);

			List<Entry> entries = null;

			try {
			//	entries = entryService.findByUserId(user1.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			model.addAttribute("entrieslist", entries);

		}
*/
		return viewname;
	}

	@GetMapping("addentry")
	public String addentry() {
		String model = new String("addentryform");

		return model;
	}

	@PostMapping("saveentry")
	public String saveentry(@ModelAttribute("entry") Entry entry, Model model) {
		String viewname = "userhomepage";

		entryService.saveEntry(entry);

		User user1 = (User) session.getAttribute("user");

		List<Entry> entries = null;

		try {
		//	entries = entryService.findByUserId(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("entrieslist", entries);

		return viewname;
	}

	@GetMapping("viewentry")
	public String viewentry(@RequestParam("id") Long id, Model model) {
		String viewname = "displayentry";

		Entry entry = entryService.findById(id);

		model.addAttribute("entry", entry);

		return viewname;
	}

	@GetMapping("userhome")
	public String userhomepage(Model model) {

		String viewname = "userhomepage";
		User user1 = (User) session.getAttribute("user");

		List<Entry> entries = null;

		try {
		//	entries = entryService.findByUserId(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("entrieslist", entries);

		return viewname;
	}

	@GetMapping("updateentry")
	public String updateentry(@RequestParam("id") Long id, Model model) {
		String viewname = "displayupdateentry";

		Entry entry = entryService.findById(id);

		model.addAttribute("entry", entry);

		User user1 = (User) session.getAttribute("user");

		if (user1 == null)
			viewname = "loginpage";

		return viewname;
	}

	@PostMapping("processentryupdate")
	public String processentryupdate(@ModelAttribute("entry") Entry entry, Model model) {
		String viewname = "userhomepage";

		entryService.updateEntry(entry);

		User user1 = (User) session.getAttribute("user");

		List<Entry> entries = null;

		try {
		//	entries = entryService.findByUserId(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("entrieslist", entries);

		return viewname;
	}

	@GetMapping("deleteentry")
	public String deleteentry(@RequestParam("id") Long id, Model model) {
		String viewname = "userhomepage";

		User user1 = (User) session.getAttribute("user");

		Entry entry = entryService.findById(id);

		if (user1 == null)
			viewname = "loginpage";
		else
			entryService.deleteEntry(entry);

		List<Entry> entries = null;

		try {
		//	entries = entryService.findByUserId(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("entrieslist", entries);

		return viewname;
	}

	@GetMapping("signout")
	public String signout() {

		String model = new String("loginpage");

		session.invalidate();

		return model;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@GetMapping("/homepage")
	public String homePage()
	{
		String viewname = "Homepage";
		return viewname;
	}
	
	@GetMapping("/registor")
	public String registrationPage() {
		
		//String viewname = "registrationpage";
		String view = new String("registrationpage");
	
		return view;
	}
	
	@PostMapping("/saveuser")
	public String postMethodName(@ModelAttribute("user") User user) {
		
		String view = "registrationsucees";
		userServiceImpl.saveUser(user);
		
		return view;
	}
	
	@PostMapping("/authenticate")
	public String userAuthenticate(@ModelAttribute("user") User user, Model model) {

		String view = "loginpage";

		User user1 = userServiceImpl.findByUsername(user.getUsername());

		if (user1 != null && user.getPassword().equals(user1.getPassword())) {

			view = "userhomepage";

			model.addAttribute("user", user1);

			session.setAttribute("user", user1);

			List<Entry> entries = null;

			try {
				entryServiceImpl.findByUserId(user1.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}

			model.addAttribute("entrieslsit", entries);

		}

		return view;
	}
	
	@GetMapping("addentry")
	public String addEntry()
	{
		String view = "addentryform";
		
		return view;
	}
	
	@PostMapping("saveentry")
	public String saveEntry(@ModelAttribute("entry") Entry entry, Model model) {

		String view = "userhomepage";
		entryServiceImpl.saveEntry(entry);

		User user1 = (User) session.getAttribute("user");

		List<Entry> entries = null;

		try {
			entryServiceImpl.findByUserId(user1.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("entrieslsit", entries);

		return view;

	}

	@GetMapping("viewentry")
	public String viewEntry(@PathVariable("id") Long id, Model model) {
		String view = "displayentry";
		Entry entry = entryServiceImpl.findById(id);
		model.addAttribute("entry", entry);
		return view;
	}
	
	@GetMapping("userhome")
	public String userHomePage(Model model) {
		String view = "userhomepage";
		User user1 = (User) session.getAttribute("user");

		List<Entry> entries = null;

		try {
			entryServiceImpl.findByUserId(user1.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("entrieslsit", entries);

		return view;
	}
*/
}
