package com.cc.service;

public interface SecurityServiceInterface {
	String findLoggedInUsername();
	
	void autoLogin(String username, String password);
}
