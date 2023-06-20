package sa.miu.RTDIS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sa.miu.RTDIS.domain.Earthquake;
import sa.miu.RTDIS.repo.EarthquakeRepository;

@Service
public class EarthquakeServiceImpl implements EarthquakeService {
    @Autowired
    private EarthquakeRepository repository;

    @Override
    public Earthquake findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Earthquake save(Earthquake earthquake) {
        return repository.save(earthquake);
    }
}
