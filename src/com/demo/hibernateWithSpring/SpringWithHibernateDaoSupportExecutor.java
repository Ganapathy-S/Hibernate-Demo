package com.demo.hibernateWithSpring;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SpringWithHibernateDaoSupportExecutor {
	
	
	public static void main(String[] args) {

		String [] carNames = {"Hyndai","Ford","Honda","BMW"};
		int [] prices = {300000,400000,500000,600000};
		Car car = null;
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com/demo/hibernateWithSpring/SpringConfigurationForHibernate.xml"));
		CarHBDaoSupportDao carHbDaoSupport = (CarHBDaoSupportDao) factory.getBean("carDaoSupport");

		//Persisting all the car objects
		for(int i=0; i<carNames.length; i++){
			car = new Car();
			car.setCarName(carNames[i]);
			car.setPrice(prices[i]);
			carHbDaoSupport.saveCar(car);
		}

		//Loading a specific car object
		System.out.println("*****************Showing the specific Car Id***************");
		car = carHbDaoSupport.load(3);
		System.out.println("Car with Id 3 is "+ car.getCarName());
		
		//Loading all the Car objects
		System.out.println("******************Showing all the Cars**********************");
		List carList = carHbDaoSupport.showCars();
		for(Object cars:carList){
			System.out.println("Car Id is "+ ((Car)cars).getId());
			System.out.println("Car Name is "+ ((Car)cars).getCarName());
			System.out.println("Car Price is "+ ((Car)cars).getPrice());
		}

		System.out.println("-----Done-----");
	}

}
