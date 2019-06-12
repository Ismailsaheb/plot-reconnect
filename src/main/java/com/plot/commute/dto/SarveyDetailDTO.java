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
public class SarveyDetailDTO implements Serializable {

	private static final long serialVersionUID = -6156793137123278647L;
	private Long id;
	private String sarvayNo;
	private Long ventureId;
	private String ventureName;
	private Long villageLkpId;
	private String villageName;

}
