package dgtic.core.service.cotizacion;

import dgtic.core.model.dto.Cotizacion.CoberturasDTO;
import dgtic.core.model.dto.colonia.ColoniaDTO;
import dgtic.core.model.entity.direccion.Colonia;

import java.util.List;

public interface CobeturaService {
    List<CoberturasDTO> findAll();
    List<CoberturasDTO> obtenerTodas();
    CoberturasDTO findById(Long id);
}
