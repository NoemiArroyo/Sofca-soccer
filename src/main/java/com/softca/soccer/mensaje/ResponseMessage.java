package com.softca.soccer.mensaje;

public record ResponseMessage<T> (

        int code,
        String message,
        T data
){

}