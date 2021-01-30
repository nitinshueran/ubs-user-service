package com.ubs.assesment.nitin.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item")
public class Item {

	@Id
	private Integer idItem;

	/** The name. */
	private String name;

	/** The game. */
	private String game;

	/** The expiration date. */
	private LocalDateTime expirationDate;

	/** The quantity. */
	private Integer quantity;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "idItem")
	private List<Property> property;

}
