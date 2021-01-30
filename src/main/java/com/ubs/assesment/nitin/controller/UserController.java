package com.ubs.assesment.nitin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.assesment.nitin.dto.UserItemsDTO;
import com.ubs.assesment.nitin.helper.ValidationHelper;
import com.ubs.assesment.nitin.service.UserService;

/**
 * The Class UserController will provide end points to expose user services to
 * clients.
 */
@RestController
@RequestMapping(value = "{application.context-path}")
public class UserController {

	/** The user service. */
	@Autowired
	private UserService userService;

	@Autowired
	private ValidationHelper validationHelper;

	/**
	 * Gets the user details interacting with the service.
	 *
	 * @param username the username
	 * @return the user details
	 */
	@GetMapping(value = "/services/user/{username}")
	public ResponseEntity<UserItemsDTO> getUserDetails(@PathVariable String username,
			final HttpServletRequest request) {
		if (validationHelper.validateMandatoryHeader(request)) {
			validationHelper.validateToken(request, "VIEW");
			return new ResponseEntity<>(userService.getUserDetails(username), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	@GetMapping(value = "/services/users/")
	public ResponseEntity<List<String>> getUsers(final HttpServletRequest request) {
		if (validationHelper.validateMandatoryHeader(request)) {
			validationHelper.validateToken(request, "ADM_VIEW");
			return new ResponseEntity<>(userService.getUserIds(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
