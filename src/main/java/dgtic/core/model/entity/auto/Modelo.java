package dgtic.core.model.entity.auto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "modelo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_modelo;
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;



}
