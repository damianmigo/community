package info.devfiles.community.repositories;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import info.devfiles.community.entities.Profile;

public class CustomUserRepository extends SimpleMongoRepository<Profile, String> {
	
	private final MongoOperations mongoOperations;
	
	private final MongoEntityInformation<Profile, String> entityInformation;
	
	public CustomUserRepository(MongoEntityInformation<Profile, String> entityInformation,
			MongoOperations mongoOperations) {
		super(entityInformation, mongoOperations);
		this.mongoOperations = mongoOperations;
		this.entityInformation = entityInformation;
	}

	public Profile findByEmail(String email) {
		return mongoOperations.findOne(Query.query(Criteria.where("email").is(email)),
				entityInformation.getJavaType(), entityInformation.getCollectionName());
	}
	
	public Profile findByNickname(String nickname) {
		return mongoOperations.findOne(Query.query(Criteria.where("nickname").is(nickname)),
				entityInformation.getJavaType(), entityInformation.getCollectionName());
	}

}
