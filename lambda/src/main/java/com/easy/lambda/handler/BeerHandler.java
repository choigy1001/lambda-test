package com.easy.lambda.handler;

import com.easy.lambda.dto.RequestDto;
import com.easy.lambda.dto.ResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BeerHandler implements Function<RequestDto , ResponseDto> {

    private final ObjectMapper objectMapper;

    public BeerHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public ResponseDto apply(RequestDto requestEvent) {
        try {
            if (requestEvent.beerCount() < 0) {
                return new ResponseDto("NO BEER.....", -99);
            }
            return new ResponseDto("NICE BEER", requestEvent.beerCount() + 5);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

