package com.albaraka.train.core.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// RestClientService.java
@Service
public class RestClientService {

    private final RestTemplate restTemplate;

    public RestClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * En yaygın kullanılan exchange metodu.
     *
     * @param url           Çağrılacak tam URL
     * @param method        HTTP Method (GET, POST, PUT, DELETE…)
     * @param requestBody   Gönderilecek body (null olabilir)
     * @param responseType  Beklenen dönüş tipi
     * @param <T>           Request tipi
     * @param <R>           Response tipi
     * @return              Deserialized response gövdesi
     */
    public <T,R> R execute(
            String url,
            HttpMethod method,
            T requestBody,
            Class<R> responseType) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<T> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<R> resp = restTemplate.exchange(url, method, entity, responseType);

        return resp.getBody();
    }

    /** POST için kısayol */
    public <T,R> R post(String url, T body, Class<R> responseType) {
        return execute(url, HttpMethod.POST, body, responseType);
    }

    /** GET için kısayol */
    public <R> R get(String url, Class<R> responseType) {
        return execute(url, HttpMethod.GET, null, responseType);
    }

    // PUT, DELETE… ihtiyaca göre ekleyin
}

/**
 * Neler kazandık?
 * Tek Noktadan Yönetim
 *
 * Auth token, error handler ve Content-Type header’ı tek bir konfigürasyonda.
 *
 * Tek İmza
 *
 * execute(url, method, body, responseType) ile tüm HTTP metodlarını tek bir yerde topladınız.
 *
 * Hata Yönetimi
 *
 * 4xx/5xx tüm durumlar RestClientException olarak fırlatılır; global @RestControllerAdvice’ınız bu exception’ları yakalayabilir.
 *
 * Kolay Genişletme
 *
 * Başka interceptor’lar (logging, tracing) veya retry mekanizması eklemek çok basit.
 *
 * Bu mimariyle dış servis çağrılarınızı olabildiğince DRY, test edilebilir ve merkezi bir noktadan yönetilebilir hale getirmiş olursunuz.
 */
