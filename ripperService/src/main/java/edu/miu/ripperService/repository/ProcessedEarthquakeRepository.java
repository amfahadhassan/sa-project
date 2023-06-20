package edu.miu.ripperService.repository;

import edu.miu.ripperService.domain.ProcessedEarthquake;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessedEarthquakeRepository extends MongoRepository<ProcessedEarthquake, String> {
}
