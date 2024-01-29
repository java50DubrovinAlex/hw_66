package telran.drons.exception;

import telran.drons.api.ServiceExceptionMessages;

@SuppressWarnings("serial")
public class DroneModelNotFoundException extends NotFoundException{

	public DroneModelNotFoundException(String message) {
		super(ServiceExceptionMessages.DRONE_MODEL_NOT_FOUND);
	}

}
