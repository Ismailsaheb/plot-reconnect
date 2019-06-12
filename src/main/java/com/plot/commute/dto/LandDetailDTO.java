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
public class LandDetailDTO implements Serializable {

	private static final long serialVersionUID = -5294864378288160670L;
	private Long id;
	private Long ventureId;
	private String ventureName;
	private Long sarveyDetailId;
	private String ownerName;
	private String documentId;
	private String phoneNumber;
	private String email;

}
