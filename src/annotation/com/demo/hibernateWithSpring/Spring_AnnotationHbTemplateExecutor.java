package annotation.com.demo.hibernateWithSpring;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Spring_AnnotationHbTemplateExecutor {

	public static void main(String[] args) {

		String [] friendNames = {"Arun","Babu","Chandra","Dhana"};
		int [] ages = {26,27,26,29};
		Friend friend = null;
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("annotation/com/demo/hibernateWithSpring/SpringForHibernateAnnotation.xml"));
		FriendHbTemplateDao friendHbTemplate = (FriendHbTemplateDao) factory.getBean("friendHBTemplate");

		//Persisting all the friend objects
		for(int i=0; i<friendNames.length; i++){
			friend = new Friend();
			friend.setName(friendNames[i]);
			friend.setAge(ages[i]);
			friendHbTemplate.addFriend(friend);
		}

		//Loading a specific Friend object
		System.out.println("*****************Showing the specific Friend with specific Id***************");
		friend = friendHbTemplate.showFriend(2);
		System.out.println("Friend with Id 2 is "+ friend.getName());

		//Loading all the Friend objects
		System.out.println("******************Showing all the Friends**********************");
		List friendsList = friendHbTemplate.showAllFriends();
		for(Object friends :friendsList){
			System.out.println("Friend Id is "+ ((Friend)friends).getId());
			System.out.println("Friend Name is "+ ((Friend)friends).getName());
			System.out.println("Friend Age is "+ ((Friend)friends).getAge());
		}

		System.out.println("-----Done-----");
	}
}
