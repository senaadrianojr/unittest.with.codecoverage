package com.unittest.codecoverage.models;

public class HealthCheckUpResult {
	
	private double pam;
	
	public HealthCheckUpResult(double pam) {
		this.pam = pam;
	}
	
	public BloodPressure bloodPressure() {
		return this.pam > 140 ? BloodPressure.HIGH : this.pam < 100 ? BloodPressure.LOW : BloodPressure.NORMAL;
	}

}
