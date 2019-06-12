package com.plot.commute.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_PLOTCMT_LAND_DETAILS")
@ToString
public class LandDetail implements Serializable {

	private static final long serialVersionUID = -8046691739220594590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn
	private Venture venture;
	@ManyToOne
	@JoinColumn
	private SarveyDetail sarveyDetail;
	@Column(name = "OWNER_NAME")
	private String ownerName;
	@Column(name = "DOCUMENT_ID")
	private String documentId;
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	@Column(name = "EMAIL")
	private String email;

}
