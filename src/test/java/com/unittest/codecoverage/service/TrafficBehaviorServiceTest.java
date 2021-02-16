package com.unittest.codecoverage.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.unittest.codecoverage.exceptions.BehaviorException;
import com.unittest.codecoverage.models.Footpassenger;
import com.unittest.codecoverage.models.StreetDirectionFlow;
import com.unittest.codecoverage.models.Traffic;
import com.unittest.codecoverage.models.TrafficLigth;
import com.unittest.codecoverage.services.TrafficBehaviorService;
import com.unittest.codecoverage.services.impl.TrafficBehaviorServiceImpl;

public class TrafficBehaviorServiceTest {
	
	private TrafficBehaviorService trafficBehaviorService = new TrafficBehaviorServiceImpl();
	
	@Test
	public void testFootpassengerCrossTheStreet_shouldThrowBehaviorExceptionWhenFootpassengerCrossesTheRoadDuringHeavyTrafficAndWhileTheTrafficLightIsRed() {
	
		Traffic currentTrafic = new Traffic();
		currentTrafic.setIntenseCarTraffic(true);
		
		Footpassenger currentFootpassengerBehavior = new Footpassenger();
		currentFootpassengerBehavior.setCrossedTheRoad(true);
		currentFootpassengerBehavior.setCrossedTrafficLigth(TrafficLigth.RED);
		
		Assertions.assertThatThrownBy(() -> trafficBehaviorService.footpassengerCrossTheStreet(currentTrafic, currentFootpassengerBehavior))
			.isInstanceOf(BehaviorException.class)
			.hasMessageContaining("You should'nt do that, reckless person");
		
	}
	
	@Test
	public void testFootpassengerCrossTheStreet_shouldThrowBehaviorExceptionWhenFootpassengerCrossesTheRoadDuringHeavyTrafficWithoutLookSides() {
	
		Traffic currentTrafic = new Traffic();
		currentTrafic.setIntenseCarTraffic(true);
		
		Footpassenger currentFootpassengerBehavior = new Footpassenger();
		currentFootpassengerBehavior.setCrossedTheRoad(true);
		currentFootpassengerBehavior.setCrossedTrafficLigth(TrafficLigth.GREEN);
		currentFootpassengerBehavior.setLookedToTheLeft(false);
		currentFootpassengerBehavior.setLookedToTheRight(false);
		
		Assertions.assertThatThrownBy(() -> trafficBehaviorService.footpassengerCrossTheStreet(currentTrafic, currentFootpassengerBehavior))
			.isInstanceOf(BehaviorException.class)
			.hasMessage("You should be more careful");
		
	}
	
	@Test
	@DisplayName("One way")
	public void testFootpassengerCrossTheStreet_StreetDirectionFlowOneWay() {
		
		Traffic currentTrafic = new Traffic();
		currentTrafic.setIntenseCarTraffic(true);
		currentTrafic.setStreetDirectionFlow(StreetDirectionFlow.ONE_WAY);
		
		Footpassenger currentFootpassengerBehavior = new Footpassenger();
		currentFootpassengerBehavior.setCrossedTheRoad(true);
		currentFootpassengerBehavior.setCrossedTrafficLigth(TrafficLigth.GREEN);
		currentFootpassengerBehavior.setLookedToTheLeft(false);
		currentFootpassengerBehavior.setLookedToTheRight(false);
		
		Assertions.assertThatThrownBy(() -> trafficBehaviorService.footpassengerCrossTheStreet(currentTrafic, currentFootpassengerBehavior))
			.isInstanceOf(BehaviorException.class)
			.hasMessage("You should be more careful. Look traffic flow. One way.");
		
	}
	
