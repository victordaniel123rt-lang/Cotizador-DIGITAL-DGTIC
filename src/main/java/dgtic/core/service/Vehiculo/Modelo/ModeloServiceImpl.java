package dgtic.core.service.Vehiculo.Modelo;

import dgtic.core.mapping.Mapper;
import dgtic.core.model.dto.auto.ModeloDTO;
import dgtic.core.model.entity.auto.Modelo;
import dgtic.core.repository.auto.ModeloRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModeloServiceImpl implements ModeloService{

    ModeloRepository modeloRepository;

    @Override
    public List<ModeloDTO> findAll() {
        return List.of();
    }

    @Override
    public ModeloDTO findById(Long id) {
        Modelo modelo = modeloRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("No se encontro el modelo con el id: " + id));
        return Mapper.toModeloDTO(modelo);
    }

    @Override
    public ModeloDTO save(ModeloDTO MarcaDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
