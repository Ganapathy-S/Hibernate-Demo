package com.demo.hibernateWithSpring;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CarHBDaoSupportDao extends HibernateDaoSupport {

	public void saveCar(Car car){
		getHibernateTemplate().save(car);		
	}
	
	public Car load(long id){
		return getHibernateTemplate().load(Car.class, id);
	}
	
	public List showCars(){
		List carList = getHibernateTemplate().find("from Car");
		return (List) (carList.size() > 0 ?  carList : null);
	}
}
