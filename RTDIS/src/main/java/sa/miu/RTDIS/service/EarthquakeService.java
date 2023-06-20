package sa.miu.RTDIS.service;

import sa.miu.RTDIS.domain.Earthquake;

public interface EarthquakeService {
    Earthquake findById(String id);
    Earthquake save(Earthquake earthquake);
}
