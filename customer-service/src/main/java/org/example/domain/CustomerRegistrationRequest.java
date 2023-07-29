package org.example.domain;

public record CustomerRegistrationRequest(
        String name,
        String lastName,
        String email
) {
}
