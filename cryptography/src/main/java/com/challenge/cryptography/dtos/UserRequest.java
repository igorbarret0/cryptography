package com.challenge.cryptography.dtos;

import com.challenge.cryptography.entity.User;

public record UserRequest(
        String userDocument,
        String creditCardToken,
        Long value
) {

    public static User toEntity(UserRequest request) {
        return new User(request.userDocument, request.creditCardToken, request.value);
    }

    public static UserResponse toResponse(Long id, Long value) {
        return new UserResponse(value);
    }

}