	@Test
	@DisplayName("Two way")
	public void testFootpassengerCrossTheStreet_StreetDirectionFlowTwoWay() {
		
		Traffic currentTrafic = new Traffic();
		currentTrafic.setIntenseCarTraffic(true);
		currentTrafic.setStreetDirectionFlow(StreetDirectionFlow.TWO_WAY);
		
		Footpassenger currentFootpassengerBehavior = new Footpassenger();
		currentFootpassengerBehavior.setCrossedTheRoad(true);
		currentFootpassengerBehavior.setCrossedTrafficLigth(TrafficLigth.GREEN);
		currentFootpassengerBehavior.setLookedToTheLeft(false);
		currentFootpassengerBehavior.setLookedToTheRight(false);
		
		Assertions.assertThatThrownBy(() -> trafficBehaviorService.footpassengerCrossTheStreet(currentTrafic, currentFootpassengerBehavior))
			.isInstanceOf(BehaviorException.class)
			.hasMessage("You should be more careful. Look traffic flow. Two way.");
		
	}
	
	@Test
	@DisplayName("Success")
	public void testFootpassengerCrossTheStreet_CrossWithCaution() {
		
		Traffic currentTrafic = new Traffic();
		currentTrafic.setIntenseCarTraffic(true);
		currentTrafic.setStreetDirectionFlow(StreetDirectionFlow.TWO_WAY);
		
		Footpassenger currentFootpassengerBehavior = new Footpassenger();
		currentFootpassengerBehavior.setCrossedTheRoad(true);
		currentFootpassengerBehavior.setCrossedTrafficLigth(TrafficLigth.GREEN);
		currentFootpassengerBehavior.setLookedToTheLeft(true);
		currentFootpassengerBehavior.setLookedToTheRight(true);
		
		trafficBehaviorService.footpassengerCrossTheStreet(currentTrafic, currentFootpassengerBehavior);
	}
	
	@Test
	@DisplayName("Success 2")
	public void testFootpassengerCrossTheStreet_CrossWithCaution2() {
		
		Traffic currentTrafic = new Traffic();
		currentTrafic.setIntenseCarTraffic(true);
		currentTrafic.setStreetDirectionFlow(StreetDirectionFlow.TWO_WAY);
		
		Footpassenger currentFootpassengerBehavior = new Footpassenger();
		currentFootpassengerBehavior.setCrossedTheRoad(false);
		currentFootpassengerBehavior.setCrossedTrafficLigth(TrafficLigth.RED);
		currentFootpassengerBehavior.setLookedToTheLeft(false);
		currentFootpassengerBehavior.setLookedToTheRight(false);
		
		trafficBehaviorService.footpassengerCrossTheStreet(currentTrafic, currentFootpassengerBehavior);
	}
	
	@Test
	@DisplayName("Success 3")
	public void testFootpassengerCrossTheStreet_CrossWithCaution3() {
		
		Traffic currentTrafic = new Traffic();
		currentTrafic.setIntenseCarTraffic(false);
		currentTrafic.setStreetDirectionFlow(StreetDirectionFlow.TWO_WAY);
		
		Footpassenger currentFootpassengerBehavior = new Footpassenger();
		currentFootpassengerBehavior.setCrossedTheRoad(true);
		currentFootpassengerBehavior.setCrossedTrafficLigth(TrafficLigth.RED);
		currentFootpassengerBehavior.setLookedToTheLeft(false);
		currentFootpassengerBehavior.setLookedToTheRight(false);
		
		trafficBehaviorService.footpassengerCrossTheStreet(currentTrafic, currentFootpassengerBehavior);
	}
	
//	@Test
	@DisplayName("Success 4")
	public void testFootpassengerCrossTheStreet_CrossWithCaution4() {
		
		Traffic currentTrafic = new Traffic();
		currentTrafic.setIntenseCarTraffic(false);
		currentTrafic.setStreetDirectionFlow(StreetDirectionFlow.ONE_WAY);
		
		Footpassenger currentFootpassengerBehavior = new Footpassenger();
		currentFootpassengerBehavior.setCrossedTheRoad(true);
		currentFootpassengerBehavior.setCrossedTrafficLigth(TrafficLigth.RED);
		currentFootpassengerBehavior.setLookedToTheLeft(false);
		currentFootpassengerBehavior.setLookedToTheRight(false);
		
		trafficBehaviorService.footpassengerCrossTheStreet(currentTrafic, currentFootpassengerBehavior);
	}
	
