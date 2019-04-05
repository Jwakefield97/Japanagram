package japanagram.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import japanagram.dao.dao.UserDao;
import japanagram.dao.domain.User;
import japanagram.dao.mappers.UserMapper;

@Repository
public class UserDaoImpl implements UserDao {
	
  @Autowired
  JdbcTemplate jdbcTemplate;

  
  	final static String GET_USERS = "SELECT * FROM user";
	@Override
	public List<User> getUsers() {
		return jdbcTemplate.query(GET_USERS, new UserMapper());
	}
  
} 