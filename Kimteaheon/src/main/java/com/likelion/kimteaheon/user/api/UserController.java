package com.likelion.kimteaheon.user.api;

import com.likelion.kimteaheon.user.api.dto.UserDto;
import com.likelion.kimteaheon.user.application.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping()
    public void save(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @GetMapping()
    public List<UserDto> findAllItem() {
        return userService.findAllUsers();
    }

    @PatchMapping("/{id}")
    public void updateItemById(@PathVariable Long id, @RequestBody UserDto userDto) {
        userService.updateUserById(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