	@Test
	@DisplayName("Success 5")
	public void testFootpassengerCrossTheStreet_CrossWithCaution5() {
		
		Traffic currentTrafic = new Traffic();
		currentTrafic.setIntenseCarTraffic(false);
		currentTrafic.setStreetDirectionFlow(StreetDirectionFlow.TWO_WAY);
		
		Footpassenger currentFootpassengerBehavior = new Footpassenger();
		currentFootpassengerBehavior.setCrossedTheRoad(true);
		currentFootpassengerBehavior.setCrossedTrafficLigth(TrafficLigth.GREEN);
		currentFootpassengerBehavior.setLookedToTheLeft(true);
		currentFootpassengerBehavior.setLookedToTheRight(true);
		
		trafficBehaviorService.footpassengerCrossTheStreet(currentTrafic, currentFootpassengerBehavior);
	}
	
	@Test
	@DisplayName("Success 6")
	public void testFootpassengerCrossTheStreet_CrossWithCaution6() {
		
		Traffic currentTrafic = new Traffic();
		currentTrafic.setIntenseCarTraffic(false);
		currentTrafic.setStreetDirectionFlow(StreetDirectionFlow.TWO_WAY);
		
		Footpassenger currentFootpassengerBehavior = new Footpassenger();
		currentFootpassengerBehavior.setCrossedTheRoad(true);
		currentFootpassengerBehavior.setCrossedTrafficLigth(TrafficLigth.GREEN);
		currentFootpassengerBehavior.setLookedToTheLeft(true);
		currentFootpassengerBehavior.setLookedToTheRight(false);
		
		trafficBehaviorService.footpassengerCrossTheStreet(currentTrafic, currentFootpassengerBehavior);
	}
	
//	@Test
//	@DisplayName("Success 7")
//	public void testFootpassengerCrossTheStreet_CrossWithCaution7() {
//		
//		Traffic currentTrafic = new Traffic();
//		currentTrafic.setIntenseCarTraffic(false);
//		currentTrafic.setStreetDirectionFlow(StreetDirectionFlow.ONE_WAY);
//		
//		Footpassenger currentFootpassengerBehavior = new Footpassenger();
//		currentFootpassengerBehavior.setCrossedTheRoad(true);
//		currentFootpassengerBehavior.setCrossedTrafficLigth(TrafficLigth.GREEN);
//		currentFootpassengerBehavior.setLookedToTheLeft(true);
//		currentFootpassengerBehavior.setLookedToTheRight(false);
//		
//		trafficBehaviorService.footpassengerCrossTheStreet(currentTrafic, currentFootpassengerBehavior);
//	}
	
//	@Test
//	@DisplayName("Success 8")
//	public void testFootpassengerCrossTheStreet_CrossWithCaution8() {
//		
//		Traffic currentTrafic = new Traffic();
//		currentTrafic.setIntenseCarTraffic(false);
//		currentTrafic.setStreetDirectionFlow(StreetDirectionFlow.ONE_WAY);
//		
//		Footpassenger currentFootpassengerBehavior = new Footpassenger();
//		currentFootpassengerBehavior.setCrossedTheRoad(true);
//		currentFootpassengerBehavior.setCrossedTrafficLigth(TrafficLigth.GREEN);
//		currentFootpassengerBehavior.setLookedToTheLeft(false);
//		currentFootpassengerBehavior.setLookedToTheRight(true);
//		
//		trafficBehaviorService.footpassengerCrossTheStreet(currentTrafic, currentFootpassengerBehavior);
//	}
	
	@Test
	@DisplayName("Success 9")
	public void testFootpassengerCrossTheStreet_CrossWithCaution9() {
		
		Traffic currentTrafic = new Traffic();
		currentTrafic.setIntenseCarTraffic(true);
		currentTrafic.setStreetDirectionFlow(StreetDirectionFlow.ONE_WAY);
		
		Footpassenger currentFootpassengerBehavior = new Footpassenger();
		currentFootpassengerBehavior.setCrossedTheRoad(true);
		currentFootpassengerBehavior.setCrossedTrafficLigth(TrafficLigth.GREEN);
		currentFootpassengerBehavior.setLookedToTheRight(true);
		
		trafficBehaviorService.footpassengerCrossTheStreet(currentTrafic, currentFootpassengerBehavior);
	}


}
