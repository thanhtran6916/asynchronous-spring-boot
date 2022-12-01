package com.example.asynchronous.service.async;

import com.example.asynchronous.dto.BaseResponse;
import com.example.asynchronous.service.remote.DogApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class DogAsyncImpl implements DogAsync {

    private final DogApiService dogApiService;

    @Override
    public String callSixApiAsync() {

        CompletableFuture<BaseResponse> response1 = dogApiService.getDog(1);
        CompletableFuture<BaseResponse> response2 = dogApiService.getDog(2);
        CompletableFuture<BaseResponse> response3 = dogApiService.getDog(3);
        CompletableFuture<BaseResponse> response4 = dogApiService.getDog(4);
        CompletableFuture<BaseResponse> response5 = dogApiService.getDog(5);
        CompletableFuture<BaseResponse> response6 = dogApiService.getDog(6);

        CompletableFuture.allOf(response1, response2, response3, response4, response5, response6);

        try {
            return response1.get().getMessage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
