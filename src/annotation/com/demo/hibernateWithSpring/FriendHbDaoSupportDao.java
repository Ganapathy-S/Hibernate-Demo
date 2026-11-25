package annotation.com.demo.hibernateWithSpring;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class FriendHbDaoSupportDao extends HibernateDaoSupport {
	
	public void addFriend(Friend friend){
		getHibernateTemplate().save(friend);
	}
	
	public Friend showFriend(long id){
		return getHibernateTemplate().get(Friend.class, id);
	}
	
	public List showAllFriends(){
		List friends = getHibernateTemplate().find("from Friend");
		return (friends.size() > 0 ? friends : null); 
	}

}
