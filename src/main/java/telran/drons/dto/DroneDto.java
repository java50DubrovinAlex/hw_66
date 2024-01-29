package telran.drons.dto;

import jakarta.validation.constraints.*;
import static telran.drons.api.ValidationConstants.*;
public record DroneDto(@NotEmpty (message = MISSING_DRONE_NUMBER_MESSAGE) @Size(max = MAX_LENGTH_DRONE_NUMBER, message=WRONG_MAX_DRONE_NUMBER_SIZE) String number, 
		@NotEmpty(message="MISSING_DRONE_TYPE_MESSAGE") ModelType modelType) {

	

} //why number @NotNull and modelType NotEmpty
