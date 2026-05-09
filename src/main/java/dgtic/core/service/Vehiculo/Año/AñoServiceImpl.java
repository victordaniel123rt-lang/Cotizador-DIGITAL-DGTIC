package dgtic.core.service.Vehiculo.Año;

import dgtic.core.mapping.Mapper;
import dgtic.core.model.dto.auto.AñoDTO;
import dgtic.core.model.entity.auto.Año;
import dgtic.core.repository.auto.AñoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AñoServiceImpl implements AñoService{

    private final AñoRepository añoRepository;

    public AñoServiceImpl(AñoRepository añoRepository) {
        this.añoRepository = añoRepository;
    }

    @Override
    public List<Año> findAll() {
        return añoRepository.findAll();
    }
//    @Override
//    public List<AñoDTO> findAll() {
//        return añoRepository.findAll().stream().map(Mapper::toAñoDTO).toList();
//    }

    @Override
    public AñoDTO findById(Long id) {
        Año año = añoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No se encontro el año con el id: " + id));
        return Mapper.toAñoDTO(año);
    }

    @Override
    public AñoDTO save(AñoDTO añoDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

}
