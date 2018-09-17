package com.stackroute.tldm.userauth.service;

import com.stackroute.tldm.userauth.exception.UserAlreadyExistsException;
import com.stackroute.tldm.userauth.model.User;

public interface UserAuthService {

	public User registerUser(User user) throws  UserAlreadyExistsException;

	public User findUserByEmail(String email);

	public User findUserByUserIdAndPassword(String userId, String password);

}
