package com.bimurto.springfoxdemo.controller;

import com.bimurto.springfoxdemo.request.SampleRequest;
import com.bimurto.springfoxdemo.response.SampleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "SampleController.")
@RequestMapping(value = "/api")
public class SampleController {

    @ApiOperation(value = "Sample GET REST Api")
    @GetMapping(value = "/test")
    public SampleResponse test(SampleRequest request){
        return null;
    }

    @ApiOperation(value = "Sample POST REST Api")
    @PostMapping(value = "/testPost")
    public SampleResponse testPost(@RequestBody SampleRequest request){
        return null;
    }
}
