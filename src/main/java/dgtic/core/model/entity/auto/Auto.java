package dgtic.core.model.entity.auto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="auto")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_anio")
    private Año anio;
    @ManyToOne
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;
    @ManyToOne
    @JoinColumn(name = "id_version")
    private Version version;


}
