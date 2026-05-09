package dgtic.core.service.cotizacion;

import dgtic.core.model.dto.Cotizacion.CotizacionFinalDTO;
import dgtic.core.model.entity.Cotizacion.CotizacionFinal;
import dgtic.core.repository.cotizacion.CotizacionFinalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
@AllArgsConstructor
public class CotizacionFinalServiceImpl implements CotizacionFinalService{

    CotizacionFinalRepository cotizacionFinalRepository;

    @Override
    public CotizacionFinalDTO obtenerCotizacionPorCobertura(Long cobertura) {
        CotizacionFinal entity =
                cotizacionFinalRepository.obtenerCotizacionPorCobertura(cobertura);
        CotizacionFinalDTO dto = new CotizacionFinalDTO();
        dto.setCosto(entity.getCosto());
        dto.setCobertura(entity.getCobertura().getId());

        return dto;
    }

    @Override
    public Map<String,Map<String, BigDecimal>> diferimiento(CotizacionFinalDTO cot) {

        Map<String, Map<String, BigDecimal>> resultado = new HashMap<>();
        List<CotizacionFinal> coberturas = cotizacionFinalRepository.findAll();

        for (CotizacionFinal cf : coberturas) {

            BigDecimal costo = cf.getCosto();
            String nombre = cf.getCobertura().getNombre();

            Map<String, BigDecimal> valores = new HashMap<>();

            valores.put("ANUAL", costo);
            valores.put("SEMESTRAL", costo.divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_UP));
            valores.put("TRIMESTRAL", costo.divide(BigDecimal.valueOf(4), 2, RoundingMode.HALF_UP));
            valores.put("MENSUAL", costo.divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP));

            resultado.put(nombre, valores);
        }

        return resultado;
    }




}
