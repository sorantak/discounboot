package com.codepresso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DiscounbootApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(DiscounbootApplication.class, args);
	}

//	@Configuration
//	public class WebConfig implements WebMvcConfigurer {
//
//		@Override
//		public void addCorsMappings(CorsRegistry registry) {
//			registry.addMapping("/**").allowedOrigins("http://localhost:8083", "http://localhost:8080").allowedMethods(
//					HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.PUT.name(), HttpMethod.DELETE.name());
//		}
//	}
	@Configuration
	public class WebConfig implements WebMvcConfigurer {

	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	      // 모든 URI에 대해 http://localhost:18080, http://localhost:8180 도메인은 접근을 허용한다.
	        registry.addMapping("/**")
	                .allowedOrigins("http://localhost:8081","http://localhost:8080");

	    }
	}
	
}
