package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.Generator;
import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.Message;
import cz.cvut.fel.rsp.tripguide.model.User;
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
public class MessageServiceTest {

    @Autowired
    public MessageService messageService;

    @Autowired
    public UserService userService;

    @Test
    public void addMessageTest() {
        Message message = Generator.generateMessage();
        assertNotNull(messageService.save(message));

        message = Generator.generateMessage();
        User user = userService.save(Generator.generateUser());
        assertNotNull(messageService.addMessage(message, user.getId()));

        user = userService.save(Generator.generateUser());
        message = Generator.generateMessage();
        assertNotNull(messageService.addMessage(message, user));

        user = userService.save(Generator.generateUser());
        message = messageService.save(Generator.generateMessage());
        assertNotNull(messageService.addMessage(message.getId(), user.getId()));

    }

    @Test
    public void getMessageTest() {
        Message message = Generator.generateMessage();
        messageService.save(message);

        assertEquals(message, messageService.findMessage(message.getId()));
    }

    @Test(expected = NotFoundException.class)
    public void removeMessageTest() {
        Message message = Generator.generateMessage();
        messageService.save(message);

        messageService.remove(message);

        messageService.findMessage(message.getId());
    }

}
