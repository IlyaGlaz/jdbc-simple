package org.iliaglaz.jdbcsimple.service;

import lombok.Data;
import org.iliaglaz.jdbcsimple.dao.UserDao;
import org.iliaglaz.jdbcsimple.dto.UserCreateDto;
import org.iliaglaz.jdbcsimple.entity.User;

@Data
public class UserService {

    private static final UserService INSTANCE = new UserService();
    private final UserDao userDao = UserDao.getInstance();

    private UserService() {
    }

    public void create(UserCreateDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .country(userDto.getCountry())
                .build();
        userDao.save(user);
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
