package com.ubs.assesment.nitin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

	/** The id user. */
	private Integer idUser;

	private Integer idRole;

	/** The roleDescription. */
	private String roleDescription;

}
