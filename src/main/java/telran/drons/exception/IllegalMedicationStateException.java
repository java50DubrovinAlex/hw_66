package telran.drons.exception;

import telran.drons.api.ServiceExceptionMessages;

@SuppressWarnings("serial")
public class IllegalMedicationStateException extends IllegalStateException{
	public IllegalMedicationStateException() {
		super(ServiceExceptionMessages.MEDICATION_ALREADY_EXISTS);
	}
}
