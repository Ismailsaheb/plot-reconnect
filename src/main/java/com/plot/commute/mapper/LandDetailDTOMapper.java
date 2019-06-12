package com.plot.commute.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.plot.commute.dto.LandDetailDTO;
import com.plot.commute.entity.LandDetail;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface LandDetailDTOMapper {

	LandDetailDTOMapper INSTANCE = Mappers.getMapper(LandDetailDTOMapper.class);

    @Mappings({
        @Mapping(target="ventureId", source="venture.id"),
        @Mapping(target="sarveyDetailId", source="sarveyDetail.id")
      })
	LandDetailDTO map(LandDetail landDetail);

	 List<LandDetailDTO> mapList(List<LandDetail> landDetail);

    @Mappings({
        @Mapping(source="ventureId", target="venture.id"),
        @Mapping(source="sarveyDetailId", target="sarveyDetail.id")
      })
	 LandDetail map(LandDetailDTO landDetailDTO);

	// List<LandDetail> map(List<LandDetailDTO> landDetailDTO);

}
