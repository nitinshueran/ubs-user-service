package com.ubs.assesment.nitin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ubs.assesment.nitin.config.RolesRightsConfig;
import com.ubs.assesment.nitin.dto.LoginDTO;
import com.ubs.assesment.nitin.entity.HTTPEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class ValidationHelper.
 */
@Component
@Slf4j
public class ValidationHelper {

	/** The http entity. */
	@Autowired
	private HTTPEntity httpEntity;

	@Autowired
	private RolesRightsConfig roleRightConfig;

	/**
	 * Validate mandatory header.
	 *
	 * @param request the request
	 * @return true, if successful
	 */
	public boolean validateMandatoryHeader(HttpServletRequest request) {
		boolean isRequestValid = true;
		String names = request.getHeader("x-ubs-auth-token");
		String userId = request.getHeader("user-id");
		if (null == names || "".equals(names) || null == userId || "".equals(userId)) {
			isRequestValid = false;
		}
		return isRequestValid;
	}

	/**
	 * Validate token.
	 * 
	 * @param string
	 *
	 * @param token  the token
	 * @return the login DTO
	 */
	public void validateToken(HttpServletRequest request, String requiredAccess) {
		String token = request.getHeader("x-ubs-auth-token");
		int userId = Integer.parseInt(request.getHeader("user-id"));
		LoginDTO loginDTO = httpEntity.validateWithExternalAPI(token);
		
		if (null != loginDTO && userId == loginDTO.getIdUser()
				&& roleRightConfig.getAirlineRoleRightMap().get(loginDTO.getIdRole()).contains(requiredAccess)) {
			log.info("User {} is authorized to access the resource", userId);
		}else {
			throw new RuntimeException("You are not authorized to access this api.");
		}
	}

}
