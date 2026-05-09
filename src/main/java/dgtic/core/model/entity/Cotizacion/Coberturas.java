package dgtic.core.model.entity.Cotizacion;

import jakarta.persistence.*;
import lombok.*;

import java.lang.annotation.Target;

@Entity
@Table(name = "coberturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coberturas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;


    @Override
    public String toString() {
        return nombre;
    }
}
