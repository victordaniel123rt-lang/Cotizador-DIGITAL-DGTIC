package dgtic.core.model.entity.auto;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "marca")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_marca;
    private String marca;

    @OneToOne(mappedBy = "marca", cascade = CascadeType.ALL)
    private Logo logo;



}
