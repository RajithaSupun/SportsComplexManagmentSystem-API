package com.createvision.wijaya_sports.dao.impl;
import com.createvision.wijaya_sports.dao.UserDao;
import com.createvision.wijaya_sports.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends AbstractDaoImpl<User, Long> implements UserDao {
    @Override
    public User getUserByUsername(String username) throws Exception {
        Criteria criteria= getSession().createCriteria(User.class,"user");
        criteria.add(Restrictions.eq("user.userName",username));
        criteria.setMaxResults(1);
        User user =(User) criteria.uniqueResult();
        return user;
    }
}
