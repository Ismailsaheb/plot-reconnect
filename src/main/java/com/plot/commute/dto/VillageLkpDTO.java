package com.plot.commute.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VillageLkpDTO implements Serializable {

	private static final long serialVersionUID = -9154164829754288468L;
	Long id;
	String description;

}