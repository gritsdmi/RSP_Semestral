package cz.cvut.fel.rsp.tripguide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class TripGuideApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripGuideApplication.class, args);
	}

	@Bean
	WebMvcConfigurer WebMvcConfigurer() {
		return new WebMvcConfigurerAdapter() {
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/static/**")
						.addResourceLocations("classpath:/static/");
			}
		};
	}

}
