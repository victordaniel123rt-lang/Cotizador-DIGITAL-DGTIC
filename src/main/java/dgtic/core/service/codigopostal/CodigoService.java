package dgtic.core.service.codigopostal;

import dgtic.core.exception.NotDataFoundException;
import dgtic.core.mapping.Mapper;
import dgtic.core.model.dto.colonia.CodigoPostalDTO;
import dgtic.core.model.dto.Formulario3DTO;
import dgtic.core.model.entity.direccion.CodigoPostal;
import dgtic.core.repository.colonia.CodigoPostalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CodigoService implements CodigoPostalService{
    Formulario3DTO formulario3DTO = new Formulario3DTO();
    @Autowired
    CodigoPostalRepository codigoPostalRepository;

    public CodigoPostal buscarPorCodigo(String codigo){
       return  codigoPostalRepository.findByCodigo(codigo).orElseThrow(
               ()-> new RuntimeException("No se encontro el Código Postal")
       );
    }

//
//    public CodigoPostalDTO buscarPorCodigoDos(String codigo){
//        String normalizado = codigo.trim().toLowerCase();
//        return codigoPostalRepository.findByCodigoDos(normalizado);
//    }

    @Override
    public List<CodigoPostalDTO> findAll() {
         return  codigoPostalRepository.findAll().stream()
                 .map(Mapper::toCodigoDTO)
                 .toList();
    }

    @Override
    public CodigoPostalDTO findById(Long id) {
        CodigoPostal codigo =codigoPostalRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("No se encontro ningún estado")
        );
        return Mapper.toCodigoDTO(codigo);
    }

    @Override
    public CodigoPostalDTO save(CodigoPostalDTO codigoPostalDTO) {
        CodigoPostal codigo=null;
        if(codigoPostalDTO.getCp_id()==null){
            codigo=CodigoPostal.builder()
                    .codigo(codigoPostalDTO.getNombre())
                    .build();
        }else{
            codigo=CodigoPostal.builder()
                    .id_cp(codigoPostalDTO.getCp_id())
                    .codigo(codigoPostalDTO.getNombre())
                    .build();

        }

        codigoPostalRepository.save(codigo);
        return Mapper.toCodigoDTO(codigo);
    }

    @Override
    public void deleteById(Long id) {

    }


    @Override
    public CodigoPostal crearOObtener(String codigo) {
        return codigoPostalRepository.findByCodigo(codigo).orElseGet(
                ()->{
                    CodigoPostal nuevo = CodigoPostal.builder()
                            .codigo(codigo)
                            .build();
                    return  codigoPostalRepository.save(nuevo);
                });
    }




}
