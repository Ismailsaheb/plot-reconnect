package com.plot.commute.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.plot.commute.dto.SarveyDetailDTO;
import com.plot.commute.entity.SarveyDetail;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface SarveyDTOMapper {

	SarveyDTOMapper INSTANCE = Mappers.getMapper(SarveyDTOMapper.class);

	@Mappings({ @Mapping(target = "villageLkpId", source = "villageLkp.id"),
			@Mapping(target = "villageName", source = "villageLkp.description"),
			@Mapping(target = "ventureName", source = "venture.ventureName"),
			@Mapping(target = "ventureId", source = "venture.id") })
	SarveyDetailDTO map(SarveyDetail sarveyDetail);

	List<SarveyDetailDTO> mapList(List<SarveyDetail> sarveyDetail);

	@Mappings({ @Mapping(source = "villageLkpId", target = "villageLkp.id"),
			@Mapping(source = "villageName", target = "villageLkp.description"),
			@Mapping(source = "ventureName", target = "venture.ventureName"),
			@Mapping(source = "ventureId", target = "venture.id") })
	SarveyDetail map(SarveyDetailDTO sarveyDetailDTO);

	List<SarveyDetailDTO> map(List<SarveyDetailDTO> sarveyDetailDTO);

}
