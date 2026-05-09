package dgtic.core.service.Vehiculo.Marca;

import dgtic.core.model.dto.auto.MarcaDTO;

import java.util.List;

public interface MarcaService {
    List<MarcaDTO> findAll();
    MarcaDTO findById(Long id);
    MarcaDTO save(MarcaDTO MarcaDTO);
    void deleteById(Long id);
}
