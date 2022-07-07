package cn.zm.knife4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 功能描述: <br>
 * <Knife4j 配置>
 * 每个微服务都集成Swagger的配置
 *
 * @author 十渊
 * @date 2021/10/12 11:23
 * @return
 */
@Configuration
@EnableSwagger2
public class Knife4jConfiguration {
  @Bean(value = "knife4j")
  public static Docket defaultApi2() {
    Docket docket = new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(new ApiInfoBuilder()
        //.title("swagger-bootstrap-ui-demo RESTful APIs")
        .description("# Knife4j swagger-bootstrap-ui RESTful APIs")
        .termsOfServiceUrl("")
        .version("1.0")
        .contact(new Contact("十渊Jermaine", "", "jermainnenee@yeah.net"))
        .build()
      )
      //分组名称
      .groupName("3.0.3")
      .select()
      //这里指定Controller扫描包路径
      // .apis(RequestHandlerSelectors.basePackage("cn.zm"))
      // .apis(RequestHandlerSelectors.any())
      //这里指定Controller扫描包路径
      .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
      // .paths(PathSelectors.any())
      // .paths(PathSelectors.ant("cn.zm"))
      .build();
    return docket;
  }}