package com.example.asynchronous.service.remote;

import com.example.asynchronous.dto.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class DogApiService {

    @Async("threadExecutor")
    public CompletableFuture<BaseResponse> getDog(int index) {
        String url = "https://dog.ceo/api/breeds/image/random";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<BaseResponse> response = restTemplate.getForEntity(url, BaseResponse.class);
        log.info(String.valueOf(index));
        return CompletableFuture.completedFuture(response.getBody());
    }
}
