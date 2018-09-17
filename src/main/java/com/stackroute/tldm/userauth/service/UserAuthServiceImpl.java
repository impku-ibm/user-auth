package com.stackroute.tldm.userauth.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.tldm.userauth.exception.UserAlreadyExistsException;
import com.stackroute.tldm.userauth.model.User;
import com.stackroute.tldm.userauth.repository.UserAuthRepository;

@Service
public class UserAuthServiceImpl implements UserAuthService {

	private UserAuthRepository userAuth;

	@Autowired
	public UserAuthServiceImpl(UserAuthRepository userAuth) {
		this.userAuth = userAuth;

	}

	@Override
	public User registerUser(User user) throws UserAlreadyExistsException {
		// boolean flag = false;
		String info = user.getUserId();

		try {
			if (!userAuth.existsById(info)
					&& (findUserByEmail(user.getEmail()) == null)) {
				userAuth.save(user);
				return user;
				// flag = true;
			} else {
				throw new UserAlreadyExistsException("User Information already present");
			}

		} catch (NoSuchElementException exception) {
			throw new UserAlreadyExistsException("User Information already present");
		}
	}

	public User findUserByEmail(String email) {
		User info = userAuth.findUserByEmail(email);
		if (info != null) {
			return info;
		} else {
			return null;
		}
	}

	@Override
	public User findUserByUserIdAndPassword(String userId, String password) {
		User fetchedUser = userAuth.findUserByUserIdAndPassword(userId, password);
		return fetchedUser;
	}

}
