package telran.drons.exception;

import org.springframework.stereotype.Service;

import telran.drons.api.ServiceExceptionMessages;

@SuppressWarnings("serial")
public class DroneNotFoundException extends NotFoundException{

	public DroneNotFoundException(String message) {
		super(ServiceExceptionMessages.DRONE_NOT_FOUND);
	}

}
