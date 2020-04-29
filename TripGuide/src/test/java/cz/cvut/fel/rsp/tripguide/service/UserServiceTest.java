package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.Generator;
import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserServiceTest {

    @Autowired
    public UserService userService;

    @Test
    public void regUserTest() {
        User createdUser = userService.regUser(Generator.generateUserDto());
        assertNotNull(createdUser);

        assertNotNull(userService.findUser(createdUser.getId()));
    }

    @Test
    public void getUserTest() {
        User user = userService.regUser(Generator.generateUserDto());
        TestCase.assertNotNull(user);
        User get = userService.findUser(user.getId());
        assertEquals(user, get);
    }

    @Test(expected = NotFoundException.class)
    public void deleteUserByIdTest() {

        User user = userService.regUser(Generator.generateUserDto());
        int userId = user.getId();

        assertNotNull(user);

        userService.remove(userId);
        userService.findUser(userId);
    }

    @Test(expected = NotFoundException.class)
    public void deleteUserTest() {
        User user = userService.regUser(Generator.generateUserDto());

        userService.remove(user);

        userService.findUser(user.getId());
    }
}
