package dgtic.core.service.Vehiculo.Año;

import dgtic.core.model.dto.auto.AñoDTO;
import dgtic.core.model.entity.auto.Año;

import java.util.List;

public interface AñoService {
    List<Año> findAll();
    AñoDTO findById(Long id);
    AñoDTO save(AñoDTO añoDTO);
    void deleteById(Long id);
}
