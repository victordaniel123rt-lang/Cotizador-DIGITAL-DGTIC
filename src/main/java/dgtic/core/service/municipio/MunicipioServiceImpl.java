package dgtic.core.service.municipio;

import dgtic.core.mapping.Mapper;
import dgtic.core.model.dto.colonia.MunicipioDTO;
import dgtic.core.model.entity.direccion.Estado;
import dgtic.core.model.entity.direccion.Municipio;
import dgtic.core.repository.colonia.MunicipioRepository;
import dgtic.core.service.estado.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MunicipioServiceImpl implements MunicipioService{
    @Autowired
    public final MunicipioRepository municipioRepository;
    @Autowired
    EstadoService estadoService;

    public MunicipioServiceImpl(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }


    @Override
    public List<MunicipioDTO> findAll() {
        return municipioRepository.findAll().stream().map(Mapper::tomunicipioDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public MunicipioDTO findById(Long id) {
        Municipio municipio =municipioRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("No se encontro ningún estado")
        );
        return Mapper.tomunicipioDTO(municipio);
    }

    @Override
    public MunicipioDTO save(MunicipioDTO municipioDTO) {
        Estado estado = Mapper.toEstado(
                estadoService.findById(municipioDTO.getEstado()));
        Municipio muni=null;
        if(municipioDTO.getId_municipio()==null){
            muni =Municipio.builder()
                    .nombre(municipioDTO.getNombre())
                    .estado(estado)
                    .build();
        }else{
            muni = Municipio.builder()
                    .municipio_id(municipioDTO.getId_municipio())
                    .nombre(municipioDTO.getNombre())
                    .estado(estado)
                    .build();
        }

        muni = municipioRepository.save(muni);
        return Mapper.tomunicipioDTO(muni);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public MunicipioDTO findByNombreyEstado(String municipio, String estado) {
        return null;
    }

    @Override
    public Municipio crearUObtener(Municipio municipio) {
        return municipioRepository.findByNombre(municipio.getNombre()).orElseGet(
                ()->{
                    Municipio nuevo = Municipio.builder()
                            .nombre(municipio.getNombre())
                            .estado(municipio.getEstado())
                            .build();
                    return municipioRepository.save(nuevo);
                }

        );
    }
}
