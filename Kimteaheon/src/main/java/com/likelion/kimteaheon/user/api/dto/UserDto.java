package com.likelion.kimteaheon.user.api.dto;

import com.likelion.kimteaheon.user.domain.User;
import lombok.Builder;

@Builder
public record UserDto(
        Long id,
        String name,
        String email
) {

    public static UserDto toDto(User user) {
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
        return userDto;
    }
}
