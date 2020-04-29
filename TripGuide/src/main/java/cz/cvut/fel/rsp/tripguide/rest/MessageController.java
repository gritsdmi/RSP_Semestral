package cz.cvut.fel.rsp.tripguide.rest;


import cz.cvut.fel.rsp.tripguide.model.Message;
import cz.cvut.fel.rsp.tripguide.model.User;
import cz.cvut.fel.rsp.tripguide.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/message")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    /* ============ */
    /* GET REQUESTS */
    /* ============ */

    @GetMapping(value = "/find/{id}", produces = "application/json")
    public Message find(@PathVariable("id") Integer id) {
        return messageService.findMessage(id);
    }


    /* ============= */
    /* POST REQUESTS */
    /* ============= */

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public Message save(@RequestBody Message message) {
        return messageService.save(message);
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Message add(@RequestBody Message message, @RequestBody User user) {
        return messageService.addMessage(message, user.getId());
    }

    @PostMapping(value = "/add/{userId}", consumes = "application/json", produces = "application/json")
    public Message add(@RequestBody Message message, @PathVariable(name = "userId") Integer userId) {
        return messageService.addMessage(message, userId);
    }


    /* ============ */
    /* PUT REQUESTS */
    /* ============ */
    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public Message update(@RequestBody Message message, @RequestParam(name = "messageId") Integer messageId) {
        return messageService.updateMessage(message, messageId);
    }

    @PutMapping(value = "/add/{messageId}/{userId}", produces = "application/json")
    public Message add(@PathVariable("messageId") Integer messageId, @PathVariable("userId") Integer userId) {
        return messageService.addMessage(messageId, userId);
    }


    /* =============== */
    /* DELETE REQUESTS */
    /* =============== */

    @DeleteMapping(value = "/remove", consumes = "application/json")
    public void remove(@RequestBody Message message) {
        messageService.remove(message);
    }

    @DeleteMapping(value = "/remove/{id}")
    public void remove(@PathVariable("id") Integer id) {
        messageService.remove(id);
    }
}
