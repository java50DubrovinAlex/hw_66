package telran.drons.exception;

import org.springframework.stereotype.Service;

import telran.drons.api.ServiceExceptionMessages;

@SuppressWarnings("serial")
public class MedicationNotFoundException extends NotFoundException{

	public MedicationNotFoundException(String message) {
		super(ServiceExceptionMessages.MEDICATION_NOT_FOUND);
	}

}
