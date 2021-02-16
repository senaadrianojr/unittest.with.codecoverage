package com.unittest.codecoverage.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.unittest.codecoverage.models.BloodPressure;
import com.unittest.codecoverage.models.HealthCheckUpResult;
import com.unittest.codecoverage.models.PersonHealthInfo;
import com.unittest.codecoverage.services.HealthCheckUpService;
import com.unittest.codecoverage.services.impl.HealthCheckUpServiceImpl;

public class HealthCheckUpServiceTest {
	
	private HealthCheckUpService healthCheckUpService = new HealthCheckUpServiceImpl();
	
	@Test
	public void testBasicCheckUp_shouldReturnHighBloodPressureWhenPmGreaterThan140() {
		PersonHealthInfo healthInfo = new PersonHealthInfo();
		healthInfo.setPas(90);
		healthInfo.setPad(60);
		HealthCheckUpResult result = healthCheckUpService.basicCheckUp(healthInfo);
		Assertions.assertEquals(BloodPressure.LOW,  result.bloodPressure());
	}
	
	@Test
	public void testBasicCheckUp_shouldReturnLowBloodPressureWhenPmLowerThan100() {
		
	}
	
	@Test
	@DisplayName("[Test basic check up] should return normal boold pressure when PM result is between 100 and 140")
	public void testBasicCheckUpBooldPressureNormal() {
		
	}

}
