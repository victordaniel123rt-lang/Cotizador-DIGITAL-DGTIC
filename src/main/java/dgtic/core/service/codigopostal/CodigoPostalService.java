package dgtic.core.service.codigopostal;

import dgtic.core.model.dto.colonia.CodigoPostalDTO;
import dgtic.core.model.entity.direccion.CodigoPostal;

import java.util.List;
import java.util.Optional;

public interface CodigoPostalService {
    List<CodigoPostalDTO> findAll();
    CodigoPostalDTO findById(Long id);
    CodigoPostalDTO save(CodigoPostalDTO codigoPostalDTO);
    void deleteById(Long id);
    CodigoPostal crearOObtener(String codigo);
}
