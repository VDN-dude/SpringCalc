package by.tms.mapper;

import by.tms.dto.RegUserDto;
import by.tms.entity.User;

public class RegUserDTOMapper {
    public static User RegUserToUser(RegUserDto regUserDto){
        User user = new User();
        user.setFirstname(regUserDto.getFirstname());
        user.setLastname(regUserDto.getLastname());
        user.setUsername(regUserDto.getUsername());
        user.setEmail(regUserDto.getEmail());
        user.setPassword(regUserDto.getPassword());
        return user;
    }
}
