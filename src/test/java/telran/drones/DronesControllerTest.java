package telran.drones;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



import telran.drons.dto.DroneDto;
import telran.drons.dto.DroneMedicationDto;
import telran.drons.dto.ModelType;
import telran.drons.exception.DroneNotFoundException;
import telran.drons.exception.IllegalDroneStateException;
import telran.drons.exception.MedicationNotFoundException;
import telran.drons.service.DronesService;
import static telran.drons.api.ServiceExceptionMessages.*;

import java.io.UnsupportedEncodingException;
import static telran.drons.api.ValidationConstants.*;

@WebMvcTest
//@SpringBootTest
public class DronesControllerTest {
	String DRONE_NUMBER = "model1";
	ModelType MODEL_TYPE = ModelType.Havyweght;
	String MEDICATION_CODE = "MEDICATION1";
	String WRONG_DRONE_NUMBER = fillString();
	DroneDto DRONE = new DroneDto(DRONE_NUMBER, MODEL_TYPE);
	String wrongMedicationCode = "asdDD@@";
	DroneMedicationDto MEDICATION = new DroneMedicationDto(DRONE_NUMBER, MEDICATION_CODE);
	DroneDto droneWrongNumber = new DroneDto(WRONG_DRONE_NUMBER, MODEL_TYPE);
	DroneMedicationDto medicationDroneWrongNumber = new DroneMedicationDto(WRONG_DRONE_NUMBER, MEDICATION_CODE);
	DroneMedicationDto medicationWrongCode = new DroneMedicationDto(DRONE_NUMBER, MEDICATION_CODE);
	@MockBean
	DronesService dronsService;
	@Autowired //for injection of MockMvc from Application Context
	MockMvc mockMvc;
	
	@Autowired //for injection of ObjectMapper from Application context
	ObjectMapper mapper; //object for getting JSON from object and object from JSON
	String fillString() {
		String res=null;
		for (int i = 0; i < 101; i++) {
            res+="X"; 
        }
		return res;
	}
	@Test
	void testRegisterDrone() throws Exception {
		when(dronsService.registerDrone(DRONE)).thenReturn(DRONE);
		String jsonDroneDto = mapper.writeValueAsString(DRONE);
		String actualJSON = mockMvc.perform(post("http://localhost:8080/drones").contentType(MediaType.APPLICATION_JSON)
				.content(jsonDroneDto)).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		assertEquals(jsonDroneDto, actualJSON);
	}
	@Test
	void testLoadDrone()throws Exception{
		when(dronsService.loadDrone(MEDICATION)).thenReturn(MEDICATION);
		String jsonMedicationDto = mapper.writeValueAsString(MEDICATION);
		String actualJSON = mockMvc.perform(post("http://localhost:8080/drones").contentType(MediaType.APPLICATION_JSON)
				.content(jsonMedicationDto)).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		assertEquals(jsonMedicationDto, actualJSON);
		
	}
	
	
	
	/******************************************************************/
	/*********** ALternative flows - Service Exceptions Handling *************/
	
	
	@Test
	void testRegisterDroneIllegalDroneStateException()throws Exception{
		when(dronsService.registerDrone(DRONE)).thenThrow(new IllegalDroneStateException());
		String jasonDroneDto = mapper.writeValueAsString(DRONE);
		String response = mockMvc.perform(post("http://localhost:8080/drones").contentType(MediaType.APPLICATION_JSON)
				.content(jasonDroneDto)).andExpect(status().isBadRequest()).andReturn().getResponse()
		.getContentAsString();
		assertEquals(DRONE_ALREADY_EXISTS, response);
	}
	
	@Test
	void testLoadDroneDroneNotFoundException()throws Exception{
		when(dronsService.loadDrone(MEDICATION)).thenThrow(new DroneNotFoundException(DRONE_NOT_FOUND));
		String actualJSON = mockMvc.perform(post("http://localhost:8080/drones/load"))
				.andExpect(status().isNotFound()).andReturn().getResponse().getContentAsString();
		assertEquals(DRONE_NOT_FOUND, actualJSON);
	}
	@Test
	void testLoadDroneMedicationNotFoundException() throws  Exception {
		when(dronsService.loadDrone(MEDICATION)).thenThrow(new MedicationNotFoundException(MEDICATION_NOT_FOUND));
		String actualJSON = mockMvc.perform(post("http://localhost:8080/drones/load")).andExpect(status().isNotFound()).andReturn()
				.getResponse().getContentAsString();
		assertEquals(MEDICATION_NOT_FOUND, actualJSON);
	}
	
	
	/**
	 * @throws Exception ***************************************************************************/
	/* Alternative flows - Validation exceptions handling ***********************/
	
	@Test
	void testDroneWrongNumberLenght() throws Exception {
		wrongEanyDataRequest(droneWrongNumber, WRONG_MAX_DRONE_NUMBER_SIZE);
	}
	
	@Test
	void testMedicationDroneWrongNumberLenght()throws Exception{
		wrongEanyDataRequest(medicationDroneWrongNumber, WRONG_MAX_DRONE_NUMBER_SIZE);
	}
	
	@Test
	void testMedicationWrongCode() throws Exception{
		wrongEanyDataRequest(medicationWrongCode, WRONG_MEDICATION_CODE_MESSAGE);
	}
	
	private void wrongEanyDataRequest(Object eanyDtoWrongData, String expectedMessage) throws  Exception {
		String jsonEanyDto = mapper.writeValueAsString(eanyDtoWrongData); //conversion from carDto object to string JSON
		String response = mockMvc.perform(post("http://localhost:8080/cars/person").contentType(MediaType.APPLICATION_JSON)
				.content(jsonEanyDto)).andExpect(status().isBadRequest())
				.andReturn().getResponse().getContentAsString();
		assertEquals(expectedMessage, response);
}
}
