package dgtic.core.service.estado;

import dgtic.core.mapping.Mapper;
import dgtic.core.model.dto.colonia.EstadoDTO;
import dgtic.core.model.dto.Formulario3DTO;
import dgtic.core.model.entity.direccion.Estado;
import dgtic.core.repository.colonia.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EstadoServiceImpl implements EstadoService{
    Formulario3DTO formulario3DTO = new Formulario3DTO();
    @Autowired
    private final EstadoRepository estadoRepository;


    public EstadoServiceImpl(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }


    @Override
    public List<EstadoDTO> findAll() {
        return estadoRepository.findAll().stream().map(Mapper::toEstadoDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public EstadoDTO findById(Long id) {
        Estado estado=estadoRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("No se encontro el estado")
        );
        return Mapper.toEstadoDTO(estado);
    }

    @Override
    public EstadoDTO save(EstadoDTO estadoDTO) {
        Estado est=null;
        if(estadoDTO.getId_estado()==null){
            est=Estado.builder()
                    .nombre(estadoDTO.getNombre())
                    .build();
        }else{
            est = Estado.builder()
                    .estado_id(estadoDTO.getId_estado())
                    .nombre(estadoDTO.getNombre())
                    .build();
        }

        estadoRepository.save(est);
        return Mapper.toEstadoDTO(est);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Estado buscarPorNombre(String nombreEstado){
    return estadoRepository.findByNombre(nombreEstado).orElseThrow(
            ()-> new RuntimeException("No se encotraron coincidencias")
    );}

    @Override
    public Estado crearUObtener(String nombre) {
        return estadoRepository.findByNombre(nombre).orElseGet(
                ()->{
                    Estado nuevo = Estado.builder()
                            .nombre(nombre)
                            .build();
                    return estadoRepository.save(nuevo);
                }
        );
    }

}
