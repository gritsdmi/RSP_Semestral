package cz.cvut.fel.rsp.tripguide.rest;

import cz.cvut.fel.rsp.tripguide.dto.UserDto;
import cz.cvut.fel.rsp.tripguide.model.User;
import cz.cvut.fel.rsp.tripguide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /* ============ */
    /* GET REQUESTS */
    /* ============ */

    @GetMapping(value = "/find/{id}", produces = "application/json")
    public User find(@PathVariable("id") Integer id) {
        return userService.findUser(id);
    }

    @GetMapping(value = "/find/{name}", produces = "application/json")
    public User find(@PathVariable("name") String username) {
        return userService.findUser(username);
    }


    /* ============= */
    /* POST REQUESTS */
    /* ============= */

    @PostMapping(value = "/registerUser")
    public User regUser(@RequestBody UserDto user) {
        return userService.regUser(user);
    }

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    /* =============== */
    /* DELETE REQUESTS */
    /* =============== */

    @DeleteMapping(value = "/remove", consumes = "application/json")
    public void remove(@RequestBody User user) {
        userService.remove(user);
    }

    @DeleteMapping(value = "/remove/{id}")
    public void remove(@PathVariable("id") Integer id) {
        userService.remove(id);
    }

}
