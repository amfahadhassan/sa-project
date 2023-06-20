package edu.miu.ripperService.services;

import edu.miu.ripperService.domain.ProcessedEarthquake;

public interface ProcessedEarthquakeService {
    ProcessedEarthquake findById(String id);
    ProcessedEarthquake save(ProcessedEarthquake processedEarthquake);
}