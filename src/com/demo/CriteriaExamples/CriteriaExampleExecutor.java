package com.demo.CriteriaExamples;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.demo.util.HibernateUtil;

public class CriteriaExampleExecutor {

	/**
	 * @author Augustine
	 * This class will explain hibernate Criteria
	 */
	public static void main(String[] args) {
		//Persist Employee objects
		persistEmployee();

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("*************Getting all the instance of a class ********************");
		Criteria criteria = session.createCriteria(Employee.class);
		List critList = criteria.list();
		for(Object objList: critList)
			System.out.println("Employee Name is "+ ((Employee)objList).getEmpName());

		System.out.println("**********Limiting the number of rows returning (Useful for pagination)**************");
		criteria = session.createCriteria(Employee.class).setMaxResults(2);
		critList = criteria.list();
		System.out.println("Number of rows returned "+ critList.size());
		for(Object objList: critList)
			System.out.println("Employee Name is "+ ((Employee)objList).getEmpName());


		System.out.println("**********Narrowing the Result Set ***************************");		
		criteria = session.createCriteria(Employee.class).add(Restrictions.like("empName", "Ana%"));
		critList = criteria.list();
		for(Object objList: critList)
			System.out.println("Employee Name is "+ ((Employee)objList).getEmpName());

		criteria = session.createCriteria(Employee.class).add(Restrictions.between("salary", new Integer(23000), new Integer(28000)));
		critList = criteria.list();
		for(Object objList: critList)
			System.out.println("Salary of "+  ((Employee)objList).getEmpName() + " is "+  ((Employee)objList).getSalary());


		criteria = session.createCriteria(Employee.class).add(Restrictions.isNotNull("age")).add(Restrictions.eq("age", new Integer(30)));
		critList = criteria.list();
		for(Object objList: critList)
			System.out.println("Employee Name whose age is 30 is "+ ((Employee)objList).getEmpName());


		System.out.println("******************Ordering the Result **************************");
		criteria = session.createCriteria(Employee.class).addOrder(Order.asc("empName"))
		.addOrder(Order.desc("salary"));
		critList = criteria.list();
		for(Object objList: critList)
			System.out.println("Employee Name is "+ ((Employee)objList).getEmpName() + " Employee Salary is " + ((Employee)objList).getSalary());


		System.out.println("***************Logically grouping the Restriction***************");
		System.out.println("*********Employees whose salary is more than 23000 or whose age is greater than or equal to 30 **************");
		criteria = session.createCriteria(Employee.class).add(Restrictions.or(
				Restrictions.gt("salary", new Integer(23000)), Restrictions.ge("age", new Integer(30))));
		critList = criteria.list();
		for(Object objList: critList)
			System.out.println("Employee Name salary is more than 23000 or whose age is greater than or equal to 30 is "+ ((Employee)objList).getEmpName());


		System.out.println("*************Aggregate Function ******************");
		//Aggregate functions are available in org.hibernate.criterion.Projections class
		critList = session.createCriteria(Employee.class).setProjection(Projections.max("salary")).list();
		System.out.println("Maximum salary is "+ critList.get(0));
		critList = session.createCriteria(Employee.class).setProjection(Projections.min("salary")).list();
		System.out.println("Minimum salary is "+ critList.get(0));
		critList = session.createCriteria(Employee.class).setProjection(Projections.rowCount()).list();
		System.out.println("Total employees "+ critList.get(0));
		critList = session.createCriteria(Employee.class).setProjection(Projections.avg("age")).list();
		System.out.println("Average employee age "+ critList.get(0));
		critList = session.createCriteria(Employee.class).setProjection(Projections.sum("salary")).list();
		System.out.println("Sum of all the salaries "+ critList.get(0));


		tx.commit();
		session.close();
		HibernateUtil.shutdown();
		System.out.println("-------------Done------------");
	}

	private static void persistEmployee(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Employee emp = null;
		String [] empNames = {"Rajesh", "Anand", "Chandra"};
		int [] empAges = {30,32,29};
		int [] empSalaries = {25000,30000,22000};

		for(int i=0; i<3; i++){
			emp = new Employee();
			emp.setEmpName(empNames[i]);
			emp.setAge(empAges[i]);
			emp.setSalary(empSalaries[i]);
			session.save(emp);
		}
		tx.commit();
		session.close();
		HibernateUtil.shutdown();
	}
}
