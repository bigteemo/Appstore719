package appstore;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppRepository extends MongoRepository<Appinfo, String> {

	public Appinfo findByAppid(String appid);
	
	public List<Appinfo> findTop20ByOrderByScoreDesc();
	
	public List<Appinfo> findByAppidIn(String[] applist);
	
}