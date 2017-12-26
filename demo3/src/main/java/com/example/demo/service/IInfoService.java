package com.example.demo.service;

import org.springframework.security.access.prepost.PreAuthorize;

public interface IInfoService {
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public String getMsg();
}
