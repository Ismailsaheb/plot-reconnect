package com.plot.commute.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "T_PLOTCMT_SARVEY_DETAIL")
@ToString
public class SarveyDetail implements Serializable {

	private static final long serialVersionUID = -5033605671954167242L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String sarvayNo;
	@ManyToOne
	@JoinColumn
	private Venture venture;

	@ManyToOne
	@JoinColumn
	private VillageLkp villageLkp;

	@OneToMany(mappedBy = "sarveyDetail")
	@JsonIgnore
	private List<LandDetail> lands;

}
