package japanagram.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import japanagram.dao.dao.UserDao;
import japanagram.dao.domain.User;


@RestController
public class HomeController {
	
	@Autowired 
	UserDao userDao;
	
	
	@RequestMapping("/")
	public List<User> home() {
		
		return userDao.getUsers();
	}

}
