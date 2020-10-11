package com.bimurto.springfoxdemo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SampleRequest {
    @ApiModelProperty(value = "Name of something", example = "Shawrup")
    String name;
    @ApiModelProperty(value = "Id of something", example = "1001")
    Long userId;
}
