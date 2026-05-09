package dgtic.core.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Formulario3DTO {
    @NotBlank(message = "El código postal es obligatorio")
    @Pattern(regexp = "\\d{5}", message = "El código postal debe tener 5 dígitos")
    private String cp;
    @NotBlank(message = "La colonia es obligatoria")
    @Size(min = 3, max = 100, message = "Debe tener entre 3 y 100 caracteres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ0-9 ]+$",
            message = "Solo letras y números")
    private String colonia;
    private String estado;
    @NotBlank(message = "El municipio es obligatorio")
    @Size(min = 3, max = 100)
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$",
            message = "Solo letras")
    private String municipio;
}
