package io.github.waileong.fcm.authentication;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

/**
 * Represents a Firebase Cloud Messaging (FCM) JWT token along with its expiration date. This record is used to
 * encapsulate the token string and its expiry information in a single, immutable data structure. It ensures that
 * the token string is not blank and the expiration date is not null through validation annotations, providing
 * a robust model for handling FCM JWT tokens within the application.
 * <p>
 * The record's immutability and validation constraints help in maintaining the integrity and correctness of
 * token information used for authentication with FCM services.
 *
 * @author Wai Leong
 */
public record FcmJwtToken(
        @NotBlank String token, // The JWT token string, ensured to be non-blank.
        @NotNull Date expireAt   // The expiration date of the token, ensured to be non-null.
) {
}
