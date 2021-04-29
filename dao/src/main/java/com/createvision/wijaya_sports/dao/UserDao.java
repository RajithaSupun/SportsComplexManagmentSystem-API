package com.createvision.wijaya_sports.dao;
import com.createvision.wijaya_sports.model.User;

public interface UserDao extends AbstractDao<User,Long>{
    User getUserByUsername(String username) throws Exception;
}
