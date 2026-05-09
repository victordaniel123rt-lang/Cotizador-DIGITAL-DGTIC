package dgtic.core.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Entity
@Table(name = "cliente")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nombre;
    private String segundoNombre;
    private String apellido_paterno;
    private String apellido_materno;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fnac;
    private String numero;
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Formato de correo inválido")
    private String correo;
    private String genero;

    @Override
    public String toString() {
        return "Cliente{" +
                "apellido_materno='" + apellido_materno + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", segundoNombre='" + segundoNombre + '\'' +
                ", apellido_paterno='" + apellido_paterno + '\'' +
                ", fnac=" + fnac +
                ", numero='" + numero + '\'' +
                ", correo='" + correo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
