package telran.drons.exception;

import org.springframework.stereotype.Service;

import telran.drons.api.ServiceExceptionMessages;

@SuppressWarnings("serial")
public class EventLogNotFoundException extends NotFoundException{

	public EventLogNotFoundException(String message) {
		super(ServiceExceptionMessages.EVENT_LOG_NOT_FOUND);
	}

}
