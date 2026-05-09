package dgtic.core.model.entity.auto;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "logo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Logo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLogo;
    private String urlogo;

@OneToOne
@JoinColumn(name = "marcaid")
    private Marca marca;

}
