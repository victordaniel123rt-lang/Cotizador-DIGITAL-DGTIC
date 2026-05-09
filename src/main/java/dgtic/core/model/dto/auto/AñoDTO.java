package dgtic.core.model.dto.auto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AñoDTO {
private Long anio_id;
private String anio;

    @Override
    public String toString() {
        return anio;
    }
}
