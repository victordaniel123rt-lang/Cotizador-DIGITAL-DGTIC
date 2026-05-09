package dgtic.core.service.cotizacion;

import dgtic.core.model.dto.Cotizacion.CotizacionFinalDTO;
import dgtic.core.model.entity.Cotizacion.Coberturas;
import dgtic.core.model.entity.Cotizacion.CotizacionFinal;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface CotizacionFinalService {
    CotizacionFinalDTO obtenerCotizacionPorCobertura(Long cobertura);
    Map<String, Map<String, BigDecimal>> diferimiento(CotizacionFinalDTO cotizacionFinalDTO);
}
