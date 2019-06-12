package com.plot.socialnetwork.domain.jpa;

import javax.persistence.AttributeConverter;

import com.plot.socialnetwork.domain.Gender;

public class GenderConverter implements AttributeConverter<Gender, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Gender gender) {
		if (gender == null)
			return null;
		return gender.getId();
	}

	@Override
	public Gender convertToEntityAttribute(Integer id) {
		return Gender.getGender(id);
	}

}