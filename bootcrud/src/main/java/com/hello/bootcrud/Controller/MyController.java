package com.hello.bootcrud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hello.bootcrud.Service.UserService;
import com.hello.bootcrud.model.User;
 
@Controller
public class MyController {
	
	@Autowired
	private UserService  userService;
	
	
	// Normal home page
	@GetMapping("/")
	public String Home()
	{
		return "home";
	}
	//   listing all the Users in a new Page.
	@GetMapping("/manage")
	public String ManageTheUsersList(Model m)
	{
		List<User> findAllUsers = this.userService.findAllUsers();
		m.addAttribute("ListUser", findAllUsers);
		 m.addAttribute("title","User Management System");
		return "manageForm";
	}
	
	
	//  Show Add new User page
	@GetMapping("/addnewuser")
	public String addnewuser(Model m)
	{
		m.addAttribute("user", new User());
		 m.addAttribute("title","User Management System");
		return "addForm";
	} 
	
	
	// save the Data from Add new User page
	@PostMapping("/saveaddeduser")
	public String addnewuser(@ModelAttribute("user") User user, Model m, RedirectAttributes ra)
	{
		this.userService.addUser(user);
		m.addAttribute("user", user);
		ra.addFlashAttribute("message","successfully submitted");
		System.out.println(user);
		 m.addAttribute("title","User Management System");
		return "redirect:/manage";
	}
	
	
	//updateOrSave User
	@GetMapping("/update/{id}")
	public String  updateOrSave(@PathVariable("id") int id, Model m)
	{
	 User user = this.userService.get(id);
	 m.addAttribute("user",user);
	 m.addAttribute("title","User Management System");
		return "editForm";
	}
	
	//delete by id
	@GetMapping("/delete/{id}")
	public String  delete(@PathVariable("id") int id)
	{
		this.userService.delete(id);
		return "redirect:/manage";
	}
	
}
