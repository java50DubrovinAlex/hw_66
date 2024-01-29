package telran.drons.model;
import jakarta.persistence.*;
import lombok.*;
import telran.drons.dto.ModelType;
@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Table(name="drone_models")
public class DroneModel {
	@Id
	@Enumerated(EnumType.STRING)
	ModelType modelName;
	int weight;
	
}
