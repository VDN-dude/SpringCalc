package by.tms.mapper;

import by.tms.entity.SessionUser;
import by.tms.entity.User;

public class UserMapper {
    public static SessionUser userToSessionUser(User user){
        SessionUser sessionUser = new SessionUser();
        sessionUser.setId(user.getId());
        sessionUser.setFirstname(user.getFirstname());
        sessionUser.setLastname(user.getLastname());
        sessionUser.setUsername(user.getUsername());
        sessionUser.setEmail(user.getEmail());
        return sessionUser;
    }
}
