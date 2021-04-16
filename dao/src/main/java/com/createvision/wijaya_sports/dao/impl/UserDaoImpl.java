package com.createvision.wijaya_sports.dao.impl;
import com.createvision.wijaya_sports.dao.UserDao;
import com.createvision.wijaya_sports.model.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends AbstractDaoImpl<User, Long> implements UserDao {
}
