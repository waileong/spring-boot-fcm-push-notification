package io.github.waileong.fcm.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import io.github.waileong.fcm.exception.FcmRestClientException;
import io.github.waileong.fcm.service.domain.FcmMessage;
import io.github.waileong.fcm.service.domain.FcmSendRequest;
import org.springframework.validation.annotation.Validated;

/**
 * Service interface for sending messages through Firebase Cloud Messaging (FCM).
 *
 * @author Wai Leong
 */
@Validated
public interface FcmService {

    /**
     * Sends a message to FCM using the provided request data.
     *
     * @param sendRequest Contains the details of the message to be sent. Must not be null.
     * @return If successful, the response body contains an instance of Message.
     */
    FcmMessage send(@NotNull @Valid FcmSendRequest sendRequest) throws FcmRestClientException;
}
