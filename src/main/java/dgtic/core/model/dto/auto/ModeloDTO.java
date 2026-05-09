package dgtic.core.model.dto.auto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModeloDTO {
    private Long idModelo;
    private String modelo;
    private Long marca;


    @Override
    public String toString() {
        return modelo;
    }
}
