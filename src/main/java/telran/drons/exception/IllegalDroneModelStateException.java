package telran.drons.exception;

import telran.drons.api.ServiceExceptionMessages;

@SuppressWarnings("serial")
public class IllegalDroneModelStateException extends IllegalStateException{
	public IllegalDroneModelStateException() {
		super(ServiceExceptionMessages.DRONE_MODEL_ALREADY_EXISTS);
	}
}
