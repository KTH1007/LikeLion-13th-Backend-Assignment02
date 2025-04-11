package com.likelion.kimteaheon.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private String email;

    @Builder
    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void updateUser(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
