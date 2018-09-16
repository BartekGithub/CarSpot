package pl.coderslab.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.coderslab.entities.Car;
import pl.coderslab.entities.User;
import pl.coderslab.repositories.CarRepository;
import pl.coderslab.repositories.UserRepository;


@Controller

public class CarController {
	
	@Autowired
	CarRepository carRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/allCars")
	public String allCars(Model model,HttpSession session) {

		List<Car> cars = carRepository.findAll();
		model.addAttribute("cars", cars);
		return "allCars";
	}
	@GetMapping("/findCar")
	public String findcar(Model model,HttpSession session) {
		
		List<Car> cars = new ArrayList<>();
		model.addAttribute("cars", cars);

		return "findCar";
	}

	@PostMapping("/findCar")
	public String findCar(Model model,HttpSession session,@RequestParam String options, @RequestParam String search) {
		
		if(options.equals("Brand")) {
            List<Car> cars = carRepository.findByBrand(search);
            model.addAttribute("cars", cars);
		}else if(options.equals("Model")) {
            List<Car> cars = carRepository.findByModel(search);
            model.addAttribute("cars", cars);
		}else if(options.equals("Place")) {
			List<Car> cars = carRepository.findByCity(search);
			model.addAttribute("cars", cars);
		}

		return "findCar";
	}

	@GetMapping("/addCar")
	public String addCarform(Model model,HttpSession session) {
		Car car = new Car();
		model.addAttribute("car", car);
		return "addCar";
	}

	@PostMapping("/addCar")
	public String addCar(@ModelAttribute Car car) {
		carRepository.save(car);
		return "mainPage";
	}
	

	@GetMapping("/addMyCar/{id}")
	public String addMeCar(Model model,@PathVariable long id,HttpSession session) {
		
		Car car = carRepository.findOne(id);
		User user = userRepository.findOne((Long) session.getAttribute("user")); 
		user.getCars().add(car);
		userRepository.save(user);


		return "redirect:/allCars";
	}

	@GetMapping("/deleteCar/{id}")
	public String deleteCar(Model model,@PathVariable long id,HttpSession session) {
		
		Car car = carRepository.findOne(id);

		carRepository.delete(car);


		return "redirect:/allCars";
	}
	
	@RequestMapping(value="/deleteMyCar/{id}")
	public String deleteMyCar(Model model,@PathVariable long id,HttpSession session) {
		
		Car car = carRepository.findOne(id);
		User user = userRepository.findOne((Long) session.getAttribute("user")); 
		List<Car> allCars=user.getCars();
		allCars.remove(car);

		user.setCars(allCars);
		userRepository.save(user);


		return "redirect:/myCars";
	}
	
	@ModelAttribute("skills")
	public List<String> options() {
	List<String> options = new ArrayList<>();
	options.add("model");
	options.add("brand");
	options.add("city");
	return options;
	}


	@GetMapping("/deleteCar")
	public String deleteCAr(Model model,HttpSession session) {
		Car car = new Car();
		model.addAttribute("car", car);
		return "deleteCar";
	}

	@PostMapping("/deleteCar")
	public String deleteCar(@ModelAttribute Car car) {
		carRepository.delete(car);
		return "mainPage";
	}

}
