package dgtic.core.model.dto.colonia;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColoniaDTO {
    private Long colonia_id;
    private Long cp;
    private String nombre;
    private Long municipio;
    private Long estado;

    public ColoniaDTO(Long colonia_id, String nombre) {
        this.colonia_id = colonia_id;
        this.nombre = nombre;
    }
}
