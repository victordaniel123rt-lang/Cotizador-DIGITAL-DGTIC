package dgtic.core.service.cotizacion;

import dgtic.core.mapping.Mapper;
import dgtic.core.model.dto.Cotizacion.CoberturasDTO;
import dgtic.core.model.entity.Cotizacion.Coberturas;
import dgtic.core.repository.cotizacion.CoberturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoberturaServiceImpl implements CobeturaService{
    @Autowired
    CoberturasRepository coberturasRepository;


    @Override
    public List<CoberturasDTO> findAll() {
        return List.of();
    }

    @Override
    public List<CoberturasDTO> obtenerTodas() {
      return null;
    }

    @Override
    public CoberturasDTO findById(Long id) {
        Coberturas coberturas = coberturasRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("No se encontro la cobertura con el id: " + id)
        );
        return Mapper.toCoberturasDTO(coberturas);

    }
}
