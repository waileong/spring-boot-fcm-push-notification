package io.github.waileong.fcm.service.impl;

import io.github.waileong.fcm.service.FcmService;
import io.github.waileong.fcm.service.domain.FcmError;
import io.github.waileong.fcm.service.domain.FcmMessage;
import io.github.waileong.fcm.service.domain.FcmSendRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.web.client.RestClient;

/**
 * Implements the {@link FcmService} interface to send messages via Firebase Cloud Messaging (FCM).
 * <p>
 * Uses a {@link RestClient} for HTTP communication with the FCM REST API. The service sends message
 * requests encapsulated in {@link FcmSendRequest} objects and expects responses as {@link FcmMessage} instances.
 * </p>
 * <p>
 * The {@link RegisterReflectionForBinding} annotation is used to ensure that reflection-based access to
 * {@link FcmSendRequest}, {@link FcmMessage}, and {@link FcmError} is available at runtime, particularly
 * necessary for AOT (Ahead-Of-Time) compilation and reflection operations in Spring's native compilation support.
 * </p>
 *
 * @author Wai Leong
 */
@RegisterReflectionForBinding({FcmSendRequest.class, FcmMessage.class, FcmError.class})
public class FcmServiceImpl implements FcmService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final RestClient fcmRestClient;

    public FcmServiceImpl(RestClient fcmRestClient) {
        this.fcmRestClient = fcmRestClient;
    }


    @Override
    public FcmMessage send(FcmSendRequest sendRequest) {
        return this.fcmRestClient.post()
                .body(sendRequest)
                .retrieve()
                .body(FcmMessage.class);
    }
}
