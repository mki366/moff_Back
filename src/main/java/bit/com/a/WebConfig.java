package bit.com.a;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
	//	WebMvcConfigurer.super.addCorsMappings(registry);
		
		registry.addMapping("/**").allowedOrigins("http://localhost:8085");		
	}

	
	 @Bean
	    MappingJackson2JsonView jsonView(){
	        return new MappingJackson2JsonView();
	    }

	
	
}




