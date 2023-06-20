package sa.miu.RTDIS.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sa.miu.RTDIS.domain.Earthquake;

import java.util.Optional;

@Repository
public interface EarthquakeRepository extends MongoRepository<Earthquake, String> {
}
