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
public class VentureDTO implements Serializable {

	private static final long serialVersionUID = 4276602594383229178L;
	private Long id;
	private String ventureName;
	private String villageName;
	private Long villageLkpId;

}
