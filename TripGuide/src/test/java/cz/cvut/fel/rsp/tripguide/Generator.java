package cz.cvut.fel.rsp.tripguide;


import cz.cvut.fel.rsp.tripguide.dto.UserDto;
import cz.cvut.fel.rsp.tripguide.model.Role;
import cz.cvut.fel.rsp.tripguide.model.User;

import java.util.Collections;
import java.util.Random;

public class Generator {

    private final static Random random = new Random();
    private static int counter = 0;

    public static int randomInt() {
        return Math.abs(random.nextInt() % 1000);
    }

    public static boolean randomBool() {
        return random.nextBoolean();
    }

    public static User generateUser() {
        UserDto userDto = generateUserDto();
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        user.setRoles(Collections.singleton(Role.TOURIST));
        user.setId(randomInt());

        return user;
    }

    public static UserDto generateUserDto() {
        UserDto user = new UserDto();
        user.setEmail("Email" + ++counter + "@test.com");
        user.setPassword(String.valueOf(randomInt()));
        user.setUsername("user" + counter);
        user.setFullName("fullNameTemplate" + counter);
        return user;
    }
}
