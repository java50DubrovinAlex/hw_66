package telran.drons.exception;

import telran.drons.api.ServiceExceptionMessages;

@SuppressWarnings("serial")
public class IllegalEventLogStateException extends IllegalStateException{
	public IllegalEventLogStateException() {
		super(ServiceExceptionMessages.EVENT_LOG_ALREADY_EXISTS);
	}
}
