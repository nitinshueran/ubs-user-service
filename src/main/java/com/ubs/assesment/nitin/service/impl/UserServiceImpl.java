package com.ubs.assesment.nitin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubs.assesment.nitin.dto.UserItemsDTO;
import com.ubs.assesment.nitin.entity.User;
import com.ubs.assesment.nitin.repository.ItemRepository;
import com.ubs.assesment.nitin.repository.PropertyRepository;
import com.ubs.assesment.nitin.repository.UserRepository;
import com.ubs.assesment.nitin.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class UserServiceImpl implements all methods in UserService.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PropertyRepository propertyrepository;

	@Autowired
	private ItemRepository itemRepository;

	/**
	 * Gets the user details.
	 *
	 * @param username the username
	 * @return the user details
	 */
	@Override
	public UserItemsDTO getUserDetails(String username) {
		User user = userRepository.findByUsername(username);
		log.info("User: {}", user.toString());
		return UserItemsDTO.builder().idUser(user.getIdUser()).item(user.getItem()).build();
	}

}
