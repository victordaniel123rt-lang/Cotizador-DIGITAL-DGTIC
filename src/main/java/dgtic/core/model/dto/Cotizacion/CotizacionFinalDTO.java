package dgtic.core.model.dto.Cotizacion;

import dgtic.core.model.entity.Cotizacion.Coberturas;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CotizacionFinalDTO {
    private Long id;
    private BigDecimal costo;
    private Long cobertura;

}
