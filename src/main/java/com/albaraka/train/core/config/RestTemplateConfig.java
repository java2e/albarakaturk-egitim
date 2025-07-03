package com.albaraka.train.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder,
                                     ClientHttpRequestInterceptor authInterceptor,
                                     DefaultResponseErrorHandler errorHandler) {
        return builder
                //.additionalInterceptors(authInterceptor)
                .errorHandler(errorHandler)
                .build();
    }

    @Bean
    public ClientHttpRequestInterceptor authInterceptor(@Value("${api.auth.token}") String token) {
        return (request, body, execution) -> {
            request.getHeaders().setBearerAuth(token);
            return execution.execute(request, body);
        };
    }

    @Bean
    public DefaultResponseErrorHandler errorHandler() {
        return new DefaultResponseErrorHandler() {

            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                int raw = response.getStatusCode().value();
                return raw >= 400 && raw < 600;
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                String body = StreamUtils.copyToString(response.getBody(), StandardCharsets.UTF_8);
                int status = response.getStatusCode().value();
                throw new RestClientException(
                        String.format("HTTP %d returned error: %s", status, body)
                );
            }

            @Override
            public void handleError(URI url, org.springframework.http.HttpMethod method, ClientHttpResponse response)
                    throws IOException {
                handleError(response);
            }
        };
    }
}