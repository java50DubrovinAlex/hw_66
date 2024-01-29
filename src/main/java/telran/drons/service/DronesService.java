package telran.drons.service;

import org.springframework.stereotype.Service;

import telran.drons.dto.DroneDto;
import telran.drons.dto.DroneMedicationDto;
	
public interface DronesService {
	/**
	 * adds new Drone into Database
	 * @param dronDto
	 * @return DronDto for success
	 * @throws DroneIllegalStateException(drone with a given number already exists)
	 */
	DroneDto registerDrone(DroneDto droneDto);
	/**
	 * checks whether a given drone available for loading (state IDEL, battery capacity >= 25%,
	 * weight match )
	 *checks whether a given medication exists
	 *checks whether a given model drone model exists
	 *creates event log with state LOADING and current battery capacity
	 * @param dronMedication
	 * @return DroneMedication for success 
	 * @throws appropriate exception in accordance with the required check 
	 */
	DroneMedicationDto loadDrone(DroneMedicationDto dronMedication); // why not boolean?
}
