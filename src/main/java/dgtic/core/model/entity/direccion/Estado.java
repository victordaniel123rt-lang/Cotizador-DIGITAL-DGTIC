package dgtic.core.model.entity.direccion;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estado_id;
    @Column(unique = true)
    private String nombre;


    @OneToMany(mappedBy = "estado")
    private List<Municipio> municios = new ArrayList<>();
}
