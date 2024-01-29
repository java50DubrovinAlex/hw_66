package telran.drons.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import telran.drons.dto.DroneDto;
import telran.drons.dto.DroneMedicationDto;
import telran.drons.service.DronesService;

@RestController
@RequestMapping("drones")
@RequiredArgsConstructor
@Slf4j
public class DronesController {
	final DronesService dronesService;
	@PostMapping
	DroneDto registerDrone(@RequestBody @Valid DroneDto droneDto) {
		log.debug("registerDrone: received car data:{}", droneDto);
		return dronesService.registerDrone(droneDto);
	}
	@PostMapping("load")
	DroneMedicationDto loadDrone(DroneMedicationDto dronMedicationDto) {
		log.debug("loadDrone: received dronMedicationDto: {}", dronMedicationDto);
		return dronesService.loadDrone(dronMedicationDto);
	}
}
