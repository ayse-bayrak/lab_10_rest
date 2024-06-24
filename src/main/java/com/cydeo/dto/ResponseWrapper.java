package com.cydeo.dto;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder //= @No + @All --> builder helps to create a multiple type of constructor even remotely, without creating hard code
public class ResponseWrapper {

    private boolean success;
    private String message;
    private Integer code;
    private Object data;
 //we don't need t create any constructor because we use @Builder
    public ResponseWrapper(String message,Object data, Integer code){
        this.message = message;
        this.data=data;
        this.code= code;
        this.success=true;
    }

    public ResponseWrapper(String message, Integer code){
        this.message=message;
        this.code=code;
        this.success=true;
    }


}
