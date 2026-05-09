package dgtic.core.model.entity.direccion;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "municipio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long municipio_id;
    @Column(unique = true)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;
}
