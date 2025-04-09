package com.likelion.kimteaheon.user.application;

import com.likelion.kimteaheon.user.api.dto.UserDto;
import com.likelion.kimteaheon.user.domain.User;
import com.likelion.kimteaheon.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.likelion.kimteaheon.user.api.dto.UserDto.toDto;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private static Long sequence = 0L;

    public void saveUser(UserDto requestDto) {
        User user = User.builder()
                .id(++sequence)
                .name(requestDto.name())
                .email(requestDto.email())
                .build();

        userRepository.save(user);
    }

    public UserDto findUserById(Long id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new IllegalArgumentException("해당하는 사용자가 없습니다. id = " + id);
        }
        return toDto(user);
    }

    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream()
                .map(UserDto::toDto)
                .collect(Collectors.toList());
    }

    public User updateUserById(Long id, UserDto requestDto) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new IllegalArgumentException("해당하는 사용자가 없습니다. id = " + id);
        }

        user.updateUser(requestDto.name(), requestDto.email());
        userRepository.updateById(id, user);
        return user;
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
