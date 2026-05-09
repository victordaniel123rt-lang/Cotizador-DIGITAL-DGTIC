package dgtic.core.model.entity.auto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "año")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Año {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_anio;
    private String anio;


}
