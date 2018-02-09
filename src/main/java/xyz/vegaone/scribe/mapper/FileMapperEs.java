package xyz.vegaone.scribe.mapper;

import org.mapstruct.Mapper;
import xyz.vegaone.scribe.domain.FileEs;
import xyz.vegaone.scribe.dto.FileDto;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface FileMapperEs {
    FileDto domainToDto(FileEs fileEs);

    FileEs dtoToDomain(FileDto fileDto);

    List<FileDto> domainToDtoList(List<FileEs> fileEsList);

    List<FileEs> dtoToDomainList(List<FileDto> fileDtoList);
}
