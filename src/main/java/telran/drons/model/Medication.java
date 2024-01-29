package telran.drons.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="medications")
@NoArgsConstructor
@AllArgsConstructor
public class Medication {
	@Id
	String name;
	int weight;
	String code;
}
