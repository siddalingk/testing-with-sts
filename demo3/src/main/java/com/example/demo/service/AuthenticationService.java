package com.example.demo.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.bean.UserInfo;
import com.example.demo.doa.UserDao;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo = userDao.getUserInfo(username);
		GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
		UserDetails userDetails = new User(userInfo.getUsername(), userInfo.getPassword(), Arrays.asList(authority));
		return userDetails;
	}

}
