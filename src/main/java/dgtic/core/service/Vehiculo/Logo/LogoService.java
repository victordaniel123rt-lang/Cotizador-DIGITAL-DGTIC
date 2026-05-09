package dgtic.core.service.Vehiculo.Logo;

import dgtic.core.model.dto.auto.LogoDTO;
import dgtic.core.model.dto.auto.MarcaDTO;
import dgtic.core.model.entity.auto.Logo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface LogoService {
    List<Logo> findAll();
    LogoDTO findById(Long id);
    LogoDTO save(LogoDTO logo, MultipartFile multipartFile);
    void deleteById(Long id);
}
