package com.bimurto.springfoxdemo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ErrorModel {

    @ApiModelProperty
    String errorCode;
    String errorMessage;
}
