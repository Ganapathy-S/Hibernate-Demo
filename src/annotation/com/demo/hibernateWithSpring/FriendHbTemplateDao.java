package annotation.com.demo.hibernateWithSpring;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class FriendHbTemplateDao {
	
	HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void addFriend(Friend friend){
		hibernateTemplate.save(friend);
	}
	
	public Friend showFriend(long id){
		return hibernateTemplate.get(Friend.class, id);
	}
	
	public List showAllFriends(){
		List friends = hibernateTemplate.find("from Friend");
		return (friends.size() > 0 ? friends : null); 
	}

}
