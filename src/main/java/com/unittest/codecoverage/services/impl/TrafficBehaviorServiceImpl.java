package com.unittest.codecoverage.services.impl;

import com.unittest.codecoverage.exceptions.BehaviorException;
import com.unittest.codecoverage.models.Driver;
import com.unittest.codecoverage.models.Footpassenger;
import com.unittest.codecoverage.models.StreetDirectionFlow;
import com.unittest.codecoverage.models.Traffic;
import com.unittest.codecoverage.models.TrafficLigth;
import com.unittest.codecoverage.services.TrafficBehaviorService;

public class TrafficBehaviorServiceImpl implements TrafficBehaviorService {

	@Override
	public void footpassengerCrossTheStreet(Traffic currentTrafic, Footpassenger currentFootpassengerBehavior) {
		
		if(TrafficLigth.RED.equals(currentFootpassengerBehavior.getCrossedTrafficLigth()) && 
				currentFootpassengerBehavior.crossedTheRoad() &&
				currentTrafic.intenseCarTraffic()) {
			throw new BehaviorException("You should'nt do that, reckless person");
		}
		
//		if(TrafficLigth.RED.equals(currentFootpassengerBehavior.getCrossedTrafficLigth()) && 
//				currentFootpassengerBehavior.crossedTheRoad() &&
//				!currentTrafic.intenseCarTraffic() &&
//				(!currentFootpassengerBehavior.lookedToTheLeft() && !currentFootpassengerBehavior.lookedToTheRight())) {
//			throw new BehaviorException("You should be more careful. Look both sides");
//		}
		
		if(TrafficLigth.GREEN.equals(currentFootpassengerBehavior.getCrossedTrafficLigth()) &&
				currentTrafic.intenseCarTraffic() && 
				(StreetDirectionFlow.ONE_WAY.equals(currentTrafic.getStreetDirectionFlow()) &&
						(!currentFootpassengerBehavior.lookedToTheLeft() && !currentFootpassengerBehavior.lookedToTheRight())
				)
		) {
			throw new BehaviorException("You should be more careful. Look traffic flow. One way.");
		}
		
		if(TrafficLigth.GREEN.equals(currentFootpassengerBehavior.getCrossedTrafficLigth()) &&
				currentTrafic.intenseCarTraffic() && 
				(StreetDirectionFlow.TWO_WAY.equals(currentTrafic.getStreetDirectionFlow()) &&
						!currentFootpassengerBehavior.lookedToTheLeft() &&
						!currentFootpassengerBehavior.lookedToTheRight())) {
			throw new BehaviorException("You should be more careful. Look traffic flow. Two way.");
		}
		
		if(TrafficLigth.GREEN.equals(currentFootpassengerBehavior.getCrossedTrafficLigth()) &&
				currentTrafic.intenseCarTraffic() && 
				!currentFootpassengerBehavior.lookedToTheLeft() && 
				!currentFootpassengerBehavior.lookedToTheRight()) {
			throw new BehaviorException("You should be more careful");
		}
		
		
	}

//	@Override
//	public void driverDrivingTheCar(Traffic currentTraffic, Driver currentDriverBehavior) {
//		
//	}

}
