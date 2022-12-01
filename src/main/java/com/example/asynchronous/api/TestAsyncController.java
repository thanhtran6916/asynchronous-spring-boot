package com.example.asynchronous.api;

import com.example.asynchronous.dto.BaseResponse;
import com.example.asynchronous.service.async.DogAsync;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestAsyncController {

    private final DogAsync dogAsync;

    @GetMapping
    public ResponseEntity<BaseResponse> asyncGetDog() {
        String result = dogAsync.callSixApiAsync();
        if (Objects.isNull(result)) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        BaseResponse response = BaseResponse.builder()
                .message(result)
                .status("success")
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
