package com.ubs.assesment.nitin.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

	private Integer idItem;

	private Integer idUser;

	/** The name. */
	private String name;

	/** The game. */
	private List<String> game;

	/** The expiration date. */
	private LocalDateTime expirationDate;

	/** The quantity. */
	private Integer quantity;

}
