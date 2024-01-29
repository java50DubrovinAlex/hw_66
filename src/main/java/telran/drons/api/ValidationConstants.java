package telran.drons.api;

public interface ValidationConstants {
	int MAX_LENGTH_DRONE_NUMBER = 100;
	String MISSING_DRONE_NUMBER_MESSAGE = "Missing drone number";
	String WRONG_MAX_DRONE_NUMBER_SIZE = "Drone number must be less than" + MAX_LENGTH_DRONE_NUMBER + "character";
	String MISSING_DRONE_MEDICATION_CODE_MESSAGE ="Missing drone medication code";
	String MISSING_MEDICATION_CODE_MESSAGE = "Missing medication code";
	String MEDICATION_CODE_REGEXP = "^[A-Z0-9_]+$";
	String WRONG_MEDICATION_CODE_MESSAGE = "Incorrect medication code";
	
}
