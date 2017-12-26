package com.example.demo.doa;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.UserInfo;

@Repository
public class UserDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public UserInfo getUserInfo(String userName) {
		String sql = "SELECT u.username name, u.password pass, a.authority role FROM "
				+ "comp_users u INNER JOIN comp_authorities a on u.username=a.username WHERE "
				+ "u.enabled =1 and u.username = ?";

		UserInfo user = jdbcTemplate.queryForObject(sql, new Object[] { userName }, new RowMapper<UserInfo>() {
			@Override
			public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserInfo info = new UserInfo();
				info.setPassword(rs.getString("pass"));
				info.setUsername("name");
				info.setRole(rs.getString("role"));
				return info;
			}
		});

		return user;
	}

}
