package dgtic.core.model.dto.colonia;

import dgtic.core.model.entity.direccion.Municipio;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadoDTO {
    private Long id_estado;
    private String nombre;
    private List<Municipio> municios = new ArrayList<>();
    public EstadoDTO(String nombre) {
        this.nombre = nombre;
    }
}
