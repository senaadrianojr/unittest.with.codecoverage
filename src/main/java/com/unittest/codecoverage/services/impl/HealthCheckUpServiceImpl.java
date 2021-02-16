package com.unittest.codecoverage.services.impl;

import com.unittest.codecoverage.models.HealthCheckUpResult;
import com.unittest.codecoverage.models.PersonHealthInfo;
import com.unittest.codecoverage.services.HealthCheckUpService;

public class HealthCheckUpServiceImpl implements HealthCheckUpService {

	@Override
	public HealthCheckUpResult basicCheckUp(PersonHealthInfo healthInfo) {
		double pam = calculatePam(healthInfo.getPas(), healthInfo.getPad());
		healthInfo.setPam(pam);
		return new HealthCheckUpResult(pam);
	}
	
	private double calculatePam(double pas, double pad) {
		return (1.0/3.0 * pas) + (2.0/3.0 * pad);
	}

}
