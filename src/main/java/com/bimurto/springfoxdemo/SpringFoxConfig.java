package com.bimurto.springfoxdemo;

import com.bimurto.springfoxdemo.response.ErrorModel;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@EnableSwagger2
@Configuration
public class SpringFoxConfig {
    @Autowired
    TypeResolver typeResolver;

    @Bean
    public Docket api() {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder()
                .code(500)
                .message("500 message")
                .responseModel(new ModelRef("ErrorModel"))
                .build());
        responseMessageList.add(new ResponseMessageBuilder()
                .code(401)
                .message("401 message")
                .responseModel(new ModelRef("ErrorModel"))
                .build());

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bimurto.springfoxdemo"))
                .paths(PathSelectors.any())
                .build()
                .additionalModels(typeResolver.resolve(ErrorModel.class))
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET,responseMessageList)
                .globalResponseMessage(RequestMethod.POST,responseMessageList)
                .globalResponseMessage(RequestMethod.PUT,responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE,responseMessageList)
                ;
    }
}
