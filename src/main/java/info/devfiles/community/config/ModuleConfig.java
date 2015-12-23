package info.devfiles.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

@Configuration
@Import(PassportCustomConfig.class)
public class ModuleConfig {

	@Bean
	public MongoClient mongoClient() throws Exception {
	    return new MongoClient("localhost", 27017);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoClient(), "passport");
	}
	
}
