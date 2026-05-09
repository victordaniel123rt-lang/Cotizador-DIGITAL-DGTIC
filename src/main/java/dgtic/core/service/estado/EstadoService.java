package dgtic.core.service.estado;

import dgtic.core.model.dto.colonia.EstadoDTO;
import dgtic.core.model.entity.direccion.Estado;

import java.util.List;

public interface EstadoService {
    List<EstadoDTO> findAll();
    EstadoDTO findById(Long id);
    EstadoDTO save(EstadoDTO estadoDTO);
    void deleteById(Long id);
    Estado buscarPorNombre(String nombre);
    Estado crearUObtener(String nombre);
}
