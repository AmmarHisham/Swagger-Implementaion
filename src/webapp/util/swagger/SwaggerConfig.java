package webapp.util.swagger;

import static springfox.documentation.builders.RequestHandlerSelectors.withMethodAnnotation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket swaggerSpringfoxDocket() {
		ApiInfo apiInfo = new ApiInfoBuilder().title("Rating")
				.description("The Rating microservice presents all the Rating related attributes for the Spots and Plans provided. The Ratings are related to the Primary, Secondary and Corporate Demos associated to the spots.").build();
       
		 List<ResponseMessage> customResponses= new ArrayList<ResponseMessage>();
	       
	        customResponses
			.add(new ResponseMessageBuilder().code(400).message("Invalid parameters passed").build());
	        customResponses.add(new ResponseMessageBuilder().code(500).message("Application Error").build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .useDefaultResponseMessages(true)
                .globalResponseMessage(RequestMethod.POST, 
                		customResponses)
                .genericModelSubstitutes(ResponseEntity.class)
                .forCodeGeneration(true)
                //.ignoredParameterTypes(Pageable.class)
                //.directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .select()
                .apis(withMethodAnnotation(ResponseBody.class))
                .paths(PathSelectors.ant("/rating/**"))
                .build();
    }
	

}