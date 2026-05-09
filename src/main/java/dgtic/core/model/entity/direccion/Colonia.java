package dgtic.core.model.entity.direccion;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="colonia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Colonia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_colonia;
    @Column(unique = true)
    private String nombre;

    @ManyToOne
    @JoinColumn(name="id_cp")
    private CodigoPostal codigoPostal;

    @ManyToOne
    @JoinColumn(name = "municipio_id")
    private Municipio municipio;
}
