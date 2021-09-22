package com.paladin.account.config.convert;

import com.paladin.account.dto.UserDTO;
import com.paladin.account.dto.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "username", target = "name")
    @Mapping(source ="age",target = "ageInfo")
    @Mapping(source ="phoneNum",target = "mobile")
    UserVO userVOToUserDTO(UserDTO userDTO);
}
