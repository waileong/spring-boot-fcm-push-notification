package io.github.waileong.fcm.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.waileong.fcm.service.domain.FcmErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Custom response error handler for the FCM REST client.
 *
 * @author Wai Leong
 **/
public class FcmRestClientResponseErrorHandler extends DefaultResponseErrorHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ObjectMapper objectMapper;

    public FcmRestClientResponseErrorHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Handles the error in the client HTTP response.
     * <p>
     * This method checks if the response status code indicates a client (4xx) or server (5xx) error and attempts
     * to deserialize the error response body into an {@link FcmErrorResponse} object. If successful, it throws
     * an {@link FcmRestClientException} with the error details. Otherwise, it logs the issue and rethrows
     * a generic {@link FcmRestClientException}.
     * </p>
     *
     * @param response   The client HTTP response with the error.
     * @param statusCode The HTTP status code of the response.
     * @throws IOException If an I/O error occurs.
     */
    @Override
    protected void handleError(ClientHttpResponse response, HttpStatusCode statusCode) throws IOException {
        if (statusCode.is4xxClientError() || statusCode.is5xxServerError()) {
            final String content = new String(getResponseBody(response), StandardCharsets.UTF_8);
            try {
                if (content.isBlank()) {
                    throw new FcmRestClientException(statusCode.value(), content);
                } else {
                    final FcmErrorResponse errorResponse = this.objectMapper.readValue(
                            content, FcmErrorResponse.class);
                    throw new FcmRestClientException(statusCode.value(), errorResponse.getError());
                }
            } catch (JsonProcessingException ex) {
                throw new FcmRestClientException(statusCode.value(), ex.getMessage());
            }
        } else {
            super.handleError(response, statusCode);
        }
    }
}
