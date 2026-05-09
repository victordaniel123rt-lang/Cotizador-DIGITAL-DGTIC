package dgtic.core.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CotizacionDTO {
    @NotBlank
    @Pattern(regexp = "^[0-9]{5}$")
    private String codigopostal;
    private String colonia;
    private String municipio;
    private String estado;


    private Long anio;
    private Long marca;
    private Long modelo;
    private Long version;

    @NotBlank(message = "El Nombre es obligatorio")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$",
            message = "Solo letras")
    @Size(min = 3, max = 100)
    private String nombre;
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$",
            message = "Solo letras")
    @Size(min = 3, max = 100)
    private String segundonombre;
    @NotBlank(message = "El Apellido es obligatorio")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$",
            message = "Solo letras")
    private String apellidoPaterno;
    @NotBlank(message = "El Apellido es obligatorio")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$",
            message = "Solo letras")
    private String apellidoMaterno;
    @NotBlank(message = "La fecha de nacimiento es obligatoria")
    private LocalDate fechaNacimiento;
    private String genero;
    private String numero;
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Formato de correo inválido")
    private String correo;


}
