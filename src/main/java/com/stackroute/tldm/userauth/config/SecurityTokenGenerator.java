package com.stackroute.tldm.userauth.config;

import java.util.Map;

import com.stackroute.tldm.userauth.model.User;

@FunctionalInterface
public interface SecurityTokenGenerator {
	Map<String, String> generateToken(User user);
}
