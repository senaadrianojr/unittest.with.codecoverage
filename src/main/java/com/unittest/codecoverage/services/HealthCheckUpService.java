package com.unittest.codecoverage.services;

import com.unittest.codecoverage.models.HealthCheckUpResult;
import com.unittest.codecoverage.models.PersonHealthInfo;

public interface HealthCheckUpService {
	
	public HealthCheckUpResult basicCheckUp(PersonHealthInfo healthInfo);

}
