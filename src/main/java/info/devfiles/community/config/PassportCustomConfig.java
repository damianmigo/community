package info.devfiles.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;

import info.devfiles.community.entities.Profile;
import info.devfiles.community.repositories.CustomUserRepository;
import info.devfiles.passport.config.ModuleConfig;

@Configuration
public class PassportCustomConfig extends ModuleConfig {

	@Override
	@Bean(name="userRepository")
	public CustomUserRepository userRepository() throws Exception {
		MongoRepositoryFactory mongoRepositoryFactory = getMongoRepositoryFactory();
		MongoEntityInformation<Profile, String> metadata = mongoRepositoryFactory.getEntityInformation(Profile.class);
		return new CustomUserRepository(metadata, getMongoTemplate());
	}

}
