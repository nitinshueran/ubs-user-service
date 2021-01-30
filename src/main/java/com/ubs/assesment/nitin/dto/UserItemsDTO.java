package com.ubs.assesment.nitin.dto;

import java.util.List;

import com.ubs.assesment.nitin.entity.Item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserItemsDTO {

	/** The id user. */
	private Integer idUser;

	/** The username. */
	private String username;

	private List<Item> item;

}
