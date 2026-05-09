package dgtic.core.service.municipio;

import dgtic.core.model.dto.colonia.MunicipioDTO;
import dgtic.core.model.entity.direccion.Municipio;

import java.util.List;
import java.util.Optional;

public interface MunicipioService {
    List<MunicipioDTO> findAll();
    MunicipioDTO findById(Long id);
    MunicipioDTO save(MunicipioDTO municipioDTO);
    void deleteById(Long id);
    MunicipioDTO findByNombreyEstado(String municipio, String estado);
    Municipio crearUObtener(Municipio municipio);
}
