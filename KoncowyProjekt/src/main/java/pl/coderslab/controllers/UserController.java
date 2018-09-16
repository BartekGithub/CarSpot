package pl.coderslab.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.entities.Car;
import pl.coderslab.entities.User;
import pl.coderslab.repositories.CarRepository;
import pl.coderslab.repositories.UserRepository;



@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
    CarRepository carRepository;

	@Autowired
	Validator validator;

	@GetMapping("/userReg")
	public String addUserForm(Model model) {
		model.addAttribute("user", new User());

		return "addUser";
	}

	@PostMapping("/userReg")
	public String addUser(@Valid User user, BindingResult result,Model model,HttpSession session) {
		if (result.hasErrors()) {

			return "addUser";


		}else {
			try {

				user.setSalt(BCrypt.gensalt());
				String password = BCrypt.hashpw(user.getPassword(), user.getSalt());
				user.setPassword(password);
				userRepository.save(user);
			}catch(JpaSystemException e) {
				model.addAttribute("user", new User());
				return "addUser";
			}

			session.setAttribute("user", user);
			return "redirect:/userLog";
		}
	}

	@GetMapping("/userLog")
	public String loggUserForm(Model model) {
		model.addAttribute("user", new User());

		return "logUser";
	}

	@PostMapping("/userLog")
	public String loggUser(@Valid User user, BindingResult result,Model model,HttpSession session) {
		List<User> users = userRepository.findAll();
		for(User userLog:users) {
			if(user.getUsername().equals(userLog.getUsername())&&BCrypt.checkpw(user.getPassword(),userLog.getPassword())){
				session.setAttribute("user", userLog.getId());
				session.setAttribute("username", userLog.getUsername());
				return "mainPage";
			}

			}

		return "redirect:/userLog";

		}

	@RequestMapping(value="/mainPage")
	public String loggUser1(Model model,HttpSession session) {
		model.addAttribute("user",session.getAttribute("user"));

		return "mainPage";
	}

	@RequestMapping(value="/logOut")
	public String logOut(Model model,HttpSession session) {
		model.addAttribute("user", new User());
		session.removeAttribute("user");
		session.removeAttribute("username");

		return "redirect:/userReg";
	}

	}
