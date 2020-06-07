package com.example.demo1.dto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseDto<T> {

    private HttpStatus statusCode;
    private T data;

    public ResponseDto(HttpStatus statusCode, T data){

        this.statusCode = statusCode;
        this.data = data;
    }

}
