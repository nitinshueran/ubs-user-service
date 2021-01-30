package com.ubs.assesment.nitin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDTO {

	private Integer idProperty;

	private Integer idItem;

	private String name;

	private String value;

}
