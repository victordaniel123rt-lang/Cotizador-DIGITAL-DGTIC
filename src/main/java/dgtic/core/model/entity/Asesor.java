package dgtic.core.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="asesor")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String usuario;
    private String password;
    private boolean activo;
}
