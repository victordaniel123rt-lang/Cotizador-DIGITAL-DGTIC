package dgtic.core.service.Vehiculo.Marca;

import dgtic.core.mapping.Mapper;
import dgtic.core.model.dto.auto.LogoDTO;
import dgtic.core.model.dto.auto.MarcaDTO;
import dgtic.core.model.entity.auto.Logo;
import dgtic.core.model.entity.auto.Marca;
import dgtic.core.repository.auto.LogoRepository;
import dgtic.core.repository.auto.MarcaRepository;
import dgtic.core.service.Vehiculo.Logo.LogoService;
import dgtic.core.util.Archivos;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service

public class MarcaServiceImpl implements MarcaService{
    private String archivoRuta="c:/imagenes/";
    @Autowired
    MarcaRepository marcaRepository;
    @Override
    public List<MarcaDTO> findAll() {
        return List.of();
    }

    @Override
    public MarcaDTO findById(Long id) {
        Marca marca = marcaRepository.findById(id).orElseThrow(
                ()->new RuntimeException("No se encontro la marca con el id: " + id));
        return Mapper.toMarcaDTO(marca);
    }

    @Override
    @Transactional
    public MarcaDTO save(MarcaDTO marcaDTO) {

        Marca marca = Marca.builder()
                .id_marca(marcaDTO.getIdMarca())
                .marca(marcaDTO.getMarca())
                .build();

        Marca guardado = marcaRepository.save(marca);

        return Mapper.toMarcaDTO(guardado);
    }





    @Override
    public void deleteById(Long id) {

    }
}
