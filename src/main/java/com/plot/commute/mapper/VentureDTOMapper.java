package com.plot.commute.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.plot.commute.dto.VentureDTO;
import com.plot.commute.entity.Venture;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface VentureDTOMapper {

	VentureDTOMapper INSTANCE = Mappers.getMapper(VentureDTOMapper.class);

	@Mappings({ @Mapping(target = "villageLkpId", source = "villageLkp.id"),
			@Mapping(target = "villageName", source = "villageLkp.description") })
	VentureDTO map(Venture venture);

	List<VentureDTO> mapToDtoList(List<Venture> venture);

	@Mappings({ @Mapping(source = "villageLkpId", target = "villageLkp.id") })
	Venture map(VentureDTO ventureDTO);

	List<Venture> map(List<VentureDTO> ventureDTO);

}
