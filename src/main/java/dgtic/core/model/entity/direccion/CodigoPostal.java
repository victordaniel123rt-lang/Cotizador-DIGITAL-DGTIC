package dgtic.core.model.entity.direccion;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "codigopostal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CodigoPostal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cp;
    @Column(unique = true)
    private String codigo;

    @OneToMany(mappedBy = "codigoPostal")
    private List<Colonia> colonias=new ArrayList<>();

    @Override
    public String toString() {
        return codigo;
    }
}
