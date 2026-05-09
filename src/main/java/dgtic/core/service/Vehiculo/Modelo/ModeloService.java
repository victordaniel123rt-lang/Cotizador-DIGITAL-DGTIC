package dgtic.core.service.Vehiculo.Modelo;

import dgtic.core.model.dto.auto.ModeloDTO;

import java.util.List;

public interface ModeloService {
    List<ModeloDTO> findAll();
    ModeloDTO findById(Long id);
    ModeloDTO save(ModeloDTO MarcaDTO);
    void deleteById(Long id);
}
