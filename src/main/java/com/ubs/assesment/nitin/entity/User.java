package com.ubs.assesment.nitin.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "user")
public class User {

	/** The id user. */
	@Id
	private Integer idUser;

	/** The username. */
	private String username;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Item> item;

}
