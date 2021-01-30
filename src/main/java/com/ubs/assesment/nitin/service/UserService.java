package com.ubs.assesment.nitin.service;

import com.ubs.assesment.nitin.dto.UserItemsDTO;

/**
 * The Class UserService will connect with User repository to fetch user
 * details.
 */
public interface UserService {

	/**
	 * Gets the user details by interacting with the user repository.
	 *
	 * @param username the username
	 * @return the user details
	 */
	UserItemsDTO getUserDetails(String username);
}
