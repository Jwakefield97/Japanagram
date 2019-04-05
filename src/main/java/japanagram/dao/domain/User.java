package japanagram.dao.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {

	  private static final long serialVersionUID = 4497752119311695765L;
	
	  private String email;
	  
	  private String name;
	  
	  private String username;
	  
	  private String password;
	  
	
	  public User(String name, String email, String username, String password) {
	    this.email = email;
	    this.name = name;
	    this.username = username;
	    this.password = password;
	  }
	  
} 
