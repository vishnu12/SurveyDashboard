package com.project.dashboard.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.dashboard.model.Role;
import com.project.dashboard.model.User;
import com.project.dashboard.service.RoleService;
import com.project.dashboard.service.UserService;

@Controller
@RequestMapping("api")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	
	@GetMapping("/users")
	@PreAuthorize("hasAuthority('Admin')")
	public String index(Model model) {
		List<User> users=userService.getUsers();
		model.addAttribute("userlist", users);
		return "users";
	}
	
	@ModelAttribute("user")
	public User userObject() {
		return new User();
	}
	
	
	@GetMapping("/user/register")
	public String register() {
		return "register";
	}
	
	
	@GetMapping("/user/add")
	@PreAuthorize("hasAuthority('Admin')")
	public String getCreateUserPage() {
		return "add-user";
	}
	
	@PostMapping("/user/register")
	public String register(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/api/user/register?success";
	}
	
	@PostMapping("/user/add")
	public String createUserByAdmin(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/";
	}
	
	@GetMapping("/user/edit/{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public String editUser(@PathVariable Long id,Model model) {
		User user=userService.findUserById(id);
		List<Role> roles=roleService.getRoles();
		model.addAttribute("user", user);
		model.addAttribute("listroles", roles);
		return "edit-user";
		
	}
	
	@PostMapping("/user/edit")
	@PreAuthorize("hasAuthority('Admin')")
	public String saveEditedUser(User usr) {
		User user=userService.updateUser(usr);
		return "redirect:/api/users";
	}
}
