package dgtic.core.service.colonia;

import dgtic.core.exception.NotDataFoundException;
import dgtic.core.mapping.Mapper;
import dgtic.core.model.dto.colonia.ColoniaDTO;
import dgtic.core.model.entity.direccion.CodigoPostal;
import dgtic.core.model.entity.direccion.Colonia;
import dgtic.core.model.entity.direccion.Estado;
import dgtic.core.model.entity.direccion.Municipio;
import dgtic.core.repository.colonia.CodigoPostalRepository;
import dgtic.core.repository.colonia.ColoniaRepository;
import dgtic.core.repository.colonia.MunicipioRepository;
import dgtic.core.service.codigopostal.CodigoService;
import dgtic.core.service.estado.EstadoService;
import dgtic.core.service.municipio.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ColoniaServiceImpl implements ColoniaService{

    @Autowired
    ColoniaRepository coloniaRepository;
    @Autowired
    CodigoPostalRepository codigoPostalRepository;
    @Autowired
    EstadoService estadoService;
    @Autowired
    MunicipioService municipioService;
    @Autowired
    CodigoService codigoService;
    @Autowired
    MunicipioRepository municipioRepository;



    public List<ColoniaDTO>  getColoniasPorId(String codigopostalId){
    return coloniaRepository.findColoniaByCP(codigopostalId);
    }

    @Override
    @Transactional
    public List<Colonia> obtenerTodas(){
        return coloniaRepository.findAllWithMunicipioCpAndEstado();
    }


    @Override
    @Transactional
    public List<ColoniaDTO> findAll() {
        return coloniaRepository.findAll().stream().map(Mapper::toColoniaDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ColoniaDTO findById(Long id) {
    Colonia colonia = coloniaRepository.findById(id)
            .orElseThrow( ()->new RuntimeException("No existe la colonia"));
        return Mapper.toColoniaDTO(colonia);
    }

    @Override
    public ColoniaDTO save(ColoniaDTO coloniaDTO) {
        //buscar entity Estado
        CodigoPostal codigo = Mapper.toCodigo(
                codigoService.findById(coloniaDTO.getCp()));

        Estado estado= Mapper.toEstado(
        estadoService.findById(coloniaDTO.getEstado()));
        Municipio municipio=Mapper.toMunicipio(
                municipioService.findById(coloniaDTO.getMunicipio()));
        Colonia colonia=null;
        if(coloniaDTO.getColonia_id()==null){
            colonia=Colonia.builder()
                    .nombre(coloniaDTO.getNombre())
                    .codigoPostal(codigo)
                    .municipio(municipio)
                    .build();
        }else{
            colonia=Colonia.builder()
                    .id_colonia(coloniaDTO.getColonia_id())
                    .nombre(coloniaDTO.getNombre())
                    .codigoPostal(codigo)
                    .municipio(municipio)
                    .build();
        }

        coloniaRepository.save(colonia);
        return Mapper.toColoniaDTO(colonia);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if(!coloniaRepository.existsById(id)){
        throw new NotDataFoundException("No existe el dato");
    }
        coloniaRepository.deleteById(id);
    }

    @Override
    public Colonia crearUObtener(Colonia colonia) {
        return coloniaRepository.findByNombre(colonia.getNombre()).orElseGet(
                ()-> {
                 Colonia nueva = Colonia.builder()
                         .nombre(colonia.getNombre())
                         .codigoPostal(colonia.getCodigoPostal())
                         .municipio(colonia.getMunicipio())
                         .build();
                 return coloniaRepository.save(nueva);
                });
    }

    @Transactional
    @Override
    public void actualizar(Colonia colonia){
        Colonia existente = coloniaRepository.findById(colonia.getId_colonia()).orElseThrow(
                ()->new RuntimeException("Colonia no encontrada"));
        existente.setNombre(colonia.getNombre());
        existente.setMunicipio(colonia.getMunicipio());
        existente.setCodigoPostal(colonia.getCodigoPostal());

        coloniaRepository.save(existente);
    }

    @Override
    public List<ColoniaDTO> findColoniaByCP(String codigo) {
        return coloniaRepository.findColoniaByCP(codigo);
    }














//@Autowired
//@Transactional
//public void update(Colonia coloniaform){
//        Colonia coloniaBD=coloniaRepository.findById(coloniaform.getId_colonia()).orElseThrow(
//                ()->new RuntimeException("Colonia no encontrada"));
//        coloniaBD.setNombre(coloniaform.getNombre());
//        if(coloniaform.getMunicipio() != null && coloniaform.getMunicipio().getMunicipio_id()!= null){
//        Municipio municipio = municipioRepository
//                .findById(coloniaform.getMunicipio().getMunicipio_id()).orElseThrow(
//                        ()->new RuntimeException("Municipio no encontrado")
//                );
//        coloniaBD.setMunicipio(municipio);
//        }
//            coloniaRepository.save(coloniaBD);
//    }






}
