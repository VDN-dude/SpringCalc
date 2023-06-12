package by.tms.service;

import by.tms.dao.HibernateUserDao;
import by.tms.dto.LoginUserDto;
import by.tms.dto.RegUserDto;
import by.tms.entity.SessionUser;
import by.tms.entity.User;
import by.tms.mapper.RegUserDTOMapper;
import by.tms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private HibernateUserDao hibernateUserDao;

    public void save(RegUserDto regUserDto) {
        User user = RegUserDTOMapper.RegUserToUser(regUserDto);
        hibernateUserDao.save(user);
    }

    public Optional<SessionUser> login(LoginUserDto loginUserDto) {
        Optional<User> user = hibernateUserDao.findByEmail(loginUserDto.getEmail());
        if (user.isPresent()) {

            User currentUser = user.get();

            if (currentUser.getPassword().equals(loginUserDto.getPassword())) {
                return Optional.of(UserMapper.userToSessionUser(currentUser));
            }
        }
        return Optional.empty();
    }
}
