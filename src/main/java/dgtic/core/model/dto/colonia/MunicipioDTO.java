package dgtic.core.model.dto.colonia;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MunicipioDTO {
    private Long id_municipio;
    private String nombre;
    private Long estado;

    public MunicipioDTO(Long id_municipio, String nombre) {
        this.id_municipio = id_municipio;
        this.nombre = nombre;
    }
}
