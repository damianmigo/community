package info.devfiles.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import info.devfiles.community.entities.Profile;
import info.devfiles.passport.config.ModuleConfig;
import info.devfiles.passport.entities.User;

@Configuration
public class PassportCustomConfig extends ModuleConfig {

	@Override
	@Bean(name="userRepository")
	public SimpleMongoRepository<? extends User, String> userRepository() throws Exception {
		MongoRepositoryFactory mongoRepositoryFactory = mongoRepositoryFactory();
		MongoEntityInformation<Profile, String> metadata = mongoRepositoryFactory.getEntityInformation(Profile.class);
		return new SimpleMongoRepository<Profile, String>(metadata, getMongoTemplate());
	}

}
