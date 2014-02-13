package com.bandgear.apfree.service;

import com.bandgear.apfree.bean.User;

public interface UserService {
	boolean loginValidate(User u, String dev_id);

	String getUsers(String deviceToken);
	String addUser(User user,String deviceToken);

	String deleteUser(User user,String deviceToken);

	String modifyUser(User user,String deviceToken);

	String activeUser(User user,String deviceToken);
}
