package edu.miu.ripperService.services;

import edu.miu.ripperService.domain.ProcessedEarthquake;
import edu.miu.ripperService.repository.ProcessedEarthquakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessedEarthquakeServiceImpl implements ProcessedEarthquakeService{

    @Autowired
    private ProcessedEarthquakeRepository repository;
    @Override
    public ProcessedEarthquake findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ProcessedEarthquake save(ProcessedEarthquake processedEarthquake) {
        return repository.save(processedEarthquake);
    }
}
