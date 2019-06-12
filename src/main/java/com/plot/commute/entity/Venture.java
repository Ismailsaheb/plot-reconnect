package com.plot.commute.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plot.socialnetwork.domain.Person;

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
@Table(name = "T_PLOTCMT_VENTURE")
@ToString
public class Venture implements Serializable {

	private static final long serialVersionUID = -1588355216267810804L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "VENTURE_NAME")
	private String ventureName;
	@OneToMany(mappedBy = "venture")
	@JsonIgnore
	private List<SarveyDetail> sarvayDetailsList;

	@ManyToOne
	@JoinColumn
	private VillageLkp villageLkp;

	@OneToMany(mappedBy = "venture")
	@JsonIgnore
	private List<LandDetail> landDetailsList;

	@ManyToMany(mappedBy = "ventures")
	@JsonIgnore
	private List<Person> persons;

	public void setSarvayDetailsList(List<SarveyDetail> sarvayDetailsList) {
		this.sarvayDetailsList = sarvayDetailsList;
	}

	public void addSarvay(SarveyDetail sarveyDetail) {
		if (this.sarvayDetailsList == null) {
			this.sarvayDetailsList = new ArrayList<>();
		}
		this.sarvayDetailsList.add(sarveyDetail);
	}
}
