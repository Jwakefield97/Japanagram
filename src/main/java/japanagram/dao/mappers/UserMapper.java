package japanagram.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import japanagram.dao.domain.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u = new User();
		u.setEmail(rs.getString("email"));
		u.setName(rs.getString("name"));
		u.setUsername(rs.getString("username"));
		return u;
	}

}
