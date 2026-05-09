package dgtic.core.model.entity.auto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="version")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Version {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_version;
    private String version;

    @ManyToOne
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;
}
