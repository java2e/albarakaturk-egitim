package com.albaraka.train.core.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBusinessService implements CommandLineRunner {

    private final RestClientService client;

    public MyBusinessService(RestClientService client) {
        this.client = client;
    }

    public void doSomething() {
        /*
        // 1) GET örneği
        MyResponseDto resp = client.get("https://api.example.com/data/42", MyResponseDto.class);

        // 2) POST örneği
        MyRequestDto req = new MyRequestDto("foo", 123);
        MyResponseDto created = client.post("https://api.example.com/data", req, MyResponseDto.class);

        // 3) Hata durumunda RestClientException fırlatılır,
        //    global exception handler’ınızda yakalayabilirsiniz.

         */


       List<CategoryDto> categoryDto = client.get("https://dummyjson.com/products/categories",List.class);

        System.out.println(categoryDto);

    }

    @Override
    public void run(String... args) throws Exception {
        doSomething();
    }
}