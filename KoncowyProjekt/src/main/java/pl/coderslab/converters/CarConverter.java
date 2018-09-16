package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.entities.Car;
import pl.coderslab.repositories.CarRepository;



public class CarConverter implements Converter<String, Car> {
	@Autowired
	private CarRepository carRepository;
	
	@Override
	public Car convert(String source) {
	Car car = carRepository.findOne(Long.parseLong(source));
	return car;
	}

}
