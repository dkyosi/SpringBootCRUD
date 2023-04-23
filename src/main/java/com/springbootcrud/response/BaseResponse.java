package com.springbootcrud.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResponse {

    private int status;
    private Object data;
    private String message;

    public BaseResponse(int status,String message){
        this.status = status;
        this.message = message;
    }
}
