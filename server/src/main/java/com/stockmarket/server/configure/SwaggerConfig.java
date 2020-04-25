package com.stockmarket.server.configure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/6-6:15 PM
 */
@Configuration
@ConditionalOnProperty(prefix = "swagger",value = {"enable"},havingValue = "true")
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        ticketPar.name("Authorization").description("access_token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(ticketPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.stockmarket.server.rest"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(pars);
    }

    /**
     * url：http://{projectUrl}/swagger-ui.html
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Server API")
                .contact(new Contact("Dai Fei Long","https://github.com/daifeil","daifeil@163.com"))
                .description("Server API")
                .version("1.0")
                .build();
    }
}
