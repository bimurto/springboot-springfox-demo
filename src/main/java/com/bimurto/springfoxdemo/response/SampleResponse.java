package com.bimurto.springfoxdemo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SampleResponse {
    @ApiModelProperty(value = "Result of something", example = "Passed")
    String result;
    @ApiModelProperty(value = "Id of result", example = "1001")
    Long resultId;
}
