package com.demo.hibernateWithSpring;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class CarHBTemplateDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void saveCar(Car car){
		hibernateTemplate.save(car);
	}
	
	public Car load(long id){
		return hibernateTemplate.load(Car.class, id);
	}
	
	public List showCars(){
		List carList = hibernateTemplate.find("from Car");
		return (List) (carList.size() > 0 ?  carList : null);
	}
}
