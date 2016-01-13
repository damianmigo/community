package info.devfiles.community.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import com.mongodb.MongoClient;

import info.devfiles.community.entities.Article;
import info.devfiles.community.web.forms.SignUpFormValidator;

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
	
	@Bean
	public MongoRepositoryFactory mongoRepositoryFactory() throws Exception {
		return new MongoRepositoryFactory(mongoTemplate());
	}
	
	@Bean
	public SignUpFormValidator signUpFormValidator() {
		return new SignUpFormValidator();
	}
	
	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	}
	
	@Bean(name="articleRepository")
	public SimpleMongoRepository<Article, String> userRepository() throws Exception {
		MongoRepositoryFactory mongoRepositoryFactory = mongoRepositoryFactory();
		MongoEntityInformation<Article, String> metadata = mongoRepositoryFactory.getEntityInformation(Article.class);
		return new SimpleMongoRepository<Article, String>(metadata, mongoTemplate());
	}
	
}
