package dgtic.core.service.Vehiculo.Logo;

import dgtic.core.mapping.Mapper;
import dgtic.core.model.dto.auto.LogoDTO;
import dgtic.core.model.entity.auto.Logo;
import dgtic.core.model.entity.auto.Marca;
import dgtic.core.repository.auto.LogoRepository;
import dgtic.core.repository.auto.MarcaRepository;
import dgtic.core.service.Vehiculo.Marca.MarcaService;
import dgtic.core.util.Archivos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class LogoServiceImpl implements LogoService{
    private String archivoRuta="c:/imagenes/";
    @Autowired
    MarcaService marcaService;
    @Autowired
    MarcaRepository marcaRepository;
    @Autowired
    LogoRepository logoRepository;

    @Override
    public List<Logo> findAll() {
        return List.of();
    }

    @Override
    public LogoDTO findById(Long id) {
    Logo logo = logoRepository.findById(id).orElseThrow(
            ()-> new RuntimeException("No se encontro el logo con el id proporcionado")
    );
    return Mapper.toLogoDTO(logo);

    }

    @Override
    public LogoDTO save(LogoDTO logo, MultipartFile multipartFile) {

        Marca marca = marcaRepository.findById(logo.getMarca()).orElseThrow(
                ()-> new RuntimeException("No se encontro la marca con el id proporcionado")
        );
        String logoNombre = null;
        if (multipartFile != null && !multipartFile.isEmpty()) {
            logoNombre = Archivos.almacenar(multipartFile, archivoRuta);
        }

        Logo log = null;
        if(logo.getLogoid()==null){
            log = Logo.builder()
                    .urlogo(logoNombre)
                    .marca(marca)
                    .build();
        }else {
            log = Logo.builder()
                    .idLogo(logo.getLogoid())
                    .urlogo(logoNombre)
                    .marca(marca)
                    .build();
        }
        Logo guardado = logoRepository.save(log);
        return Mapper.toLogoDTO(guardado);
    }

    @Override
    public void deleteById(Long id) {

    }
}
