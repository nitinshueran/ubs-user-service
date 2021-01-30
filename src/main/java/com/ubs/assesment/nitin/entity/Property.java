package com.ubs.assesment.nitin.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "property")
public class Property {

	/** The id property. */
	@Id
	private Integer idProperty;

	/** The name. */
	private String name;

	/** The value. */
	private String value;

}
