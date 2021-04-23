package com.security.springsecurityinauth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
   
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/home")
	public String homeModule() {
		log.info("Entered HomeController :: homeModule()");
		return "HomePage";  //Home page for External/All Users
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		log.info("Entered HomeController :: welcome()");
		return "WelcomePage"; //Welcome page for Internal/Company Users
	}
	
	@GetMapping("/dashboard")
	public String  dashboard(){
		log.info("Entered HomeController :: dashboard()");
		return "DashboardPage"; //Dash-board page for Internal/Company Users
	}
	
	@GetMapping("/admin")
	public String adminModule() {
		log.info("Entered HomeController :: adminModule()");
		return "AdminPage";//Admin page for admin users only
	}
	
	@GetMapping("/employee")
	public String EmployeeModule() {
		return "EmployeePage";//Employee page for Employees & admin users only
	}
	
	@GetMapping("/user")
	public String userModule() {
		return "UserPage";//User page for admin users only
	}
	
	@GetMapping("/customer")
	public String customerModule() {
		return "CustomerPage";//Customer page for Internal & admin users only
	}
	
	@GetMapping("/denied")
	public String denied() {
		return "deniedPage";//Un-authorized persons
	}
	
}
