package telran.drons.exception;

import telran.drons.api.ServiceExceptionMessages;

@SuppressWarnings("serial")
public class IllegalDroneStateException extends IllegalStateException{
	public IllegalDroneStateException() {
		super(ServiceExceptionMessages.DRONE_ALREADY_EXISTS);
	}
}
