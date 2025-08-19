package io.github.waileong.fcm.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.waileong.fcm.service.domain.FcmErrorResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;

/**
 * Custom response error handler for the FCM REST client.
 *
 * @author Wai Leong
 **/
public class FcmRestClientResponseErrorHandler extends DefaultResponseErrorHandler {
    private final ObjectMapper objectMapper;

    public FcmRestClientResponseErrorHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Custom error handling method for HTTP responses in the FCM REST client. This method intercepts and processes
     * HTTP responses with 4xx or 5xx status codes, extracting error details and throwing appropriate exceptions.
     *
     * @param response   The {@link ClientHttpResponse} object representing the HTTP response.
     * @param statusCode The {@link HttpStatusCode} of the response.
     * @param url        The {@link URI} of the request, if available (nullable).
     * @param method     The {@link HttpMethod} used for the request, if available (nullable).
     * @throws IOException            If an I/O error occurs during error processing.
     * @throws FcmRestClientException If the response contains client or server errors.
     */
    @Override
    protected void handleError(ClientHttpResponse response, HttpStatusCode statusCode, @Nullable URI url, @Nullable HttpMethod method) throws IOException {
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
            super.handleError(response, statusCode, url, method);
        }
    }
}
