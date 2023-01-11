package com.example.finalproject.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {
    public final static String CHANNEL= "Каналы";
    public final static  String ORDERS = "Заказы";

    public final static String DAYS = "Дни";
    public final static String DISCOUNT = "Скидка";
    public final static String ORDER_DETAIL="Детали заказа";
    public final static String PRICE = "Цена";
    @Bean
    public Docket apiMonitoramento() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag(CHANNEL, ""))
                .tags(new Tag(ORDERS, ""))
                .tags(new Tag(DAYS, ""))
                .tags(new Tag(DISCOUNT, ""))
                .tags(new Tag(ORDER_DETAIL, ""))
                .tags(new Tag(PRICE, ""))

                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("REST API")
                .description("Размещение рекламы")
                .build();
    }
}
