package telran.drons.dto;

import jakarta.validation.constraints.*;
import static telran.drons.api.ValidationConstants.*;

public record DroneMedicationDto(@NotEmpty(message=MISSING_DRONE_NUMBER_MESSAGE) @Size(max = MAX_LENGTH_DRONE_NUMBER, message=WRONG_MAX_DRONE_NUMBER_SIZE) String dronNumber, 
		@NotEmpty (message=MISSING_DRONE_MEDICATION_CODE_MESSAGE) @Pattern(regexp = MEDICATION_CODE_REGEXP, message=WRONG_MEDICATION_CODE_MESSAGE) String medicationCode) {

}
