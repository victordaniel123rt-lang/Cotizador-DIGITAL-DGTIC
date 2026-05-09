package dgtic.core.model.dto.colonia;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CodigoPostalDTO {

    private Long cp_id;
    @NotBlank
    @Email(message = "No tiene el formato correcto")
    @Pattern(regexp = "^[0-9]{5}$")
    private String nombre;

}
